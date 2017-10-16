package Objects;

/**
 * Created by EoinH on 10/06/2017.
 */
public class Transfer {
    private int vote;
    private int canID;
    private double percentage;
    Transfer(int vote, int canID){
        this.vote = vote;
        this.canID = canID;
    }
    Transfer(int vote, int canID, double percentage){
        this.vote = vote;
        this.canID = canID;
        this.percentage = percentage;
    }

    public int getVote(){
        return vote;
    }
    public int getCanID(){
        return canID;
    }
    public double getPercentage(){
        return percentage;
    }
}