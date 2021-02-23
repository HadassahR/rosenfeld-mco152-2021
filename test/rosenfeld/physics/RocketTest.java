package rosenfeld.physics;
import org.junit.Assert;
import org.junit.Test;
public class RocketTest {

    @Test
    public void getX() {
        // given
        Rocket rocket = new Rocket(71, 35);

        // when
        double x = rocket.getX(3);
        double y = rocket.getY(3);

        // then
        Assert.assertEquals(174.47, x, 0.01);

    }

    @Test
    public void getY() {
        // given
        Rocket rocket = new Rocket(71, 35);

        // when
        double y = rocket.getY(3);

        // then
        Assert.assertEquals(78.07, y, 0.01);

    }

    // This test was added for homework
    @Test
    public void getTimeLanded() {
        //given
        Rocket rocket = new Rocket(71, 35);

        //when
        double timeToLand = rocket.getFlightTime();

        //then
        Assert.assertEquals(8.31, timeToLand, 0.01);
    }



}
