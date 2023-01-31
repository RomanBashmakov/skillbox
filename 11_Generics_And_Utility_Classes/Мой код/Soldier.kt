class Soldier(var name: String) : MyWarrior
    (
    100,
    10,
    50,
    Weapons.createRifle(),
) {
    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
        if (isKilled) println ("Рядовой $name был убит")
    }
}