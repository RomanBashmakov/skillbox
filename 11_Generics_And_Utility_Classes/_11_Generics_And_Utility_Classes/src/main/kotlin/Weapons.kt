object Weapons {
    lateinit var weapon: AbstractWeapon
    fun createPistol(): AbstractWeapon {
        return MyWeapon(10, FireType.SingleShotMode, Ammo.bullet1)
    }

    fun createRifle(): AbstractWeapon {
        return MyWeapon(10, FireType.BurstMode(3), Ammo.bullet2)
    }

    fun createRevolver(): AbstractWeapon {
        return MyWeapon(10, FireType.SingleShotMode, Ammo.bullet3)
    }

    fun createMachineGun(): AbstractWeapon {
        return MyWeapon(10, FireType.BurstMode(10), Ammo.bullet1)
    }
}