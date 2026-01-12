// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manual;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joy;
import frc.robot.subsystems.DriveSubsystem.Drive_Subsystem;
import frc.robot.subsystems.DriveSubsystem.Pigeon;
import frc.robot.subsystems.DriveSubsystem.modo;

public class DriveManual_Command extends Command {
 
     double reto;
    double rotacao;
  
  private final modo troca = new modo();
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


    if(troca.getmodo() == "reto"){
      reto = joy.axis(1);
     rotacao = joy.axis(2);
     
    } else {
      reto = -joy.axis(1);
     rotacao = -joy.axis(2);
    }
    

    double pidOutput = pid.calculate(pigeon.getYaw());

// PITCH CORRECTION:

    double angulo = pigeon.getPitch();

    double correcao = 1 - (angulo - 5 / 15 );

if (pigeon.getPitch() <= 20 ) {
   
  drive.set(reto * correcao, rotacao * correcao);
  
    }
     else
     
    if (Math.abs(rotacao) > 0.08) {
      pid.setSetpoint(pigeon.getYaw());
      
      drive.set(reto, rotacao);
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