package br.com.rocha.firstkotlinproject.main

import br.com.rocha.firstkotlinproject.module.Period
import br.com.rocha.firstkotlinproject.module.Plan
import br.com.rocha.firstkotlinproject.module.SeparatePlan
import br.com.rocha.firstkotlinproject.module.SubscriptionPlan
import br.com.rocha.firstkotlinproject.services.UseApi
import java.time.LocalDate

fun main(){
    val consume = UseApi()
    val listGamer = consume.searchGamer()
//    val gameApi = consume.searchGame("151")
    val listGames = consume.listGames()

    val gamerGui = listGamer.get(2)
    val gameRE_Vilage = listGames.get(10)
    val gameSpider = listGames.get(13)
    val gameGodOfWar = listGames.get(7)


    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(2))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(12))
    val period3 = Period(LocalDate.now(), LocalDate.now().plusDays(7))
    val period4 = Period(LocalDate.now(), LocalDate.now().plusMonths(5))

    gamerGui.rentedGame(gameRE_Vilage, period1)
    gamerGui.rentedGame(gameSpider, period2)
    gamerGui.rentedGame(gameGodOfWar, period3)


    val gamerCamila = listGamer.get(5)

    gamerCamila.plan = SubscriptionPlan("SILVER", 9.90, 3)

    gamerCamila.rentedGame(gameGodOfWar, period1)
    gamerCamila.rentedGame(gameSpider, period2)
    gamerCamila.rentedGame(gameRE_Vilage, period2)
    gamerCamila.rentedGame(gameRE_Vilage, period2)

    println(gamerCamila.rentedGames)
}
