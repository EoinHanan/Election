import Objects.Candidate;
import Objects.Constituency;
import Objects.Party;
import Objects.Round;

import java.util.ArrayList;

/**
 * Created by EoinH on 10/06/2017.
 */
public class PercentageCalculator extends Calculator{
    ArrayList<Candidate> candidates;
    ArrayList <Constituency> constituencies;
    ArrayList <Party> parties;
    ArrayList <Round> rounds;
    PercentageCalculator (ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies, ArrayList<Party> parties, ArrayList<Round> rounds){
        this.candidates = candidates;
        this.constituencies = constituencies;
        this.parties = parties;
        this.rounds = rounds;
    }

    public void CalculateConstituency(){

    }

    public void CalculateCandidates(){

    }

    public void CalculateParties(){
        for (int i =0; i < candidates.size();i++){

        }
    }


}
