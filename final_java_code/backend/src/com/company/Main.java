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
    public int[][] chords_from_midi(String path, String note_name){
        MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes(path);

        int[][] out = new int[notes.length][3];

        //figure out here how to choose first chord
        int key = key_from_input(notes, note_name);
        //Chord current = new Chord(); current.number = "i"; current.key = key - 12;
        Note first_note = new Note(); first_note.midi_num = notes[0]; first_note.note_to_String();
        Chord current = new Chord(); current = current.choose_first(first_note, key, "major");
        out[0] = current.build_chord();
        //System.out.println("first chord is " + current.number);

        for(int i = 1; i < notes.length; i++){
            //System.out.println("current chord.number is " + current.number);
            //System.out.println("current chord.key is " + current.key);
            int next_n = notes[i];
            Note next_note = new Note(); next_note.midi_num = next_n; next_note.note_to_String();
            //System.out.println("next note is " + next_note.letter);

            Chord next = current.get_next(next_note, key);

            out[i] = next.build_chord();
            //System.out.println("current chord is " + current.number + " and next note is " + next_note.letter);
            //System.out.println("next chord is " + next.number);

            current = next;
            //System.out.println("next.number is " + next.number);
            //System.out.println("next.key is " + next.key);
            //current = next;
        }
        return out;
    }

    public String array_to_string(int[][] chords){
        String out = "[";
        for(int i = 0; i < chords.length; i++){
            for(int j = 0; j < chords[0].length; j++){
                if(j==0) out += "[";
                out += Integer.toString(chords[i][j]);
                if(j!= 2) out += ",";
                if(j==2) {
                    out += "]";
                    if(i != chords.length -1){
                        out += ",";
                    }
                }
            }
        }
        out += "]";
        return out;
    }


    public void write_to_file(int[][] chords, String path_to_midi){

        String out = "../" + path_to_midi + '\n';
        out += array_to_string(chords);

        BufferedWriter bw = null;
        FileWriter fw = null;
        try {

            String content = out;

            fw = new FileWriter("java_out.txt");
            bw = new BufferedWriter(fw);

            bw.write(content);


            System.out.println(out + " is written to file " + "java_out.txt");

            //bw.write(Arrays.toString(chords));
            //System.out.println("test is " + Arrays.toString(chords));

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

    public int key_from_input(int[] notes, String note_name){
        int min = notes[0];
        int max = notes[0];
        for(int i = 1; i < notes.length; i++){
            if(notes[i] < min){
                min = notes[i];
            }
            else if(notes[i] > max){
                max = notes[i];
            }
        }
        return note_in_range(note_name, min, max);
    }

    public int note_in_range(String note_name, int min, int max){
        int out = 0;
        int subtract = 0;
        if(note_name == "A"){
            subtract = 21;
        }
        else if(note_name == "Bb"){
            subtract = 22;
        }
        else if(note_name == "B"){
            subtract = 23;
        }
        else if(note_name == "C"){
            subtract = 24;
        }
        else if(note_name == "Db"){
            subtract = 25;
        }
        else if(note_name == "D"){
            subtract = 26;
        }
        else if(note_name == "Eb"){
            subtract = 27;
        }
        else if(note_name == "E"){
            subtract = 28;
        }
        else if(note_name == "F"){
            subtract = 29;
        }
        else if(note_name == "Gb"){
            subtract = 30;
        }
        else if(note_name == "G"){
            subtract = 31;
        }
        else { //a flat
            subtract = 32;
        }

        for(int i = min; i <= max; i++){
            if((i - subtract) % 12 == 0){
                out = i;
            }
        }
        if(out == 0){
            int i = min -1;
            while((i - 24) % 12 != 0){
                i--;
            }
            out = i;
        }
        return out;
    }

    /*public void nums_from_midi(String path){
        MidiParser mp = new MidiParser();
        int[] notes = mp.get_notes(path);


        String out = "";

        Chord current = new Chord(); current.number = "i"; current.key = 48;
        //Chord current = new Chord;
        current = current.choose_first(notes[0], )


        for(int i = 0; i < notes.length; i++){
            int note = notes[i];
            Note n = new Note(); n.midi_num = note; n.note_to_String();


            Chord next = current.get_next(n, 48);
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



    }*/



    public static void main(String[] args) {
        //args = new String[]{"deck the halls.mid"};

        Main m = new Main();
        //m.nums_from_midi(args[0]);


        //int[][] test = m.chords_from_midi("deck the halls.mid", "C");
        int[][] test = m.chords_from_midi(args[0], args[1]);
        /*System.out.println(test[0][0] + " " + test[0][1] + " " + test[0][2]);
        System.out.println(test[1][0] + " " + test[1][1] + " " + test[1][2]);
        System.out.println(test[2][0] + " " + test[2][1] + " " + test[2][2]);
        System.out.println(test[3][0] + " " + test[3][1] + " " + test[3][2]);*/

        //System.out.println("array to string is " + m.array_to_string(test));
        m.write_to_file(test, args[0]);
    }
}
