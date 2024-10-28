package org.example

fun main() {

    val channel = YoutubeChannel(mutableListOf())
    channel.addVideo("Reactive Programming")
    channel.addVideo("Introduction to Machine Learning")
    channel.addVideo("Kotlin Development Basics")

    val user = User("Hugo")

    channel.subscribe(user)

}