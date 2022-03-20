
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