import com.bg.Action;
import com.bg.OneLevelCarPark;
import com.bg.UnsupportedActionException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.bg.Action.*;

public class OneLevelCarParkTest {
    OneLevelCarPark cp = new OneLevelCarPark(10);

    @Test
    public void testParkInputAsLastAction() throws UnsupportedActionException {

            List<Action> actions = new ArrayList<>();

            actions.add(new Action(PARK, String.valueOf(1022)));
            actions.add(new Action(PARK, String.valueOf(1003)));
            actions.add(new Action(PARK, String.valueOf(1014)));
            actions.add(new Action(PARK, String.valueOf(1035)));
            actions.add(new Action(SMALLEST));
            actions.add(new Action(DEPART));
            actions.add(new Action(PARK, String.valueOf(1056)));

            Assert.assertEquals(String.valueOf(1056), cp.actionPerformed(actions));

    }

    @Test
    public void testDepartInputAsLastAction()  throws UnsupportedActionException {

        List<Action> actions = new ArrayList<>();

        actions.add(new Action(PARK, String.valueOf(1022)));
        actions.add(new Action(PARK, String.valueOf(1003)));
        actions.add(new Action(PARK, String.valueOf(1014)));
        actions.add(new Action(PARK, String.valueOf(1035)));
        actions.add(new Action(SMALLEST));
        actions.add(new Action(DEPART));
        Assert.assertEquals(String.valueOf(1014), cp.actionPerformed(actions));
    }

    @Test
    public void testSmallestInputAsLastAction() throws UnsupportedActionException {

        List<Action> actions = new ArrayList<>();

        actions.add(new Action(PARK, String.valueOf(1022)));
        actions.add(new Action(PARK, String.valueOf(1003)));
        actions.add(new Action(PARK, String.valueOf(1014)));
        actions.add(new Action(PARK, String.valueOf(1035)));
        actions.add(new Action(SMALLEST));

        Assert.assertEquals(String.valueOf(1003), cp.actionPerformed(actions));

    }

    @Test(expected = NumberFormatException.class)
    public void testNotHappyTesting() throws UnsupportedActionException {

        List<Action> actions = new ArrayList<>();

        actions.add(new Action(PARK, String.valueOf(1022)));
        actions.add(new Action(PARK, String.valueOf("BR1003")));
        actions.add(new Action(PARK, String.valueOf(1014)));
        actions.add(new Action(PARK, String.valueOf(1035)));
        actions.add(new Action(SMALLEST));

        Assert.assertEquals(String.valueOf("1003"), cp.actionPerformed(actions));

    }

    @Test(expected = UnsupportedActionException.class)
    public void testNotHappyTesting_2() throws UnsupportedActionException {

        List<Action> actions = new ArrayList<>();

        actions.add(new Action(PARK, String.valueOf(1022)));
        actions.add(new Action("CLAMPED", String.valueOf("1003")));
        actions.add(new Action(PARK, String.valueOf(1014)));
        actions.add(new Action(PARK, String.valueOf(1035)));
        actions.add(new Action(SMALLEST));

        Assert.assertEquals(String.valueOf("1003"), cp.actionPerformed(actions));

    }

}
