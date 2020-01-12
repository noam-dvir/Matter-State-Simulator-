import java.util.Arrays;
import java.util.List;

public class MatterStateSimulator {
    public static void main(String[] args) {
        RunSimulation("L,G,G","Co");
        RunSimulation("L,L","");
        RunSimulation("G","Co");
    }


    /**
     *
     * @param states - List of objects' state status codes, separated by a comma. e.g. “L,G,G”
     * @param transitions - List of transition codes, separated by a comma, e.g. “Ht,Di”
     * no return value (void)
     * output: print a comma separated string with number of objects with a given state
     *         E.g. “G:0,S:2,L:0,P:0,X:1”
     */
    private static void RunSimulation(String states, String transitions) {
        String[] statesArray = states.split(",");
        List<String> transList = Arrays.asList(transitions.split(","));
        int[] resStates = new int[5]; //[G,S,L,P,X] - # of objects
        for (String state : statesArray){
            AnalyzeState(state, transList, resStates);
        }

        String resString=getResultString(resStates);
        System.out.println(resString);

    }


    private static void AnalyzeState(String state, List<String> transList, int[] resStates) {
        switch(state){
            case "G":
                GasAnalysis(transList, resStates);
                break;
            case "S":
                SolidAnalysis(transList, resStates);
                break;
            case "L":
                LiquidAnalysis(transList, resStates);
                break;
            case "P":
                PlasmaAnalysis(transList, resStates);
                break;
            case "X":
                XAnalysis(transList, resStates);
                break;

            default:
                throw new IllegalArgumentException();
        }
    }

    static void GasAnalysis(List<String> transList, int[] resStates) {
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

    static void SolidAnalysis(List<String> transList, int[] resStates) {
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

    static void LiquidAnalysis(List<String> transList, int[] resStates) {
        if (transList.contains("Di")){
            //Deionization prevents Liquids turning into X, stays Liquid after applying it
            resStates[2]++;
        }
        else{
            //liquid objects turn into X without deionization
            resStates[4]++;
        }
    }

    static void PlasmaAnalysis(List<String> transList, int[] resStates) {
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

    private static void XAnalysis(List<String> transList, int[] resStates) {
        //NEED TO ADD IMPLEMENTATION FOR THE RULE:
        //"One time in a million the planet’s God shows his alien power and
        //turns X matter into Solid, which is impossible for humankind."
    }

    private static String getResultString(int[] resStates) {
        return "G:"+String.valueOf(resStates[0])
             +",S:"+String.valueOf(resStates[1])
             +",L:"+String.valueOf(resStates[2])
             +",P:"+String.valueOf(resStates[3])
             +",X:"+String.valueOf(resStates[4]);
    }
}
