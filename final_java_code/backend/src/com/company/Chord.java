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
        if (k.letter == "db") {
            Map<String, int[]> dbmajor = new HashMap<String, int[]>();
            dbmajor.put("i", new int[]{25, 29, 32});
            dbmajor.put("ii", new int[]{27, 30, 34});
            dbmajor.put("iii", new int[]{29, 32, 36});
            dbmajor.put("iv", new int[]{30, 34, 37});
            dbmajor.put("v", new int[]{32, 36, 39});
            dbmajor.put("vi", new int[]{34, 37, 41});
            dbmajor.put("vii", new int[]{24, 27, 30});

            int[] ch = dbmajor.get(number);
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
        else if (k.letter == "eb") {
            Map<String, int[]> ebmajor = new HashMap<String, int[]>();
            ebmajor.put("i", new int[]{27, 31, 34});
            ebmajor.put("ii", new int[]{29, 32, 36});
            ebmajor.put("iii", new int[]{32, 34, 37});
            ebmajor.put("iv", new int[]{32, 36, 39});
            ebmajor.put("v", new int[]{22, 26, 29});
            ebmajor.put("vi", new int[]{24, 27, 30});
            ebmajor.put("vii", new int[]{26, 29, 32});

            int[] ch = ebmajor.get(number);
            return ch;
        }
        else if (k.letter == "e") {
            Map<String, int[]> emajor = new HashMap<String, int[]>();
            emajor.put("i", new int[]{28, 32, 35});
            emajor.put("ii", new int[]{30, 33, 37});
            emajor.put("iii", new int[]{32, 35, 38});
            emajor.put("iv", new int[]{33, 37, 40});
            emajor.put("v", new int[]{23, 27, 30});
            emajor.put("vi", new int[]{25, 28, 31});
            emajor.put("vii", new int[]{27, 30, 33});

            int[] ch = emajor.get(number);
            return ch;
        }
        else if (k.letter == "f") {
            Map<String, int[]> fmajor = new HashMap<String, int[]>();
            fmajor.put("i", new int[]{29, 33, 36});
            fmajor.put("ii", new int[]{31, 34, 38});
            fmajor.put("iii", new int[]{33, 36, 39});
            fmajor.put("iv", new int[]{34, 38, 41});
            fmajor.put("v", new int[]{24, 28, 31});
            fmajor.put("vi", new int[]{26, 29, 32});
            fmajor.put("vii", new int[]{28, 31, 34});

            int[] ch = fmajor.get(number);
            return ch;
        }
        else if (k.letter == "gb") {
            Map<String, int[]> gbmajor = new HashMap<String, int[]>();
            gbmajor.put("i", new int[]{30, 34, 37});
            gbmajor.put("ii", new int[]{32, 35, 39});
            gbmajor.put("iii", new int[]{34, 37, 40});
            gbmajor.put("iv", new int[]{35, 39, 42});
            gbmajor.put("v", new int[]{25, 29, 32});
            gbmajor.put("vi", new int[]{27, 30, 33});
            gbmajor.put("vii", new int[]{29, 32, 35});

            int[] ch = gbmajor.get(number);
            return ch;
        }
        else if (k.letter == "g") {
            Map<String, int[]> gmajor = new HashMap<String, int[]>();
            gmajor.put("i", new int[]{31, 35, 38});
            gmajor.put("ii", new int[]{33, 36, 40});
            gmajor.put("iii", new int[]{35, 38, 41});
            gmajor.put("iv", new int[]{36, 40, 43});
            gmajor.put("v", new int[]{26, 30, 33});
            gmajor.put("vi", new int[]{28, 31, 34});
            gmajor.put("vii", new int[]{30, 33, 36});

            int[] ch = gmajor.get(number);
            return ch;
        }
        else if (k.letter == "ab") {
            Map<String, int[]> abmajor = new HashMap<String, int[]>();
            abmajor.put("i", new int[]{32, 36, 39});
            abmajor.put("ii", new int[]{34, 37, 41});
            abmajor.put("iii", new int[]{36, 39, 42});
            abmajor.put("iv", new int[]{37, 41, 44});
            abmajor.put("v", new int[]{27, 31, 34});
            abmajor.put("vi", new int[]{29, 32, 35});
            abmajor.put("vii", new int[]{31, 34, 37});

            int[] ch = abmajor.get(number);
            return ch;
        }
        else if (k.letter == "a") {
            Map<String, int[]> amajor = new HashMap<String, int[]>();
            amajor.put("i", new int[]{33, 37, 40});
            amajor.put("ii", new int[]{35, 38, 42});
            amajor.put("iii", new int[]{37, 40, 43});
            amajor.put("iv", new int[]{38, 42, 45});
            amajor.put("v", new int[]{28, 32, 35});
            amajor.put("vi", new int[]{30, 33, 36});
            amajor.put("vii", new int[]{32, 35, 38});

            int[] ch = amajor.get(number);
            return ch;
        }
        else if (k.letter == "bb") {
            Map<String, int[]> bbmajor = new HashMap<String, int[]>();
            bbmajor.put("i", new int[]{34, 38, 41});
            bbmajor.put("ii", new int[]{36, 39, 43});
            bbmajor.put("iii", new int[]{38, 41, 44});
            bbmajor.put("iv", new int[]{39, 43, 46});
            bbmajor.put("v", new int[]{29, 33, 36});
            bbmajor.put("vi", new int[]{31, 34, 37});
            bbmajor.put("vii", new int[]{33, 36, 39});

            int[] ch = bbmajor.get(number);
            return ch;
        }
        else if (k.letter == "b") {
            Map<String, int[]> bmajor = new HashMap<String, int[]>();
            bmajor.put("i", new int[]{35, 39, 42});
            bmajor.put("ii", new int[]{37, 40, 44});
            bmajor.put("iii", new int[]{39, 42, 45});
            bmajor.put("iv", new int[]{40, 44, 47});
            bmajor.put("v", new int[]{30, 34, 37});
            bmajor.put("vi", new int[]{32, 35, 38});
            bmajor.put("vii", new int[]{34, 37, 40});

            int[] ch = bmajor.get(number);
            return ch;
        }
        else{return new int[]{0};}
    }



    public static void main(String[] args) {
    }
}