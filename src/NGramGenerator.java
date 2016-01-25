/**
 * N-Gram Training Model
 */

/**
 *
 * @author Daikaiser
 */
public class NGramGenerator {

    public static String generateAndLearn(String input) {
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
        s += "\nNGrams:\n";
        for (int i = 0; i < expressions.length; i++) {
                try {
                    s += generateNGram(expressions, i - 1, 2);
                    NGDAO.write(generateNGram(expressions, i - 1, 2));
                } catch (Exception e) {
                
                }
                try {
                    s += generateNGram(expressions, i, 2);
                    NGDAO.write(generateNGram(expressions, i, 2));
                } catch (Exception e) {

                }
        }
        return s;
    }

    public static String generateNGram(Expression[] expressions, int startIndex, int countGrams) {
        int noOfTags = 0;
        String s = "";
        for (int i = 0; i < countGrams; i++) {
            try {
                System.out.print(expressions[startIndex + i].postag + " ");
                try {
                    s += expressions[startIndex + i].postag.substring(0, 2) + " ";
                    noOfTags++;
                } catch (Exception e) {
                    s += expressions[startIndex + i].postag + " ";
                    noOfTags++;
                }
            } catch (Exception e) {

            }
        }
        if (noOfTags > 1) {
            return s + "\n";
        }
        return "";
    }
}
