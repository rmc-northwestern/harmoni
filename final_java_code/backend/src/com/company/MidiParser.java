package com.company;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.sound.midi.Track;
import java.util.Vector;
import javax.sound.midi.spi.*;
import java.util.*;

public class MidiParser {
    public int[] get_notes(String path) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer == null) {
                System.err.println("Sequencer device not supported");
                return new int[]{0};
            }


            sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File(path));

            Track[] a = sequence.getTracks();
            Track track1 = a[0];

            int[] x = new int[]{};
            int[] full;

            int i = 0;
            for (int k = 0; k < track1.size(); k++) {
                MidiEvent event = track1.get(k);
                MidiMessage msg = event.getMessage();
                byte[] data = msg.getMessage();
                String s1 = String.format("%8s", Integer.toBinaryString(data[0] & 0xFF)).replace(' ', '0');
                String s2 = "1001";
                if (s1.startsWith(s2)) {
                    System.out.println(k + " is the index of k. The note is: " + +data[1] + "and the velocity is: " + data[2]);

                    full = new int[x.length + 1];
                    System.arraycopy(x, 0, full, 0, x.length);
                    full[full.length - 1] = data[1];


                    x = full;
                    i++;
                }
            }
            System.out.println(x.length);
            return x;

        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
            return new int[]{0};
        }


    }
//    static final int header[] = new int[]
//            {
//                    0x4d, 0x54, 0x68, 0x64, 0x00, 0x00, 0x00, 0x06,
//                    0x00, 0x00,
//                    0x00, 0x01,
//                    0x00, 0x10,
//                    0x4d, 0x54, 0x72, 0x6B
//            };
//
//    static final int keySigEvent[] = new int[]
//            {
//                    0x00, 0xFF, 0x59, 0x02,
//                    0x00,
//                    0x00  //  major key
//            };


    public static void main(String[] args) {
        try {
            Sequence sequence = MidiSystem.getSequence(new File("test_simple.mid"));

            Track[] a = sequence.getTracks();
            Track track1 = a[0];
            Track t = sequence.createTrack();


//            for(int i=0; i<track1.size; i++) {
//                MidiEvent event = track.get(i);
//
//                int status;
//                int eventtype;
//                int metatype;
//                int data1, data2;
//                int length;
//                byte data[] = null;
//                ShortMessage shortMessage = null;
//                MetaMessage  metaMessage  = null;
//                SysexMessage sysexMessage = null;

            //shortMessage = (ShortMessage) event.getMessage();
//
            byte[] b = {(byte)0xF0, 0x7E, 0x7F, 0x09, 0x01, (byte)0xF7};

            SysexMessage sm = new SysexMessage();
            sm.setMessage(b, 6);
            MidiEvent me = new MidiEvent(sm,(long)0);
            t.add(me);

            ShortMessage mm = new ShortMessage();
            mm.setMessage(0xB0, 0x7D,0x00);
            me = new MidiEvent(mm,(long)0);
            t.add(me);

            mm = new ShortMessage();
            mm.setMessage(0x90,0x3C,0x60);
            me = new MidiEvent(mm,(long)1);
            t.add(me);

            mm = new ShortMessage();
            mm.setMessage(0x80,0x3C,0x40);

            //****  note on - middle C  ****
            mm = new ShortMessage();
            mm.setMessage(0x90,0x2B,0x1A);
            me = new MidiEvent(mm,(long)1);
            t.add(me);


            mm = new ShortMessage();
            mm.setMessage(0x80,0x2B,0x1A);
            me = new MidiEvent(mm,(long)121);
            t.add(me);

            me = new MidiEvent(mm,(long)121);
            t.add(me);
            File f = new File("midifile.mid");
            MidiSystem.write(sequence,1,f);
//            System.out.println(track2);

// System. out.println(" COMMIT ADD PROG ");
      /*      try {

                metaEvent = new MidiEvent(getMessage(), startTick);
                getTrack().add(metaEvent);

            } catch (InvalidMidiDataException e) {
                e.printStackTrace();
            }

        }
        */


            int[] x = new int[]{};
            int[] full;

            int i = 0;
            for (int k = 0; k < track1.size(); k++) {
                MidiEvent event = track1.get(k);
                MidiMessage msg = event.getMessage();
                byte[] data = msg.getMessage();
                for (int j=0; j<data.length;j++) {
                    String hex = Integer.toHexString(data[j]);
                    String s1 = String.format("%8s", Integer.toBinaryString(data[j] & 0xFF)).replace(' ', '0');
                    System.out.println(hex);
                }
               /* String s1 = String.format("%8s", Integer.toBinaryString(data[0] & 0xFF)).replace(' ', '0');
                String s2 = "1001";
                if (s1.startsWith(s2)) {
                    System.out.println(k + " is the index of k. The note is: " + +data[1] + "and the velocity is: " + data[2]);

                    full = new int[x.length + 1];
                    System.arraycopy(x, 0, full, 0, x.length);
                    full[full.length - 1] = data[1];
                    x = full;
                    i++;
                }
                */
            }

            // System.out.println(x.length);

        }
        catch (InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
    }
}