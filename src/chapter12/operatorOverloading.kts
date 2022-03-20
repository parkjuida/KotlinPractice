
class RationalNumber(
    val numerator: Int,
    val denominator: Int
) {
    operator fun plus(other: RationalNumber): RationalNumber {
        return RationalNumber(
            this.numerator * other.denominator + other.numerator * this.denominator,
            this.denominator * other.denominator
        )
    }

    operator fun plus(other: Int): RationalNumber {
        return RationalNumber(
            this.numerator + this.denominator * other,
            this.denominator
        )
    }

    operator fun times(other: RationalNumber): RationalNumber {
        return RationalNumber(
            this.numerator * other.numerator,
            this.denominator * other.denominator
        )
    }

    override fun toString(): String {
        return "$numerator / $denominator"
    }
}

println(RationalNumber(1, 2) + RationalNumber(1, 4))
println(RationalNumber(1, 2) * RationalNumber(1, 2))
println(RationalNumber(1, 2) + 1)

operator fun Int.plus(rationalNumber: RationalNumber): RationalNumber {
    return RationalNumber(
        this * rationalNumber.denominator + rationalNumber.numerator,
        rationalNumber.denominator
    )
}

println(1 + RationalNumber(1, 2))