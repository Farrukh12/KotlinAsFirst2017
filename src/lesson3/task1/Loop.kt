@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var k = 0
    if (n == 0) return 1
    else {
        var s = n
        while (s != 0) {
            s /= 10
            k++

        }
    }
    return (k)

}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
    var fib1 = 1
    var fib2 = 1
    if (n == 1) return 1
    if (n == 2) return 1
    for (i in 3..n) {
        val fib3 = fib1 + fib2
        fib1 = fib2
        fib2 = fib3
    }
    return fib2

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
    var max = maxOf(m, n)
    var min = minOf(m, n)
    if (max % min == 0) return max
    while (max % min != 0) {
        val temp = min
        min = max % min
        max = temp
    }
    return m * n / min
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var s = 0
    var k = 2
    while (s == 0) {
        if (n % k == 0) {
            s = 1
        } else {
            k++
        }
    }
    return k
    /*Эту задачу можно с For решить,но думаю с while легче*/
}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int {
    var k = 1
    var s = 0
    while (k < n) {
        if (n % k == 0) s = k
        k++
    }
    return s
}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
    var k: Int
    k = 0
    for (i in 1..n) {
        if (m % i == 0 && n % i == 0) k++
        else k = k
    }
    return (k == 1)

}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
    var k = 0
    if (m == 0 && n == 0) return true
    while (k <= m) {
        k++
        if (Math.sqrt(m.toDouble()) <= k && k <= Math.sqrt(n.toDouble())) return true
    }
    return false
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double {
    val num = x % (2 * Math.PI)
    var result = num
    var member = 1.0
    var count = 3
    while (Math.abs(member) > eps) {
        member = Math.pow(num, count.toDouble()) / factorial(count)
        if ((count - 1) % 4 == 0) {
            result += member
        } else {
            result -= member
        }
        count += 2
    }
    return result
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double {
    val num = x % (2 * Math.PI)
    var result = 1.0
    var member = 1.0
    var count = 2
    while (Math.abs(member) > eps) {
        member = Math.pow(num, count.toDouble()) / factorial(count)
        if (count % 4 == 0) {
            result += member
        } else {
            result -= member
        }
        count += 2
    }
    return result
}

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
    var s = 0
    var k: Int
    var m = n
    while (m > 0) {
        k = m % 10
        s = 10 * s + k
        m /= 10
    }
    return s
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean = n == revert(n)


/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    val d = n % 10
    var m = n / 10
    while (m > 0) {
        if (m % 10 != d) return true
        m /= 10
    }
    return false
}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    var num = n
    var count = 0
    while (num > 0) {

        count++
        num -= digitNumber(count * count)
    }
    num = Math.abs(num)
    return count * count / Math.pow(10.0, num.toDouble()).toInt() % 10
}

/**
 * Сложная
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    var number = n
    var count = 0
    while (number > 0) {
        count++
        number -= digitNumber(fib(count))
    }
    number = Math.abs(number)
    return fib(count) / Math.pow(10.0, number.toDouble()).toInt() % 10
}