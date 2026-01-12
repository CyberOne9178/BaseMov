// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manual;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joy;
import frc.robot.subsystems.DriveSubsystem.Drive_Subsystem;
import frc.robot.subsystems.DriveSubsystem.Pigeon;

public class DriveManual_Command extends Command {

  private final Drive_Subsystem drive;
  private final Joy joy;
  private final Pigeon pigeon = new Pigeon();
  private final PIDController pid = new PIDController(0.1, 0.001, 0);

  public DriveManual_Command(Drive_Subsystem drive, Joy joy) {
    this.drive = drive;
    this.joy = joy;
    addRequirements(drive);
  }

  @Override
  public void initialize() {
    pigeon.setYaw(0);
    pigeon.setPitch(0);
    pid.setSetpoint(0);
  }

  @Override
  public void execute() {

    double reto = joy.axis(1);
    double virar = joy.axis(2);

    double pidOutput = pid.calculate(pigeon.getYaw());

if (pigeon.getPitch() > 8 ) {

  drive.set(reto * 0.5, virar * 0.5);

    }
     else
     
    if (Math.abs(virar) > 0.08) {
      pid.setSetpoint(pigeon.getYaw());
      drive.set(reto, virar);
    } 
    else {
     
      drive.set(reto, pidOutput);
    }
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}