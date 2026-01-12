// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manual;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem.Drive_Subsystem;
import frc.robot.subsystems.DriveSubsystem.Pigeon;


/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveManual_Command extends Command {

  Drive_Subsystem drive;
  Pigeon pigeon = new Pigeon();
  Joy joy;
  PIDController pid = new PIDController(0.1, 0.001, 0);

  public DriveManual_Command(Drive_Subsystem drive, Joy joy) {
    this.drive = drive;
    this.joy = joy;
    addRequirements(drive);
  }


  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
