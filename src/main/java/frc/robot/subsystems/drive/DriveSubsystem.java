package frc.robot.subsystems.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TeleopCommand;

public class DriveSubsystem extends SubsystemBase {
    

    public DriveSubsystem(DriveSubsystemIO io) {

    }

    /**
     * @return Instance of TeleopCommand
     */
    public Command getTeleopCommand() {
        return new TeleopCommand();
    }
}
