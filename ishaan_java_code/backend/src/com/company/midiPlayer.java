package com.company;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.sound.midi.Track;
import java.util.Vector;
import javax.sound.midi.spi.MidiFileReader;


public class midiPlayer {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer==null) {
                System.err.println("Sequencer device not supported");
                return;
            }
            sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File("jingle_bells.mid"));
            sequencer.setSequence(sequence); // load it into sequencer
            sequencer.start();  // start the playback
            System.out.println("playing!");

        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
