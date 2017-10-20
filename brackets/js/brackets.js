

const isBalanced = function(str){
	const stack = new Array(); //can be used as LIFO stack
	for (let i = 0; i < str.length; i++){
		const c = str.charAt(i);
		if (c =='(' || c == '[' || c == '{'){
			stack.push(c);
		}
		else{
			if (stack.length === 0){
				return false;
			}
			const p = stack.pop();
 			if (c === ')'){
 				if (p !== '(') return false;
 				else 
 					continue;
 			}
 			if (c === '['){
 				if (p !== ']') return false;
 				else 
 					continue;
 			}
 			if (c === '{'){
 				if (p !== '}') return false;
 			}

		}
	}

	return (stack.length === 0 ? true : false);

}


//test function:

console.log(isBalanced("[{([])}[]({})]")); //true
console.log(isBalanced("[{{}]")); //false
console.log(isBalanced("[]]"));//false