//This script searches all open issues on Github tagged with Hacktoberfest

var https = require('https');

//Github requires us to use a user-agent
//(http://developer.github.com/v3/#user-agent-required)
var objOptions = {
    headers : {
        'User-Agent' : 'lwagf'
    },
    path : '/search/issues?q=label:hacktoberfest+state:open&sort=created',
    protocol : "https:",
    host : 'api.github.com'
};

https.get(objOptions, function(resp) {
  var data = '';

  // A chunk of data has been recieved.
  resp.on('data', function(chunk) {
    data += chunk;
  });

  // The whole response has been received. Print out the result.
  resp.on('end', function() {
    console.log(data);
  });

}).on("error", function(err) {
  console.log("Error: " + err.message);
});
