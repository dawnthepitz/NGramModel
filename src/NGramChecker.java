/**
 * Checks if the words are in the N-Gram Language Model
 */

import javax.swing.JOptionPane;


/**
 *
 * @author Daikaiser
 */
public class NGramChecker {
    public static String check(String input) {
        String s = "";
        String posTaggedInput = POSTagger.tag(input);
        s += posTaggedInput + "\n";
        String[] tokens = posTaggedInput.split(" ");
        Expression[] expressions = new Expression[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            expressions[i] = new Expression(tokens[i].split("_")[0], tokens[i].split("_")[1]);
        }
        for (Expression expression : expressions) {
            System.out.print(expression.postag + " ");
            try {
                s += expression.postag.substring(0, 2) + " ";
            } catch (Exception e) {
                s += expression.postag + " ";
            }
        }
        s+="\nWrongly Used Words:\n";
        NGramParser.parse(expressions);
        for(Expression expression:expressions){
            if(!expression.isInvoked){
                JOptionPane.showMessageDialog(null, "The token \""+expression.word+"\" has incorrect usage, please check your grammar", "Grammatical Error", JOptionPane.ERROR_MESSAGE);
                s+="\n"+expression.word+"\n";
            }
        }
        return s;
    }
}
