package com.company;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.sound.midi.Track;
import java.util.Vector;
import javax.sound.midi.spi.*;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public int[][] chords_from_midi(String path){
        MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes(path);

        int[][] out = new int[notes.length][3];

        Chord current = new Chord(); current.number = "i"; current.key = 60;
        for(int i = 0; i < notes.length; i++){
            int note = notes[i];
            Note n = new Note(); n.midi_num = note; n.note_to_String();
            System.out.println(n.letter);

            out[i] = current.build_chord();

            Chord next = current.get_next(n, 60);
            current = next;
        }
        return out;
    }

    public void nums_from_midi(String path){
        MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes(path);


        String out = "";

        Chord current = new Chord(); current.number = "i"; current.key = 60;
        for(int i = 0; i < notes.length; i++){
            int note = notes[i];
            Note n = new Note(); n.midi_num = note; n.note_to_String();


            Chord next = current.get_next(n, 60);
            out = out + next.number + " ";
            current = next;
        }


        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String content = out;

            fw = new FileWriter("result.txt");
            bw = new BufferedWriter(fw);
            bw.write(content);

            System.out.println(out + " is written to file " + "result.txt");

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null)
                    bw.close();

                if (fw != null)
                    fw.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }



    }



    public static void main(String[] args) {
        args = new String[]{"test_simple.mid"};

        Main m = new Main();
        m.nums_from_midi(args[0]);

        /*System.out.println(result[0][0]);
        System.out.println(result[0][1]);
        System.out.println(result[0][2]);*/

        /*System.out.println(result[1][0]);
        System.out.println(result[1][1]);
        System.out.println(result[1][2]);*/

        /*System.out.println(result[2][0]);
        System.out.println(result[2][1]);
        System.out.println(result[2][2]);*/

        /*System.out.println(result[3][0]);
        System.out.println(result[3][1]);
        System.out.println(result[3][2]);*/

        Note c = new Note();
        c.midi_num = 60;
        //System.out.println(c.get_chords(60, "major")[1].number);

        /*Chord ch = new Chord();
        ch.number = "i";
        ch.key = 66;

        Note e = new Note();
        e.midi_num = 64;

        System.out.println(e.get_chords(60, "major")[0].number);*/
        /*c.note_to_String();
        System.out.println(c.letter);

        Chord[] test = c.get_chords(60, "major");
        System.out.println(test[0].number);
        System.out.println(test[1].number);
        System.out.println(test[2].number);

        Chord i = test[0];
        Chord vi = test[1];
        Chord iv = test[2];

        System.out.println(i.build_chord()[0]);
        System.out.println(vi.build_chord()[0]);
        System.out.println(iv.build_chord()[0]);*/


    }
}
