const express = require("express");
const upload = require("./upload");
const cors = require("cors");

const server = express();

var corsOptions = {
  origin: "*",
  optionsSuccessStatus: 200
};

server.use(cors(corsOptions));

server.post("/upload", upload);

server.get('/download', async function(req, res){
  var child = await require('child_process').spawn('java',['-jar', 'files/test.jar']);
  var file = 'files/test.txt'
  res.download(file); // Set disposition and send it.
});

server.listen(8000, () => {
  console.log("Server started!");
});
