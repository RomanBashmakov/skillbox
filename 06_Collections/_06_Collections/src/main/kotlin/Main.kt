fun main(args: Array<String>) {
//ЧАСТЬ 1_________________________________________________________________________________________________________

    println("************** Part 1 **************")
    //Ввод количества элементов в исходном списке
    var N: Int? = null
    while (N == null || N < 0) {
        print("Enter number N:")
        N = readlnOrNull()?.toIntOrNull()
    }

    //Генерирование исходного списка со случайными значениями
    val myImmutableList: List<Int> = List(N) { (-5..5).random() }
    println("\nGenerated immutable list:\n$myImmutableList\n")

    //Преобразование исходного списка в mutable список
    val myMutableList: MutableList<Int> = myImmutableList.toMutableList()
    println("Generated mutable list:\n$myMutableList\n")

    //Умножение каждого четного элемента на 10

    /*Первый вариант
    for (i in myMutableList.indices)
    {
        if (myMutableList[i] % 2 == 0) myMutableList[i] *= 10
    }*/

    //Второй вариант
    //Функция умножения на
    fun <Int> MutableList<Int>.mapInPlace(mutator: (Int) -> (Int)) {
        this.forEachIndexed { i, value ->
            val changedValue = mutator(value)
            this[i] = changedValue
        }
    }

    myMutableList.mapInPlace {
            element -> if (element % 2 == 0) element * 10 else element
    }

    println("Generated mutable list:\n$myMutableList\n")

    //Суммирование элементов списка
    val sumOfMyList: Int = myMutableList.sumOf { i -> i }
    println("A sum of the all elements of my mutable list is $sumOfMyList\n")

    //Фильтрация, оставить только положительные
    val myMutableListFiltered: List<Int> = myMutableList.filter { element -> element > 0}
    println("Filtered list:\n$myMutableListFiltered\n")


//ЧАСТЬ 2_________________________________________________________________________________________________________
    println("************** Part 2 **************")

    //Ввод user и password:

    N = null
    while (N == null || N < 0) {
        print("Enter number of users:")
        N = readlnOrNull()?.toIntOrNull()
    }

    val myUsersHashMap = HashMap<String, String> ()
    var newKey: String? = null
    var newValue: String? = null

    var enteredPassword: String? = null
    var enteredUserName: String? = null

    println("The data preparation's started")
    for (i in 1..N)
    {
        newKey = null
        newValue = null

        while (newKey == null) {
            print("Enter Username ${i}:")
            newKey = readlnOrNull().toString()
        }

        while (newValue == null) {
            print("Enter Password ${i}:")
            newValue = readlnOrNull().toString()
        }

        myUsersHashMap[newKey] = newValue
    }

    println("The data preparation's finished. The given hash map is:\n ${myUsersHashMap}")

    while (true)
    {
        enteredUserName = null
        enteredPassword = null

        while (enteredUserName == null) {
            print("\nEnter Username:")
            enteredUserName = readlnOrNull().toString()
        }

        while (enteredPassword == null) {
            print("Enter Password:")
            enteredPassword = readlnOrNull().toString()
        }

        if (enteredPassword == myUsersHashMap[enteredUserName]) println("Hello, ${enteredUserName}!")
        else println("You entered an incorrect username or password")
    }

}