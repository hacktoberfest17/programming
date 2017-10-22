function MakeTimer(){
  var t = {
    start: function(duration,func,callback) {
      this.func = func;
      this.duration = duration;
      this.callback = callback;
      this.timer = setTimeout(function() {
        func();
        if(typeof callback === "function"){
          callback();
        }
      }, duration);
    },
    stop: function(){
      clearTimeout(this.timer);
      return;
    }
  };
  return {
    start: t.start,
    stop: t.stop
  };
}
module.exports = MakeTimer;
