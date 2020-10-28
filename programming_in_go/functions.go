package main
import "fmt"
func main(){
    var a int=50
    var b int=40
    var ret int
    ret=max(a,b)
    fmt.Printf("Max is %d",ret)
}

func max(num1,num2 int) int {
    if(num1>num2){
    return num1
    } else{
    return num2
    }
}