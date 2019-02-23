import React, { Component } from 'react';
import './App.css';

class App extends Component {
  render() {
    return (
      <div className="App">
        <header className="App-header">
          <img src='/wave.png' className="App-logo" alt="logo" />
          <h1>
            harmoni
          </h1>
          <h6>
            automated harmony generator
          </h6>
          <a
            className="App-link"
            href="http://will.com"
            target="_blank"
            rel="noopener noreferrer"
          >
            Enter
          </a>
        </header>
      </div>
    );
  }
}

export default App;
