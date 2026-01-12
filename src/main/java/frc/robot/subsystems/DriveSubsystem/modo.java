// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveSubsystem;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class modo extends SubsystemBase {


String drive = "reto" ;

  public modo() {}

public void trocar(){
  if(drive == "reto"){

    drive = "inversor" ;
  } 
  else  {

    drive = "reto" ;
  }
}

public String getmodo(){
  return drive;
}

  @Override
  public void periodic() {

  SmartDashboard.putString("modo", drive);

  }
}
