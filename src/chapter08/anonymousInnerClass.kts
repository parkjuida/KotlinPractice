package chapter08

interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }
}

class TV {
    private var volume = 0
    val remote: Remote get() = object: Remote {
        override fun up() {
            volume++;
        }

        override fun down() {
            volume--;
        }
    }

    override fun toString(): String {
        return "Volume: $volume"
    }
}

val tv = TV()
val remote = tv.remote
val remote2 = tv.remote
println("$remote $remote2")
