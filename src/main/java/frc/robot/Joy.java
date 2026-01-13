// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Joy {
  Joystick joy;
  int joystick;
  public Joy(int joystick) {
    joy = new Joystick(joystick);
  }

  public Joystick getJoystick() {
    return joy;
  }
  public boolean button(int button) {
    return joy.getRawButton(button);
  }
  public boolean buttonPressed(int button) {
    return joy.getRawButtonPressed(button);
  }
  public double axis(int axis) {
    return joy.getRawAxis(axis);
  }

public boolean getRawButton(int i) {
    throw new UnsupportedOperationException("Unimplemented method 'getRawButton'");
}
}
