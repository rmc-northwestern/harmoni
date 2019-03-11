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

        for(int i = 0; i < notes.length; i++){
            int note = notes[i];
            Note n = new Note(); n.midi_num = note; n.note_to_String();
            Chord[] chords = n.get_chords(48, "major");
            System.out.println(chords.length);
            int[] first_chord = chords[0].build_chord();
            //System.out.println(first_chord[0]);
            //System.out.println(chords[0].number);
            //System.out.println(chords[0]);
            out[i] = first_chord;
        }
        return out;
    }

    public static void main(String[] args) {
        Main m = new Main();
        int[][] result = m.chords_from_midi();
        //System.out.println(result.length);
        /*MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes();
        int note = notes[0];
        Note n = new Note(); n.midi_num = note; n.note_to_String();
        Chord[] chords = n.get_chords(48, "major");
        int[] first_chord = chords[0].build_chord();
        System.out.println(first_chord[0]);
        System.out.println(first_chord[1]);*/


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
