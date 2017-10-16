function binarySearch(data, target, low, high) {

  if (low > high) {
    return false;
  }
  else {
    mid = (low+high)//2;

    if (target < data[mid]) {
      return binarySearch(data, target, 0, mid-1);
    }
    else if (target > data[mid]) {
      return binarySearch(data, target, mid+1, high);
    }
    else{
      return true;
    }
  }
}



array = [1,3,5,7,9,11,20,55];
console.log(array);

console.log("5 in arr: ", binarySearch(array, 5, 0, array.length-1));
console.log("10 in arr: ", binarySearch(array, 10, 0, array.length-1));
console.log("-1 in arr: ", binarySearch(array, -1, 0, array.length-1));
console.log("55 in arr: ", binarySearch(array, 55, 0, array.length-1));
