// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import org.littletonrobotics.junction.LoggedRobot;
import org.littletonrobotics.junction.Logger;
import org.littletonrobotics.junction.networktables.NT4Publisher;
import org.littletonrobotics.junction.wpilog.WPILOGWriter;

import com.revrobotics.REVPhysicsSim;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

public class Robot extends LoggedRobot {
  private Command autonomousCommand;

  private RobotContainer robotContainer;

  @Override
  public void robotInit() {

    if (Robot.isReal()) {
      Logger.addDataReceiver(new WPILOGWriter());
    } else if (Robot.isSimulation()) {
      Logger.addDataReceiver(new NT4Publisher());
    }

    Logger.recordMetadata("BuildConstants/GitSHA",
        BuildConstants.GIT_SHA);
    Logger.recordMetadata("BuildConstants/GitBranch",
        BuildConstants.GIT_BRANCH);
    Logger.recordMetadata("BuildConstants/BuildDate",
        BuildConstants.BUILD_DATE);
    Logger.recordMetadata("BuildConstants/BuildUnixTimestamp",
        String.valueOf(BuildConstants.BUILD_UNIX_TIME));

    robotContainer = new RobotContainer();
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = robotContainer.getAutonomousCommand();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  @Override
  public void teleopInit() {
    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  @Override
  public void simulationPeriodic() {
    REVPhysicsSim.getInstance().run();
  }

}
