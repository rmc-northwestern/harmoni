package com.company;

import javax.sound.midi.*;

public class soundTest{

    public static void main(String[] args) {
        try {

            Synthesizer midiSynth = MidiSystem.getSynthesizer();
            midiSynth.open();
            Instrument[] instr = midiSynth.getDefaultSoundbank().getInstruments();
            MidiChannel[] mChannels = midiSynth.getChannels();
            midiSynth.loadInstrument(instr[0]);

            Main m = new Main();
            int[][] result = m.chords_from_midi();
            for(int x = 0; x < result.length; x++){
                for(int y = 0; y < 3; y++){
                    result[x][y] += 48;
                }
            }

            for (int i = 0; i < result.length; i++) {
                int one = 0;
                int three = 0;
                int five = 0;
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        one = result[i][j];
                    } else if (j == 1) {
                        three = result[i][j];
                    } else {
                        five = result[i][j];
                    }

                    mChannels[0].noteOn(result[i][j], 100);// Note C note 1
                    mChannels[0].noteOn(result[i][j], 100); // Note E note 3
                    mChannels[0].noteOn(result[i][j], 100); // Note G note 5
                }
                try {
                    Thread.sleep(1000); // wait time in milliseconds to control duration
                } catch (InterruptedException e) {}

                mChannels[0].noteOff(one);//turn of the note
                mChannels[0].noteOff(three);//turn of the note
                mChannels[0].noteOff(five);//turn of the note
            }
            midiSynth.close();
        }
        catch (MidiUnavailableException e) {}









           /* try { Thread.sleep(1000); // wait time in milliseconds to control duration
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


        } */
    }

}