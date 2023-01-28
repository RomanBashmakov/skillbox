interface Warrior {
    var isKilled: Boolean
    var isLucky: Boolean

    fun attack(enemy: Warrior) {}
    fun takeDamage(damage: Int) {}
}