val names = listOf("Park", "Kim")

println(names.withIndex().javaClass)
names.withIndex().forEach {(index, name) -> println("$index $name")}

// Pair
println(Pair("A", "B"))
println(Triple("Park", 180, 60))
println(mapOf("A" to 1, "B" to 2))

val nameArray = arrayOf("Park", "Kim")
println(nameArray::class)
println(nameArray.javaClass)
println("${nameArray[0]} ${nameArray[1]}")

val numbers = intArrayOf(1, 2, 3)
val numberObjects = arrayOf(1, 2, 3)

println("${numbers::class} ${numberObjects::class}")
println("${numbers.javaClass} ${numberObjects.javaClass}")

val fruits: List<String> = listOf("Apple", "Banana", "Orange")
println(fruits::class)
println(fruits.javaClass)
println("${fruits[0]} ${fruits.get(0)}")
println("${"Apple" in fruits} ${fruits.contains("Apple")}")

val addGrape = fruits + "Grape"
val noOrange = fruits - "Orange"
println("${addGrape} ${noOrange}")

val mutableFruits = mutableListOf("Apple")
mutableFruits.add("Banana")
mutableFruits.add("Orange")
println(mutableFruits::class)
println(mutableFruits.javaClass)

val nameSet = setOf("Park", "Kim", "Kim")
println(nameSet)
println(nameSet::class)
println(nameSet.javaClass)

val simpleMap = mapOf("A" to 1, "B" to 2)
println(simpleMap)
println(simpleMap::class)
println(simpleMap.javaClass)

println(simpleMap.keys)
println(simpleMap.containsKey("A"))
println(simpleMap.containsValue(10))

val value: Int? = simpleMap.get("C")
val cAdded = simpleMap + ("C" to 3)
val noB = simpleMap - "B"
println(cAdded)
println(noB)

for((key, value) in simpleMap) {
    println("$key $value")
}