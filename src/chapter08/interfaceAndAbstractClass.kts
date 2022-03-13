
interface Remote {
    fun up()
    fun down()
    fun doubleUp() {
        up()
        up()
    }
    companion object {
        fun combine(first: Remote, second: Remote): Remote = object: Remote {
            override fun up() {
                first.up()
                second.up()
            }

            override fun down() {
                first.down()
                second.down()
            }

        }
    }
}

class TV {
    var volume = 0
}

class TVRemote(val tv: TV): Remote {
    override fun up() {
        tv.volume++;
    }

    override fun down() {
        tv.volume--;
    }
}

val tv = TV()
val tvRemote = TVRemote(tv)
tvRemote.up()
println(tv.volume)
tvRemote.doubleUp()
println(tv.volume)
tvRemote.down()
println(tv.volume)

val tv1 = TV()
val tv2 = TV()
val tv1AndTv2 = Remote.combine(TVRemote(tv1), TVRemote(tv2))
tv1AndTv2.up()
println("${tv1.volume} ${tv2.volume}")