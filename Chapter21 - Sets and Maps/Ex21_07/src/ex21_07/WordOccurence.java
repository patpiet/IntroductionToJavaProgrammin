package ex21_07;

/**
 *
 * @author patpiet
 */
public class WordOccurence implements Comparable<WordOccurence>{
    private String word;
    private int count;
    
    public WordOccurence(String word){
        this.word = word;
        this.count = 1;
    }
    
    public String getWord(){
        return word;
    }
    
    public int getCounter(){
       return count; 
    }
    
    public void increaseCount(){
        count++;
    }
    
    @Override
    public int compareTo(WordOccurence t) {
        if(count > t.count){
            return 1;
        }else if (count == t.count){
            return 0;
        }else{
            return -1;
        }
        
    }
    
}
