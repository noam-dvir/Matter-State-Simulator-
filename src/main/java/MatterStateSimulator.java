import java.util.Arrays;
import java.util.List;

public class MatterStateSimulator {

    private static int runsCounter =1;

    public static void main(String[] args) {
        RunSimulation(args[0], args[1]);
    }


    /**
     *
     * @param states - List of objects' state status codes, separated by a comma. e.g. “L,G,G”
     * @param transitions - List of transition codes, separated by a comma, e.g. “Ht,Di”
     * no return value (void)
     * output: print a comma separated string with number of objects of a given state
     *         E.g. “G:0,S:2,L:0,P:0,X:1”
     */
    static void RunSimulation(String states, String transitions) {
        List<String> transList = Arrays.asList(transitions.split(","));
        State[] inputStates = getInputStates(states);
        int[] resStates = new int[5]; //[G,S,L,P,X] - # of objects
        for (State state : inputStates){
            if (null != state){
                state.analyse(transList, resStates);
            }
        }
        String resString=getResultString(resStates);
        System.out.println(resString);

    }


    private static String getResultString(int[] resStates) {
        return "G:"+String.valueOf(resStates[0])
             +",S:"+String.valueOf(resStates[1])
             +",L:"+String.valueOf(resStates[2])
             +",P:"+String.valueOf(resStates[3])
             +",X:"+String.valueOf(resStates[4]);
    }

    private static State[] getInputStates(String states) {
        StateFactory stateFactory = new StateFactory();
        String[] statesArray = states.split(",");
        State[] res = new State[statesArray.length];
        for (int i=0; i<statesArray.length; i++){
            res[i] = stateFactory.getState(statesArray[i]);
        }
        return res;
    }

    public static int getRunsCounter() {
        return runsCounter;
    }

    public static void setRunsCounter(int runsCounter) {
        MatterStateSimulator.runsCounter = runsCounter;
    }
    
}
