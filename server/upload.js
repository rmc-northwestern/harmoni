const IncomingForm = require("formidable").IncomingForm;
const fs = require('fs');

module.exports = async function upload(req, res) {
  var form = new IncomingForm();

  form.on("file", async (field, file) => {
    // Do something with the file
    // e.g. save it to the database
    // you can access it using file.path
    // console.log(file.path)

    inputFile = 'input.mid'
    fs.copyFile(file.path,inputFile,console.log)

    //check for existing test file to make sure an old one isnt returned
    if (fs.existsSync('files/result.txt')) {
      fs.unlinkSync('files/result.txt'); //make sure to not send old file
    }

    console.log('running java on file ', inputFile)
    var child = await require('child_process').spawn('java',['-jar', 'files/backend.jar', inputFile]);

    child.stdout.on('data', (data) => {
      console.log(`child stdout:\n${data}`);
    });

    child.stderr.on('data', (data) => {
      console.error(`child stderr:\n${data}`);
    });

    // fs.unlinkSync('files/input.mid'); //remove input

  });
  form.on("end", () => {
    console.log('sending response')
    res.send('complete.')
  });
  form.parse(req);
};
