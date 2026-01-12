// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.modo_command;
import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.commands.Autos;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {
  
   Joy joy = new Joy(0);
   Joy joy2 = new Joy(1);


  public RobotContainer() {
 
    configureBindings();
  }


  private void configureBindings() {

   new JoystickButton(joy.getJoystick(),1).toggleOnTrue(new modo_command());

  }


  
}
