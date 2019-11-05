fun main(args: Array<String>) {
  var length_b: Int?
  var a = "abc"

  var b: String? = "bcd"

  print(a)
  print(b)

  val length_a = a.length
  //val length_b =b.length  --> Not allowed as only safe calls and non-null asserted calls are allowed


  // Multiple ways of unwrapping the value


  // 1 use if

  length_b = if (b != null) {
    b.length
  } else {
    -1

  }

  println(length_a)
  println(length_b)


  //Use safe call operator

  length_b = b?.length
  println(length_b)


  //Elvis operator
  val l = b?.length ?: -1
  println(l)


  val foo = fun(a:Int , b:Int):Int{return a+b}

}
