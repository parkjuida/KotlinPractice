data class FootballPlayer(val name: String, val height: Int, val injured: Boolean)

val kim = FootballPlayer("Kim", 180, false)
println(kim)
val injuredKim = kim.copy(injured=true)
println(injuredKim)
println(kim.component1())

val (nameOfKim, heightOfKim, _) = kim
println("$nameOfKim $heightOfKim")