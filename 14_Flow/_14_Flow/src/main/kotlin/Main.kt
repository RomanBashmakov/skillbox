import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.random.Random

fun main(args: Array<String>) {
    var n = getPositiveInt("Введите количество игроков: ")
    var game = Game(n)

    runBlocking {
        launch {
            intermediateFlow.collect {
                if (game.gameIsOver) cancel()
                else {
                    println("Выпало число $it")
                    game.checkNumber(it)
                }
                delay(100)
            }
        }
    }
}

val intermediateFlow = (0..100)
    .shuffled()
    .asFlow()

fun getPositiveInt(message: String): Int {
    var n: Int? = null
    while (n == null || n < 0) {
        print(message)
        n = readlnOrNull()?.toIntOrNull()
    }
    return n
}


