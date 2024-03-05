package br.com.rocha.firstkotlinproject.module

import java.time.LocalDate
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name:String, var email:String):Average{
    var birthday: String? = null
    var user: String? = null
        set(value) {
            field = value
            if(id.isNullOrBlank()){
                createId()
            }
        }
    private var id :String? = null
        private set

    var plan: Plan = SeparatePlan("COPPER")
    val searchedGames = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent>()
    private val noteList = mutableListOf<Int>()

    override val medium: Double
        get() = noteList.average()

    override fun recommend(note: Int) {
        noteList.add(note)
    }

    constructor(name:String, email:String, birthday:String, user:String):
            this(name, email){
                this.birthday = birthday
                this.user = user
                createId()
            }

    override fun toString(): String {
        return "Gamer:\n" +
                " name=$name,\n" +
                " email=$email,\n" +
                " birthday=$birthday,\n" +
                " user=$user,\n" +
                " id=$id,\n" +
                " Reputation=${medium}"
                ")"
    }

    fun createId(){
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        id = "$user#$tag"
    }

//    fun validarEmail(): String{
//        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
//        if(regex.matches(email)){
//            return email
//        } else{
//            throw IllegalArgumentException("Email inválido")
//        }
//    }

    fun rentedGame(game: Game, period: Period): Rent{
        val rent =  Rent(this, game, period)
        rentedGames.add(rent)

        return rent
    }

    fun gamesByMonth(month:Int):List<Game>{
        val findGameByMonth = rentedGames.filter { rent -> rent.period.initialDate.monthValue == month }.map { rent -> rent.game }
        return findGameByMonth

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
