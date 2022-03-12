import chapter07.Computer
import java.lang.IllegalArgumentException

fun drawCircle() {
    val circle = object {
        val x = 10
        val y = 20
        val radius = 5
    }
    println("Circle x: ${circle.x} y: ${circle.y} radius: ${circle.radius}")
}

drawCircle()


fun createRunnable(): Runnable {
    val runnable = object: Runnable {
        override fun run() {
            println("You called...")
        }
    }
    return runnable
}

createRunnable().run()

fun createRunnableSingle(): Runnable = Runnable { println("You called single method") }
createRunnableSingle().run()

fun createRunnableTwo(): Runnable = object: Runnable, AutoCloseable {
    override fun run() {
        println("Im runnable")
    }

    override fun close() {
        TODO("Not yet implemented")
    }
}

object Util {
    fun numberOfProcessors() = Runtime.getRuntime().availableProcessors()
}

println(Util.numberOfProcessors())

object Sun: Runnable {
    val radius = 696000
    var temperature = 15000000
    override fun run() {
        println("I`m Sun.")
    }
}

fun runSun(sun: Runnable) {
    sun.run()
}

runSun(Sun)

val computer = Computer(10, "black")
//
//class Person(val name: String, val age: Int) {
//    var location = ""
//    var phone = ""
//
//    constructor(name: String, age: Int, _phone: String): this(name, age) {
//        phone = _phone
//    }
//    constructor(name: String, age: Int, _location: String, _phone: String): this(name, age, _phone) {
//        location = _location
//    }
//}

class ClassWithCompanion {
    companion object {
        var number: Int = 0

        fun companionMethod() {
            println("Companion Method")
        }
    }
    fun printNumber() {
        println(number)
    }
}
val c1 = ClassWithCompanion()
c1.printNumber()
ClassWithCompanion.number = 100
val c2 = ClassWithCompanion()
c2.printNumber()
ClassWithCompanion.companionMethod()

val companionRef = ClassWithCompanion.Companion
companionRef.companionMethod()

class CompanionWithName {
    companion object AnonymousCompanion {
        fun getName(): String {
            return "Anonymous"
        }
    }
}

println(CompanionWithName.AnonymousCompanion.getName())

class Person private constructor(val name: String, val nation: String) {
    companion object PersonFactory {
        private const val KOREA = "KOR"

        fun createKorean(name: String): Person {
            if(name.isEmpty()) throw IllegalArgumentException("Give name")
            val p = Person(name, KOREA)
            return p
        }
    }

}

// Person("Kim", "KOR") 접근 불가능
val p = Person.createKorean("Park")
println("${p.name} ${p.nation}")

