import java.util.Arrays;
import java.util.List;

public class Gas implements State{

    private static final String HT = "Ht";
    private static final String CO = "Co";
    private static final List<String> TRANSITIONS_CREATE_X = Arrays.asList(HT, CO);


    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS_CREATE_X)){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if (transList.contains(HT)||transList.contains(CO)){
            //Heat turns Gas into Solid
            //Cold turns Gas into Solid
            resStates[1]++;
        }
        else{ //gas stays gas
            resStates[0]++;
        }

    }
}
