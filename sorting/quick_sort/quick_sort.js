// Quick sort algorithm
// Quicksort has a time complexity of O(nlog n)

// quickSort([11,8,14,3,6,2,7],0,6); 
// //[2, 3, 6, 7, 8, 11, 14]
// quickSort([11,8,14,3,6,2,1, 7],0,7);
// //[1, 2, 3, 6, 7, 8, 11, 14]
// quickSort([16,11,9,7,6,5,3, 2],0,7);
// //[2, 3, 5, 6, 7, 9, 11, 16]


function partition(arr, pivot, left, right){
   var pivotValue = arr[pivot],
       partitionIndex = left;

   for(var i = left; i < right; i++){
    if(arr[i] < pivotValue){
      swap(arr, i, partitionIndex);
      partitionIndex++;
    }
  }
  swap(arr, right, partitionIndex);
  return partitionIndex;
}

function swap(arr, i, j){
   var temp = arr[i];
   arr[i] = arr[j];
   arr[j] = temp;
}
    
function quickSort(arr, left, right){
   var len = arr.length, 
   pivot,
   partitionIndex;


  if(left < right){
    pivot = right;
    partitionIndex = partition(arr, pivot, left, right);
    
   //sort left and right
   quickSort(arr, left, partitionIndex - 1);
   quickSort(arr, partitionIndex + 1, right);
  }
  return arr;
}

