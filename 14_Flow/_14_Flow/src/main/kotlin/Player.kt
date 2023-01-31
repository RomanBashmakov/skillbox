class Player(val playersName: String) {
    var isWin: Boolean = false
    var card: Card = Card()
    init {
        println("Карточка игрока $playersName:")
        card.printCard()
    }

    fun markSquare(number: Int): Boolean{
        if (card.markSquareIfNumber(number)){
            println("$playersName отмечает у себя число $number")
            checkIfWin()
        }
        return isWin
    }

    fun checkIfWin() {
        isWin = card.isWin
        if (isWin) println("Бинго! $playersName победил!")

    }
}