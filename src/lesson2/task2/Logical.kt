@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val s1 = number / 1000
    val s2 = (number / 100) % 10
    val s3 = (number / 10) % 10
    val s4 = number % 10
    return (s1 + s2 == s3 + s4)
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 * (x1 == x2 || y1 == y2 || Math.abs(x1 - x2) == Math.abs(y1 - y2))
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val queenInverhor = (x1 == x2 || y1 == y2)
    val queenBydiagonally = (Math.abs(x1 - x2) == Math.abs(y1 - y2))
    return when {
        queenInverhor || queenBydiagonally -> true
        else -> false
    }
}

/**
 * Средняя
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * pointInsideCircle(x1, y1, x2, y2, r2) && (Math.sqrt(sqr(x2 - x1) + sqr(y2 - y1)) + r1) <= r2
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val o2 = pointInsideCircle(x1, y1, x2, y2, r2)
    val d = (Math.sqrt(sqr(x2 - x1) + sqr(y2 - y1)))
    return o2 && (d + r1) <= r2
}


/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        a <= r && b <= s -> true
        a <= r && c <= s -> true
        b <= r && a <= s -> true
        b <= r && c <= s -> true
        c <= r && a <= s -> true
        c <= r && b <= s -> true
        else -> false
    }
}



