import kotlin.random.Random

open class Animal (protected var energy: Int, protected var weight: Int, protected val maxAge: Int, val name: String) {
    protected var age: Int = 0
    protected var children: Int = 0
    private var isTooOld: Boolean = false

    fun tooOld():Boolean { return age >= maxAge }

    fun sleep()
    {
        if (this.age < this.maxAge)
        {
            this.age++
            this.energy += 5
            println("$name спит")
        }
        else println("$name слишком старая, чтобы спать")
    }

    fun eat()
    {
        if (this.age < this.maxAge)
        {
            this.energy += 3
            this.weight++
            tryIncrementAge()
            println("$name ест")
        }
        else println("$name слишком старая, чтобы есть")
    }

    open fun move()
    {
        if ( (this.age < this.maxAge) && (this.weight > 0) && ((this.energy > 5)))
        {
            this.energy -= 5
            this.weight--
            tryIncrementAge()
            println("$name передвигается")
        }
        else println("$name слишком худая, старая или уставшая, чтобы двигаться")
    }

    fun tryIncrementAge() {if (Random.nextBoolean()) this.age++}

    open fun givingBirth (): Animal
    {
        var aChild = Animal((0..10).random(), (0..5).random(), this.maxAge, "${this.name}${this.children + 1}")
        this.children++
        println("Было рождено животное ${aChild.name} весом ${aChild.weight} с энергией ${aChild.energy} и макс. возрастом ${aChild.maxAge}")
        return aChild
    }

    fun doSmthg (move: Int): Animal?
    {
        when (move) {
            1 -> {
                sleep()
                return null
            }
            2 -> {
                eat()
                return null
            }
            3 -> {
                move()
                return null
            }
            4 -> {
                return givingBirth()
            }
            else -> {
                println("$name не может этого сделать")
                return null
            }
        }
    }
}