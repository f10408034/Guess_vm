package com.vangood.guess_vm

class SecretNumber {
    val secret : Int = ( 2..99 ).random()
    var count : Int = 0

    fun validate(number: Int) :Int{
        count++
        return number - secret
    }
}

fun main(){
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    println("${secretNumber.validate(2)} , count: ${secretNumber.count}")
}