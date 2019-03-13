package com.company;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.sound.midi.Track;
import java.util.Vector;
import javax.sound.midi.spi.*;
import java.util.*;

public class ah {
    public static void main(String[] args) {
        try {
            //Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            //if (sequencer == null) {
               // System.err.println("Sequencer device not supported");
                //return;
            //}
            //sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File("test_simple.mid"));

            Track[] a = sequence.getTracks();
            Track track1 = a[0];


            for (int k = 0; k <track1.size(); k++) {
                MidiEvent event = track1.get(k);
                MidiMessage msg = event.getMessage();
                byte[] data = msg.getMessage();
                String s1 = String.format("%8s", Integer.toBinaryString(data[0] & 0xFF)).replace(' ', '0');
                String s2 = "1001";
                if (s1.startsWith(s2)){
                    System.out.println(k + " is the index of k. The note is: " +  + data[1] + " and the velocity is: " + data[2]);
                }
            }

            /* int i = 6;
            MidiEvent event = track1.get(i);

            MidiMessage msg = event.getMessage();
            byte[] data = msg.getMessage();
            //System.out.println(data[data.length - 4]);

            float d = sequence.getDivisionType();
            int r = sequence.getResolution();
            //sequencer.setSequence(sequence); // load it into sequencer
            //sequencer.start();  // start the playback
            //System.out.println("playing!");

            int s = track1.size();
            /*for(int i = 0; i < s; i++) {
                MidiEvent event = track1.get(i);
                MidiMessage msg = event.getMessage();

                //System.out.println(msg.getLength());
                //System.out.println((event.getMessage()).getMessage()[2]);
            }*/


        } catch (InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
        //MidiUnavailableException
    }
}