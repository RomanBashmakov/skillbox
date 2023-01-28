class MyArmy(val name: String, var quantity: Int) {

    private var captainsPossibility: Int = 40
        set(value) {captainsPossibility = value}
    private var generalsPossibility: Int = 10
        set(value) {generalsPossibility = value}

    var myArmy: MutableList<MyWarrior> = mutableListOf()
    var Q: Int = 0// Number of created people

    init {
        fillArmy(quantity)
    }

    fun fillArmy(quantity: Int){
        for (i in 1..quantity){

            //Попробовать добавить капитана
            if (captainsPossibility.isEvent()) myArmy.add(MyWarrior(
                100,
                50,
                50,
                Weapons.createPistol(),
                "Captain${++Q}")
            )

            //Попробовать добавить генерала
            else if (generalsPossibility.isEvent()) myArmy.add(MyWarrior(
                1000,
                90,
                100,
                Weapons.createRevolver(),
                "General${++Q}")
            )

            //Если не получилось, то добавить обычного солдата
            else myArmy.add(MyWarrior(
                100,
                0,
                50,
                Weapons.createRifle(),
                "Soldier${++Q}")
            )
        }
    }

    fun isAllKilled(): Boolean{
        return myArmy.size == 0
    }

    fun updateArmy(): Boolean{
        myArmy.removeIf { myWarrior: MyWarrior -> myWarrior.isKilled }
        return isAllKilled()
    }
}