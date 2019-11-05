//Write down a function which after triggering like this:
//console.log('hello'.repeatify(3))
//Should print hellohellohello.

String.prototype.repeatify =
  String.prototype.repeatify ||
  function(count) {
    return this.repeat(count);
  };

console.log("hello".repeatify(3)); //hellohellohello
