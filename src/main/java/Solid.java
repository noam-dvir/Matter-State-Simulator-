import java.util.Arrays;
import java.util.List;

public class Solid implements State {

    private static final List<String> TRANSITIONS_CREATE_X = Arrays.asList("Ht", "Co");
    private static final List<String> TRANSITIONS_CREATE_GAS = Arrays.asList("Di", "Pr");

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS_CREATE_X)){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if (transList.containsAll(TRANSITIONS_CREATE_GAS)){
            //If Deionization is mixed with Pressure, Solid turns into Gas
            resStates[0]++;
        }
        else{ //solid stays solid
            resStates[1]++;
        }
    }
}
