// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Garras.Shooters_Subsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class Shooters_Command extends Command {

  private final Shooters_Subsystem shooterEsquerda;
  private final Joystick joy2;

  public Shooters_Command(Shooters_Subsystem shooterEsquerda, Joystick joy2) {
    this.shooterEsquerda = shooterEsquerda;
    this.joy2 = joy2;
    addRequirements(shooterEsquerda);

  }

  @Override
  public void initialize() {}


  public void execute() {
    shooterEsquerda.set(joy2.getRawButton(2) ? -0.7 : 0.0);
  }


  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
