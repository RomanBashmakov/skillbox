class CreditCard(var limit: Int) : BankCard(){
    override var balance: Int = 0
    var creditBalance: Int = 0
    init {
        creditBalance = limit
    }

    override fun cashIn(money: Int) {
        if (creditBalance < limit){
            if ((limit - creditBalance) <= money) creditBalance += money
            else {
                balance += money - (limit - creditBalance)
                creditBalance = limit
            }
        }
        else balance += money
        println("После пополнения на $money:")
        accountAllBalance()
    }

    override fun pay(money: Int) {
        if (money <= balance) {
            balance -= money
            println("После покупки на $money:")
        }
        else if (money < (balance + creditBalance)) {
            creditBalance = balance + creditBalance - money
            balance = 0
        }
        else println("Денег недостаточно для покупки на $money")
        accountAllBalance()
    }

    override fun accountBalance() {
        println("Собственные средства: $balance")
    }

    override fun accountAllBalance() {
        println("Собственные средства: $balance")
        println("Кредитные средства: $creditBalance")
    }

}