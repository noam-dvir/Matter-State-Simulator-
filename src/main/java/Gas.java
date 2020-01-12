import java.util.Arrays;
import java.util.List;

public class Gas implements State{

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.containsAll(Arrays.asList("Ht", "Co"))){
            //Applying Heat and Cold at the same time, matter turns into X.
            resStates[4]++;
        }
        else if (transList.contains("Ht")||transList.contains("Co")){
            //Heat turns Gas into Solid
            //Cold turns Gas into Solid
            resStates[1]++;
        }
        else{ //gas stays gas
            resStates[0]++;
        }

    }
}
