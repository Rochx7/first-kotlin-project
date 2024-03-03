package br.com.rocha.firstkotlinproject.module

data class ListGames(var titulo:String, var capa:String, var preco:Double, var descricao:String){
    override fun toString(): String {
        return "Game(title='$titulo', thumb='$capa', price=$preco, description=$descricao)"
    }
}
