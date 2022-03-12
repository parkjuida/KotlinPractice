package chapter07

class Computer(val numberOfProcessor: Int, var color: String) {
    public val publicA = 100
    internal val internalA = 100
    private val privateA = 100
    protected val protectedA = 100
}
//
//Compiled from "Computer.kt"
//public final class chapter07.Computer {
//    private final int numberOfProcessor;
//    private java.lang.String color;
//    public chapter07.Computer(int, java.lang.String);
//    public final int getNumberOfProcessor();
//    public final java.lang.String getColor();
//    public final void setColor(java.lang.String);
//}
