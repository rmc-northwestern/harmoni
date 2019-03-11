package com.company;

import java.util.*;

public class Chord {
    public String number;
    public int key;

    //returns a 3-element int array with midi numbers for 1 3 and 5 of chord
    public int[] build_chord() {

        Note k = new Note();
        k.midi_num = key;
        k.note_to_String();

        if (k.letter == "c") {
            Map<String, int[]> cmajor = new HashMap<String, int[]>();
            cmajor.put("i", new int[]{24, 28, 31});
            cmajor.put("ii", new int[]{26, 29, 33});
            cmajor.put("iii", new int[]{28, 31, 35});
            cmajor.put("iv", new int[]{29, 33, 36});
            cmajor.put("v", new int[]{31, 35, 38});
            cmajor.put("vi", new int[]{33, 36, 40});
            cmajor.put("vii", new int[]{23, 26, 29});

            int[] ch = cmajor.get(number);
            return ch;
        }
        else if (k.letter == "d") {
            Map<String, int[]> dmajor = new HashMap<String, int[]>();
            dmajor.put("i", new int[]{26, 30, 33});
            dmajor.put("ii", new int[]{28, 31, 35});
            dmajor.put("iii", new int[]{30, 33, 36});
            dmajor.put("iv", new int[]{31, 35, 38});
            dmajor.put("v", new int[]{21, 25, 28});
            dmajor.put("vi", new int[]{23, 26, 29});
            dmajor.put("vii", new int[]{25, 28, 31});

            int[] ch = dmajor.get(number);
            return ch;
        }
        else{return new int[]{0};}
    }



    public static void main(String[] args) {
    }
}
