import java.util.Arrays;
import java.util.List;

public class Plasma implements State {

    private static final List<String> TRANSITIONS_CREATE_X = Arrays.asList("Ht", "Co");

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(TRANSITIONS_CREATE_X)){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if(transList.contains("Pr")){
            //Pressure turns Plasma into Solid
            resStates[1]++;
        }
        else{ //plasma stays plasma
            resStates[3]++;
        }

    }
}
