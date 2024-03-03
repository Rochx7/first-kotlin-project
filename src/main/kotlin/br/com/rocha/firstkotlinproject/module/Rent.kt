package br.com.rocha.firstkotlinproject.module

import java.time.LocalDate


data class Rent(
    val gamer: Gamer,
    val game: Game,
    val period: Period
){
    private val priceRent = game.price * period.inDays
    override fun toString(): String {
        return "${game.title} rented by ${gamer.name} for ${priceRent}"
    }
}
