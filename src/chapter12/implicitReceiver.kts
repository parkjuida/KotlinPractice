var length = 100
val printIt: String.(Int) -> Unit = { n: Int ->
    println("n is $n, length is $length")
}

printIt("Hello", 10)

val printItJustInt: (Int) -> Unit = { n: Int ->
    println("n is $n, length is $length")
}
printItJustInt(10)

fun top(func: String.() -> Unit) = "hello".func()
fun nested(func: Int.() -> Unit) = (-2).func()
top {
    println("In outer lambda $this and $length")
    nested {
        println("in ineer lambda $this and ${toDouble()}")
        println("from inner through receiver of outer: ${length}")
        println("from inner to outer receiver ${this@top}")
    }
}