// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems.DriveSubsystem;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pigeon extends SubsystemBase {
  public static Pigeon2 pigeon;

  /** Creates a new Pigeon. */
  public Pigeon() {
    pigeon = new Pigeon2(1);
  }

public double getYaw() {
  return pigeon.getYaw().getValueAsDouble();
  }
    public void setYaw(double angle) {
    pigeon.setYaw(angle);
  }

  public double getPitch() {
    return pigeon.getPitch().getValueAsDouble();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void setPitch(int i) {
   
    throw new UnsupportedOperationException("Unimplemented method 'setPitch'");
}
}
