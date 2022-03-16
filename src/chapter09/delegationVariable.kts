import java.lang.Thread.sleep
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class GetterThief(var content: String) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("content will be returned")
        return content
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value is stolen. value will be gone")
        content = "gone"
    }
}

var strExample: String by GetterThief("my first message")
println(strExample)
strExample = "Hi"
println(strExample)


class Translator(val _map: MutableMap<String, String>) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>) =
        (_map[property.name])?.replace("apple", "사과") ?: ""

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        _map[property.name] = value
    }
}

val translator = mutableMapOf("name" to "apple")
class Fruit(translator: MutableMap<String, String>) {
    val name: String by Translator(translator)
}

val apple = Fruit(translator)
println(apple.name)

fun getTemperatureFromOthers(): Int {
    println("get temperature called")
    sleep(10000)
    return 20
}

val showTemperature = false
//val temperature = getTemperatureFromOthers()
val temperature by lazy { getTemperatureFromOthers() }
if(showTemperature && temperature > 10)
    println("Long sleeve")
else
    println("I dont know")

fun callCountChanged() {
    println("count chaned!")
}
//var count by Delegates.observable(0) {
//    property: KProperty<*>, oldValue: Int, newValue: Int ->
//    callCountChanged()
//}

var toVeto by Delegates.vetoable(0) {
    property: KProperty<*>, oldValue: Int, newValue: Int ->
    newValue <= 0
}
toVeto += 100
println("toVeto: $toVeto")