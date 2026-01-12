// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Garras;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

public class Intake_Subsystem extends SubsystemBase {

  final SparkMax itk;
  final SparkMax suc;
  
  double pocicao;
  
  public Intake_Subsystem() {
    itk = new SparkMax(5, MotorType.kBrushless);
    suc = new SparkMax(6, MotorType.kBrushless);

    pocicao = itk.getEncoder().getPosition();

  }
public void set(double POTENCIA_ITK, double POTENCIA_SUC) {
  itk.set(POTENCIA_ITK);
  suc.set(POTENCIA_SUC);
}



  @Override
  public void periodic() {
   SmartDashboard.putNumber("Intake/Intake Voltage", itk.getBusVoltage());
    SmartDashboard.putNumber("Intake/Intake Temperature", itk.getMotorTemperature());
    SmartDashboard.putString("Intake/Intake Error", itk.getLastError().toString());

SmartDashboard.putNumber("MiniNeo/ Voltage", suc.getBusVoltage());
    SmartDashboard.putNumber("MiniNeo/ Temperature", suc.getMotorTemperature());
    SmartDashboard.putString("MiniNeo/ Error", suc.getLastError().toString());


  }
}
