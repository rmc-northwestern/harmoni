package com.company;

public class Note {

    public int midi_num;
    public String letter;
    //public boolean first_note = false;


    Chord[] chords;

    //returns ordered list of possible chords that could be under note (in the octave directly below)
    //inputs: key - midi number for letter key; type - string for major/minor; note - midi number of input note
    public Chord[] get_chords (int key, String type){

        String letter = note_to_String();
        Note k = new Note(); k.midi_num = key; k.note_to_String();



        Chord[] c;
        Chord i = new Chord(); i.key = key-12; i.number = "i";
        Chord ii = new Chord(); ii.key = key-12; ii.number = "ii";
        Chord iii = new Chord(); iii.key = key-12; iii.number = "iii";
        Chord iv = new Chord(); iv.key = key-12; iv.number = "iv";
        Chord v = new Chord(); v.key = key-12; v.number = "v";
        Chord vi = new Chord(); vi.key = key-12; vi.number = "vi";
        Chord vii = new Chord(); vii.key = key-12; vii.number = "vii";


        //just ask for note number in key of note and get chords based on that
        if(k.letter == "c"){ //in the key of c

            if(letter == "c"){

                c = new Chord[] {i, vi, iv};

            }
            else if(letter == "d"){

                c = new Chord[] {ii, v, vii};
            }
            else if(letter == "e"){

                c = new Chord[] {iii, i, vi};

            }
            else if(letter == "f"){

                c = new Chord[] {ii, iv, vii};
            }
            else if( letter == "g"){

                c = new Chord[] {v, iii, i};
            }
            else if(letter == "a"){

                c = new Chord[] {ii, iv, vi};
            }
            else {
                //letter == "b" -- no accidentals

                c = new Chord[] {vii, iii, v};
            }
        }

        else if (k. letter == "d") {
            if(letter == "d") {c = new Chord[] {i, vi, iv};}
            else if(letter == "e") {c = new Chord[] {ii, v, vii};}
            else if(letter == "f") {c = new Chord[] {iii, i, vi};}
            else if(letter == "g") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "a") {c = new Chord[] {v, iii, i};}
            else if(letter == "b") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}} //letter was "c" -- no accidentals
        //else {c = new Chord[] {};}

        else if(k.letter == "e"){
            if(letter == "e") {c = new Chord[]{i, vi, iv};}
            else if(letter == "f") {c = new Chord[] {ii, v, vii};}
            else if(letter == "g") {c = new Chord[] {iii, i, vi};}
            else if(letter == "a") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "b") {c = new Chord[] {v, iii, i};}
            else if(letter == "c") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}
            }

        else if(k.letter == "f"){
            if(letter == "f") {c = new Chord[]{i, vi, iv};}
            else if(letter == "g") {c = new Chord[] {ii, v, vii};}
            else if(letter == "a") {c = new Chord[] {iii, i, vi};}
            else if(letter == "b") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "c") {c = new Chord[] {v, iii, i};}
            else if(letter == "d") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}
        }

        else if(k.letter == "g"){
            if(letter == "g") {c = new Chord[]{i, vi, iv};}
            else if(letter == "a") {c = new Chord[] {ii, v, vii};}
            else if(letter == "b") {c = new Chord[] {iii, i, vi};}
            else if(letter == "c") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "d") {c = new Chord[] {v, iii, i};}
            else if(letter == "e") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}
        }

        else if(k.letter == "a"){
            if(letter == "a") {c = new Chord[]{i, vi, iv};}
            else if(letter == "b") {c = new Chord[] {ii, v, vii};}
            else if(letter == "c") {c = new Chord[] {iii, i, vi};}
            else if(letter == "d") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "e") {c = new Chord[] {v, iii, i};}
            else if(letter == "f") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}
        }

        else if(k.letter == "b"){
            if(letter == "b") {c = new Chord[]{i, vi, iv};}
            else if(letter == "c") {c = new Chord[] {ii, v, vii};}
            else if(letter == "d") {c = new Chord[] {iii, i, vi};}
            else if(letter == "e") {c = new Chord[] {ii, iv, vii};}
            else if(letter == "f") {c = new Chord[] {v, iii, i};}
            else if(letter == "g") {c = new Chord[] {ii, iv, vi};}
            else {c = new Chord[] {ii, v, vii};}
        }

        else{c = new Chord[]{};} //black key

        chords = c;
        return c;
    }

    public String note_to_String(){

        if((midi_num-21)%12 == 0) {letter = "a"; return "a";}
        else if((midi_num-22)%12 == 0) {letter = "bb"; return "bb";}
        else if((midi_num-23)%12 == 0) {letter = "b"; return "b";}
        else if((midi_num-24)%12 == 0) {letter = "c"; return "c";}
        else if((midi_num-25)%12 == 0) {letter = "db"; return "db";}
        else if((midi_num-26)%12 == 0) {letter = "d"; return "d";}
        else if((midi_num-27)%12 == 0) {letter = "eb"; return "eb";}
        else if((midi_num-28)%12 == 0) {letter = "e"; return "e";}
        else if((midi_num-29)%12 == 0) {letter = "f"; return "f";}
        else if((midi_num-30)%12 == 0) {letter = "gb"; return "gb";}
        else if((midi_num-31)%12 == 0) {letter = "g"; return "g";}
        else {letter = "ab"; return "ab";}

    }


    public static void main(String[] args) {

    }
}