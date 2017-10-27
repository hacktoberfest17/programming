object PascalTriangle {
  def main(args: Array[String]): Unit = {
    println("Enter no. of rows")
    val row = scala.util.Try(readInt())
    if(row.isSuccess && row.get > 0){
      val pascalSum = scala.math.pow(2,row.get) - 1
      println(s"Pascal Triangle Sum = ${pascalSum}")
    }else{
      println("Enter valid row")
    }
  }
}

