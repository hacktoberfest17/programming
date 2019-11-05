/*
    Given a nested array the objective is to flatten it to a signle array in the same order it appaers
    Sample i/p      : [1,2,[3,4,[5,6],7],8,9]
    Expected o/p    : [1,2,3,4,5,6,7,8,9,] 
*/

var input = [1,2,[3,4,[5,6],7],8,9]
var output = [];

function flattenArray(input, output){
  for(var i = 0; i < input.length; i++) {
    if(Array.isArray(input[i])) {
      flattenArray(input[i], output);
    } else {
      output.push(input[i]);
    }
  }
};

flattenArray(input, output);
console.log(output);