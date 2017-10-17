package Calculators;

import Objects.Candidate;
import Objects.Constituency;
import Objects.Party;
import Objects.Round;

import java.util.ArrayList;

/**
 * Created by EoinH on 08/06/2017.
 */
public abstract class Calculator {
    ArrayList <Candidate> candidates;
    ArrayList <Constituency> constituencies;
    ArrayList <Party> parties;
    ArrayList <Round> rounds;
    Calculator(){}
    Calculator (ArrayList<Candidate> candidates, ArrayList<Constituency> constituencies, ArrayList<Party> parties, ArrayList<Round> rounds){
        this.candidates = candidates;
        this.constituencies = constituencies;
        this.parties = parties;
        this.rounds = rounds;
    }



}
