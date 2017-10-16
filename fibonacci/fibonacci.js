function fibonacci(n) {
   return n < 1 ? 0
        : n <= 2 ? 1
        : fibonacci(n - 1) + fibonacci(n - 2);
}

//to test it, refer this js file in a html page, and in browser console you can do the command bellow, for example
console.log(fibonacci(4));