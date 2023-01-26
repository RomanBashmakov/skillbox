open class DebitCard : BankCard() {
    override var balance: Int = 0

    override fun cashIn(money: Int) {
        balance += money
        accountAllBalance()
    }

    override fun pay(money: Int): Boolean {
        var isEnoughMoney = false
        if (money <= balance) {
            balance -= money
            isEnoughMoney = true
        }
        else {
            println("Денег недостаточно для покупки на $money")
        }
        accountAllBalance()
        return isEnoughMoney
    }

    override fun accountBalance() {
        println("Ваш баланс: $balance")
    }

    override fun accountAllBalance() {
        println("Ваш баланс: $balance")
    }

}