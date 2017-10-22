// var user_input = prompt("Give me a number: ");

user_input = 25;



for (var num = 0; num <= user_input; num++) {
    var show = '';
    if (num % 3 === 0) show += 'Fizz';
    if (num % 5 === 0) show += 'Buzz';
    console.log(show ? show : num);

}