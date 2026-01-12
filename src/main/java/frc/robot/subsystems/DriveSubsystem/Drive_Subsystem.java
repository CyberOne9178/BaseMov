  // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveSubsystem;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.config.SparkMaxConfig;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive_Subsystem extends SubsystemBase {

DifferentialDrive mover;  

SparkMaxConfig config1 = new SparkMaxConfig();
SparkMaxConfig config2 = new SparkMaxConfig();

   SparkMax[] arrayMovimento = new SparkMax[4];
        
  public Drive_Subsystem() {

  config1.follow(1);
  config2.follow(2);
    for(int i = 0; i < arrayMovimento.length; i++ ) {
        arrayMovimento[i] = new SparkMax(i + 1, MotorType.kBrushed);
        }

    mover = new DifferentialDrive(arrayMovimento[0], arrayMovimento[2]);

      }

  @Override
  public void periodic() {
  }

public void set(double axis, double axis2) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'set'");
}
}
