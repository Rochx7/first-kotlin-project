package br.com.rocha.firstkotlinproject.module
data class Game(
    val title: String,
    val thumb: String,

) {
    var price = 0.0
    var description:String? = null
    constructor(title: String, thumb: String, price: Double, description: String):
            this(title, thumb) {
        this.price = price
        this.description = description
    }
    override fun toString(): String {
        return "\nTitle: $title \n" +
                "Thumb: $thumb \n" +
                "Price: $price \n" +
                "Description: $description"
    }

}