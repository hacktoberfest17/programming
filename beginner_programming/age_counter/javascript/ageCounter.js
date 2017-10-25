function getAge() {
  var date = new Date();
  var currentYear = date.getFullYear();
  var birthYear = prompt("Enter your birth year");
  var age = currentYear - birthYear;
  return "you are " + age + " years old";
}

console.log(getAge());
