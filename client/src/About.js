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

            <br/><br/>


            <div className='tint'>
              <img className='group' src='/group.jpeg' alt='group' />
            </div>
            <div className='bodyText left'>
              <b style={{fontSize:'1.3em'}}>The Tool:</b><br/><br/> Harmoni is a tool that provides users with harmonized versions of basic melodies. The user inputs a monophonic Musical Instrument Digital Interface (MIDI) file, and the key of the melody. Harmoni outputs the corresponding harmonized polyphonic MIDI file for download.
            </div>


            <br/><br/><br/>


            <div className='bodyText right'>
              <b style={{fontSize:'1.3em'}}>The Purpose:</b><br/><br/> Harmoni is built to be particularly useful for a few specific sets of users. Firstly, Harmoni allows young or inexperienced musicians to experiment with the fundamentals of chordal structure and harmony. As students learn and begin to create their own compositions, Harmoni provides them with a baseline comparison for their work. Instead of having to check with friends or professors, these users can measure the “legality” of chords and chord progressions with Harmoni itself.<br/><br/>
              Secondly, Harmoni caters to experienced composers who often need to perform mundane harmonization tasks by providing the opportunity to automate these processes. We hope that these professionals can leverage Harmoni to expedite their tedious workflows, allowing them to instead focus on more creative musical pursuits.

            </div>
            <div className='tint'>
              <img className='group' src='/ableton.png' alt='ableton' />
            </div>


            <br/><br/><br/>


            <div className='tint'>
              <img className='group' src='/workflow.png' alt='setup' />
            </div>
            <div className='bodyText left'>
              <b style={{fontSize:'1.3em'}}>The Workflow:</b><br/><br/>
              Our user-friendly interface takes the two inputs and passes this information to the Harmoni algorithm which is detailed in the stages below.
              <br/>
              <b>1. Chord Mapping:</b> After parsing and extracting each note in our melody, our algorithm decides which chords (the I or the V in the key, for example) are best played with it. These chord mappings are stored, and the chord to accompany the very first note in the melody is noted.
              <br/>
              <b>2. Progression Matrix:</b> We create a matrix assigning probabilities to all the chord mappings we have created. These probabilities dictate the likelihood a certain chord will be selected, given a specific chord that was played immediately prior.
              <br/>
              <b>3. Write to MIDI:</b> Our algorithm then creates and edits the original MIDI file by adding a “legal” progression of non-inverted triads to it. This step provides an appropriate harmonization of the input melody.
              <br/><br/>
              Because Harmoni aims to get young or inexperienced musicians more excited about composing, the algorithm incorporates an element of randomness. More specifically, our progression matrix keeps it interesting by choosing the next chord in a progression based on probabilities in our major and minor progression matrices. This means a user may input the same melody twice and obtain two different output harmonizations.
            </div>

            <br/><br/><br/>



            <div className='bodyText right'>
              <b style={{fontSize:'1.3em'}}>User Testing:</b><br/><br/>

              <br/><br/>
              Our testing phase consisted of three parts. We tested for how well-received our harmonizations were by musicians, non-musicians, and ground-truth information from music websites online.
            </div>
            <div className='tint'>
              <img className='group' src='/setup.jpeg' alt='setup' />
            </div>

            <div style={{height:'100px'}}></div>

          </div>
        </header>
      </div>
    );
  }
}

export default About;
