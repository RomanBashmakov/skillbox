import java.math.BigInteger

fun main(args: Array<String>) {

    var sum = BigInteger.valueOf(0)
    var sumPrevious1 = BigInteger.valueOf(0)
    var sumPrevious2 = BigInteger.valueOf(1)

    var i: Int = 1

    var n: Int? = null
    while (n == null || n < 0) {
        print("Enter the Fibonacci number's index you want to count to:")
        n = readlnOrNull()?.toIntOrNull()
    }
    println("The final index: $n")

    while (i <= n)
    {
        sum = sumPrevious1.add(sumPrevious2)
        sumPrevious2 = sumPrevious1
        sumPrevious1 = sum
        println("$i.$sum")
        i++
    }
}