fun getDigits(n: Int): Set<Int> {
    val digits = HashSet<Int>()
    var number = n
    while (number != 0) {
        val digit = number % 10
        digits.add(digit)
        number /= 10
    }
    return digits
}
fun main() {
    println("Введите количество строк: ")
    val a = readln().toInt()
    println("Введите количество столбцов: ")
    val b = readln().toInt()
    var i = 0
    var j = 0
    val arr = Array(a) { IntArray(b) }
    println("Введите трехзначные числа: ")
    for (row in arr) {
        i++
        for (cell in row) {
            j++
            val o = readln().toInt()
            arr[i - 1][j - 1] = o
        }
        j = 0
    }
    println("Массив: ")
    for (row in arr) {
        println(row.contentToString())
    }
    val digitSet = HashSet<Int>()
    for (row in arr) {
        for (element in row) {
            val digits = getDigits(element)
            digitSet.addAll(digits)
        }
    }
    // Вывод количества различных цифр
    val count = digitSet.size
    println("Количество различных цифр: $count")
}
