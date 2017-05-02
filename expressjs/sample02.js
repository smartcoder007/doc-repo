// Pug Template engine

var express = require('express');
var app = express();

app.set('view engine', 'pug');
app.set('views','./views');

app.get('/pugview', function(req, res){
    res.render('view01');
});

app.listen(3000,function(){
	console.log('Example app listening on port 3000!');
});
