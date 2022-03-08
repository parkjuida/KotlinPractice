fun computeSqrt(n: Double): Double {
    if(n >= 0) {
        return Math.sqrt(n)
    } else {
        throw RuntimeException("No negative number")
    }
}


fun returnNull(n: Int?): String? {
    if(n != null && n > 0) {
        return "Natural number"
    }
    return null
}

println(returnNull(1))
println(returnNull(-1))
println(returnNull(null))

println("Safe call operator")

fun reverseString(s: String?): String? {
    if(s != null) {
        return s.reversed()
    }
    return "give not null"
}

fun reverseStringWithSafeCallOp(s: String?): String? {
//    if(s?.reversed() != null)
//        return s?.reversed()
//    return "give not null"
    return s?.reversed() ?: "give not null"
}

println(reverseString("reverse"))
println(reverseString(null))
println(reverseStringWithSafeCallOp("reverse"))
println(reverseStringWithSafeCallOp(null))

fun reverseString1(s: String?): String {
    if(s == "NPC") {
        return "NPC"
    }
    return s?.reversed() ?: "Anonymous"
}

fun reverseString2(s: String?): String = when (s) {
    "NPC" -> "NPC"
    null -> "Anonymous"
    else -> s.reversed()
}

