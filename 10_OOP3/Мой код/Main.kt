fun main(args: Array<String>) {
    //Make some Converters
    val currencyConverter1 = CurrencyConverter1("EUR", 50)
    val currencyConverter2 = CurrencyConverter1("BYN", 30)

    //Create my singleton
    val mySingletonConverters = Converters
    //Add created Converters to my singleton
    mySingletonConverters.addConverter(currencyConverter1)
    mySingletonConverters.addConverter(currencyConverter2)

    val gottenCurrencyConverter1 = mySingletonConverters.get("EUR")
    val gottenCurrencyConverter2 = mySingletonConverters.get("BYN")
    val gottenCurrencyConverter3 = mySingletonConverters.get("USDT")

    //Сконвертировать рубли в валюту
    gottenCurrencyConverter1.convertRub(1000)
    gottenCurrencyConverter2.convertRub(1000)
    gottenCurrencyConverter3.convertRub(1000)

}

//Мой синглетон с анонимным объектом внутри функции get
object Converters {
    private val myConvertersSingleton: MutableList<CurrencyConverter> = mutableListOf()

    fun addConverter(currencyConverter: CurrencyConverter) {
        myConvertersSingleton.add(currencyConverter)
    }

    fun get(currencyCodeConverters: String): CurrencyConverter {
        var myConverters = myConvertersSingleton.firstOrNull { currencyConverter -> currencyConverter.currencyCode == currencyCodeConverters}
        if (myConverters == null) {
            //Спросить курс неизвестной валюты у пользователя
            var n: Int? = null
            while (n == null || n < 0) {
                print("Введите курс $currencyCodeConverters: ")
                n = readlnOrNull()?.toIntOrNull()
            }
            //Создать конвертер, наследуя готовый класс
            myConverters = object : CurrencyConverter1(currencyCodeConverters, n){}//анонимный объект
        }
        return myConverters
    }
}
