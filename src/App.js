import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src='/wave.gif' className="App-logo" alt="logo" />
          <div className='title'>
            <span className='titleBlue'>&lt;</span>
            &nbsp;harmoni&nbsp;
            <span className='titleBlue'> &#47;&gt;</span>
          </div>

          <input type='file' name='midiFile'/>

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

          <a href="http://will.com" target="_blank" rel="noopener noreferrer">
            <button className='buttonPrimary'>HARMONIZE</button>
          </a>
        </header>
      </div>
    );
  }
}

export default App;
