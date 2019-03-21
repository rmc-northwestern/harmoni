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
            // Track [] t_arr = new Track[3];
            // Track one = a[0];
            // Track three = a[0];
            // Track five = a[0];
            // t_arr[0] = one;
            // t_arr[1] = three;
            // t_arr[2] = five;

              for (int i = 0; i<track1.size(); i++){
                  MidiEvent event = track1.get(i);
                  MidiMessage msg = event.getMessage();
                  byte[] data = msg.getMessage();
                  String s1 = String.format("%8s", Integer.toBinaryString(data[0] & 0xFF)).replace(' ', '0');
                  String s2 = "1001";
                  String s3 = "1000";
                  if (s1.startsWith(s2)) {
                      data[1] = 59;
                      System.out.println(k + " is the index of k. The note is: " + +data[1] + "and the velocity is: " + data[2]);

                  }
                  if (s1.startsWith(s3)) {
                      data[1] = 59;
                  }
                  sequence.track1.add(event);
              }
            // }


                    File f = new File("midifiler.mid");

                    MidiSystem.write(sequence, 1, f);
        }
        catch(InvalidMidiDataException | IOException ex){
                ex.printStackTrace();
            }


        System.out.println("midifile end ");
    } //main
} //midifile
