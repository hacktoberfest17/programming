function getThisMonth() {
  var date = new Date();
  var firstDay = new Date(date.getFullYear(), date.getMonth(), 1);
  var lastDay = new Date(date.getFullYear(), date.getMonth()+1,0);

  var fDay = format(firstDay, "day");
  var fMonth = format(firstDay, "month");
  var fYear = firstDay.getFullYear();
  firstDay = fYear + "-" + fMonth + "-" + fDay;

  var lDay = format(lastDay, "day");
  var lMonth = format(lastDay, "month");
  var lYear = lastDay.getFullYear();
  lastDay = lYear + "-" + lMonth + "-" + lDay;

  // Format the dates so single digits have a 0 before them.
  function format(a, x){
    if (x === "month"){
      var b = a.getMonth()+1;
      if (parseInt(b) < 10){
        b = "0" + b;
      }
    }
    else if (x === "day"){
      var b = a.getDay();
      if (parseInt(b) < 10){
        b = "0" + b;
      }
    }
    return b;
  }

  console.log("✅ First: " + firstDay + " | Last: " + lastDay);
}
