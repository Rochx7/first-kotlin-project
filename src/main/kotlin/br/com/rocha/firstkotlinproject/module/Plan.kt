package br.com.rocha.firstkotlinproject.module

abstract  class Plan (val type: String) {

    open fun getValue(rent:Rent):Double{
        return rent.game.price * rent.period.inDays
    }
}