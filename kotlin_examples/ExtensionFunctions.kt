fun Array<Int>.swap(a: Int, b: Int) {

  var temp = this[a]
  this[a] = this[b]
  this[b] = temp
}


fun main(args: Array<String>) {

  var arr = arrayOf(1, 2, 3, 4, 5, 6, 65)
  arr.forEach {
    print(" ${it},")
  }

  println("\n\npost swap")
  arr.swap(4, 5)
  arr.forEach {
    print(" ${it},")
  }
}