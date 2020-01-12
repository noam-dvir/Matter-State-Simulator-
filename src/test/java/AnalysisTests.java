import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AnalysisTests {
    private static ArrayList<String> trans_list;
    private static int[] states_array;

    @BeforeClass
    public static void initMatterStates() {
        trans_list = new ArrayList<>();
    }

    @Before
    public void beforeEachTest() {
        //re-initialization
        states_array= new int[]{0, 0, 0, 0, 0};
        trans_list.clear();
    }


    @Test
    public void testGasAnalysis() {
        trans_list.add("Ht");
        MatterStateSimulator.GasAnalysis(trans_list, states_array);
        assertEquals(1, states_array[1]);

        trans_list.add("Co");
        MatterStateSimulator.GasAnalysis(trans_list, states_array);
        assertEquals(1, states_array[4]);
    }

    @Test
    public void testSolidAnalysis() {
        trans_list.add("Di");
        MatterStateSimulator.SolidAnalysis(trans_list, states_array);
        assertEquals(1, states_array[1]);

        trans_list.add("Pr");
        MatterStateSimulator.SolidAnalysis(trans_list, states_array);
        assertEquals(1, states_array[0]);
    }

    @Test
    public void testLiquidAnalysis() {
        MatterStateSimulator.LiquidAnalysis(trans_list, states_array);
        assertEquals(1, states_array[4]);

        trans_list.add("Di");
        MatterStateSimulator.LiquidAnalysis(trans_list, states_array);
        assertEquals(1, states_array[2]);
    }

    @Test
    public void testPlasmaAnalysis() {
        trans_list.add("Pr");
        MatterStateSimulator.PlasmaAnalysis(trans_list, states_array);
        assertEquals(1, states_array[1]);
    }

}
