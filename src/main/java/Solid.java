import java.util.Arrays;
import java.util.List;

public class Solid implements State {

    private static final List<String> TRANSITIONS = Arrays.asList("Ht", "Co");
    //ToDo: better naming. maybe move all constants to single file.
    private static final List<String> TRANSITIONS_2 = Arrays.asList("Di", "Pr");

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS)){
            //Applying Heat and Cold at the same time, matter turns into X.
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[4]++;
        }
        else if (transList.containsAll(TRANSITIONS_2)){
            //If Deionization is mixed with Pressure, Solid turns into Gas
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[0]++;
        }
        else{ //solid stays solid
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[1]++;
        }
    }
}
