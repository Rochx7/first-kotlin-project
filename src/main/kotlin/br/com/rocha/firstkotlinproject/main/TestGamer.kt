import br.com.rocha.firstkotlinproject.module.Gamer


fun main(){

    val gamer1 = Gamer(name = "Rocha", email ="guizin@gmail.com")

    println(gamer1)

    val gamer2 = Gamer(name = "Rocha", email ="guizin@gmail.com", birthday = "05/05/2000", user = "Guizão")
    println(gamer2)

    gamer1.let {
        it.birthday = "20/04/1997"
        it.user = "Aggy"

    }.also {
        println(gamer1)
    }
}