object Weapons {
    lateinit var weapon: AbstractWeapon
    fun createPistol(): AbstractWeapon {
        return MyWeapon(10, FireType.SingleShotMode, Ammo.BULLET1)
    }

    fun createRifle(): AbstractWeapon {
        return MyWeapon(10, FireType.BurstMode(3), Ammo.BULLET2)
    }

    fun createRevolver(): AbstractWeapon {
        return MyWeapon(10, FireType.SingleShotMode, Ammo.BULLET3)
    }

    fun createMachineGun(): AbstractWeapon {
        return MyWeapon(10, FireType.BurstMode(10), Ammo.BULLET1)
    }
}