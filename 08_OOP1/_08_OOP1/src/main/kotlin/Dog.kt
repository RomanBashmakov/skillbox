class Dog(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {
    override fun move()
    {
        if ( (this.age < this.maxAge) && (this.weight > 0) && ((this.energy > 5)))
        {
            this.energy -= 5
            this.weight--
            tryIncrementAge()
            println("$name летит")
        }
        else println("$name слишком худая, старая или уставшая, чтобы летать")
    }

    override fun givingBirth(): Dog
    {
        var aPuppy = Dog((0..10).random(), (0..5).random(), this.maxAge, "${this.name}${this.children + 1}")
        this.children++
        println("Родился щенок ${aPuppy.name} весом ${aPuppy.weight} с энергией ${aPuppy.energy} и макс. возрастом ${aPuppy.maxAge}")
        return aPuppy
    }
}