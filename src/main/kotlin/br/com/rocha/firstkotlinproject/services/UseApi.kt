package br.com.rocha.firstkotlinproject.services

import br.com.rocha.firstkotlinproject.module.*
import br.com.rocha.firstkotlinproject.utils.createGamer
import br.com.rocha.firstkotlinproject.utils.createGames
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse


class UseApi {

    private fun consumeData(url:String): String{
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder().uri(URI.create(url)).build()

        val response = client
            .send(request, HttpResponse.BodyHandlers.ofString())

        return response.body()
    }

    fun searchGame(id:String): InfoGame{
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = consumeData(url)

        if (json.isEmpty() || json.trim() == "[]") {
            throw IllegalStateException("A resposta da API está vazia ou é um array vazio.")
        }

        val gson = Gson()
        val myInfoGame = gson.fromJson(json, InfoGame::class.java)

        return myInfoGame

    }

    fun listGames(): List<Game>{
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = consumeData(url)

        val gson = Gson()
        val gameType = object : TypeToken<List<InfoApiListGames>>() {}.type
        val listGames: List<InfoApiListGames> = gson.fromJson(json, gameType)
        val mappedListGamesList = listGames.map { InfoApiListGames -> InfoApiListGames.createGames()}

        return mappedListGamesList

    }

    fun searchGamer(): List<Gamer>{
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consumeData(url)

        val gson = Gson()
        val myGamerType = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listGamers: List<InfoGamerJson> = gson.fromJson(json, myGamerType)

        val mappedGamerList = listGamers.map { InfoGamerJson -> InfoGamerJson.createGamer()
        }

        return mappedGamerList
    }
}