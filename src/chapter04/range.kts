val shortRange: IntRange = 1 .. 5
println(shortRange)
for(i in shortRange) print("$i ")

//val aToZ: CharRange = 'a' .. 'z'
//for(i in aToZ) println(i)

val stringRange: ClosedRange<String> = "aaa" .. "aad"
println(stringRange.contains("aac"))
println(stringRange.contains("aae"))

for(i in 5.downTo(1))
    print("$i ")

for(i in 5 downTo 1)
    print("$i ")

for(i in 1 until 5)
    print("$i ")

println("step")
for(i in 1 .. 10 step 3)
    print("$i ")

println("step to downTo")
for(i in 10 downTo 1 step 3)
    print("$i ")

println("filter")
for(i in (1 .. 10).filter { it % 3 == 0 || it % 5 == 0})
    print("$i ")