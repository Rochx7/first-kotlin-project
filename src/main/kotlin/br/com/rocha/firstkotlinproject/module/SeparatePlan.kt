package br.com.rocha.firstkotlinproject.module

class SeparatePlan(
    type: String,
): Plan(type) {

    override fun getValue(rent: Rent): Double {
        var originalValue = super.getValue(rent)
        if(rent.gamer.medium > 8){
            originalValue -= originalValue * 0.1
        }
        return originalValue
    }
}
