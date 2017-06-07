/**
 * Created by EoinH on 05/06/2017.
 */
public class Round {
    int number;
    int rid;
    int eid;
    int conid;
    int canid;
    String candidate;
    String constituency;
    boolean elected;
    int votes;

    Round(int rid, int eid, String constituency, String candidate,boolean elected,int number,int votes){
        this.number = number;
        this.rid = rid;
        this.eid = eid;
        this.candidate =candidate;
        this.elected = elected;
        this.constituency =constituency;
        this.votes = votes;
    }
    public void setConid (String constituencies[], String candidates[]){
        int id =0;
        boolean found = false;
        for (int i =0;i < constituencies.length && !found;i++) {
            if (constituency.equals(constituencies[i])) {
                found = true;
                id = i;
            }
            System.out.println(constituency + " Eqauls " + constituencies[i] + " : " + found);
        }
        conid = id;
        System.out.println(conid);
    }

    public void setCanid(String [] candidates){
        int id =0;
        boolean found = false;
        for (int i =0;i < candidates.length && !found;i++) {
            if (candidate.equals(candidates[i])) {
                found = true;
                id = i;
            }
            System.out.println(candidates + " Eqauls " + candidates[i] + " : " + found);
        }
        conid = id;
        System.out.println(conid);
    }

    public int getRid(){return rid;}
    public int getEid(){return eid;}
    public int getConid(){return conid;}
    public int getCanid(){return canid;}
    public String getCandidate(){return candidate;}
    public String getConstituency(){return constituency;}
    public boolean isElected(){return elected;}
    public int getVotes(){return votes;}
}
