import java.util.List;

public class Liquid implements State {

    public static final String DI = "Di";

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.contains(DI)){
            //Deionization prevents Liquids turning into X, stays Liquid after applying it
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[2]++;
        }
        else{
            //liquid objects turn into X without deionization
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[4]++;
        }
    }
}
