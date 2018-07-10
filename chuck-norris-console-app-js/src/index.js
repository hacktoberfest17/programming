#!/usr/bin/env node

"use strict"

var request = require('request');
var readline = require('readline');

var inputOutput = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

console.log("Categories: explicit, dev, movie, food, celebrity, science, political, sport, religion, animal, music, history, travel, career, money, fashion \n");

inputOutput.question('What Category of Chuck Norris Joke Do you want? You can select from the categories listed above. If you want a random joke from any category, just hit Enter: ', (answer) => {
  var requestURL = "";

  if(answer != "" && typeof answer == "string"){
    requestURL = "https://api.chucknorris.io/jokes/random?category=" + answer;
  } else {
    requestURL = "https://api.chucknorris.io/jokes/random";
  }

  var options = {  
      url: requestURL,
      method: 'GET',
      headers: {
          'Accept-Charset': 'utf-8',
          'User-Agent': 'joel-console-application'
      }
  };


  request.get(options, function(error, response) {
    if (!error && response.statusCode == 200) {
      var returned = JSON.parse(response.body);
      console.log("\b");
      console.log(returned.value);
    } else {
      console.log("We couldn't find what you were looking for");
      console.log("Status Code: " + response.statusCode);
    }
  });
  inputOutput.close();
});

