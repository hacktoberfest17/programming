import scala.collection.mutable.Queue

object ReverseNumber extends App {
  var int = Queue[Int]()
  println("Reverse Number: ")
  var no = scala.io.StdIn.readInt()
  while (no != 0) {
    val remainder = no %10;
    int.enqueue(remainder)
    no = no/10;
  }
  println("reversed " + int.mkString(""))
  // reverses the string
}