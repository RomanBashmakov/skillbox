
fun main(args: Array<String>) {

    //Enter the cycles quantity
    var n: Int? = null
    while (n == null || n < 0) {
        print("Enter the cycles quantity: ")
        n = readlnOrNull()?.toIntOrNull()
    }

    val natureReserve = NatureReserve(2, 5, 3,2)
    natureReserve.startZoo(n)
}