**MakeTimer.js**

example usage:
```
// Example usage
var MakeTimer = require("./MakeTimer");

var timed = new MakeTimer();
var count = 10;

function thing(){
  if(count >= 0){
    timed.start(1000,aTimedThing,thing);
    // timed.start(duration,function,callback)
    // callback is not required. This example
    // is simply demonstrating it's usage.
  }
  if(count === 5){
    timed.stop()
  }
}

function aTimedThing() {
  console.log("this is timed count",count)
  count--
}

thing()
```
