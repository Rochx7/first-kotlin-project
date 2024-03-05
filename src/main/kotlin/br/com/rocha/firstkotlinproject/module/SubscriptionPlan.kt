package br.com.rocha.firstkotlinproject.module

class SubscriptionPlan(
    type: String,
    val monthly: Double,
    private val gamesIncluded:Int,
    val percentDiscount:Double
): Plan(type){
    override fun getValue(rent: Rent): Double {
        val totalGamesMonth = rent.gamer.gamesByMonth(rent.period.initialDate.monthValue).size + 1

        return if(totalGamesMonth <= gamesIncluded){
            0.0
        } else{
            var originalValue = super.getValue(rent)

            if(rent.gamer.medium > 8){
                originalValue -= originalValue * percentDiscount
            }
             originalValue
        }
    }
}
