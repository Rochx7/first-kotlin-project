package br.com.rocha.firstkotlinproject.module

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


}
