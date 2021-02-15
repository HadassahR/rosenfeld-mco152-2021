package rosenfeld.physics;

public class Rocket {
    final static double GRAVITY = 9.8;
    private final double velocity;
    private final double angle;


    public Rocket(double velocity, double angle) {
        this.velocity = velocity;
        this.angle = angle;
    }

    public double getX(double time) {
        double xVelocity = Math.cos(Math.toRadians(angle)) * velocity;
        double x = xVelocity * time;
        return x;
    }

    public double getY(double time) {
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double y = yVelocity * time - 0.5 * GRAVITY * time * time;
        return y;
    }

    // This method was added for homework
    public double getFlightTime(double time) {
        final double GRAVITY = 9.8;
        double yVelocity = Math.sin(Math.toRadians(angle)) * velocity;
        double retTime = yVelocity / (0.5 * GRAVITY);
        return retTime;
    }
}
