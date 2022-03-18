val myFunction = { e: String -> e + 1 }

fun isPrime1(n: Int) = n > 1 && (2 until n).none { k -> n % k == 0}
isPrime1(3)

fun isPrime(n: Int) = n > 1 && (2 until n).none { n % it == 0}

fun modifyOneToTen(func: (Int) -> Int): List<Int> {
    return (1 .. 10).map { func(it) }
}

modifyOneToTen { it * 2 }


fun manyParameters(func: (Int) -> Int, n: Int): List<Int> {
    return (1 .. n).map { func(it) }
}

manyParameters({
    val k = 25
    it * k
}, 5)

fun manyParameters1(n: Int, func: (Int) -> Int): List<Int> {
    return (1 .. n).map { func(it) }
}

manyParameters1(5){
    val k = 25
    it * k
}


fun doSomething(str: String, func: (String) -> Unit) = func(str)

doSomething("arg") { arg -> println(arg) }
doSomething("it") { println(it) }
doSomething("::", ::println)

fun thisFunctionReturnFunction(n: Int): (Int) -> Boolean {
    return { it -> it % n == 0 }
}

println((1 .. 10).filter(thisFunctionReturnFunction(3)))

//val tenTimes = { n: Int -> (n * 10).toString()}

//val tenTimes: (Int) -> String = { n -> (n * 10).toString() }

val tenTimes = fun(n: Int): String { return (n * 10).toString() }
tenTimes(10)

var factor = 2
val doubled = listOf(1, 2).map { it * factor }
val doubledAlso = sequenceOf(1, 2).map { it * factor }
factor = 0

doubled.forEach { println(it) }
doubledAlso.forEach { println(it) }


fun outerFunction(string: String): (String) -> String {
    val name = string
    return { str -> "$name $str"}
}

val function1 = outerFunction("Lexical")
println(function1("Scoping"))
