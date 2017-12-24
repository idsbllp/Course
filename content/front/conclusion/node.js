var http = require('http');
var fs = require('fs');

var server = http.createServer(function(request, response) {
    var pathname = request.url;
    if (pathname === '/') {
        response.end(fs.readFileSync('./index.html'));
    } else {
        response.end(fs.readFileSync('.' + pathname));
    }
});

server.listen(1025);
