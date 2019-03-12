const IncomingForm = require("formidable").IncomingForm;
const fs = require('fs');

module.exports = async function upload(req, res) {
  var form = new IncomingForm();

  form.on("file", async (field, file) => {
    // Do something with the file
    // e.g. save it to the database
    // you can access it using file.path
    // console.log(file.path)
    localPathOrig = 'files/midi.mid'
    localPathResp = 'files/chords.mid'
    fs.copyFile(file.path,localPathOrig,console.log)
    fs.copyFile(localPathOrig,localPathResp,console.log)
    //do things to file 'localPathResp'

    //check for existing test file to make sure an old one isnt returned
    if (fs.existsSync('files/test.txt')) {
      fs.unlinkSync('files/test.txt'); //make sure to not send old file
    }
    var child = await require('child_process').spawn('java',['-jar', 'files/test.jar']);
  });
  form.on("end", () => {
    console.log('sending response')
    res.send('complete.')
  });
  form.parse(req);
};
