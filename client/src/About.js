import React, { Component } from 'react';
import './App.css';
import './About.css'
import Nav from './Nav'

class About extends Component {

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <Nav current='about'/>
          <video src='/wave.mov' autoPlay loop className="App-logo" alt="logo"/>
          <div style={{height: '60px'}}></div>
          <div className='title'>
            <span className='titleBlue'>&lt;</span>
            &nbsp;about&nbsp;
            <span className='titleBlue'> &#47;&gt;</span>
          </div>

          <div className='cardContainer'>
            <div>
              <b>DESIGNED @:</b> <br/><br/>
            <span style={{fontWeight:100}}>
              Northwestern University<br/>
              EECS352 - Machine Perception of Audio<br/>
              Prof. Bryan Pardo<br/>
              Spring, 2019
            </span>
            </div>
            <div className='tint'>
              <img className='group' src='/group.jpeg' alt='group' />
            </div>
            <div className='bodyText'>
              This project was designed for multiple user groups. First, we considered the up and coming music student: passionate about composition, but still learning the fundamentals of theory and chordal structure. Melodi provides these students with the ability to harmonize their compositions and continue to learn and experiment, even with a limited knowledge base. Second, we considered experienced professional composers who routinely perform harmonization and orchestration tasks that require mundane adn repititive chordal analysis. <i>Harmoni</i> provides this user group with the automation to accelerate their workflow and avoid brute work to focus on creativity.
            </div>


            <br/>


            <div className='bodyText'>
              Harmoni takes any given monophonic melody in the form of a MIDI file and develops a practical harmonization for the user, returned in the form of a second accompanied MIDI file. By using a Markov probability model based on each individual melody note and the preceding chord, Harmoni decides on the most logical progession and builds the MIDI file for the user to play right away.
            </div>
            <div className='tint'>
              <img className='group' src='/ableton.png' alt='ableton' />
            </div>


            <br/>



            <div className='tint'>
              <img className='group' src='/setup.jpeg' alt='setup' />
            </div>
            <div className='bodyText'>
              The model was built using MIDI versions of common folk songs, holiday carols, and other simple melody sequences.  Measuring success on the 'does this sound right?' scale as well as the results of musicians and composers, we are confident that Harmoni can design a functionally correct harmonization in all scenarios.
            </div>

            <div style={{height:'100px'}}></div>

          </div>
        </header>
      </div>
    );
  }
}

export default About;
