import java.lang.RuntimeException

inline fun invokeTwo(
    n: Int,
    action1: (Int) -> Unit,
    action2: (Int) -> Unit
): (Int) -> Unit {
    println("Enter invokeTwo $n")
    action1(n)
    action2(n)
    println("exit invokeTwo $n")
    return { _: Int -> println("lambda returned from invokeTwo") }
}

fun callInvokeTwo() {
    invokeTwo(1, {i -> report(i)}, {i -> report(i)})
}
callInvokeTwo()

fun report(n: Int) {
    println("")
    print("called with $n, ")
    val stackTrace = RuntimeException().stackTrace
    println("Stack depth: ${stackTrace.size}")
    println("Partial listing of stack:")
    stackTrace.take(3).forEach(::println)
}

fun printStackTrace(func: () -> Unit) {
    func()
}
println("Call")
inline fun printStackTraceInline(crossinline func1: (n: Int) -> Unit): (Int) -> Unit {
    return {input -> func1(input) }
}

fun call() {
    printStackTraceInline { (1..5).map {
        if(it == 3) return@map
        println(it * 10) }
    }
}

call()