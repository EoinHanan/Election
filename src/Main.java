import Calculators.Calculator;
import Calculators.PercentageCalculator;
import Database.DBConnector;
import Database.DBReader;
import Objects.*;
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
        DBReader reader = new DBReader();
        reader.readConstituency("Wicklow");
        Model model = reader.getModel();
        model.printAll();
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
        //roundReader.printAll();
        ArrayList<Round> rounds = roundReader.give();

        DBConnector connector = new DBConnector();
        //connector.writeParties(parties);
        connector.writeCandidates(candidates);
        //connector.writeConstituencies(constituencies);
        //connector.writeRounds(rounds);

        System.out.print("About to end.");
    }
}
