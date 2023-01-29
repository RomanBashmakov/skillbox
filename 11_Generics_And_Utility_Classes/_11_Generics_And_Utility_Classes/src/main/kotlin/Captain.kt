class Captain(var name: String) : MyWarrior
    (
    100,
    50,
    50,
    Weapons.createPistol()
) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (isKilled) println ("Капитан $name был убит")
    }
}