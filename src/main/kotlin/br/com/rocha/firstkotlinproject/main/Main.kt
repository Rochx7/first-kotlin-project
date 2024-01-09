package br.com.rocha.firstkotlinproject.main

import br.com.rocha.firstkotlinproject.module.Game
import br.com.rocha.firstkotlinproject.module.Gamer
import br.com.rocha.firstkotlinproject.services.UseApi
import java.util.*

fun main() {

    val reading = Scanner(System.`in`)
    val gamer = Gamer.createGame(reading)

    println("Cadastro criado com sucesso.")
    println(gamer)

    do {
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
            val descriptionOption = reading.nextLine()
            if(descriptionOption.equals("s", ignoreCase = true)){
                println("Insira a descrição personalizada para o jogo: ")
                val description = reading.nextLine()
                myGame?.description = description
            }else{
                myGame?.description = myGame?.title
            }

            gamer.searchedGames.add(myGame)
        }

        println("Deseja buscar outro jogo? S/N")
        val searchAnotherGame = reading.nextLine()
    } while (searchAnotherGame.equals("s", true))

    println("Lista de jogos buscados:")
    println(gamer.searchedGames)
    println("Busca finalizada")
}