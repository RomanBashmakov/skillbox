class MyWeapon(
    override val maxBullets: Int,
    override val fireType: FireType,
    override val ammoType: Ammo,
) : AbstractWeapon() {

    var magazine: Stack<Ammo> = Stack()

    override var isBullets: Boolean = checkBullets()

    override fun newBullet(): Ammo {
        return ammoType
    }

    override fun reload() {
        if (!checkBullets()) {
            for (i in 1..maxBullets) {
                magazine.push(newBullet())
            }
        }
    }

    override fun nextBullet(): Ammo {
        if (checkBullets()) reload()
        return magazine.pop() ?: Ammo.bullet1
    }

    override fun checkBullets(): Boolean {
        return magazine.isEmpty()
    }

    override fun updateIsBullets() {
        isBullets = checkBullets()
    }

    override fun shot(): Int {
        var d: Int = 0

        if (fireType is FireType.SingleShotMode) d = nextBullet().shot()
        else if (fireType is FireType.BurstMode){
            for (i in 1..fireType.shotsSize){
                d += nextBullet().shot()
            }
        }
        return d
    }
}