fun main(args: Array<String>) {
    val fruits = listOf("orange", "apple", "strawberry")

    //print all the fruits
    fruits.forEach { println(it) }

    //check fruit basket
    check(fruits)

}

fun check(b: List<String>) {
    when {
        "orange" in b -> println("Good basket")
        "apples" in b -> println("Good basket")
        else -> {
            println("Not so good basket")
        }
    }
}
