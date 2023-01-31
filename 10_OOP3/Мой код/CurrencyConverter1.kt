open class CurrencyConverter1(currencyCodeArg: String, exchangeRateArg: Int): CurrencyConverter{
    override var currencyCode: String = ""
    override var exchangeRate: Int = 0

    init {
        currencyCode = currencyCodeArg
        exchangeRate = exchangeRateArg
    }

    override fun convertRub(rubs: Int): Int {
        println("$rubs рублей = ${rubs / exchangeRate} $currencyCode")
        return rubs / exchangeRate
    }

    override fun setRate(exchangeRate: Int) {
        this.exchangeRate = exchangeRate
    }

    override fun getRate(): Int {
        return this.exchangeRate
    }
}