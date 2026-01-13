// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Garras;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkMax;

public class Intake_Subsystem extends SubsystemBase {

  final SparkMax itk;
  final RelativeEncoder itkEncoder;
  
  public Intake_Subsystem() {
    itk = new SparkMax(5, MotorType.kBrushless);
    itkEncoder = itk.getEncoder();

    itkEncoder.setPosition(0);
    
  }

public void set(double forca) {
  itk.set(forca);
}
public double getEncoderDegrees() {
    return itkEncoder.getPosition();
}




  @Override
  public void periodic() {
   SmartDashboard.putNumber("Intake/Intake Voltage", itk.getBusVoltage());
   SmartDashboard.putNumber("Itk/Itk Encoder", itk.getEncoder().getPosition());
    SmartDashboard.putNumber("Intake/Intake Temperature", itk.getMotorTemperature());

  }

  }
