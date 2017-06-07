import com.sun.prism.shader.DrawRoundRect_RadialGradient_PAD_AlphaTest_Loader;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Created by EoinH on 15/05/2017.
 */
public class Main {
    public static void main(String args[]) throws FileNotFoundException {
        PartyReader partyReader = new PartyReader("Data/PartyDetails");
        //partyReader.printAll();
        String[] partyList = partyReader.givePartyList();

        ConstituencyReader conReader = new ConstituencyReader("Data/ConstDetails");
        //conReader.printAll();
        String[] conList = conReader.giveConList();
        ArrayList<Constituency> constituency = conReader.giveList();

        CandidateReader canReader = new CandidateReader("Data/CandidateDetails");
        canReader.setIDs(partyList,conList);
        canReader.printAll();
        ArrayList<Constituency> candidates = conReader.giveList();

        RoundReader roundReader = new RoundReader("Data/CountDetails", 2016);


    }
}
