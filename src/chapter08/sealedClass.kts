import chapter08.Ace
import chapter08.Card
import chapter08.King
import chapter08.Queen


val ace = Ace("Diamond")
val king = King("Spade")
val queen = Queen("Heart")

println(ace)
println(king)
println(queen)

fun process(card: Card) = when(card) {
    is Ace -> "ACE"
    is King -> "KING"
    is Queen -> "QUEEN"
}

process(ace)