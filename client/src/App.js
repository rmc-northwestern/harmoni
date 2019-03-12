import React, { Component } from 'react';
import './App.css';
import Upload from './upload/Upload';
import Nav from './Nav'
import Loading from './Loading'

class App extends Component {

  constructor(props){
    super(props);
    this.state = {
      upload:false,
      loading:false,
      complete:false
    }
  }

  closeUpload(closebutton){
    if (closebutton === true){
      this.setState({upload:false})
    }
    else{
      this.setState({upload:false, loading:true})
    }
  }

  renderUploadBox(){
    if (this.state.upload){
      return(
        <div style={{position:'absolute', zIndex:999, height: '100vh', width: '100vw', top:'20vh',margin:'auto'}}>
          <div className='Card' style={{margin:'auto'}}>
            <Upload closeUpload={(e)=>this.closeUpload(e)}/>
          </div>
        </div>
      )
    }
  }

  waitForComplete(){
    window.setTimeout(()=>{
      this.setState({complete:true,loading:false})
    },2000)
  }

  render() {
    if (!this.state.loading && !this.state.complete){
      return (
        <div className="App">
          <header className="App-header">
            <Nav current='home'/>
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
              <br/>
              <button className='buttonPrimary' onClick={()=>this.setState({upload:true})}>HARMONIZE</button>
            </div>

          </header>
          {this.renderUploadBox()}
        </div>
      );
    }


    if (this.state.loading){
      this.waitForComplete()
      return (
        <div className="App">
          <header className="App-header">
            <Nav current='home'/>
            <img src='/wave.gif' className="App-logo" alt="logo" />

            <div className='cardContainer'>
              <Loading/>
            </div>

          </header>
        </div>
      );
    }

    if (this.state.complete){
      return (
        <div className="App">
          <header className="App-header">
            <Nav current='home'/>
            <img src='/wave.gif' className="App-logo" alt="logo" />
            <div className='title'>
              <span className='titleBlue'>&lt;</span>
              &nbsp;complete&nbsp;
              <span className='titleBlue'> &#47;&gt;</span>
            </div>

            <div className='cardContainer'>
              <a href='http://localhost:8000/download'>
                <button className='buttonPrimary'>DOWNLOAD MIDI FILES</button>
              </a>
            </div>

          </header>
        </div>
      );
    }

  }
}

export default App;
