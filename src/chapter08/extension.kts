
open class Vehicle(val year: Int, open var color: String) {
    open val km = 0
    final override fun toString() = "year : $year, Color: $color, KM: $km"
    fun repaint(newColor: String) {
        color = newColor
    }
}

open class Car(year: Int, color: String) : Vehicle(year, color) {
    override var km: Int = 0
    set(value) {
        if(value < 1) {
            throw RuntimeException("can`t be < 1")
        }
        field = value
    }
    fun drive(distance:Int) {
        km += distance
    }
}

val car = Car(2000, "Red")
car.drive(100)
println(car.km)
try { car.drive(-120) } catch(ex: RuntimeException) {println(ex.message)}
