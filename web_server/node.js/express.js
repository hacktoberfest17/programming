const express = require('express');

const app = express();
const port = process.env.PORT || 3000;
const router = express.Router();

app.use(express.static(__dirname + '/public'));
app.get('/', function (req, res) {
  res.sendfile('index.html');
});

app.use('/', router);

app.listen(port);
console.log('Magic happens on port ' + port);
