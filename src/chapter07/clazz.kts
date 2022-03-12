import java.lang.RuntimeException

class Car

class Computer(val numberOfProcessor: Int, var color: String)

val computer = Computer(10, "Red")
println("${computer.numberOfProcessor} ${computer.color}")


class ComputerWithSetter(val numberOfProcessor: Int, theColor: String) {
    var battery = 100
    set(value) {
        println("set battery")
        field = if(value < 0) 0 else value
    }
    var color = theColor
    set(value: String) {
        println("set color ${value} ${field}")
        if(value.isEmpty()) {
            throw RuntimeException("value is Empty")
        }
        field = value
    }
}

val computerWithSetter = ComputerWithSetter(10, "Black")
println(computer.numberOfProcessor)
computerWithSetter.color = "Blue"
computerWithSetter.battery = 0
//println(computerWithSetter.battery)
//computerWithSetter.name = "Kim"
//println("${computerWithSetter.color} ${computerWithSetter.name}")