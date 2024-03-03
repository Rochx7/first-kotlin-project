package br.com.rocha.firstkotlinproject.module

import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name:String, var email:String){
    var birthday: String? = null
    var user: String? = null
        set(value) {
            field = value
            if(id.isNullOrBlank()){
                createId()
            }
        }
    var id :String? = null
        private set

    val searchedGames = mutableListOf<Game?>()

    constructor(name:String, email:String, birthday:String, user:String):
            this(name, email){
                this.birthday = birthday
                this.user = user
                createId()
            }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthday=$birthday, user=$user, id=$id)"
    }

    fun createId(){
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$user#$tag"
    }

    fun validarEmail(): String{
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
        if(regex.matches(email)){
            return email
        } else{
            throw IllegalArgumentException("Email inválido")
        }
    }

    companion object{
        fun createGame(reading: Scanner): Gamer{
            println("Boas vindas ao GameNation! Vamos fazer seu cadastro. Digite seu nome:")
            val name = reading.nextLine()
            println("Digite seu e-mail:")
            val email = reading.nextLine()
            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val option = reading.nextLine()

            if(option.equals("s", ignoreCase = true)){
                println("Digite sua data de nascimento:")
                val birthday = reading.nextLine()
                println("Digite seu usuário:")
                val user = reading.nextLine()
                return Gamer(name, email, birthday, user)
            }else{
                return Gamer(name, email)
            }
        }
    }

}
