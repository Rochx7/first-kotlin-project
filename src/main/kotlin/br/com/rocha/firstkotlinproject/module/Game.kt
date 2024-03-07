package br.com.rocha.firstkotlinproject.module

import com.google.gson.annotations.Expose

data class Game(
    @Expose val title: String,
    @Expose val thumb: String,
):Recommended {
    var price = 0.0
    var description:String? = null
    private val scoreList = mutableListOf<Int>()
    override val media: Double
        get() = scoreList.average()
    override fun recommend(score: Int) {
        scoreList.add(score)
    }

    constructor(title: String, thumb: String, price: Double, description: String):
            this(title, thumb) {
        this.price = price
        this.description = description
    }
    override fun toString(): String {
        return "\nTitle: $title \n" +
                "Thumb: $thumb \n" +
                "Price: $price \n" +
                "Description: $description\n" +
                "Score: $scoreList"
    }

}