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
            cmajor.put("i", new int[]{60, 64, 67});
            cmajor.put("iii", new int[]{64, 67, 71});
            cmajor.put("iv", new int[]{65, 69, 72});
            cmajor.put("v", new int[]{67, 71, 74});
            cmajor.put("vi", new int[]{69, 72, 76});

            int[] ch = cmajor.get(number);
            return ch;
        } else {
            return new int[]{0};
        }
    }



    public static void main() {
    }
}
