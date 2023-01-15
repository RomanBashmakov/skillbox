fun main(args: Array<String>) {

    //The tasks from #1 to #5
    val firstName: String = "Roman"
    val lastName: String = "Bashmakov"
    var height: Double = 1.72
    var weight: Float = 86.0F

    //Auxiliary function
    var info: String = myAppearance(firstName, lastName, height, weight)
    println("The first variant:\n" + info)

    //New height
    height = 1.4
    println("New height = $height m\n")

    //Taking into account the new value
    info = myAppearance(firstName, lastName, height, weight)
    println("The second variant:\n" + info)
}

fun myAppearance(_firstName: String,
                 _lastName: String,
                 _height: Double,
                 _weight: Float): String {
    val _isChild: Boolean = _height < 1.5 || _weight < 40
    val myAppearance: String =
        "My first name: $_firstName\n" +
        "My last name: $_lastName\n" +
        "My height: $_height m\n" +
        "My weight: $_weight kg\n" +
        "I am a child? - $_isChild\n"
    return myAppearance
}