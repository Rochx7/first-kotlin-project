package br.com.rocha.firstkotlinproject.main

import br.com.rocha.firstkotlinproject.module.Period
import br.com.rocha.firstkotlinproject.module.Plan
import br.com.rocha.firstkotlinproject.module.SeparatePlan
import br.com.rocha.firstkotlinproject.module.SubscriptionPlan
import br.com.rocha.firstkotlinproject.services.UseApi
import com.google.gson.GsonBuilder
import java.io.File
import java.time.LocalDate

fun main(){
    val consume = UseApi()
    val listGamer = consume.searchGamer()
    val listGames = consume.listGames()

    val gamerGui = listGamer.get(2)
    val gameREVilage = listGames.get(10)
    val gameSpider = listGames.get(13)
    val gameGodOfWar = listGames.get(7)


    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(2))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(12))
    val period3 = Period(LocalDate.now(), LocalDate.now().plusDays(7))

    gamerGui.rentedGame(gameSpider, period2)

    gamerGui.plan = SubscriptionPlan("SILVER", 9.90, 3, 0.15)

    gamerGui.recommendGame(gameSpider, 10)

    println(gamerGui.recommendedGames)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialization = gson.toJson(gamerGui.recommendedGames)
    println(serialization)

    val file = File("recommendedGames.json")
    file.writeText(serialization)

    println(file.absolutePath)

}
