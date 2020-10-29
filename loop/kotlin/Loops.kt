/**
 * A demo for different types of loops in Kotlin
 *
 * See [Kotlin Loops](https://kotlinlang.org/docs/tutorials/kotlin-for-py/loops.html)
 */
fun main(args: Array<String>) {
    println("A demo for different types of loops in Kotlin ^_^")
    println("")
    println("Input is a list of {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}")
    println("")

    val inputList = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("\nFor loop with a range (start and end inclusive)")
    for (input in 0..inputList.size) {
        println(input)
    }

    println("\nFor each loop")
    for (input in inputList) {
        println(input)
    }

    println("\nFor loop (exclude last value)")
    for (i in 0 until 10) {
        println(inputList[i])
    }

    println("\nFor loop in steps")
    for (i in 0 until 10 step 2) {
        println(inputList[i])
    }

    println("\nFor loop in steps (reverse)")
    for (i in 9 downTo 0 step 2) {
        println(inputList[i])
    }

    println("\nWhile loop")
    var i = 0
    while (i < inputList.size) {
        println(inputList[i])
        i++
    }

    println("\nWhile loop with continue to print even numbers")
    i = 0
    outer@ while (i < inputList.size) {
        if(i % 2 == 0) {
            i++
            continue@outer
        }
        println(inputList[i])
        i++
    }

    println("\nStream")
    inputList.forEach { println(it) }

    println("\nStream and index")
    inputList.forEachIndexed { index, value -> println("index=$index value=$value") }
}
