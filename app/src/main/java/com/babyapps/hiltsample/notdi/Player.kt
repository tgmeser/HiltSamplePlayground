package com.babyapps.hiltsample.notdi

class Player(squadNumber: Int, playerName: String, position: Position, team: Team) {
    val squadNumber = squadNumber
    val playerName = playerName
    val position = position
    val team = team
    fun play(){
        println("$playerName is playing....")
    }

}