/**
 * Created by EoinH on 15/05/2017.
 */
public class Party {

    private String name;
    private double percent2016;
    private double percentagePredicted;
    private int votes2016;
    private int votesPredicted;

    Party(String name, int votes2016)
    {
        this.name = name;
        this.votes2016 = votes2016;
    }

    public String getName()
    {
        return name;
    };
}
