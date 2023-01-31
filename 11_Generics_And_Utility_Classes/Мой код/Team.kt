class Team(val name: String, var quantity: Int) {

    private var captainsPossibility: Int = 40
        set(value) {captainsPossibility = value}
    private var generalsPossibility: Int = 10
        set(value) {generalsPossibility = value}

    var myArmy: MutableList<MyWarrior> = mutableListOf()
    var Q: Int = 0// Number of created people
    var peopleLeft: Int = 0// Number of left people

    init {
        fillArmy(quantity)
        peopleLeft = quantity
    }

    fun fillArmy(quantity: Int){
        for (i in 1..quantity){

            //Попробовать добавить капитана
            if (captainsPossibility.isEvent()) myArmy.add(Captain("Captain${++Q}"))

            //Попробовать добавить генерала
            else if (generalsPossibility.isEvent()) myArmy.add(General("General${++Q}"))

            //Если не получилось, то добавить обычного солдата
            else myArmy.add(Soldier("Soldier${++Q}"))
        }
    }

    fun isAllKilled(): Boolean{
        return myArmy.size == 0
    }

    fun updateArmy(): Boolean{
        myArmy.removeIf { myWarrior: MyWarrior -> myWarrior.isKilled }
        peopleLeft = myArmy.size
        return isAllKilled()
    }

    fun people(): Int{
        peopleLeft = myArmy.size
        return peopleLeft
    }
}