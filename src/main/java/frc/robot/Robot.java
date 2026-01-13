// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Hub_ID;
import frc.robot.subsystems.Led;


public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

 Led LED = new Led();
  String ativo;

  public Robot() {
    new RobotContainer();

   
  }

  
  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();

    // chama métodos static da forma correta
    Hub_ID.logToDashboard();

    if (Hub_ID.isAllianceHubActive()) {
        ativo = "Lançar bolas";
        LED.LED_RGB(225, 0, 0);
    } else {
        ativo = "Pegar bolas";
        LED.LED_RGB(0, 225, 0);
    }

    SmartDashboard.putString("AÇÃO", ativo);
}


  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  
  @Override
  public void autonomousInit() {
  


    if (m_autonomousCommand != null) {
      CommandScheduler.getInstance().schedule(m_autonomousCommand);
    }
  }


  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
 
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  
  @Override
  public void teleopPeriodic() {}

  @Override
  public void testInit() {

    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  
  @Override
  public void simulationInit() {}

 
  @Override
  public void simulationPeriodic() {}
}
