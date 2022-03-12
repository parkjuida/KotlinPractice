package chapter07

fun useComputerObject(): Pair<Int, String> {
    val computer = Computer(10, "White")
    val numberOfCore = computer.numberOfProcessor
    computer.color = "Black"
    val color = computer.color
    return numberOfCore to color
}