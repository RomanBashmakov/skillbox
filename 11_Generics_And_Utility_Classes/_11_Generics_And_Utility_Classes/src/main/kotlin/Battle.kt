
class Battle(var team1: MyArmy, var team2: MyArmy) {

    var isOver: Boolean = false

    fun getState(){
        if (isOver) println("Битва завершена")
        else println("Битва продолжается")
    }

    fun isAlive(): Boolean {
        return team1.myArmy.size != 0 && team2.myArmy.size != 0
    }

    fun whoWin(){
        if ( team1.myArmy.size == 0 ) println("Выиграла команда ${team2.name}")
        else println("Выиграла команда ${team1.name}")
    }

    fun fight(){
        while (isAlive()) {
            team1.myArmy.shuffle()// Стреляющие будут определены
            team2.myArmy.shuffle()// случайным образом с помощью перемешивания

            team1.myArmy.first().attack(team2.myArmy.first())//первый атакует первого
            team2.updateArmy()
            if (!isAlive()) break

            team2.myArmy.first().attack(team1.myArmy.first())//первый атакует первого
            team1.updateArmy()
        }
        whoWin()
    }
}