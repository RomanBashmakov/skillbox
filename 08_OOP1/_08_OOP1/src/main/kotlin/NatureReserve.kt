class NatureReserve(val animals: Int, val birds: Int, val fishes: Int, val dogs: Int) {

    val myZoo: MutableList<Animal> = mutableListOf()

    init {
        //Get some animals
        for (i in 1..animals)
        {
            myZoo.add(Animal((0..10).random(), (0..5).random(), (0..10).random(), "animal$i"))
        }
        //Get some birds
        for (i in 1..birds)
        {
            myZoo.add(Bird((0..10).random(), (0..5).random(), (0..10).random(), "bird$i"))
        }
        //Get some fishes
        for (i in 1..fishes)
        {
            myZoo.add(Fish((0..10).random(), (0..5).random(), (0..10).random(), "fish$i"))
        }
        //Get some dogs
        for (i in 1..dogs)
        {
            myZoo.add(Dog((0..10).random(), (0..5).random(), (0..10).random(), "dog$i"))
        }
    }

    fun startZoo(n: Int)
    {
        for (i in 0..n){
            println("\nШаг $i:")
            if (myZoo.size != 0)
            {
                var bornAnimal: Animal? = null
                myZoo.forEach { animal: Animal -> bornAnimal = animal.doSmthg((1..4).random()) }
                if (bornAnimal != null) myZoo.add(bornAnimal!!)
                myZoo.filter { animal: Animal -> animal.tooOld() }
                println("Осталось животных: ${myZoo.size}")
            }
            else
            {
                println("Все мертвы")
                break
            }
        }
    }
}