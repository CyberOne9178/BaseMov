// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.manual;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Garras.Suc_Subsystem;
import edu.wpi.first.wpilibj.Joystick;


public class SucManual_Commandd extends Command {

  private final Suc_Subsystem suc;
  private final Joystick joy;

  public SucManual_Commandd(Suc_Subsystem suc, Joystick joy) {
    this.suc = suc;
    this.joy = joy;

    addRequirements(suc);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    suc.set(joy.getRawButton(2) ? -0.7 : 0.0);
  }

  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}
