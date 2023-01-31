import kotlin.random.Random
import kotlin.random.nextInt

// Этот класс описывает игральную карточку

//Из условия задания:
//Игровая карточка состоит из трёх строк, в каждой из них по девять клеток,
//пять из которых занимают числа. Пустые клетки для игры не предназначены.
//Числа на одной карточке не могут повторяться. При желании можно
//расположить числа на карточке в порядке возрастания (для удобства игрока).
class Card() {
    var card: MutableList<MutableList<Square>> = mutableListOf()
    var isWin: Boolean = false
    var numbers: List<Int> = listOf()// числа на карточке

    init {
        this.fillRandomly()
    }

    //всего чисел 99, они перемешиваются и беруться первые 15, и распределяются по трем строчкам
    fun fillRandomly() {
        //Добавить три пустых строчки
        for (i in 1..3) {
            card.add(mutableListOf())
        }

        //Получить числа со всей карточки
        this.numbers = (0..100)
            .shuffled()
            .take(15)
            .toList()

        //Распределить те числа по карточке
        //На каждую строчку по пять чисел
        var iMap = 1
        card.map {
            var numbersTemp = numbers.slice((iMap - 1) * 5 until (iMap * 5)).sorted().toMutableList()
            while (numbersTemp.size < 9) numbersTemp.add(
                Random.nextInt(0..numbersTemp.size),
                0
            )// Поставить пробелы в случайные места
            iMap++

            for (iSquareNumber in 1..9) {
                it.add(Square())
            }
            var ii = 0// Номер ячейки в строчке
            it.forEach {
                it.number = numbersTemp[ii]
                ii++
            }
        }
    }

    fun printCard() {
        for (line: MutableList<Square> in card) {
            for (everySquare: Square in line) {
                var element: String = ""
                if (everySquare.number < 10) element = " "
                if (everySquare.number == 0) print(" ${element}  |")
                else print(" ${element}${everySquare.number} |")
            }
            println("")
        }
        println("")
    }

    fun checkLines(): Boolean {
        for (line: MutableList<Square> in card) {
            var markedSquares = 0
            for (everySquare: Square in line) {
                if (everySquare.isMarked) markedSquares++
                if (markedSquares == 5) {
                    this.isWin = true
                }
            }
        }
        return this.isWin
    }

    fun markSquareIfNumber(number: Int): Boolean {
        var isMarked = false
        for (line: MutableList<Square> in card) {
            for (everySquare: Square in line) {
                if (everySquare.number == number)
                {
                    everySquare.isMarked = true
                    isMarked = true
                }
                checkLines()
            }
        }
        return isMarked
    }
}