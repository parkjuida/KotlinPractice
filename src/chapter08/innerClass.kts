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
    val remote: Remote
    get() = TVRemote()
    inner class TVRemote: Remote {
        override fun up() {
            volume++;
        }

        override fun down() {
            volume--;
        }

        override fun toString(): String {
            return "Remote: ${this@TV.toString()}"
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
remote.up()
println(tv)
