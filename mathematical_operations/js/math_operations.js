//math_operations.js --- using node.js readline-sync module
//(must install the module to run --- package.json included) 
const rlSync = require('readline-sync');

const a = parseInt(rlSync.question("First integer: "));
const b = parseInt(rlSync.question("Second integer: "));

const sum = a + b;
const product = a * b;
const difference = a - b;
const quotient = a / b;
const remainder = a % b;


console.log("The sum %d + %d = %d", a, b, sum);
console.log("The difference %d - %d = %d", a, b, difference);
console.log("The product %d * %d = %d", a, b, product);
console.log("The quotient %d / %d = %d", a, b, quotient);
console.log("The remainder of the division %d / %d = %d", a, b, remainder);
