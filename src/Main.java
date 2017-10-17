import Calculators.Calculator;
import Calculators.PercentageCalculator;
import Database.DBConnector;
import Objects.Candidate;
import Objects.Constituency;
import Objects.Party;
import Objects.Round;
import Reader.CandidateReader;
import Reader.ConstituencyReader;
import Reader.PartyReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import Reader.RoundReader;
import Calculators.PercentageCalculator;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        //createDatabase();

    }
    public static void createDatabase()throws FileNotFoundException{
        PartyReader partyReader = new PartyReader("Data/PartyDetails");
        String[] partyList = partyReader.givePartyList();
        ArrayList<Party> parties= partyReader.give();

        ConstituencyReader conReader = new ConstituencyReader("Data/ConstDetails");
        String[] conList = conReader.giveConList();
        ArrayList<Constituency> constituencies = conReader.give();

        CandidateReader canReader = new CandidateReader("Data/CandidateDetails");
        canReader.setIDs(partyList,conList);
        ArrayList<Candidate> candidates = canReader.giveList();
        String[] canList = canReader.give();

        RoundReader roundReader = new RoundReader("Data/CountDetails", 2016);
        roundReader.setIDs( conList,canList);
        roundReader.printAll();
        ArrayList<Round> rounds = roundReader.give();

        PercentageCalculator calculator = new PercentageCalculator(candidates,constituencies,parties, rounds);
        calculator.DivideCandidates();
        calculator.CalculateCandidates();
        calculator.CalculateConstituency();
        calculator.CalculateParties();

        DBConnector connector = new DBConnector();
        //connector.writeParties(parties);
        //connector.writeCandidates(candidates);
        //connector.writeConstituencies(constituencies);
        //connector.writeRounds(rounds);

        System.out.print("About to end.");
    }
    public void newPrediction(){
        Scanner in = new Scanner(System.in);

    }
}
