@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

import com.sun.corba.se.impl.oa.toa.TOAFactory
import com.sun.org.apache.bcel.internal.generic.RETURN
import lesson1.task1.discriminant
import lesson5.task1.firstDuplicateIndex
import java.io.File.separator
import java.io.StringReader

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    var s = 0.0
    for (element in v) {
        s += Math.pow(element, 2.0)
    }
    return Math.sqrt(Math.abs(s))
}

/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    var sum = 0.0
    if (list.isEmpty()) return 0.0
    for (element in list) {
        sum += element
    }
    return sum / list.size
}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    var sum = 0.0
    for (element in list) {
        sum += element
    }
    val average = sum / list.size
    for (i in 0 until list.size) {
        list[i] = list[i] - average
    }
    return list
}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    var c = 0.0
    for (i in 0 until a.size) {
        c += a[i] * b[i]
    }
    return c
}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    if (p.isEmpty()) return 0.0
    var s = p[0]
    for (i in 1 until p.size) {
        s += p[i] * Math.pow(x, i.toDouble())
    }
    return s
}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */


fun accumulate(list: MutableList<Double>): MutableList<Double> {
    var s = 0.0
    for (i in 0 until list.size) {
        list[i] += s
        s = list[i]
    }
    return list
}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> {
    val result = mutableListOf<Int>()
    var f = 2
    var number = n
    while (number > 1) {
        if (number % f == 0) {
            result.add(f)
            number /= f
            f = 1
        }
        f++
    }
    return result
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var result = ""
    var f = 2
    var number = n
    var k = 0
    while (number > 1) {
        while (number % f == 0) {
            k++
            if (k == 1) result += "$f"
            else result += "*$f"
            number /= f
        }
        f++
    }
    return result
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    val result = mutableListOf<Int>()
    var number = n
    if (number == 0) result.add(0)
    var remainder: Int
    val s2 = base
    while (number > 0) {
        remainder = number % s2
        result.add(remainder)
        number /= s2
    }
    return result.reversed()
}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    var string = n /* Под переменной string задаем число n*/
    if (n == 0) return "0"
    var convert: String = ""
    val changebase = base
    val char = ('a'..'z').toList()
    while (string > 0) {
        if (string % changebase > 9) {
            for (i in 10..35) {
                if (string % changebase == i) convert += char[i - 10]
            }
        } else
            convert += string % changebase
        string /= changebase
    }
    return convert.reversed()
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    var result = 0
    for (i in 0 until digits.size) {
        result = result * base + digits[i]
    }
    return result
}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val number = str.reversed()
    var result = 0
    for ((index, element) in number.withIndex()) {
        var k1 = 1 /*k1: 1, 2, 3, 4, 5, 6, 7, 8, 9*/
        for (j in '1'..'9') {
            if (number[index] == j) result += k1 * Math.pow(base.toDouble(), index.toDouble()).toInt()
            k1++
        }
        var k2 = 10 /*k2 : a = 10, b = 11, c = 12, d = 13, e = 14, f = 15*/
        for (char in 'a'..'z') {
            if (number[index] == char) result += k2 * Math.pow(base.toDouble(), index.toDouble()).toInt()
            k2++
        }
    }
    return result
}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String {
    /*В переменную d в задаем n, a*/
    var roman = n
    var digit: Int
    var result = ""
    //*4567
    if (roman >= 1000) {
        digit = roman / 1000
        for (i in 1..digit) {
            result += "M"
        }
        roman %= 1000
    }
    //*467
    if (roman >= 100) {
        digit = roman / 100
        when {
            digit == 9 -> result += "CM"
            digit >= 5 -> {
                result += "D"
                for (i in 1..digit - 5) {
                    result += "C"
                }
            }
            digit == 4 -> result += "CD"
            digit >= 1 -> {
                for (i in 1..digit) {
                    result += "C"
                }

            }
        }
        roman %= 100
    }
    if (roman >= 10) {
        digit = roman / 10
        when {
            digit == 9 -> result += "XC"
            digit >= 5 -> {
                result += "L"
                for (i in 1..digit - 5) {
                    result += "X"
                }
            }
            digit == 4 -> result += "XL"
            digit >= 1 -> {
                for (i in 1..digit) {
                    result += "X"
                }
            }
        }
        roman %= 10
    }
    if (roman >= 1) {
        digit = roman
        when {
            digit == 9 -> result += "IX"
            digit >= 5 -> {
                result += "V"
                for (i in 1..digit - 5) {
                    result += "I"
                }
            }
            digit == 4 -> result += "IV"
            digit >= 1 -> {
                for (i in 1..digit) {
                    result += "I"
                }
            }
        }
    }
    return result
}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String {
    var result = ""
    var digit: Int
    var number = n
    /*999 999*/
    if (number > 100000) {
        digit = number / 100000
        if (digit == 9) result += "девятьсот"
        if (digit == 8) result += "восемьсот"
        if (digit == 7) result += "семьсот"
        if (digit == 6) result += "шестьсот"
        if (digit == 5) result += "пятьсот"
        if (digit == 4) result += "четыреста"
        if (digit == 3) result += "триста"
        if (digit == 2) result += "двести"
        if (digit == 1) result += "сто"
        if ((number / 1000) % 10 == 0 && (number / 10000) % 10 == 0) {
            if (result.isEmpty()) result += ""
            else if (result.isNotEmpty()) result += " "
            result += "тысяч"
        }
        number %= 100000
    }
    /*99 999*/
    if (number > 10000) {
        digit = number / 10000
        if (result.isEmpty()) result += ""
        else if (result.isNotEmpty()) result += " "
        if (digit == 9) result += "девяносто"
        if (digit == 8) result += "восемьдесят"
        if (digit == 7) result += "семьдесят"
        if (digit == 6) result += "шестьдесят"
        if (digit == 5) result += "пятьдесят"
        if (digit == 4) result += "сорок"
        if (digit == 3) result += "тридцать"
        if (digit == 2) result += "двадцать"
        if (digit == 1) {
            val m = (number / 1000) % 10
            if (m == 9) result += "девятнадцать тысяч"
            if (m == 8) result += "восемнадцать тысяч"
            if (m == 7) result += "семнадцать тысяч"
            if (m == 6) result += "шестнадцать тысяч"
            if (m == 5) result += "пятнадцать тысяч"
            if (m == 4) result += "четырнадцать тысяч"
            if (m == 3) result += "тринадцать тысяч"
            if (m == 2) result += "двенадцать тысяч"
            if (m == 1) result += "одиннадцать тысяч"
            if (m == 0) result += "десять тысяч"
            number %= 1000
        }
        if (digit > 1 && (number / 1000) % 10 == 0) result += " тысяч"
        number %= 10000
    }
    /* 9 999*/
    if (number > 1000) {
        digit = number / 1000
        if (result.isEmpty()) result += ""
        else if (result.isNotEmpty()) result += " "
        if (digit == 9) result += "девять тысяч"
        if (digit == 8) result += "восемь тысяч"
        if (digit == 7) result += "семь тысяч"
        if (digit == 6) result += "шесть тысяч"
        if (digit == 5) result += "пять тысяч"
        if (digit == 4) result += "четыре тысячи"
        if (digit == 3) result += "три тысячи"
        if (digit == 2) result += "две тысячи"
        if (digit == 1) result += "одна тысяча"
        number %= 1000
    }
    if (number > 100) {
        digit = number / 100
        if (result.isEmpty()) result += ""
        else if (result.isNotEmpty()) result += " "
        if (digit == 9) result += "девятьсот"
        if (digit == 8) result += "восемьсот"
        if (digit == 7) result += "семьсот"
        if (digit == 6) result += "шестьсот"
        if (digit == 5) result += "пятьсот"
        if (digit == 4) result += "четыреста"
        if (digit == 3) result += "триста"
        if (digit == 2) result += "двести"
        if (digit == 1) result += "сто"
        number %= 100
    }
    if (number >= 10) {
        digit = number / 10
        if (result.isEmpty()) result += ""
        else if (result.isNotEmpty()) result += " "
        if (digit == 9) result += "девяносто"
        if (digit == 8) result += "восемьдесят"
        if (digit == 7) result += "семьдесят"
        if (digit == 6) result += "шестьдесят"
        if (digit == 5) result += "пятьдесят"
        if (digit == 4) result += "сорок"
        if (digit == 3) result += "тридцать"
        if (digit == 2) result += "двадцать"
        if (digit == 1) {
            val m = number % 10
            if (m == 9) result += "девятнадцать"
            if (m == 8) result += "восемнадцать"
            if (m == 7) result += "семнадцать"
            if (m == 6) result += "шестнадцать"
            if (m == 5) result += "пятнадцать"
            if (m == 4) result += "четырнадцать"
            if (m == 3) result += "тринадцать"
            if (m == 2) result += "двенадцать"
            if (m == 1) result += "одиннадцать"
            if (m == 0) result += "десять"
            number = 0
        }
        number %= 10
    }
    if ((number <= 9)) {
        if (result.isEmpty()) result += ""
        else if (result.isNotEmpty()) result += " "
        if (number == 9) result += "девять"
        if (number == 8) result += "восемь"
        if (number == 7) result += "семь"
        if (number == 6) result += "шесть"
        if (number == 5) result += "пять"
        if (number == 4) result += "четыре"
        if (number == 3) result += "три"
        if (number == 2) result += "два"
        if (number == 1) result += "один"
    }
    return result.trim()
}