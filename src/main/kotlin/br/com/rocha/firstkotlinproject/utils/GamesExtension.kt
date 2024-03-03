package br.com.rocha.firstkotlinproject.utils

import br.com.rocha.firstkotlinproject.module.InfoApiListGames
import br.com.rocha.firstkotlinproject.module.ListGames

fun InfoApiListGames.createGames(): ListGames{
    return ListGames(this.titulo, this.capa, this.preco, this.descricao)
}