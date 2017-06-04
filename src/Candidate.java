import java.util.List;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Candidate {
    String name;
    boolean elected;
    //private List<int> votes2016;
    Candidate(String name){
        this.name = name;
        elected = false;
    }
    public String getName(){
        return name;
    }
    public boolean isElected (){
        return elected;
    }

}
