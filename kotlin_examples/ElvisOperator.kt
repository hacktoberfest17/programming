//The Elvis operator takes two inputs.  It returns the 1st parameter if it's not null, otherwise it returns the second
//It's named this because it looks like an Elvis hairstyle emoji

class ElvisOperator {

    fun main(args: Array<String>) {
        
        var a: Int? = 1
        var b: Int? = 2
        println("Let a=1 and b=2")
        println("a ?: b = " + a ?: b)
        println("a is returned because it's not null")
        println()

        a = null
        b = 2
        println("Let a=null and b=2")
        println("a ?: b = " + a ?: b)
        println("b is returned because a is null")
        println()

        a = 1
        b = null
        println("Let a=1 and b=null")
        println("a ?: b = " + a ?: b)
        println("a is returned because it's not null")
        println()

        a = null
        b = null
        println("Let a=null and b=null")
        println("b is returned because a is null")
        println("a ?: b = " + a ?: b)
        println()
    }
}
