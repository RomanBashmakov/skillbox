import kotlinx.coroutines.*
import java.math.BigInteger

fun main(): Unit = runBlocking {

    //3. "Запустите две или более корутин в функции main."
    //4. "Рассчитайте несколько чисел Фибоначчи в порядке возрастания"
    val job = launch {
        delay(1000)
        val sum = Fibonacci.take(5)
        println("Значение пятого числа Фибоначчи - $sum")
    }

    val job1 = launch {
        delay(500)
        val sum = Fibonacci.take(10)
        println("Значение десятого числа Фибоначчи - $sum")
    }

    val job2 = launch {
        delay(100)
        val sum = Fibonacci.take(15)
        println("Значение пятнадцатого числа Фибоначчи - $sum")
    }

    job.join()
    job1.join()
    job2.join()
    println("Задание 3-4 закончилось.\n")

    //7-8. "Отмените выполнение функции take при превышении какого-то времени."

    try {
        withTimeout(30) {
            var sum = Fibonacci.take(500000)
            println(sum)
        }
    }
    catch (e: TimeoutCancellationException){
        println("Превышено время выполнения\n")
    }

    //9 + доп. "Эта корутина должна работать до тех пор, пока идут вычисления всех ваших чисел Фибоначчи."
    println("Задание 9. Вычисление большого числа (У меня это занимает примерно секунды 4-5):")
    val job3 = launch {
        var i = 1
        while (isActive){
            delay(10)
            if (i % 100 == 0){
                println(".")
                i = 1
            }
            else {
                print(".")
                i++
            }
        }
    }


    val job4 = launch{
        var sum = Fibonacci.take(500000)//
        job3.cancelAndJoin()
        println("\n$sum")
    }

    job4.join()
    println("Конец программы")
}