// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Led extends SubsystemBase {
  private AddressableLED m_led;
  private AddressableLEDBuffer m_ledBuffer;

  public Led() {
    m_led = new AddressableLED(0);
    m_ledBuffer = new AddressableLEDBuffer(60);
    m_led.setLength(60);
    m_led.setData(m_ledBuffer);
    m_led.start();
  }

  public void LED_RGB(int R, int G, int B) {
    // CORREÇÃO: i < m_ledBuffer.getLength() evita erro de índice 60
    for (int i = 0; i < m_ledBuffer.getLength(); i++) {
        m_ledBuffer.setRGB(i, R, G, B);
    }
    m_led.setData(m_ledBuffer);
    SmartDashboard.putString("Cor do LED Atual", "RGB(" + R + "," + G + "," + B + ")");
  }
}