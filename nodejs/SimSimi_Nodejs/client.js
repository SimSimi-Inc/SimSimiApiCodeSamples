var http = require('http');
var url = require('url');
var querystring = require('querystring');

var callback = function(req, res) {
	var urlObj = url.parse(req.url);
	var uri = urlObj.pathname;
	var paramObj = querystring.parse(urlObj.query);
	console.log("===========================");
	console.log(uri);
	console.log(paramObj);
	console.log("===========================");
	if (uri === "/") {
		res.writeHead(200, {
			"Content-Type" : "text/html"
		});
		res.write("<html>");
		res.write("<head>");
		res.write('<meta http-equiv="Content-Type" Content="text/html; charset=utf-8" />');
		res.write("<title>Hello World Page</title>");
		res.write("</head>");
		res.write("<body>");
		res.write("<form method='get' action='/request' accept-charset='utf-8'>");
		res.write("text:<input type='text'name='text'/><br>");
		res.write("language code : <input type='text' name='lc'/><br>");
		res.write("<input type='submit' value = 'submit'/>");
		res.write("</form>");
		res.write("</body>");
		res.write("</html>");
		res.end();
		
	} else if (uri === "/request") {
		
		var lc = encodeURI(paramObj.lc);
		var text = encodeURI(paramObj.text);
		
		var options = {
			hostname : 'sandbox.api.simsimi.com',
			port : 80,
			path : '/request.p?key=d6bbfd1b-7cb3-4cfe-87b1-261e4d210d19&lc='+lc+'&ft=0.0&text='+text,
			method : 'GET'
		};

		http.get(options, function(apiRes) {
			var data = "";
			
			apiRes.on("data", function(chunk) {
				data = data + chunk;
			});
			
			apiRes.on("end", function() {
				console.log(data);
				res.writeHead(200, {
					"Content-Type" : "application/json; charset=utf-8"
				});
				res.write(data);
				res.end();
			});
			
		}).on('error', function(e) {
			console.log("error");
		});

	} else {
		res.writeHead(404);
		res.end();
	}
};

http.createServer(callback).listen(8080);
