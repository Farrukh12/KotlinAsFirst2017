@file:Suppress("UNUSED_PARAMETER")

package lesson4.task1

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
    var s = 0.0
    if (list.isEmpty()) return 0.0
    for (element in list) {
        s += element
    }
    return s / list.size
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
    var s = 0.0
    var c = 0.0
    for (element in list) {
        s += element
    }
    c = s / list.size
    for (i in 0 until list.size) {
        list[i] = list[i] - c
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
    val s = mutableListOf<Int>()
    var f = 2
    var d = n
    while (d > 1) {
        if (d % f == 0) {
            s.add(f)
            d = d / f
            f = 2
        }

        f++
    }
    return s
}

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String {
    var s = ""
    var f = 2
    var d = n
    var k = 0
    while (d > 1) {
        if (d % f == 0) {
            k++
            if (k == 1) s += "$f"
            else s += "*$f"
            d /= f
            f = 2
        }

        f++
    }
    return s
}

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var f = mutableListOf<Int>()
    var s1 = n
    var d: Int = 0
    val s2 = base
    while (s1 > 0) {
        d = s1 % s2
        f.add(d)
        s1 /= s2
    }
    return f.reversed()
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
    var chislo = n
    var convert: String = ""
    val osnovanie = base
    val n = ('a'..'z').toList()
    while (chislo > 0) {
        if (chislo % osnovanie > 9) {
            for (i in 10..35) {
                if (chislo % osnovanie == i) convert += n[i - 10]
            }
        } else
            convert += chislo % osnovanie
        chislo /= osnovanie
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
    var s = 0
    for (i in 0 until digits.size) {
        s = s * base + digits[i]
    }
    return s
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
    var s = 0.0
    var k = 0.0
    for (i in str.indices) {
        if (str[i].toInt() >= 1 && str[i].toInt() <= 9) s += str[i].toInt() * Math.pow(base.toDouble(), k)
        var d = 10
        for (j in 'A'..'Z') {
            if (str[i] == j) s += d * Math.pow(base.toDouble(), k)
            d++
        }
        k++
    }
    return s.toInt()
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
    var d = n
    var s = 0
    var result = ""
    //*4567
    if (d >= 1000) {
        s = d / 1000
        for (i in 1..s) {
            result += "M"
        }
        d %= 1000
    }
    //*467
    if (d >= 100) {
        s = d / 100
        if (s == 9) result += "CM"
        else if (s >= 5) {
            result += "D"
            for (i in 1..s - 5) {
                result += "C"
            }
        } else if (s == 4) {
            result += "CD"
        } else if (s >= 1) {
            for (i in 1..s) {
                result += "C"

            }
        }
        d %= 100
    }
    if (d >= 10) {
        s = d / 10
        if (s == 9) result += "XC"
        else if (s >= 5) {
            result += "L"
            for (i in 1..s - 5) result += "X"
        } else if (s == 4) result += "XL"
        else if (s >= 1) {
            for (i in 1..s) result += "X"
        }
        d %= 10
    }
    if (d >= 1) {
        s = d
        if (s == 9) result += "IX"
        else if (s >= 5) {
            result += "V"
            for (i in 1..s - 5) result += "I"
        } else if (s == 4) result += "IV"
        else if (s >= 1) {
            for (i in 1..s)
                result += "I"
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
    var s = " "
    var d = 0
    var k = n
    if (k > 100000) {
        d = k / 100000
        if (d == 9) s += " девьятсот "
        if (d == 8) s += " восемьсот "
        if (d == 7) s += " семьсот "
        if (d == 6) s += " шестьсот "
        if (d == 5) s += " пятьсот "
        if (d == 4) s += " четыреста "
        if (d == 3) s += " триста "
        if (d == 2) s += " двести "
        if (d == 1) s += " сто "
        k %= 100000
    }
    if (k > 10000) {
        d = k / 10000
        if (d == 9) s += " девяносто "
        if (d == 8) s += " восемьдесят "
        if (d == 7) s += " семьдесят "
        if (d == 6) s += " шестьдесят "
        if (d == 5) s += " пятьдесят "
        if (d == 4) s += " сорок "
        if (d == 3) s += " тридцать "
        if (d == 2) s += " двадцать "
        if (d == 1) {
            var m = (d / 1000) % 10
            if (m == 9) s += " девятнадцать "
            if (m == 8) s += " восемнадцать "
            if (m == 7) s += " семнадцать "
            if (m == 6) s += " шестнадцать "
            if (m == 5) s += " пятнадцать "
            if (m == 4) s += " четырнадцать "
            if (m == 3) s += " тринадцать "
            if (m == 2) s += " двенадцать "
            if (m == 1) s += " одиннадцать "
        }
        if (d == 0) s = s
        if (d == 0 && (k / 10000) == 0) s += " тысяч "
        k %= 10
    }
    if (k > 1000) {
        d = k / 1000
        if (d == 9) s += " девять тысяч "
        if (d == 8) s += " восемь тысяч"
        if (d == 7) s += " семь тысяч "
        if (d == 6) s += " шесть тысяч "
        if (d == 5) s += " пять тысяч "
        if (d == 4) s += " четыре тысячи "
        if (d == 3) s += " три тысячи "
        if (d == 2) s += " две тысячи "
        if (d == 1) s += " одна тысяча "
        k /= 10
    }
    if (k > 100) {
        d = k / 100
        if (d == 9) s += " девятьсот "
        if (d == 8) s += " восемьсот "
        if (d == 7) s += " семьсот "
        if (d == 6) s += " шестьсот "
        if (d == 5) s += " пятьсот "
        if (d == 4) s += " четыреста "
        if (d == 3) s += " триста "
        if (d == 2) s += " двести "
        if (d == 1) s += " сто "
    }
    if (k > 10) {
        d = k / 10
        if (d == 9) s += " девяносто "
        if (d == 8) s += " восемьдесят "
        if (d == 7) s += " семьдесят "
        if (d == 6) s += " шестьдеят "
        if (d == 5) s += " пятьдесят "
        if (d == 4) s += " сорок "
        if (d == 3) s += " тридцать "
        if (d == 2) s += " двадцать "
        if (d == 1) {
            val m = d % 10
            if (m == 9) s += " девятнадцать "
            if (m == 8) s += " восемнадцать "
            if (m == 7) s += " семнадцать "
            if (m == 6) s += " шестнадцать "
            if (m == 5) s += " пятнадцать "
            if (m == 4) s += " четырнадцать "
            if (m == 3) s += " тринадцать "
            if (m == 2) s += " двенадцать "
            if (m == 1) s += " одиннадцать "
        }
        k
    }
    if (k < 9) {
        if (k == 9) s += " девять "
        if (k == 8) s += " восемь "
        if (k == 7) s += " семь "
        if (k == 6) s += " шесть "
        if (k == 5) s += " пять "
        if (k == 4) s += " четыре "
        if (k == 3) s += " три "
        if (k == 2) s += " два "
        if (k == 1) s += " один "
    }
    return s
}