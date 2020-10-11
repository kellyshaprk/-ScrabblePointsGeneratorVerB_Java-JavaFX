package scrabble_b;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Scrabble_B_Controller {
    ArrayList<String> newWordList = new ArrayList<String>();
    String newWordDisplay = "";
    int getPoints = 0;
    int letterChk = 0;

    Boolean disableAlpahbet = true;

    Map<String, Integer> mapLetterBag = new HashMap<String, Integer>(){
        {
            put("A", 9); put("B", 2); put("C", 2); put("D", 4); put("E", 12); put("F", 2);
            put("G", 3); put("H", 2); put("I", 8); put("J", 1); put("K", 1); put("L", 4);
            put("M", 2); put("N", 6); put("O", 8); put("P", 2); put("Q", 1); put("R", 6);
            put("S", 4); put("T", 6); put("U", 4); put("V", 2); put("W", 2); put("X", 1);
            put("Y", 2); put("Z", 1);
        }
    };
    Set<String> keySetLetterBag = mapLetterBag.keySet();

    @FXML
    TextField newWord;

    @FXML
    TextArea preWords;

    @FXML
    Label lblPoint, errMsg, lblA, lblB, lblC, lblD, lblE, lblF, lblG, lblH, lblI, lblJ, lblK, lblL, lblM, lblN, lblO, lblP, lblQ, lblR, lblS, lblT, lblU, lblV, lblW, lblX, lblY, lblZ;

    @FXML
    Button A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z, submit;


    @FXML
    public void onSubmit (ActionEvent event) {
        String valueNewWord = newWord.getText().toUpperCase();
        Scrabble_B_Model scrabble_b_model = new Scrabble_B_Model(valueNewWord);

        try {
            // validate user's word
            scrabble_b_model.validWord();

            // check if user's word has more word than available count
                // step 1
            scrabble_b_model.tempArray();
                // step 2
                // if (user's word count> available count) => error
            for(String c : scrabble_b_model.keySetNewWord) {
                for (String k : keySetLetterBag) {
                    if (c.equals(k) && scrabble_b_model.mapNewWord.get(c) > mapLetterBag.get(k)) {
                        disableAlpahbet = false;
                        newWord.setText("");
                        newWord.requestFocus();

                        throw new IllegalArgumentException(
                                String.format("Word contains letter that is no longer available “in bag”: %s\r\n%s - %d left"
                                        , valueNewWord, k, mapLetterBag.get(k))
                        );
                    }
                }
            }

            if (disableAlpahbet) {
                // check if user's word has already existed
                if (newWordList.contains(valueNewWord)) {
                    throw new IllegalArgumentException(
                            String.format("Word was already entered: %s", valueNewWord)
                    );
                }
                else {
                    // if the word is the first one
                    if (newWordList.size() == 0) {
                        newWordDisplay = newWord.getText().toUpperCase();
                    }
                    // if previous words list has at least one word,
                        // previous world + ", " + new word
                    else {
                        newWordDisplay = newWordDisplay + ", " + newWord.getText().toUpperCase();
                    }

                    newWordList.add(newWord.getText().toUpperCase());

                    // display all words
                    preWords.setText(newWordDisplay);
                    // initialize text field for typing a new word
                    newWord.setText("");
                    newWord.requestFocus();

                    // based on point system and user's word, calculate points and display
                    getPoints += scrabble_b_model.calWord();
                    lblPoint.setText(String.valueOf(getPoints));

                    // disappear err message
                    errMsg.setText("");

                    // if all letters in bag are used, the letter button is disabled
                    for (int i = 0; i < valueNewWord.length(); i++) {
                        for (String k : keySetLetterBag) {
                            if(String.valueOf(valueNewWord.charAt(i)).equals(k)){
                                int p = mapLetterBag.get(k) - 1;
                                mapLetterBag.put(k, p);

                                System.out.println(valueNewWord.charAt(i) + ":" + mapLetterBag.get(k));

                                if (mapLetterBag.get(k)== 0) {
                                    switch (valueNewWord.charAt(i)){
                                        case 'A':
                                            A.setDisable(true);
                                            lblA.setVisible(false);
                                            break;
                                        case 'B':
                                            B.setDisable(true);
                                            lblB.setVisible(false);
                                            break;
                                        case 'C':
                                            C.setDisable(true);
                                            lblC.setVisible(false);
                                            break;
                                        case 'D':
                                            D.setDisable(true);
                                            lblD.setVisible(false);
                                            break;
                                        case 'E':
                                            E.setDisable(true);
                                            lblE.setVisible(false);
                                            break;
                                        case 'F':
                                            F.setDisable(true);
                                            lblF.setVisible(false);
                                            break;
                                        case 'G':
                                            G.setDisable(true);
                                            lblG.setVisible(false);
                                            break;
                                        case 'H':
                                            H.setDisable(true);
                                            lblH.setVisible(false);
                                            break;
                                        case 'I':
                                            I.setDisable(true);
                                            lblI.setVisible(false);
                                            break;
                                        case 'J':
                                            J.setDisable(true);
                                            lblJ.setVisible(false);
                                            break;
                                        case 'K':
                                            K.setDisable(true);
                                            lblK.setVisible(false);
                                            break;
                                        case 'L':
                                            L.setDisable(true);
                                            lblL.setVisible(false);
                                            break;
                                        case 'M':
                                            M.setDisable(true);
                                            lblM.setVisible(false);
                                            break;
                                        case 'N':
                                            N.setDisable(true);
                                            lblN.setVisible(false);
                                            break;
                                        case 'O':
                                            O.setDisable(true);
                                            lblO.setVisible(false);
                                            break;
                                        case 'P':
                                            P.setDisable(true);
                                            lblP.setVisible(false);
                                            break;
                                        case 'Q':
                                            Q.setDisable(true);
                                            lblQ.setVisible(false);
                                            break;
                                        case 'R':
                                            R.setDisable(true);
                                            lblR.setVisible(false);
                                            break;
                                        case 'S':
                                            S.setDisable(true);
                                            lblS.setVisible(false);
                                            break;
                                        case 'T':
                                            T.setDisable(true);
                                            lblT.setVisible(false);
                                            break;
                                        case 'U':
                                            U.setDisable(true);
                                            lblU.setVisible(false);
                                            break;
                                        case 'V':
                                            V.setDisable(true);
                                            lblV.setVisible(false);
                                            break;
                                        case 'W':
                                            W.setDisable(true);
                                            lblW.setVisible(false);
                                            break;
                                        case 'X':
                                            X.setDisable(true);
                                            lblX.setVisible(false);
                                            break;
                                        case 'Y':
                                            Y.setDisable(true);
                                            lblY.setVisible(false);
                                            break;
                                        case 'Z':
                                            Z.setDisable(true);
                                            lblZ.setVisible(false);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            // the game will be over
            // if (1) there is only one letter left
            //    (2) there is/are only consonant(s) left
            for (String c : keySetLetterBag) {
                letterChk += mapLetterBag.get(c);

                if (mapLetterBag.get("A") == 0 && mapLetterBag.get("E") == 0
                    && mapLetterBag.get("I") == 0 && mapLetterBag.get("O") == 0
                    && mapLetterBag.get("U") == 0 && mapLetterBag.get("Y") == 0)
                {
                    letterChk = 1;
                }
            }

            if (letterChk == 1) {
                errMsg.setText("Game Over");
                submit.setDisable(true);
                newWord.setDisable(true);
            }
        }
        catch(IllegalArgumentException e) {
            errMsg.setText(e.getMessage());
            newWord.setText("");
            newWord.requestFocus();
        }

        disableAlpahbet = true;
        letterChk = 0;
    }

    @FXML
    public void btnA (ActionEvent event) {
        newWord.setText(newWord.getText() + "A");
    }
    @FXML
    public void btnB (ActionEvent event) {
        newWord.setText(newWord.getText() + "B");
    }
    @FXML
    public void btnC (ActionEvent event) {
        newWord.setText(newWord.getText() + "C");
    }
    @FXML
    public void btnD (ActionEvent event) {
        newWord.setText(newWord.getText() + "D");
    }
    @FXML
    public void btnE (ActionEvent event) {
        newWord.setText(newWord.getText() + "E");
    }
    @FXML
    public void btnF (ActionEvent event) {
        newWord.setText(newWord.getText() + "F");
    }
    @FXML
    public void btnG (ActionEvent event) {
        newWord.setText(newWord.getText() + "G");
    }
    @FXML
    public void btnH (ActionEvent event) {
        newWord.setText(newWord.getText() + "H");
    }
    @FXML
    public void btnI (ActionEvent event) {
        newWord.setText(newWord.getText() + "I");
    }
    @FXML
    public void btnJ (ActionEvent event) {
        newWord.setText(newWord.getText() + "J");
    }
    @FXML
    public void btnK (ActionEvent event) {
        newWord.setText(newWord.getText() + "K");
    }
    @FXML
    public void btnL (ActionEvent event) {
        newWord.setText(newWord.getText() + "L");
    }
    @FXML
    public void btnM (ActionEvent event) {
        newWord.setText(newWord.getText() + "M");
    }
    @FXML
    public void btnN (ActionEvent event) {
        newWord.setText(newWord.getText() + "N");
    }
    @FXML
    public void btnO (ActionEvent event) {
        newWord.setText(newWord.getText() + "O");
    }
    @FXML
    public void btnP (ActionEvent event) {
        newWord.setText(newWord.getText() + "P");
    }
    @FXML
    public void btnQ (ActionEvent event) {
        newWord.setText(newWord.getText() + "Q");
    }
    @FXML
    public void btnR (ActionEvent event) {
        newWord.setText(newWord.getText() + "R");
    }
    @FXML
    public void btnS (ActionEvent event) {
        newWord.setText(newWord.getText() + "S");
    }
    @FXML
    public void btnT (ActionEvent event) {
        newWord.setText(newWord.getText() + "T");
    }
    @FXML
    public void btnU (ActionEvent event) {
        newWord.setText(newWord.getText() + "U");
    }
    @FXML
    public void btnV (ActionEvent event) {
        newWord.setText(newWord.getText() + "V");
    }
    @FXML
    public void btnW (ActionEvent event) {
        newWord.setText(newWord.getText() + "W");
    }
    @FXML
    public void btnX (ActionEvent event) {
        newWord.setText(newWord.getText() + "X");
    }
    @FXML
    public void btnY (ActionEvent event) {
        newWord.setText(newWord.getText() + "Y");
    }
    @FXML
    public void btnZ (ActionEvent event) {
        newWord.setText(newWord.getText() + "Z");
    }
}
