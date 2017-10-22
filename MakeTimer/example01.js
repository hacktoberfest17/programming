// Example usage
var MakeTimer = require("./MakeTimer");

var timed = new MakeTimer();
var count = 10;

function thing(){
  if(count >= 0){
    timed.start(1000,aTimedThing,thing);
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
