/**
 * Contains Models used For N-Gram Language Modeling
 */

import java.util.LinkedList;

/**
 *
 * @author Daikaiser
 */

class Expression {

    public String word;
    public String postag;
    public boolean isInvoked=false;

    public Expression(String word, String postag) {
        this.word = word;
        this.postag = postag;
    }
}

class WordList extends LinkedList<String> {

    @Override
    public boolean contains(Object obj) {
        for (String word : this) {
            if (obj instanceof String) {
                if (word.equals((String) obj)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean contains(String s) {
        for (String word : this) {
            if (word.equals(s)) {
                return true;
            }
        }
        return false;
    }
    
    public WordList sort(){
        WordList sortedList=new WordList();
        int maxLen=0;
        for(String word:this){
            if(word.length()>maxLen){
                maxLen=word.length();
            }
        }
        for(int i=maxLen;i>=0;i--){
            for(String word:this){
                if(word.length()==i){
                    sortedList.add(word);;
                }
            }
        }
        return sortedList;
    }
}

public class Models {

}
