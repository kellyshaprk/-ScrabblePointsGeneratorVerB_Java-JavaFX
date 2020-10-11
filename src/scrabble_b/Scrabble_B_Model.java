package scrabble_b;
import java.util.*;

public class Scrabble_B_Model {
    int point = 0;
    String newWord;

    Map<String, Integer> mapPoint = new HashMap<String, Integer>() {
        {
           put("A", 1); put("B", 3); put("C", 3); put("D", 2); put("E", 1); put("F", 4);
           put("G", 2); put("H", 4); put("I", 1); put("J", 8); put("K", 5); put("L", 1);
           put("M", 3); put("N", 1); put("O", 1); put("P", 3); put("Q", 10); put("R", 1);
           put("S", 1); put("T", 1); put("U", 1); put("V", 4); put("W", 4); put("X", 8);
           put("Y", 4); put("Z", 10);
        }
    };
    Set<String> keySetPoint = mapPoint.keySet();

    Map<String, Integer> mapNewWord = new HashMap<String, Integer>(){
        {
           put("A", 0); put("B", 0); put("C", 0); put("D", 0); put("E", 0); put("F", 0);
           put("G", 0); put("H", 0); put("I", 0); put("J", 0); put("K", 0); put("L", 0);
           put("M", 0); put("N", 0); put("O", 0); put("P", 0); put("Q", 0); put("R", 0);
           put("S", 0); put("T", 0); put("U", 0); put("V", 0); put("W", 0); put("X", 0);
           put("Y", 0); put("Z", 0);
        }
    };
    Set<String> keySetNewWord = mapNewWord.keySet();

    public Scrabble_B_Model (String newWord) {
        this.newWord = newWord.toUpperCase();
    }

    // word restrictions
    public boolean validWord() throws IllegalArgumentException {
        if (newWord.length() == 0) {
            throw new IllegalArgumentException(
                    String.format("Word is blank")
            );
        }
        else if (newWord.length() == 1) {
            throw new IllegalArgumentException(
                    String.format("Word is too short: %s", newWord)
            );
        }
        else if (newWord.length() > 8) {
            throw new IllegalArgumentException(
                    String.format("Word is too long (more than 8 characters): %s", newWord)
            );
        }
        else if (newWord.indexOf("A") == -1 && newWord.indexOf("E") == -1 && newWord.indexOf("I") == -1
                && newWord.indexOf("O") == -1 && newWord.indexOf("U") == -1  && newWord.indexOf("Y") == -1 ) {
            throw new IllegalArgumentException(
                    String.format("Word does not include vowel: %s", newWord)
            );
        }

        return true;
    }

    // function for calculating points
    public int calWord() {
        for(int i = 0; i < newWord.length(); i++) {
            for (String c : keySetPoint) {
                if(String.valueOf(newWord.charAt(i)).equals(c)) {
                    point += mapPoint.get(c);
                }
            }
        }

        return point;
    }

    // function for checking if user's word has more word than available count
    public void tempArray() {
        for (int i = 0; i < newWord.length(); i++) {
            for (String c : keySetNewWord) {
                if(String.valueOf(newWord.charAt(i)).equals(c)) {
                    int p = mapNewWord.get(c) + 1;
                    mapNewWord.put(c, p);
                }
            }
        }
    }
}
