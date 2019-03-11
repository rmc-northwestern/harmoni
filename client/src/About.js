import React, { Component } from 'react';
import './App.css';
import './About.css'
import Nav from './Nav'
import { Redirect } from 'react-router-dom'

class About extends Component {

  render() {
    return (
      <div className="App">
        <header className="App-header">
          <Nav current='about'/>
          <img src='/wave.gif' className="App-logo" alt="logo" />
          <div className='title'>
            <span className='titleBlue'>&lt;</span>
            &nbsp;about&nbsp;
            <span className='titleBlue'> &#47;&gt;</span>
          </div>

          <div className='cardContainer'>
            <div>
              DESIGNED @: <br/><br/>
              Northwestern University<br/>
              EECS352 - Machine Perception of Audio<br/>
              Prof. Bryan Pardo<br/>
              Spring, 2019
            </div>
          </div>
        </header>
      </div>
    );
  }
}

export default About;
