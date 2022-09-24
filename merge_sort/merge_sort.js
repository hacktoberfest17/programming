

function mergeSort(array){
   var len = array.length;
   if(len < 2){
     return array;
   }
    
   var middle, left, right;
   middle = Math.floor(len/2)
   left = array.slice(0, middle);
   right = array.slice(middle);
   
   return merge(mergeSort(left),mergeSort(right));
}
        


function merge(left, right){
  var result = [],
      lLen = left.length,
      rLen = right.length;

  var leftPtr = 0, rightPtr = 0;
      
  while(leftPtr < lLen && rightPtr < rLen){
     if(left[leftPtr] < right[rightPtr]){
       result.push(left[leftPtr]);
       leftPtr += 1;
     }
     else{
       result.push(right[rightPtr]);
       rightPtr += 1;
    }
  }  

  return result.concat(left.slice(leftPtr)).concat(right.slice(rightPtr));

}

t = [1,2,4,5,6,2,3,8,12,43]
x = [2,4,5]
console.log(mergeSort(t))
console.log(mergeSort(x))
