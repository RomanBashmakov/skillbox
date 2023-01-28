fun main(args: Array<String>) {

//____Часть 1 ________________________________________________________________
    println("Первая часть практической работы")
    val myStack: Stack<Int> = Stack()

    for (i in 0..10) myStack.push(i)

    for (i in 0..15){
        println(myStack.pop())
    }

//____Часть 2 ________________________________________________________________
//  Каждый ход битвы каждый член команды атакует случайного члена другой команды.
//  Каждый ход обе команды "очищаются" от умерших.
//  Если в обеих коммандах хоть кто-то остался – шаг повторяется

    println("Вторая часть практической работы")

    var team1 = MyArmy("Team 1", getPositiveInt("Воинов в команде 1:"))
    var team2 = MyArmy("Team 2", getPositiveInt("Воинов в команде 2:"))

    var theBattle = Battle(team1, team2)
    theBattle.fight()
}


fun getPositiveInt(message: String): Int {
    var n: Int? = null
    while (n == null || n < 0) {
        print(message)
        n = readlnOrNull()?.toIntOrNull()
    }
    return n
}