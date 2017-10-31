
package bubbleSort;

import java.util.*


fun main(args: Array<String>){

    var sortList: Array<Int> = arrayOf(12,38,25,7,89,51)

    println(Arrays.toString(bubbleSort(sortList)))

}


fun bubbleSort(sortList:Array<Int>) : Array<Int> {

    var isSwap : Boolean
    var tempArr: Array<Int> = sortList

    do{
        isSwap = false

        for(i in 1..tempArr.size - 1){
            if(tempArr[i] < tempArr[i-1]) {

                var tmpvar = tempArr[i-1]
                tempArr[i-1] = tempArr[i]
                tempArr[i] = tmpvar


                isSwap = true
            }

        }
    }while(isSwap)

    return tempArr

}