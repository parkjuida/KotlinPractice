
data class Book(
    val title: String,
    val author: String,
    val price: Int
)

fun Book.isWrittenBy(author: String): Boolean {
    return this.author == author
}

val b = Book("Kotlin book", "Park", 100)
b.isWrittenBy("Park")

val Book.displayName: String get() = "$title $author $price"
b.displayName

fun String.toLowerCase() = toUpperCase()

val str = "AaBbCcDd"
str.toLowerCase()

print(Char.MIN_VALUE)


class RationalNumber(
    val numeratorDenominator: Pair<Int, Int>
) {

    fun Pair<Int, Int>.plus(rationalNumber: RationalNumber): RationalNumber {
        return RationalNumber(
            Pair<Int, Int>(
                numeratorDenominator.first * this.second + this@RationalNumber.numeratorDenominator.second * this.first,
                this.second * numeratorDenominator.second
            )
        )
    }
}

val rationalNumber = RationalNumber(Pair(1, 2))


fun <T, R, U> ((T) -> R).andThen(next: (R) -> U): (T) -> U =
    { input: T -> next(this(input))}

fun incremental(input: Int): Int {
    return input + 1
}

fun double(input: Int): Int {
    return input * 2
}

val incrementalAndDouble = ::incremental.andThen(::double)
println(incrementalAndDouble(0))

fun toString() = "lexical"
val doAlso = "context".also { arg -> print("this: ${this.toString()}, arg: $arg, ") }
println("result $doAlso")

val doApply = "context".apply { print("this: $this ") }
println("result $doApply")

val doLet = "context".let { arg -> print("this: ${this.toString()}, arg: $arg, ") }
println("result $doLet")

val doRun = "context".run { print("this: $this ") }
println("result $doRun")


class Computer {
    var status = "off"
    var battery = 100

    fun turnOn() {
        println("turn on")
        status = "on"
    }

    fun turnOff() {
        println("turn off")
        status = "off"
    }

    fun doSomthing() {
        println("doSomthing")
    }

    fun batteryCharge() {
        println("battery charge")
        battery = 100
    }

    override fun toString(): String {
        return "status: $status battery: $battery"
    }
}

val computer = Computer()
computer.turnOn()
computer.doSomthing()
computer.batteryCharge()
// 아래로 변형 가능
computer.apply { turnOn() }.apply{ doSomthing() }.apply { batteryCharge() }
// 아래로 변형 가
computer.run {
    turnOn()
    doSomthing()
    batteryCharge()
}

fun createComputer(): Computer {
    return Computer()
}

fun Computer.calculate(): Boolean = true

val calculateResult = createComputer()
    .let { computer -> computer.calculate() }

println(calculateResult)