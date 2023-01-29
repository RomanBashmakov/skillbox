fun main(args: Array<String>) {
    val myArray = arrayOf(-5, 6, 2)

    val myWheel = Wheel(1.6, 2.5)

    for (i in myArray){
        try {
            myWheel.pump(i)
        }
        catch (e: Throwable){
            println(e.message)
        }
    }
}

class TooLowPressure : Throwable (message = "Давление в шинах слишком низкое! Эксплуатация невозможна.")
class TooHighPressure : Throwable (message = "Давление в шинах слишком высокое! Эксплуатация невозможна.")
class IncorrectPressure : Throwable (message = "Введено неверное значение давления в шинах.")