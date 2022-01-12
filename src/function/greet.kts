package function

fun hello() = "hello"

println(hello())


var returnString = hello()
println("return string is $returnString")

fun unitFunction() {
}
println("result of unit function: ${unitFunction()}")

fun functionHasParameter(arg: String): String {
    return arg
}
println("parameter function: ${functionHasParameter("Hello")}")

