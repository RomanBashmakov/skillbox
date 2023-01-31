abstract class AbstractWeapon {
    abstract val maxBullets: Int
    abstract val fireType: FireType
    abstract val ammoType: Ammo
    abstract var isBullets: Boolean

    abstract fun newBullet(): Ammo
    abstract fun reload()
    abstract fun nextBullet(): Ammo?
    abstract fun checkBullets(): Boolean
    abstract fun updateIsBullets()
    abstract fun shot(): Int


}