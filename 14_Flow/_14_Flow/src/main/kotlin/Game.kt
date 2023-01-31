class Game(val gamersQuantity: Int) {
    var playersList = mutableListOf<Player>()
    var gameIsOver = false

    init {
        initPlayers(gamersQuantity)
    }

    fun initPlayers(quantity: Int){
        println("Новые игроки:\n")
        for (i in 1..quantity){
            playersList.add(Player("Игрок_$i"))
        }
    }

    fun checkNumber(number: Int){
        playersList.forEach { gameIsOver = gameIsOver || it.markSquare(number)  }
        if (gameIsOver) println("Игра окончена!")
    }

}