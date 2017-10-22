
function insSort(arr) {
  var length = arr.length;
  
  for(var i = 1; i < length; i++) {
    var tmp = arr[i];
    for(var j = i - 1; j >= 0 && arr[j] > tmp; j--) {
      arr[j+1] = arr[j];
    }
    arr[j+1] = tmp;
  }
  
  return arr;
}
