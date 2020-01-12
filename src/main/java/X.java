import java.util.List;

public class X implements State {
    @Override
    public void analyse(List<String> transList, int[] resStates) {
        //"One time in a million the planet’s God shows his alien power and
        //turns X matter into Solid, which is impossible for humankind."
        int counter = MatterStateSimulator.getRunsCounter();
        if (counter==1000000){
            resStates[1]++;
            MatterStateSimulator.setRunsCounter(0);
        }
        else{
            resStates[4]++;
        }
        MatterStateSimulator.setRunsCounter(counter+1);

    }
}
