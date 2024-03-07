package br.com.rocha.firstkotlinproject.module

interface Recommended {
    val media:Double

    fun recommend(score: Int)
}