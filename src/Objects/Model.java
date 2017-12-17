package Objects;

import java.util.ArrayList;

/**
 * Created by EoinH on 17/10/2017.
 */
public class Model {
    public Constituency constituency;
    public ArrayList<Candidate> candidates;
    public ArrayList<ArrayList<Round>> rounds;
    public ArrayList<Transfer> transfers;;

    public Model (Constituency constituency){
        this.constituency = constituency;
        candidates = new ArrayList<Candidate>();
        rounds = new ArrayList<ArrayList<Round>>();
        transfers = new ArrayList<>();
    }

    public void addCandidate(Candidate candidate){
        candidates.add(candidate);
        rounds.add(new ArrayList<Round>());
    }

    public void addRound(int i, Round round){
        rounds.get(i).add(round);
    }

    public int getCandidatesSize(){
        return candidates.size();
    }

    public Candidate getCandidate(int i ){
        return candidates.get(i);
    }

    public void printAll(){
        System.out.println("Constituency: " + constituency.getName() + "\n");

        for (int i =0; i < candidates.size();i++) {
            System.out.println("\nCandidate " + i + " : " + candidates.get(i).getName());


            for (int j =0; j < rounds.get(i).size();j++)
                System.out.println("Round "+ rounds.get(i).get(j).getNumber() + ": "  + rounds.get(i).get(j).getVotes());
        }

    }

    public void calculateTransfers(){
        //Create Empty Transfers
        System.out.println(candidates.size());
        boolean  found[]  = new boolean[candidates.size()];

        for (int i = 0; i < candidates.size(); i++){
            found[i] = false;
            for (int j =0; j < candidates.size();j++){
                if (i == j){
                    ;
                }
                else
                    transfers.add(new Transfer(candidates.get(i).getCanid(),candidates.get(j).getCanid()));
            }
        }

        for (int i =0;i < rounds.get(0).size() - 1;i++)
        {
            System.out.println("Round: " + i);
            for (int j =0;j < rounds.size();j++){
                System.out.println(candidates.get(j).getName());
                if (!found[j]) {
                    if (rounds.get(j).get(i).getStatus().equals("Elected") && i + 1 < rounds.get(i).size()) {
                        elected(i, j);
                        found[j] = true;
                    } else if (rounds.get(j).get(i + 1).getStatus().equals("Excluded")) {
                        excluded(i, j);
                        found[j] = true;
                    }
                }
            }
        }

        //for (int i=0;i < transfers.size();i++)
        //    System.out.println("Candidate from: " + transfers.get(i).getFromCanID() + " Candidate to: " + transfers.get(i).getToCanID());
    }

    public void elected(int round, int candidate){
        int total = rounds.get(candidate).get(round).getVotes() - (int)(Math.ceil(constituency.getPoll2016()/(constituency.getSeats() + 1)));
        //System.out.println("Candidate:"+ rounds.get(candidate).get(round).getVotes()+ " Number of seats: " + constituency.getSeats() + " Valid polls " + constituency.getPoll2016());
        System.out.println("Elected, Total transfer for " + candidates.get(candidate).getName() + " = " + total);
    }

    public void excluded(int round, int candidate){
        int total = rounds.get(candidate).get(round).getVotes();
        System.out.println("Excluded, Total transfer for " + candidates.get(candidate).getName() + " = " + total);
    }
}