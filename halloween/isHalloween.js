// LANGUAGE: Javascript
// ENV: Node.js
// AUTHOR: Michael Hurley
// GITHUB: https://github.com/craftman32

var currentDate = new Date();
if ((currentDate.getMonth() + 1) === 10) {
    // the current month is October
    if (currentDate.getDate() === 31) {
        // today is Halloween!
        alert('Happy Halloween!');
    } else {
        alert('It is October, but today is not Halloween!');
    }
} else {
    alert('The current month is not October!');
}