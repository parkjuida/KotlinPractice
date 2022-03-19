import java.time.LocalDateTime
import java.util.*

val l = 1..10

val multipleOfThree = mutableListOf<Int>()
for(x in l) {
    if(x % 3 == 0) {
        multipleOfThree.add(x)
    }
}

println(multipleOfThree)

val multipleOfThreeWithMap = l.filter { it % 3 == 0 }
println(multipleOfThreeWithMap)

val setOfInteger = setOf(1, 2, 3, 4, 5)
val twice = setOfInteger.map { "$it * 2 will be ${it * 2}" }
println(twice)

val groupByResult = l.groupBy { it % 3 }
println(groupByResult)

val tuples = listOf(
    ("park" to "ji sung"),
    ("son" to "heung min"),
    ("lee" to "chung young"),
    ("park" to "joo young"),
    ("lee" to "seung woo")
)

val mapFromListOfTuples = tuples.groupBy({it.first}, {it.second})
println(mapFromListOfTuples)

val sumOfL = l.reduce { acc, i -> acc + i }
println(sumOfL)

fun incremental(x: Int): Int {
    println("Incremental")
    return x + 1
}

fun double(x: Int): Int {
    println("Double")
    return x * 2
}
val start = System.currentTimeMillis()
(1..100).map(::incremental)
    .map(::double).first()
//    .forEach(::printer)
println(System.currentTimeMillis() - start)
println("sequence")
val start2 = System.currentTimeMillis()
(1..100).asSequence().map(::incremental)
    .map(::double).first()
//    .forEach(::printer)
println(System.currentTimeMillis() - start2)

println("generate sequence")
val seq = generateSequence(10) {it + 1}
println(seq.take(10).toList())
println(seq.take(2).contains(13))
println(seq.take(5).contains(13))

val multipleOfSix = sequence {
    var start = 6
    while (true) {
        yield(start)
        start += 6
    }
}

multipleOfSix.take(10).toList()