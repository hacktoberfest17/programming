const http = require('http');
const process = require('process');

const port = process.env.PORT || 8080;

const html = `
    <html>
    <head>
        <title>Web Server</title>
    </head>
    <body>
        <h1>Hello World</h1>
    </body>
    </html>
`;

http.createServer(function(req, res) {
    res.writeHead(200, {'Content-Type': 'text/html'});
    res.end(html);
}).listen(port);
