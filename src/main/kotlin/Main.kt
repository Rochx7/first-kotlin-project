import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.util.*

fun main() {
    val reading = Scanner(System.`in`)
    println("Digite para buscar:")

    val search = reading.nextLine()
    val url = "https://www.cheapshark.com/api/1.0/games?id=$search"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder().uri(URI.create(url)).build()

    val response = client
        .send(request, HttpResponse.BodyHandlers.ofString())

    val json = response.body()
    println(json)

    val gson = Gson()

    var myGame:Game? = null

    val result = runCatching {
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)
        myGame = Game(myInfoGame.info.title, myInfoGame.info.thumb)
    }

    result.onFailure {
        println("Jogo não encontrado! Tente outro ID.")
    }

    result.onSuccess {
        println("Deseja adicionar uma descrição personalizada? S/N")
        var descriptionOption = reading.nextLine()
        if(descriptionOption.equals("s", ignoreCase = true)){
            println("Insira a descrição personalizada para o jogo: ")
            var description = reading.nextLine()
            myGame?.description = description
        }else{
            myGame?.description = myGame?.title
        }

        println(myGame)
    }

}