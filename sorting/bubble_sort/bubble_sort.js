function bubble_sort(arr) {
  console.log("before:", arr);
  for (var i=arr.length-1; i>0; i-- ) {
    for (var j=0; j<i;j++) {
      if (arr[j] > arr[j+1]) {
        swap(arr,j,j+1);
      }
    }
  }
  return arr;
}

function swap(arr, a, b) {
    const temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
}


array = [5,6,2,4,3,1,0,0]

console.log("sorted:", bubble_sort(array))
