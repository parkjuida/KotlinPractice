package function

fun hello(): String = "hello"

println(hello())


var returnString = hello()
println("return string is $returnString")

fun unitFunction() {
}
println("result of unit function: ${unitFunction()}")

fun functionHasParameter(arg: String): String {
    return arg
}
println("parameter function: ${functionHasParameter("Hello")}")

fun notReally() = {2}
println(notReally())
println(notReally()())

// 기본 아규먼트
fun greet(name: String, msg: String = "Hello"): String = "$msg $name"
println("기본 아규먼트" + greet("park"))
println("기본 아규먼트 2" + greet("park", " Hi"))

fun greet2(name: String="park", msg: String): String = "$msg $name"
println("hi")
println(greet2(msg="abc"))

// 명시적 아규먼트
fun createItem(name: String, quantity: Int, price: Int, discountRate: Double) {
    println("name: $name quantity: $quantity price: $price discountRate: $discountRate")
}
println("명시적 아규먼트")
createItem("Apple", 100, 1000, 0.0)
createItem(name="Apple", quantity = 100, price=1000, discountRate=0.0)
createItem("Apple", 100, discountRate = 0.0, price=1000)

//
fun max1(numbers: IntArray): Int {
    var maximum = Int.MIN_VALUE
    for(number in numbers) {
        maximum = if(number > maximum) number else maximum
    }
    return maximum
}
println("다중 인자")
println(max1(intArrayOf(1, 2, 3, 4, 5)))
// 다중인자
fun max(vararg numbers: Int): Int {
    var maximum = Int.MIN_VALUE
    for(number in numbers) {
        maximum = if(number > maximum) number else maximum
    }
    return maximum
}
println("다중인자")
println(max(1, 2, 3, 4, 5))
println(max(*intArrayOf(1, 2, 3, 4, 5)))
println(max(*listOf(1,2,3,4,5).toIntArray()))

fun multiParameter(vararg numbers: Int, msg: String): String = "${numbers.toString()} $msg"
multiParameter(1,2,3, msg="A")

fun multiParameter2(msg: String, vararg messages: String) = "${messages.joinToString(", ")} $msg"
multiParameter2("A", "B", "C", "D")

// 스프레드 연산자
val numberList = intArrayOf(1, 2, 3, 4, 5)
println("스프레드 연산자")
println(max(*numberList))

// 구조분해
fun getName() = Triple("Park", "Kim", "Son")
val result = getName()
println("${result.first} ${result.second} ${result.third}")

val (park, kim, son) = getName()
println("$park $kim $son")

val (a12, _, c1) = getName()
println("$a12 $c1")

val (a1, b1) = getName()
println("$a1 $b1")
