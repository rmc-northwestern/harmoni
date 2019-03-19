import React, { Component } from "react";
import Dropzone from "../dropzone/Dropzone";
import "./Upload.css";
import Progress from "../progress/Progress";

class Upload extends Component {
  constructor(props) {
    super(props);
    this.state = {
      files: [],
      uploading: false,
      uploadProgress: {},
      successfullUploaded: false
    };

    this.onFilesAdded = this.onFilesAdded.bind(this);
    this.uploadFiles = this.uploadFiles.bind(this);
    this.sendRequest = this.sendRequest.bind(this);
    this.renderActions = this.renderActions.bind(this);
  }

  onFilesAdded(files) {
    this.setState(prevState => ({
      files: prevState.files.concat(files)
    }));
  }

  async uploadFiles() {
    if (!this.state.key){
      alert('Whoops! Make sure to select a key!')
      return
    }
    this.setState({ uploadProgress: {}, uploading: true });
    const promises = [];
    this.state.files.forEach(file => {
      promises.push(this.sendRequest(file));
    });
    try {
      await Promise.all(promises);

      this.setState({ successfullUploaded: true, uploading: false });
      window.setTimeout(()=>{this.props.closeUpload()},2000)
    } catch (e) {
      // Not Production ready! Do some error handling here instead...
      this.setState({ successfullUploaded: true, uploading: false });
    }
  }

  sendRequest(file) {
    return new Promise(async (resolve, reject) => {
      const req = new XMLHttpRequest();

      req.upload.addEventListener("progress", event => {
        if (event.lengthComputable) {
          const copy = { ...this.state.uploadProgress };
          copy[file.name] = {
            state: "pending",
            percentage: (event.loaded / event.total) * 100
          };
          this.setState({ uploadProgress: copy });
        }
      });

      req.upload.addEventListener("load", event => {
        const copy = { ...this.state.uploadProgress };
        copy[file.name] = { state: "done", percentage: 100 };
        this.setState({ uploadProgress: copy });
        resolve(req.response);
      });

      req.upload.addEventListener("error", event => {
        const copy = { ...this.state.uploadProgress };
        copy[file.name] = { state: "error", percentage: 0 };
        this.setState({ uploadProgress: copy });
        reject(req.response);
      });

      const formData = new FormData();
      formData.append("file", file, this.state.key);

      req.open("POST", "http://localhost:8000/upload");
      req.send(formData);

    });
  }

  renderProgress(file) {
    const uploadProgress = this.state.uploadProgress[file.name];
    if (this.state.uploading || this.state.successfullUploaded) {
      return (
        <div className="ProgressWrapper">
          <Progress progress={uploadProgress ? uploadProgress.percentage : 0} />
          <img
            className="CheckIcon"
            alt="done"
            src="baseline-check_circle_outline-24px.svg"
            style={{
              opacity:
                uploadProgress && uploadProgress.state === "done" ? 0.5 : 0
            }}
          />
        </div>
      );
    }
  }

  renderActions() {
    if (this.state.successfullUploaded) {
      return (
        <button
          onClick={() =>
            this.setState({ files: [], successfullUploaded: false })
          }
        >
          Clear
        </button>
      );
    } else {
      return (
        <button
          disabled={this.state.files.length < 0 || this.state.uploading}
          onClick={this.uploadFiles}
        >
          Upload
        </button>
      );
    }
  }

  async selectKey(key){
    await this.setState({key:key})
  }

  keyStyle(key){
    if (key.length === 1){
      return this.state.key === key ? 'whiteKey selectedKey' : 'whiteKey'
    }
    return this.state.key === key ? 'blackKey selectedKey' : 'blackKey'
  }

  renderPiano(){
    if (this.state.files.length > 0){
      return(
        <div>
          <div>Choose the major key signature...&nbsp;<b style={{color: '#B80F42', fontSize:'1.2em'}}>{this.state.key}</b></div>
          <div className='pianoContainer'>
            <div className={this.keyStyle('C')} onClick={()=>this.selectKey('C')}></div>
            <div className={this.keyStyle('D')} onClick={()=>this.selectKey('D')}></div>
            <div className={this.keyStyle('E')} onClick={()=>this.selectKey('E')}></div>
            <div className={this.keyStyle('F')} onClick={()=>this.selectKey('F')}></div>
            <div className={this.keyStyle('G')} onClick={()=>this.selectKey('G')}></div>
            <div className={this.keyStyle('A')} onClick={()=>this.selectKey('A')}></div>
            <div className={this.keyStyle('B')} onClick={()=>this.selectKey('B')}></div>

            <div className={this.keyStyle('Db')} id='Db' onClick={()=>this.selectKey('Db')}></div>
            <div className={this.keyStyle('Eb')} id='Eb' onClick={()=>this.selectKey('Eb')}></div>
            <div className={this.keyStyle('Gb')} id='Gb' onClick={()=>this.selectKey('Gb')}></div>
            <div className={this.keyStyle('Ab')} id='Ab' onClick={()=>this.selectKey('Ab')}></div>
            <div className={this.keyStyle('Bb')} id='Bb' onClick={()=>this.selectKey('Bb')}></div>
          </div>
      </div>
      )
    }
  }

  render() {
    return (
      <div className="Upload">
        <div className='closeButton' onClick={()=>this.props.closeUpload(true)}>X</div>
        <span className="Title">Upload Files</span>
        <div className="Content">
          <div>
            <Dropzone
              onFilesAdded={this.onFilesAdded}
              disabled={this.state.uploading || this.state.successfullUploaded}
            />
          </div>
          <div className="Files">
            {this.state.files.map(file => {
              return (
                <div key={file.name} className="Row">
                  <span className="Filename">{file.name}</span>
                  {this.renderProgress(file)}
                </div>
              );
            })}

            {this.renderPiano()}
          </div>
        </div>
        <div className="Actions">{this.renderActions()}</div>
      </div>
    );
  }
}

export default Upload;
