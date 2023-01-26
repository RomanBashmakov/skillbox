open class DebitCard : BankCard() {
    override var balance: Int = 0

    override fun cashIn(money: Int) {
        balance += money
        accountAllBalance()
    }

    override fun pay(money: Int) {
        if (money <= balance) balance -= money
        else println("Денег недостаточно для покупки на $money")
        accountAllBalance()
    }

    override fun accountBalance() {
        println("Ваш баланс: $balance")
    }

    override fun accountAllBalance() {
        println("Ваш баланс: $balance")
    }

}