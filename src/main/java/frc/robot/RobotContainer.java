// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

//import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.modo_command;
import frc.robot.commands.manual.DriveManual_Command;
import frc.robot.commands.manual.IntakeManual_Command;
//import frc.robot.commands.manual.Shooters_Command;
//import frc.robot.commands.manual.SucManual_Commandd;
import frc.robot.subsystems.DriveSubsystem.Drive_Subsystem;
import frc.robot.subsystems.Garras.Intake_Subsystem;
//import frc.robot.subsystems.Garras.Shooters_Subsystem;
//import frc.robot.subsystems.Garras.Suc_Subsystem;
//import edu.wpi.first.wpilibj.Joystick;
//import frc.robot.commands.Autos;
//import frc.robot.commands.ExampleCommand;
//import frc.robot.subsystems.ExampleSubsystem;
//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//import edu.wpi.first.wpilibj2.command.button.Trigger;



public class RobotContainer {
  
   Joy joy = new Joy(0);
   Joy joy2 = new Joy(1);

  //Drive_Subsystem mover = new Drive_Subsystem();
   Intake_Subsystem itk = new Intake_Subsystem();
   //Suc_Subsystem suc = new Suc_Subsystem();
  //Shooters_Subsystem shooterEsquerda = new Shooters_Subsystem();

  public RobotContainer() {
 
    configureBindings();
  }


  private void configureBindings() {
   /*
      mover.setDefaultCommand(
          new DriveManual_Command(mover, joy));
*/

// modo (reto ou invertido)
   new JoystickButton(joy.getJoystick(),1).toggleOnTrue(new modo_command());


   
// intake
   new JoystickButton(joy2.getJoystick(),1).toggleOnTrue(new IntakeManual_Command(itk, joy2.getJoystick()));
 
  // sistema de sucção
 // new JoystickButton(joy2.getJoystick(),2).toggleOnTrue(new SucManual_Commandd(suc, joy2.getJoystick()));
  
// shooters
//new JoystickButton(joy2.getJoystick(),3).toggleOnTrue(new Shooters_Command(shooterEsquerda, joy2.getJoystick()));
}


  
}
