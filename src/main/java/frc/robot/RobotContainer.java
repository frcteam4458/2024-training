// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import frc.robot.subsystems.drive.DriveSubsystem;
import frc.robot.subsystems.drive.DriveSubsystemIOSim;
import frc.robot.subsystems.flywheel.Flywheel;
import frc.robot.subsystems.flywheel.FlywheelIOSim;

public class RobotContainer {
  CommandGenericHID commandGenericHID;

  DriveSubsystem drive;
  Flywheel flywheel;

  public RobotContainer() {
    commandGenericHID = new CommandGenericHID(Constants.CONTROLLER_PORT);

    if (Robot.isSimulation()) {
      drive = new DriveSubsystem(new DriveSubsystemIOSim());
      flywheel = new Flywheel(new FlywheelIOSim());
    }
    configureBindings();
  }

  /**
   * This method will be used to configure controls
   */
  private void configureBindings() {

    /*
     * Set the drive subsystem to use the command returned by getTeleopCommand
     * if no other command is scheduled for the subsystem
     */
    drive.setDefaultCommand(drive.getTeleopCommand());
  }

  public Command getAutonomousCommand() {
    // Factory method returning a PrintCommand
    return Commands.print("No autonomous command configured");
  }
}
