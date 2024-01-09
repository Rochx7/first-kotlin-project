package br.com.rocha.firstkotlinproject.module

data class InfoGame(val info: InfoApiShark) {

    override fun toString(): String {
        return info.toString()
    }
}