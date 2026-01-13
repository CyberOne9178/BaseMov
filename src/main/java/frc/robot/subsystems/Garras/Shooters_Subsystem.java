// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.Garras;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
 

public class Shooters_Subsystem extends SubsystemBase {

final SparkMax shooterEsquerda;
final SparkMax shooterDireita; 

  public Shooters_Subsystem() {
    shooterEsquerda = new SparkMax(7, MotorType.kBrushless);
    shooterDireita = new SparkMax(8, MotorType.kBrushless);

SparkMaxConfig config3 = new SparkMaxConfig();
config3.follow(shooterEsquerda);

shooterDireita.configure(
  config3, 
  SparkMax.ResetMode.kResetSafeParameters,
  SparkMax.PersistMode.kPersistParameters
);
  }

  public void set(double forca){
    shooterEsquerda.set(forca);
  }

  

  @Override
  public void periodic() {
  }
}
