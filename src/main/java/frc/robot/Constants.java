package frc.robot;

public final class Constants {
    public static final int CONTROLLER_PORT = 0;

    public class FlywheelConstants {
        public static final double P = 0.0;
        public static final double I = 0.0;
        public static final double D = 0.0;

        public static final double S = 0.0;
        public static final double V = 0.0;
        public static final double A = 0.0;

        public static final double GEAR_RATIO = 1.0; // Direct drive
        public static final double MOMENT_OF_INERTIA = 0.002; // From CAD, in units of kilogram * meters squared

        public static final int FLYWHEEL_PORT = 9;
    }
}
