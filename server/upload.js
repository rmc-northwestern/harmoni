const IncomingForm = require("formidable").IncomingForm;
const fs = require('fs');

module.exports = function upload(req, res) {
  var form = new IncomingForm();

  form.on("file", (field, file) => {
    // Do something with the file
    // e.g. save it to the database
    // you can access it using file.path
    console.log(file.path)
    localPathOrig = 'files/midi.mid'
    localPathResp = 'files/chords.mid'
    fs.copyFile(file.path,localPathOrig,console.log)
    fs.copyFile(localPathOrig,localPathResp,console.log)
  });
  form.on("end", () => {
    res.writeHead(200, {
          "Content-Type": "application/octet-stream",
          "Content-Disposition": "attachment; filename=" + localPathResp
        });
        fs.createReadStream(localPathResp).pipe(res);
  });
  form.parse(req);
};
