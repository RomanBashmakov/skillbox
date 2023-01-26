//Бонусные баллы в размере percent% от покупок.
class Sber(private var percent: Int) : DebitCard() {
    private var bonus: Int = 0

    override fun pay(money: Int): Boolean {
        var isEnoughMoney: Boolean = false
        if (money <= balance) {
            balance -= money
            bonus += (money * percent) / 100 //дробная часть не учитывается сознательно
            isEnoughMoney = true
        }
        else {
            println("Денег недостаточно для покупки на $money")
        }
        accountAllBalance()
        return isEnoughMoney
    }

    override fun accountAllBalance() {
        super.accountAllBalance()
        println("Баллы: $bonus")
    }

}