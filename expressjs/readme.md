Ref:
https://expressjs.com/en/starter/installing.html
https://www.tutorialspoint.com/expressjs/expressjs_routing.htm

1) Express is a routing and middleware web framework. An Express application is essentially a series of middleware function calls. Middleware functions are functions that have access to the request object (req), the response object (res), and the next middleware function in the application’s request-response cycle.


2) app.METHOD(PATH, HANDLER)
METHOD is any one of the HTTP verbs(get, set, put, delete). An alternate method called all exists that executes independent of the request type.
Path is the route at which the request will run.
Handler is a callback function that executes when a matching request type is found on the relevant route.

eg: app.get('/hello', function(req, res){
	res.send("Hello World!");
});


3) Routers:

file: things.js

var express = require('express');
var router = express.Router();

router.get('/', function(req, res){
	res.send('GET route on things.');
});
router.post('/', function(req, res){
	res.send('POST route on things.');
});
//export this router to use in our index.js
module.exports = router;


In Indexd.js use things.js
var things = require('./things.js'); 
//both index.js and things.js should be in same directory
app.use('/things', things); 



4) Templating:
Pug is a templating engine for express.

add these line 
app.set('view engine', 'pug');
app.set('views','./views');

5)Loading static files:
app.use(express.static('public'));

6) Form data

7) Database
//1. Require
var mongoose = require('mongoose');
// 2. connection establishment
mongoose.connect('mongodb://localhost/my_db');
// 3. create model
var personSchema = mongoose.Schema({
   name: String,
   age: Number,
   nationality: String
});
var Person = mongoose.model("Person", personSchema);

8) RESTFul APIs

9) Scaffolding
Scaffolding allows us to easily create a skeleton for a web application. The scaffolder we'll use is called Yeoman.
To install yeoman
npm install -g yeoman

Yeoman uses generators to scaffold out applications. To check out the generators available on npm to use with yeoman
npm install -g generator-express-simple


10 )Error Handling

//An error handling middleware
app.use(function(err, req, res, next) {
    res.status(500);
    res.send("Oops, something went wrong.")
});

11) Debugging
DEBUG=express:* node index.js

For example, if you wish to restrict the logger to application and router, you can use:
DEBUG=express:application,express:router node index.js





