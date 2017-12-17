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
    private int canID;
    private int conID;
    private int pid;
    private ArrayList <Round> rounds;
    private ArrayList <Transfer> transfers;

    public Candidate(int canID, String constituency, String name, String gender, String party,int votes){
        this.canID =canID;
        this.name = name.toLowerCase();
        this.constituency = constituency;
        this.gender = gender;
        this.votes = votes;
        this.party=party;
    }

    public Candidate(int canID, int conID, String name, int pid, String gender, int votes) {
        this.canID =canID;
        this.conID = conID;
        this.name = name;
        this.pid = pid;
        this.gender = gender;
        this.votes = votes;
    }

    public int getCanid(){return canID;}
    public int getConid(){return conID;}
    public int getPid(){return pid;}
    public String getName(){
        return name;
    }
    public String getConstituency (){return constituency;}
    public String getGender(){return gender;}
    public String getParty(){return party;}
    public int getVotes(){return votes;}
    public void hasRounds(){
        rounds = new ArrayList<>();
    }
    public Round getRound(int i){
        return rounds.get(i);
    }

    public void addRound(Round round){
        rounds.add(round);
    }

    public int roundSize(){
        return rounds.size();
    }


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
        conID = id;
        //System.out.println(conid);
    }
}
