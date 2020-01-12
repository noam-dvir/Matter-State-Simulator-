import java.util.Arrays;
import java.util.List;

public class Plasma implements State {
    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(Arrays.asList("Ht", "Co"))){
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
