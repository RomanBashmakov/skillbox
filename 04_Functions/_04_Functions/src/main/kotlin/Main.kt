/* Шифрование:
    Разделить сообщение пополам.
    Обработать первую половину сообщения следующим образом:
        2.1. В исходном тексте заменить все символы о на символ 0 (ноль).
        2.2. В получившемся тексте заменить каждый символ сообщения символом, стоящим на 3 правее от исходного (сдвиг каждого символа вправо на 3).
        2.3. В получившемся тексте заменить все символы u на цифру 4.
        2.4. В получившемся тексте заменить все символы s на цифру 5.
        2.5. В получившемся тексте заменить каждый символ сообщения символом, стоящим на 1 левее от исходного (сдвиг каждого символа влево на 1).
    Вторую половину сообщения обработать так:
        3.1. Заменить пробелы на символ _
        3.2. В получившемся тексте заменить каждый символ сообщения символом, стоящим на 4 правее от исходного (сдвиг каждого символа вправо на 4).
        3.3. Развернуть получившуюся строку.
    Соединить обе зашифрованные половины.*/

fun main(args: Array<String>) {

    val encryptedString1st: String = """
        F2p)v"y233{0
        """.trimIndent()

    val encryptedString2nd: String = """
        ->c}ttelciFc
        """.trimIndent()

    print(decryptFirstHalf(encryptedString1st))
    println(decryptSecondHalf(encryptedString2nd))

    print(decryptFirstHalf2(encryptedString1st))
    println(decryptSecondHalf2(encryptedString2nd))
}

// The 1st way of decrypting_______________________________________________________________________________________
fun decryptFirstHalf(sourceString: String): String {
    return sourceString.map { c -> c + 1 }.joinToString("")
        .replace("5", "s")
        .replace("4", "u")
        .map { char -> char - 3 }.joinToString("")
        .replace("0", "o")
}

fun decryptSecondHalf(sourceString: String): String {
    return sourceString.reversed()
        .map { char -> char - 4 }.joinToString("")
        .map<Any> { char -> if (char == '_') " " else char }.joinToString("")
}

// The 2nd way of decrypting_______________________________________________________________________________________
fun shift(sourceString: String, func: (Char) -> Char): String
{
    return sourceString.map(func).joinToString("")
}

fun decryptFirstHalf2 (sourceString: String): String
{
    val shiftedString: String = shift(sourceString) { ch -> ch + 1 }
    val mappedString5tos: String = shift(shiftedString) { char -> if (char == '5') 's' else char }
    val mappedString4tou = shift(mappedString5tos) { char -> if (char == '4') 'u' else char }
    val shiftedStringMinus3 = shift(mappedString4tou) { char -> char - 3 }
    val decryptFirstHalf = shift(shiftedStringMinus3) { char -> if (char == '0') 'o' else char }

    return decryptFirstHalf
}

fun decryptSecondHalf2 (sourceString: String): String
{
    val reversedString = sourceString.reversed()
    val shiftedStringMinus4 = shift(reversedString) {char -> char - 4}
    val decryptSecondHalf = shift(shiftedStringMinus4) {char -> if (char == '_') ' ' else char}
    return decryptSecondHalf
}