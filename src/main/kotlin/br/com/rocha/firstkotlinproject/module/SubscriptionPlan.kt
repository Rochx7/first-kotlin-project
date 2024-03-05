package br.com.rocha.firstkotlinproject.module

class SubscriptionPlan(
    type: String,
    val monthly: Double,
    val gamesIncluded:Int
): Plan(type){
    override fun getValue(rent: Rent): Double {
        val totalGamesMonth = rent.gamer.gamesByMonth(rent.period.initialDate.monthValue).size + 1

        return if(totalGamesMonth <= gamesIncluded){
            0.0
        } else{
            super.getValue(rent)
        }
    }
}
