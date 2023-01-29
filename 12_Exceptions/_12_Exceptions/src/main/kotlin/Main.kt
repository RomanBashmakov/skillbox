fun main(args: Array<String>) {

    val myWheel = Wheel(1.6, 2.5)

}

class TooLowPressure : Throwable (message = "Давление в шинах слишком низкое! Эксплуатация невозможна.")
class TooHighPressure : Throwable (message = "Давление в шинах слишком высокое! Эксплуатация невозможна.")
class IncorrectPressure : Throwable (message = "Введено неверное значение давления в шинах.")