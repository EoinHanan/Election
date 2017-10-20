package Objects;

import java.util.ArrayList;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Candidate {
    private String name;
    private String constituency;
    private String party;
    private int votes;
    private String gender;
    private int canid;
    private int conid;
    private int pid;
    private ArrayList <Transfer> transfers;

    public Candidate(int canid, String constituency, String name, String gender, String party,int votes){
        this.canid =canid;
        this.name = name;
        this.constituency = constituency;
        this.gender = gender;
        this.votes = votes;
        this.party=party;
    }
    public int getCanid(){return canid;}
    public int getConid(){return conid;}
    public int getPid(){return pid;}
    public String getName(){
        return name;
    }
    public String getConstituency (){return constituency;}
    public String getGender(){return gender;}
    public String getParty(){return party;}
    public int getVotes(){return votes;}

    public void setPid(String [] parties){
        int id =0;
        boolean found = false;
        for (int i =0;i < parties.length && !found;i++){
            if (party.equals(parties[i])) {
                found = true;
                id =i;
            }
            //System.out.println(party + " Equals " + parties[i] + " : " + found);
        }
        pid = id;
        //System.out.println(pid);
    }

    public void setConid(String [] constituencies){
        int id =0;
        boolean found = false;
        for (int i =0;i < constituencies.length && !found;i++) {
            if (constituency.equals(constituencies[i])) {
                found = true;
                id = i;
            }
            //System.out.println(constituency + " Eqauls " + constituencies[i] + " : " + found);
        }
        conid = id;
        //System.out.println(conid);
    }
}
