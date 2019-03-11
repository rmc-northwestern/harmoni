package com.company;

import javax.sound.midi.*;

public class soundTest{

    public static void main(String[] args) {
        try{
            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();

            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();

            midiSynth.loadInstrument(instr[0]);

            mChannels[0].noteOn(60, 100);// Note C note 1
            mChannels[0].noteOn(64,100); // Note E note 3
            mChannels[0].noteOn(67,100); // Note G note 5

            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }


            mChannels[0].noteOff(60);//turn of the note
            mChannels[0].noteOff(64);//turn of the note
            mChannels[0].noteOff(67);//turn of the note


            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }

            mChannels[0].noteOn(65, 100);//On channel 0, play note number 60 with velocity 100
            mChannels[0].noteOn(69,100);
            mChannels[0].noteOn(72,100);


            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }


            mChannels[0].noteOff(65);//turn of the note
            mChannels[0].noteOff(69);//turn of the note
            mChannels[0].noteOff(72);//turn of the note

            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }

            mChannels[0].noteOn(67, 100);//On channel 0, play note number 60 with velocity 100
            mChannels[0].noteOn(71,100);
            mChannels[0].noteOn(74,100);


            try { Thread.sleep(1000); // wait time in milliseconds to control duration
            } catch( InterruptedException e ) { }


            mChannels[0].noteOff(67);//turn of the note
            mChannels[0].noteOff(71);//turn of the note
            mChannels[0].noteOff(74);//turn of the note


        } catch (MidiUnavailableException e) {}
    }

}