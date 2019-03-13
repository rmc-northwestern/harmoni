package com.company;

import javax.sound.midi.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import javax.sound.midi.Track;
import java.util.Vector;
import javax.sound.midi.spi.*;
import java.util.*;

public class Main {
    public int[][] chords_from_midi(){
        MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes();

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



    public static void main(String[] args) {
        System.out.println("here");
        Main m = new Main();
        int[][] result = m.chords_from_midi();

        /*System.out.println(result[0][0]);
        System.out.println(result[0][1]);
        System.out.println(result[0][2]);*/

        /*System.out.println(result[1][0]);
        System.out.println(result[1][1]);
        System.out.println(result[1][2]);*/

        /*System.out.println(result[2][0]);
        System.out.println(result[2][1]);
        System.out.println(result[2][2]);*/

        System.out.println(result[3][0]);
        System.out.println(result[3][1]);
        System.out.println(result[3][2]);

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
