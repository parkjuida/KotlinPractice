package chapter08

sealed class Card(val suit: String)

class Ace(suit: String): Card(suit) {
    override fun toString(): String = "ACE of $suit"
}
class King(suit: String): Card(suit) {
    override fun toString(): String = "King of $suit"
}
class Queen(suit: String): Card(suit) {
    override fun toString(): String = "Queen of $suit"
}