class MyWarrior(
    override var maxHealth: Int,
    override var luckyPossibility: Int,
    override var accuracy: Int,
    override var weapon: AbstractWeapon,
    override var name: String
) : AbstractWarrior() {

    override var health: Int = 0

    init {
        health = maxHealth
    }

    override var isKilled: Boolean = false
    override var isLucky: Boolean = false

    override fun attack(enemy: Warrior) {
        if (accuracy.isEvent()) {//если попал, то нанес урон
            enemy.takeDamage(weapon.shot())
        }
    }

    override fun takeDamage(damage: Int) {
        if (!luckyPossibility.isEvent()) {//если не везет, то не получать урон
            health -= damage
            isKilled = health <= 0
        }
    }
}