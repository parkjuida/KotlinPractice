import kotlinx.coroutines.*
import java.util.concurrent.Executors

suspend fun task1() {
    println("start task1 in Thread ${Thread.currentThread()}")
    println("end task1 in Thread ${Thread.currentThread()}")
}
suspend fun task2() {
    println("start task2 in Thread ${Thread.currentThread()}")
    println("end task2 in Thread ${Thread.currentThread()}")
}

Executors.newFixedThreadPool(5).asCoroutineDispatcher().use {
    context ->
    println("start")
    runBlocking {
        launch(context) { task1() }
        launch(context) { task2() }
        println("called task1 and task2 from ${Thread.currentThread()}")
    }
    println("done")
}