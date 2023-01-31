class General(var name: String) : MyWarrior
    (
    1000,
    90,
    100,
    Weapons.createRevolver()
) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (isKilled) println ("Генерал $name был убит")
    }
}