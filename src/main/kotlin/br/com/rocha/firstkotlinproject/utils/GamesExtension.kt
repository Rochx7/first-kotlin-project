package br.com.rocha.firstkotlinproject.utils

import br.com.rocha.firstkotlinproject.module.Game
import br.com.rocha.firstkotlinproject.module.InfoApiListGames

fun InfoApiListGames.createGames(): Game{
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}