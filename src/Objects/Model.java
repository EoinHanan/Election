package Objects;

import java.util.ArrayList;

/**
 * Created by EoinH on 17/10/2017.
 */
public class Model {
    public Constituency constituency;
    public ArrayList<Candidate> candidates;
    public ArrayList<ArrayList<Round>> rounds;

    public Model (Constituency constituency){
        this.constituency = constituency;
        candidates = new ArrayList<Candidate>();
        rounds = new ArrayList<ArrayList<Round>>();
    }

    public void addCandidate(Candidate candidate){
        candidates.add(candidate);
        rounds.add(new ArrayList<Round>());
    }

    public void addRound(int i, Round round){
        rounds.get(i).add(round);
    }

}
