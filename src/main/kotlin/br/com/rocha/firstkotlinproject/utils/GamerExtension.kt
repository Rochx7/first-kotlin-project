package br.com.rocha.firstkotlinproject.utils

import br.com.rocha.firstkotlinproject.module.Gamer
import br.com.rocha.firstkotlinproject.module.InfoGamerJson

fun InfoGamerJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario)
}