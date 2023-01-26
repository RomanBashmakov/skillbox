fun main(args: Array<String>) {

    //Операции по карте Сбера______________________________________
    var n: Int? = null
    while (n == null || n < 0) {
        print("Процент от покупки при оплате картой Сбера, возвращаемый бонусными баллами:")
        n = readlnOrNull()?.toIntOrNull()
    }
    val sber = Sber (n)

    sber.cashIn(100000)
    sber.pay(10000)
    sber.pay(1000)
    sber.pay(100000)

    //Операции по карте TBC________________________________________
    n = null
    while (n == null || n < 0) {
        print("\nКэшбэк на карту TBC от покупки больше 5000:")
        n = readlnOrNull()?.toIntOrNull()
    }
    val tbc = TBC (n)

    tbc.cashIn(100000)
    tbc.pay(10000)
    tbc.pay(1000)
    tbc.pay(100000)

    //Операции по кредитной карте Tinkoff___________________________
    n = null
    while (n == null || n < 0) {
        print("\nЛимит по карте Tinkoff:")
        n = readlnOrNull()?.toIntOrNull()
    }

    val tinkoff = CreditCard (n)

    tinkoff.cashIn(100000)
    tinkoff.pay(10000)
    tinkoff.pay(1000)
    tinkoff.pay(100000)
}