package com.company;

import java.io.*;
import java.util.*;
import javax.sound.midi.*; // package for all midi classes

public class WriteMidi {
    public static void main(String argv[]) {
        System.out.println("midifile begin ");
        try {
            Sequence sequence = MidiSystem.getSequence(new File("test_simple.mid"));

            Track[] a = sequence.getTracks();
            Track track1 = a[0];
            Track [] t_arr = new Track[3];
            Track one = a[0];
            Track three = a[0];
            Track five = a[0];
            t_arr[0] = one;
            t_arr[1] = three;
            t_arr[2] = five;

            for (int i =0; i<t_arr.length;i++) {
                for (int k = 0; k < t_arr[i].size(); k++) {
                    MidiEvent event = track1.get(k);
                    MidiMessage msg = event.getMessage();
                    byte[] data = msg.getMessage();
                    for (int j = 0; j < data.length; j++) {
                        String s1 = String.format("%8s", Integer.toBinaryString(data[j] & 0xFF)).replace(' ', '0');
                        String s2 = "1001";
                        String s3 = "1000";
                        if (s1.startsWith(s2)) {
                            data[j] = 60;
                            System.out.println(k + " is the index of k. The note is: " + +data[1] + "and the velocity is: " + data[2]);

                        }
                        if (s1.startsWith(s3)) {
                            data[j] = 60;
                        }

                    }
                    sequence.createTrack().add(event);
                }
            }


                    File f = new File("midifiler.mid");

                    MidiSystem.write(sequence, 1, f);
        }
        catch(InvalidMidiDataException | IOException ex){
                ex.printStackTrace();
            }


        System.out.println("midifile end ");
    } //main
} //midifile




