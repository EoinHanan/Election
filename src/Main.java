import Objects.Candidate;
import Objects.Constituency;
import Objects.Party;
import Objects.Round;
import Reader.CandidateReader;
import Reader.ConstituencyReader;
import Reader.PartyReader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import Reader.RoundReader;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException {
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

        Calculator calculator = new PercentageCalculator(candidates,constituencies,parties, rounds);

    }
}
