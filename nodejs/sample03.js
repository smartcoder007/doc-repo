// Blocking Code example
var fs = require("fs");

var data = fs.readFileSync('notes.txt');

console.log(data.toString());
console.log("Program Ended");