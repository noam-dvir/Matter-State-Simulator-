import java.util.Arrays;
import java.util.List;

public class Plasma implements State {

    private static final List<String> TRANSITIONS = Arrays.asList("Ht", "Co");

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS)){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if(transList.contains("Pr")){
            //Pressure turns Plasma into Solid
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[1]++;
        }
        else{ //plasma stays plasma
            //ToDo: why use these number in specific. Very difficult to modify in case the logic changes. move all number to a single place
            resStates[3]++;
        }

    }
}
