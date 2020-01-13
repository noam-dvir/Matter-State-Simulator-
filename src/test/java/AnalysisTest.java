import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AnalysisTest {
    private static ArrayList<String> trans_list;
    private static int[] states_array = new int[]{0, 0, 0, 0, 0};
    private static StateFactory stateFactory;

    @BeforeClass
    public static void initMatterStates() {
        trans_list = new ArrayList<>();
        stateFactory = new StateFactory();
    }

    @Before
    public void beforeEachTest() {
        //re-initialization
        trans_list.clear();
    }


    @Test
    public void testGasAnalysis() {
        State gasMatter = stateFactory.getState("G");
        trans_list.add("Ht");
        gasMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[1]);

        trans_list.add("Co");
        gasMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[4]);
    }

    @Test
    public void testSolidAnalysis() {
        State solidMatter = stateFactory.getState("S");
        trans_list.add("Di");
        solidMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[1]);

        trans_list.add("Pr");
        solidMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[0]);
    }

    @Test
    public void testLiquidAnalysis() {
        State liquidMatter = stateFactory.getState("L");
        liquidMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[4]);

        trans_list.add("Di");
        liquidMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[2]);
    }

    @Test
    public void testPlasmaAnalysis() {
        State plasmaMatter = stateFactory.getState("P");
        trans_list.add("Pr");
        plasmaMatter.analyse(trans_list, states_array);
        assertEquals(1, states_array[1]);
    }

    /**
     * This test is designed to test the rule:
     *      "One time in a million the planet’s God shows his alien power and
     *       turns X matter into Solid, which is impossible for humankind."
     * by running 1000000 simulations with X matter and Heat transition.
     * The test pass if the X turned into solid exactly once in all those runs and fails otherwise.
     */
    @Test
    public void testXAnalysis() {
        State xMatter = stateFactory.getState("X");
        trans_list.add("Ht");
        for (int i=0; i<1000000; i++){
            xMatter.analyse(trans_list, states_array);
        }
        assertEquals(1, states_array[1]);
    }


}
