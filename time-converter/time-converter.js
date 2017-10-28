//takes in digital clock format of time and returns in seconds only number
//(example use: user input to set start time of a video)


function timeChange(time){
  var splitTime = time.split(":");
  var newTime = parseInt(splitTime[0]*60) + parseInt(splitTime[1]);
  console.log(newTime);
  return newTime;

}

timeChange("1:30");
