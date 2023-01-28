import kotlin.random.Random

enum class Ammo(var damage: Int, var crit: Int, var koeff: Int) {
    bullet1(20, 20, 2),
    bullet2(30, 30, 3),
    bullet3(40, 40, 4);

    fun shot(): Int {
        return if (crit.isEvent()) damage * koeff
        else damage
    }
}

//Расширение для класса Int
fun Int.isEvent(): Boolean {
    return this >= Random.nextInt(0, 100)
}