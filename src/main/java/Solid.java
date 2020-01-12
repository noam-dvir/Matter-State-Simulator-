import java.util.Arrays;
import java.util.List;

public class Solid implements State {
    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(Arrays.asList("Ht", "Co"))){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if (transList.containsAll(Arrays.asList("Di", "Pr"))){
            //If Deionization is mixed with Pressure, Solid turns into Gas
            resStates[0]++;
        }
        else{ //solid stays solid
            resStates[1]++;
        }
    }
}
