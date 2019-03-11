import React, { Component } from 'react';
import './App.css';
import './Team.css';
import Upload from './upload/Upload';
import Nav from './Nav'
import { Redirect } from 'react-router-dom'

class Team extends Component {

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
          <Nav current='team'/>
          <img src='/wave.gif' className="App-logo" alt="logo" />
          <div className='title'>
            <span className='titleBlue'>&lt;</span>
            &nbsp;team&nbsp;
            <span className='titleBlue'> &#47;&gt;</span>
          </div>

          <div className='cardContainer'>
            <div className='container'>
              <div className='colorbg'>
                <img className='profimg' src='/ishaan.jpg' />
              </div>
              <div className='name'>Ishaan Madan</div>
              <div className='description'>he writes some java but also breaks things sometimes?</div>
            </div>
            <div className='container'>
              <div className='colorbg'>
                <img className='profimg' src='/sarah.png' />
              </div>
              <div className='name'>Sarah O'Brien</div>
              <div className='description'>she does math good and also plays the music #jinglebells</div>
            </div>
            <div className='container'>
              <div className='colorbg'>
                <img className='profimg' src='/ryan.jpg' />
              </div>
              <div className='name'>Ryan McHenry</div>
              <div className='description'>he makes things pretty and colorful and writes the no fun code!</div>
            </div>
          </div>
        </header>
      </div>
    );
  }
}

export default Team;
