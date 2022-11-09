#!/usr/local/bin/python
var A = [5,4,3,2,1]
var B = []
var C = []


function TowerOfHanoi(n, source, target, aux) {
  if (n > 0) {
    // Move n - 1 disks from source to auxiliary, so they are out of the way
    TowerOfHanoi(n - 1, source, aux, target);
    // Move the nth disk from source to target
    target.push(source.pop());
    // Display progress
    printArrays();
    // Move the n - 1 disks that we left on auxiliary onto target
    TowerOfHanoi(n - 1, aux, target, source);

  }
}

function printArrays() {
  console.log(A + ' ****** ' + B + ' ****** ' + C);
}

printArrays();
TowerOfHanoi(5, A, B, C);
