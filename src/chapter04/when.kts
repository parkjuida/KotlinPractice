fun isAlive(alive: Boolean, numberOfLiveNeighbors: Int) = when {
    numberOfLiveNeighbors > 3 -> false
    numberOfLiveNeighbors < 2 -> false
    numberOfLiveNeighbors == 3 -> true
    else -> alive && numberOfLiveNeighbors == 2
}

fun translateDay(dayOfWeek: Any) = when (dayOfWeek) {
    "Sat", "Sun" -> "주말"
    in listOf("Mon", "Tue", "Wed", "Thu", "Fri") -> "평일"
    in 0 .. 4 -> "평일"
    is String -> "Give Mon - Sun"
    else -> "Give String"
}

println(translateDay("Sat"))
println(translateDay("Fri"))
println(translateDay("abcd"))
println(translateDay(10))

fun printTranslateDay(dayOfWeek: Any) {
    when (dayOfWeek) {
        "Sat", "Sun" -> println("주말")
        in listOf("Mon", "Tue", "Wed", "Thu", "Fri") -> println("평일")
        in 0..4 -> println("평일")
        is String -> println("Give Mon - Sun")
    }
}
printTranslateDay("Sat")
printTranslateDay("Fri")
printTranslateDay("abcd")
printTranslateDay(10)

val dayOfWeek: Any = "Sat"
println(when (dayOfWeek) {
    "Sat", "Sun" -> "주말"
    in listOf("Mon", "Tue", "Wed", "Thu", "Fri") -> "평일"
    in 0 .. 4 -> "평일"
    is String -> "Give Mon - Sun"
    else -> "Give String"
})
println(dayOfWeek)

println(when (val dayOfWeek1: Any = "Sat") {
    "Sat", "Sun" -> "주말"
    in listOf("Mon", "Tue", "Wed", "Thu", "Fri") -> "평일"
    in 0 .. 4 -> "평일"
    is String -> "Give Mon - Sun"
    else -> "Give String $dayOfWeek1"
})
//print(dayOfWeek1)
