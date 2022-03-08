import java.lang.Appendable

open class Fruit
class Banana : Fruit()
class Orange : Fruit()

fun printFruits(basket: Array<out Fruit>) {
    basket.forEach { e -> println(e) }
}

fun printFruit(f: Fruit) {
    println("${f::class}")
}

val fruits = arrayOf<Fruit>(Banana())
val bananas = arrayOf<Banana>(Banana())
printFruits(fruits)
printFruit(Banana())
printFruits(bananas)

fun printFruitsList(basket: List<Fruit>) {
    println("Fruit basket ${basket.size}")
}

printFruitsList(listOf(Banana(), Orange()))

fun copyFruit(from: Array<out Fruit>, to: Array<in Fruit>): String {
    for(i in from.indices) {
        to[i] = from[i]
    }
    return "copied"
}

val anyArray: Array<Any> = arrayOf(1)
val oranges: Array<Orange> = arrayOf(Orange())
println(copyFruit(oranges, anyArray))

fun <T: AutoCloseable> useAndClose(input: T) {
    input.close()
}

fun <T> useAndCloseAndAppend(input: T) where T: AutoCloseable, T: Appendable {
    input.append()
    input.close()
}

fun printer(input: Array<*>) {
    for(e in input.iterator()) println(e)
    //input[0] = 10
}

printer(arrayOf(1, 2, 3))

inline fun <reified T> findFruit(fruits: List<Fruit>): T {
    val result = fruits.filter { fruit -> fruit is T }
    return result[0] as T
}

println(findFruit<Orange>(listOf<Fruit>(Orange(), Banana())))