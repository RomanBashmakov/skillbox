interface CurrencyConverter {
    var currencyCode: String
    var exchangeRate: Int
    fun convertRub(rubs: Int): Int
    fun setRate(exchangeRate: Int)
    fun getRate(): Int
}