import React, { Component } from 'react';
import './App.css';
import Upload from './upload/Upload';
import { Redirect } from 'react-router-dom'

class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      file:[],
      upload:false
    }
  }

  closeUpload(finished){
    // if (finished){
    //   <Redirect to=''
    // }
    this.setState({upload:false})
  }

  renderUploadBox(){
    if (this.state.upload){
      return(
        <div style={{position:'absolute', zIndex:999, height: '100vh', width: '100vw', top:'20vh',margin:'auto'}}>
          <div className='Card' style={{margin:'auto'}}>
            <Upload closeUpload={()=>this.closeUpload()}/>
          </div>
        </div>
      )
    }
  }

  render() {
    console.log(this.state.file)
    return (
      <div className="App">
        <header className="App-header">
          <img src='/wave.gif' className="App-logo" alt="logo" />
          <div className='title'>
            <span className='titleBlue'>&lt;</span>
            &nbsp;harmoni&nbsp;
            <span className='titleBlue'> &#47;&gt;</span>
          </div>

          <div className='cardContainer'>
            <div className='card'>
              <div className='cardHeader'>YOU GIVE US:</div>
              <div className='cardBody'>
                Input MIDI file<br/>
                Monophonic Melody<br/>
                Basic Metadata
              </div>
            </div>

            <div className='card'>
              <div className='cardHeader'>WE GIVE YOU:</div>
              <div className='cardBody'>
                Output MIDI file<br/>
                Harmonized Accompaniment<br/>
                Chord Progression
              </div>
            </div>
          </div>
          <button className='buttonPrimary' onClick={()=>this.setState({upload:true})}>HARMONIZE</button>
        </header>
        {this.renderUploadBox()}
      </div>
    );
  }
}

export default App;
