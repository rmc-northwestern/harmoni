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

    public Chord get_next(Note note, int key) {

        Map<String, double[]> progression = new HashMap<String, double[]>();
        /*progression.put("i", new double[]{0,.13,0,.15,.62,.05,.05});
        progression.put("ii", new double[]{.49,0,.01,0,.40,.01,.09});
        progression.put("iii", new double[]{.67,0,0,0,0,.33,0});
        progression.put("iv", new double[]{.64,.14,0,0,.15,0,.07});
        progression.put("v", new double[]{.94,0,0,.01,0,.04,.01});
        progression.put("vi", new double[]{.11,.51,0,.14,.20,0,.04});
        progression.put("vii", new double[]{.82,0,.01,.01,.16,0,0});*/

        progression.put("i", new double[]{.5, 0, 0, .15, .35, 0, 0});
        progression.put("ii", new double[]{.2, .5, 0, 0, .3, 0, 0});
        progression.put("iii", new double[]{.4, 0, .5, 0, 0, .1, 0});
        progression.put("iv", new double[]{.2, .1, 0, .5, .2, 0, 0});
        progression.put("v", new double[]{.4, 0, 0, .01, .5, 0, .0});
        progression.put("vi", new double[]{0, .3, 0, 0, .2, .5, 0});
        progression.put("vii", new double[]{.8, 0, 0, 0, .2, 0, 0});

        String num = number;
        double[] probs = progression.get(num);
        Chord[] options = note.get_chords(60, "major");
        //System.out.println("options " + options[0].number + " " + options[1].number + " " + options[2].number);

        //generate "random" based on probabilities
        Random rand = new Random();
        int r = rand.nextInt(100) + 1;
        //System.out.println(r);

        int next = -1;

        int[] int_options = new int[options.length];

        //index of chord in progression array
        for(int j = 0; j < options.length; j++){
            if(options[j].number == "i"){
                int_options[j] = 0;
            }
            else if(options[j].number == "ii"){
                int_options[j] = 1;
            }
            else if(options[j].number == "iii"){
                int_options[j] = 2;
            }
            else if(options[j].number == "iv"){
                int_options[j] = 3;
            }
            else if(options[j].number == "v"){
                int_options[j] = 4;
            }
            else if(options[j].number == "vi"){
                int_options[j] = 5;
            }
            else if(options[j].number == "vii"){
                int_options[j] = 6;
            }
        }
        //System.out.println("int_options " + int_options[0] + " " + int_options[1] + " " + int_options[2]);

        double[] options_probs = new double[int_options.length];
        int max_idx = -1;
        double max = -1;
        for(int i = 0; i < int_options.length; i++){
            options_probs[i] = probs[int_options[i]];
            if(options_probs[i] > max){
                max = options_probs[i];
                max_idx = int_options[i];
            }
        }
        /*System.out.println("options_probs " + options_probs[0] + " " + options_probs[1] + " " + options_probs[2]);
        System.out.println("max " + max);
        System.out.println("man_idx" + max_idx);*/
        next = max_idx;



        Chord next_chord = new Chord();
        if (next == 0) {
            next_chord.number = "i";
        } else if (next == 1) {
            next_chord.number = "ii";
        } else if (next == 2) {
            next_chord.number = "iii";
        } else if (next == 3) {
            next_chord.number = "iv";
        } else if (next == 4) {
            next_chord.number = "v";
        } else if (next == 5) {
            next_chord.number = "vi";
        } else if (next == 6) {
            next_chord.number = "vii";
        }

        next_chord.key = key;

        return next_chord;
    }



    public static void main(String[] args) {
        Chord f = new Chord();
        f.number = "iv";
        f.key = 60;

        Note g = new Note();
        g.letter = "g";
        g.midi_num = 67;

        Chord next = f.get_next(g, 60);
        System.out.println("next number " + next.number);
    }
}