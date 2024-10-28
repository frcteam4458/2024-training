package frc.robot.subsystems.flywheel;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheel extends SubsystemBase {
    private FlywheelIO io;
    private FlywheelIOInputsAutoLogged inputs;

    private PIDController pid;
    private SimpleMotorFeedforward feedforward;

    private static final String LPREFIX = "/Subsystems/Flywheel/";

    public Flywheel(FlywheelIO io) {
        this.io = io;
        inputs = new FlywheelIOInputsAutoLogged();
    }

    @Override
    public void periodic() {
        io.updateInputs(inputs);

        Logger.recordOutput(LPREFIX + "ProgramData", "m");
    }

    public Command setVelocity(double velocity) {
        return Commands.runOnce(() -> {
            System.out.println("Do something useful.");
        });
    }
}
