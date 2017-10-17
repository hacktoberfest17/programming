
// Functions are modules of a program which does a specific task
// Here I try to explain functions with help of currency converter program in javascript which converts a value of currency to another 


// Here we have defined a function convertToEuros which takes in one value named "dollars".This value is also known as argument,
// or parameter of a function

function convertToEuros (dollars){
	return dollars*0.85;  // this statement returns the calculated value to the place where function is called
}
var euros = convertToEuros(10); // this is where the function convertToEuros is called.
								// the retrun value is stored in euros variable
								// euros = 	8.5



// ANONYMOUS FUNCTIONS :- these functions do not have any name, hence anonymous

// Here we are declaring an anon function and storing that function in variable convertToYens
// NOTE:- convertToYens does not contain the return value of the function, it contains the function itself
var convertToYens = function (dollars){
	return dollars*112;
}
var yens = convertToYens(10); // the function stored in variable convertToYens is called and the return value is stored in var yens
							  // yens = 1120	 




// IIFE (IMMEDIATELY INVOKED FUNCTION EXPRESSION) :- it's an anonymous function that is invoked immediately after it's definition

(function (){
	console.log("It's an IIFE!");
}());                            // the function is invoked immediately after it is defined
								 // the whole thing is inside of a parenthesis to make it a JS expression	




// SCOPES
// GLOBAL & LOCAL SCOPES

var dollars = 15;  // this is a global variable, it has a global scope i.e this variable can be used any where in the program

function convertToRoubles (dollars){
	return dollars*57;
}
convertToRoubles(dollars);

function convertToINR (dollars){
	var dollars = 30;            // Here the var dollars has a local scope i.e the var dollars with value 30 can 
	return dollars*60;			 // only be used inside the function convertToINR.	
}
var rupees = convertToINR(dollars); // Here the dollars refer to the global dollar variable, although inside the function
									// it is changed locally
					    			// outside the val of dollars is still 15