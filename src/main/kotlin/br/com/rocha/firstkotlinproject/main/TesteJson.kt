package br.com.rocha.firstkotlinproject.main

import br.com.rocha.firstkotlinproject.services.UseApi

fun main(){
    val consume = UseApi()
//    val list = consume.searchGamer()
//    val gameApi = consume.searchGame("151")
    val listGames = consume.listGames()

//     println(list)
//    println(gameApi)
    println(listGames)
}
