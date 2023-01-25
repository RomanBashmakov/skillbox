class Fish(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(energy, weight, maxAge, name) {
    override fun move()
    {
        if ( (this.age < this.maxAge) && (this.weight > 0) && ((this.energy > 5)))
        {
            this.energy -= 5
            this.weight--
            tryIncrementAge()
            println("$name плывет")
        }
        else println("$name слишком худая, старая или уставшая, чтобы плавать")
    }

    override fun givingBirth(): Animal
    {
        var aBabyFish = Fish((0..10).random(), (0..5).random(), this.maxAge, "${this.name}${this.children + 1}")
        this.children++
        println("Вылупился малёк ${aBabyFish.name} весом ${aBabyFish.weight} с энергией ${aBabyFish.energy} и макс. возрастом ${aBabyFish.maxAge}")
        return aBabyFish
    }
}