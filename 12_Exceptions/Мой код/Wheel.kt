class Wheel(var minPressure: Double, var maxPressure: Double) {
    var currentPressure: Int = 0

    fun pump(pressure: Int) {
        when {
            pressure <= minPressure && pressure >= 0 -> {
                println("При накачке $pressure атмосфер процедура удалась. Эксплуатация невозможна — давление слишком низкое.")
                throw TooLowPressure()
            }
            pressure >= maxPressure && pressure <= 10 ->{
                println("При накачке $pressure атмосфер процедура не удалась. Эксплуатация невозможна — давление превышает.")
                throw TooHighPressure()
            }

            pressure < 0 || pressure > 10 ->{
                println("При накачке $pressure атмосфер процедура не удалась.")
                throw IncorrectPressure()
            }
            else ->{
                println("При накачке $pressure атмосфер процедура удалась. Эксплуатация возможна.")
                currentPressure = pressure
            }
        }
    }

    fun checkPressure() {
        when {
            currentPressure <= minPressure && currentPressure >= 0 -> throw TooLowPressure()
            currentPressure >= maxPressure && currentPressure <= 10 -> throw TooHighPressure()
            currentPressure < 0 || currentPressure > 10 -> throw IncorrectPressure()
            else -> println("Давление – $currentPressure. Эксплуатация возможна")
        }
    }

}