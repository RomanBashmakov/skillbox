//Потенциальный кэшбэк percent% от покупок при условии трат больше 5 000 тыс.
class TBC(private var percent: Int) : DebitCard() {
    override fun pay(money: Int): Boolean {
        var isEnoughMoney: Boolean = false
        if (money <= balance) {
            balance -= money
            if (money > 5000){
                println("Ваш кэшбэк ${(money * percent) / 100}")
                balance += (money * percent) / 100
                isEnoughMoney = true
            }
            println("Кэшбэка нет")
        }
        else println("Денег недостаточно для покупки на $money")
        super.accountAllBalance()
        return isEnoughMoney
    }
}