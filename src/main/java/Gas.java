import java.util.Arrays;
import java.util.List;

public class Gas implements State{

    private static final String HT = "Ht";
    private static final String CO = "Co";
    private static final List<String> TRANSITIONS = Arrays.asList(HT, "Co");


    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS)){
            //Applying Heat and Cold at the same time, matter turns into X.
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[4]++;
        }
        else if (transList.contains(HT)||transList.contains(CO)){
            //Heat turns Gas into Solid
            //Cold turns Gas into Solid
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[1]++;
        }
        else{ //gas stays gas
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[0]++;
        }

    }
}
