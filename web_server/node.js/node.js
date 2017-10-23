const http = require('http');

const port = process.env.PORT || 3000;

const html =
    <html>
    <head>
        <title>Node.js</title>
    </head>
    <body>
        <h1>Hello World</h1>
    </body>
    </html>
    ;

http.createServer(function(req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(html);
}).listen(port);
