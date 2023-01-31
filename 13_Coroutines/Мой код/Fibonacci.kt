import kotlinx.coroutines.yield
import java.math.BigInteger

object Fibonacci {

    suspend fun take(number: Int): BigInteger{

        var sum = BigInteger.valueOf(0)
        var sumPrevious1 = BigInteger.valueOf(0)
        var sumPrevious2 = BigInteger.valueOf(1)

        var i = 1

        while (i <= number)
        {
            sum = sumPrevious1.add(sumPrevious2)
            sumPrevious2 = sumPrevious1
            sumPrevious1 = sum
            i++
            yield()//5. Сделайте suspend функцию take отменяемой.
        }
        return sum
    }
}