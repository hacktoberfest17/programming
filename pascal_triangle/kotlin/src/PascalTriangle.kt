import java.util.*

object PascalTriangle {
    @JvmStatic fun main(args: Array<String>) {
        println("Enter row number: ")
        val rowNum = Scanner(System.`in`).nextInt()
        print(Math.pow(2.0, rowNum.toDouble()))
    }
}