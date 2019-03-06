public class Note {

    public int midi_num;
    public String letter;


    Chord[] chords;

    //returns ordered list of possible chords that could be under note (in the octave directly below)
    //inputs: key - midi number for letter key; type - string for major/minor; note - midi number of input note
    public Chord[] get_chords (int key, String type){

        String letter = note_to_String();
        Note k = new Note(); k.midi_num = key; k.note_to_String();

        //just ask for note number in key of note and get chords based on that

        Chord[] c;

        if(k.letter == "c"){ //in the key of c
            if(letter == "c"){

                Chord i = new Chord(); i.key = key-12; i.number = "i";
                Chord vi = new Chord(); vi.key = key-12; vi.number = "vi";
                Chord iv = new Chord(); iv.key = key-12; iv.number = "iv";
                c = new Chord[] {i, vi, iv};

            }
            else if(letter == "e"){

                Chord iii = new Chord(); iii.key = key-12; iii.number = "iii";
                Chord i = new Chord(); i.key = key-12; i.number = "i";
                Chord vi = new Chord(); vi.key = key-12; vi.number = "vi";
                c = new Chord[] {iii, i, vi};

            }
            else if( letter == "g"){
                Chord v = new Chord(); v.key=key-12; v.number="v";
                Chord iii = new Chord(); iii.key=key-12; iii.number="iii";
                Chord i = new Chord(); i.key=key-12; i.number="i";
                c = new Chord[] {v, iii, i};
            }
            else {c = new Chord[] {};}
        }
        else {c = new Chord[] {};}
        chords = c;
        return c;
    }

    public String note_to_String(){

        if((midi_num-21)%12 == 0) {letter = "a"; return "a";}
        else if((midi_num-23)%12 == 0) {letter = "b"; return "b";}
        else if((midi_num-24)%12 == 0) {letter = "c"; return "c";}
        else if((midi_num-26)%12 == 0) {letter = "d"; return "d";}
        else if((midi_num-28)%12 == 0) {letter = "e"; return "e";}
        else if((midi_num-29)%12 == 0) {letter = "f"; return "f";}
        else if((midi_num-31)%12 == 0) {letter = "g"; return "g";}
        else {return "error: note not in key of c";}

    }


    public static void main() {
        Note c = new Note();
        c.midi_num = 66;
        System.out.println(c.note_to_String());
    }
}
