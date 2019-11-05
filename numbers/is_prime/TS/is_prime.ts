/**
 * To run this file:
 * In the project root run:
 * 1. npm install
 * 2.  npm run tsc is_prime\is_prime.ts
 */

const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Please enter a number: ', (numberString: string) => {
    try {
        const number: number = Number(numberString);
        console.log(`The number: ${number} is ${isPrime(number) ? '':'not '} prime.`);
    } catch (e) {
        console.log(`The ${numberString} is not a number: ${e}`)
    }
    rl.close();
});

function isPrime(number: number): boolean {
    let i = 0;
    for(let j = 1; j <= number; j++) {
        if(number % j === 0) i = i + 1;
    }
    return i === 2;
}

