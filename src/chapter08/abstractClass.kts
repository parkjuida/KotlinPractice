
abstract class CellularPhone(val name: String) {
    fun call() {
        println("call")
    }
    abstract fun ring()
}

class IPhone(name: String): CellularPhone(name) {
    override fun ring() {
        println("Iphone ringing")
    }
}

class Galaxy(name: String): CellularPhone(name) {
    override fun ring() {
        println("Galaxy ringing")
    }
}

val iphone = IPhone("My iphone")
val galaxy = Galaxy("My galaxy")
println("${iphone.name} ${galaxy.name}")
iphone.call()
galaxy.call()
iphone.ring()
galaxy.ring()