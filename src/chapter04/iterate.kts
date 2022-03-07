import kotlin.reflect.typeOf

val array = arrayOf(1, 2, 3)
val array1 = intArrayOf(1, 2, 3)

println(array.joinToString(", ", "[", "]"))
println(arrayOf("ab", "ac", "ad").joinToString(", ", "[", "]"))
println(intArrayOf(1, 2, 3).joinToString(", ", "[", "]"))

println(listOf(1, 2, 3).javaClass)

val names = listOf("park", "kim", "lee")
for(index in names.indices) {
    println("$index ${names[index]}")
}

for((index, name) in names.withIndex()) {
    println("$index $name")
}