
//class Animal {
//    override operator fun equals(other: Any?) = other is Animal
//}

//val animal = Animal()
//val animalString: Any = "Animal"
//println(animal == Animal())
//println(animal == animalString)

//class Animal(val age: Int) {
//    override operator fun equals(other: Any?): Boolean {
//        return if(other is Animal) age == other.age else false
//    }
//}

class Animal(val age: Int) {
    override operator fun equals(other: Any?) =
        other is Animal && age == other.age
}

val tiger = Animal(10)
val cat = Animal(10)
val monkey = Animal(3)
println(tiger == cat)
println(tiger == monkey)

fun smartcastWithWhen(input: Any): String = when (input) {
    is String -> "$input length is ${input.length}"
    is IntArray -> input.joinToString(",", "[", "]")
    else -> "Default"
}

println(smartcastWithWhen("String"))
println(smartcastWithWhen(intArrayOf(1, 2, 3)))

fun fetchMessage(id: Int): Any =
    if(id == 1) "Record found" else StringBuilder("data not found")

println((fetchMessage(1) as String).length)
println((fetchMessage(2) as? String)?.length ?: 0)