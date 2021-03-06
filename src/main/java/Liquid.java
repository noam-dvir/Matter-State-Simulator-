import java.util.List;

public class Liquid implements State {

    public static final String DI = "Di";

    @Override
    public void analyse(List<String> transList, int[] resStates) {
        if (transList.contains(DI)){
            //Deionization prevents Liquids turning into X, stays Liquid after applying it
            resStates[2]++;
        }
        else{
            //liquid objects turn into X without deionization
            resStates[4]++;
        }
    }
}
