
/**
 * This is the type dumbIsOdd.
 *
 * @author <a href="mailto:jsvg88@scania.com">jsvg88</a>
 * @since 2017-11-01
 */
fun main(args: Array<String>) {
    println(isOdd(5))
}

tailrec fun isOdd(num: Int): Boolean {
    if (num == 2147483647) return true
    else if (num == 0) return false
    return isOdd(num + 2)
}
