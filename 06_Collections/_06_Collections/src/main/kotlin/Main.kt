fun main(args: Array<String>) {
    //Ввод количества элементов в исходном списке
    var N: Int? = null
    while (N == null || N < 0) {
        print("Enter number N:")
        N = readlnOrNull()?.toIntOrNull()
    }

    //Генерирование исходного списка со случайными значениями
    val myImmutablelist: List<Int> = List(N) { (-5..5).random() }
    println("Generated immutable list:\n$myImmutablelist")

    //Преобразование исходного списка в mutable список
    val myMutableList: MutableList<Int> = myImmutablelist.toMutableList()
    println("Generated mutable list:\n$myMutableList")

    //Умножение каждого четного элемента на 10
    for (i in myMutableList.indices)
    {
        if (myMutableList[i] % 2 == 0) myMutableList[i] *= 10
    }
    println("Generated mutable list:\n$myMutableList")

    //Суммирование элементов списка
    val sumOfMyList: Int = myMutableList.sumOf { i -> i }
    println("A sum of the all elements in my mutable list is $sumOfMyList")

    //Фильтрация че
}