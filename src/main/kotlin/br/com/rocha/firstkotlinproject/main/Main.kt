package br.com.rocha.firstkotlinproject.main

import br.com.rocha.firstkotlinproject.module.Game
import br.com.rocha.firstkotlinproject.services.UseApi
import java.util.*

fun main() {
    val reading = Scanner(System.`in`)
    println("Digite para buscar:")

    val search = reading.nextLine()

    val searchApi = UseApi()
    val infoGame = searchApi.searchGame(search)

    var myGame: Game? = null
    val result = runCatching {

        myGame = Game(infoGame.info.title, infoGame.info.thumb)
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