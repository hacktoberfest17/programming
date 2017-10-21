// FOR LOOP
// -Use for loop when you know exact number of times to run loop
// for ([initialization]; [condition]; [iteration]) {
//   [loop body]
// }
// -Initialization: begin a counter variable
// -Condition: expression evaluated before passing through each loop
// -Iteration: statement executed at the end of each iteration, bringing loop closer to completion
// -Loop body: code that runs on each pass through the loop

const dogs = ['Caroga', 'Titan', 'Chief'];

function goodDog(dogs) {
  for (let i = 0; i < dogs.length; i++) {
    console.log(`Who's a good dog? ${dogs[i]}'s a good dog!'`);
  }
  return dogs;
}
// goodDog(dogs); => Who's a good dog? Caroga's a good dog!'
//                   Who's a good dog? Titan's a good dog!'
//                   Who's a good dog? Chief's a good dog!'
//                   (3) ["Caroga", "Titan", "Chief"]
