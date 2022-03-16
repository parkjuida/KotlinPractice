package chapter08

enum class Day(val korean: String) {
    MON("월"),
    TUE("화"),
    WED("수"),
    THU("목"),
    FRI("금"),
    SAT("토"),
    SUN("일") {
        override fun toString(): String {
            return "${super.toString()} SUNDAY"
        }
    };

    override fun toString(): String {
        return "$name $korean"
    }
}

fun getKorean(day: Day) = when(day) {
    in Day.MON .. Day.FRI -> "평일"
    Day.SAT, Day.SUN -> "주말"
    else -> "??"
}

fun main() {
    println(Day.MON)
    println(Day.TUE)
    println(Day.valueOf("SUN"))
}
