abstract class BankCard {
    abstract var balance: Int
    abstract fun cashIn(money: Int)
    abstract fun pay(money: Int): Boolean
    abstract fun accountBalance()
    abstract fun accountAllBalance()

}