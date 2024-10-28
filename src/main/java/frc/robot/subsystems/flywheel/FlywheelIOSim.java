package frc.robot.subsystems.flywheel;

import com.revrobotics.CANSparkMax;
import com.revrobotics.REVPhysicsSim;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import frc.robot.Constants.FlywheelConstants;

public class FlywheelIOSim implements FlywheelIO {

    private FlywheelSim flywheelSim;
    private CANSparkMax flywheelSpark;

    public FlywheelIOSim() {
        flywheelSpark = new CANSparkMax(FlywheelConstants.FLYWHEEL_PORT,
                MotorType.kBrushed);
        REVPhysicsSim.getInstance().addSparkMax(flywheelSpark,
                DCMotor.getNEO(1));
    }

    @Override
    public void setVoltage(double voltage) {

    }

    @Override
    public double getVelocity() {
        return Double.NaN;
    }

    @Override
    public void updateInputs(FlywheelIOInputs inputs) {
        inputs.velocity = 0.0;
        inputs.voltage = 0.0;
    }

}