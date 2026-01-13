package frc.robot.commands.manual;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Garras.Intake_Subsystem;

public class IntakeManual_Command extends Command {

  PIDController PID = new PIDController(0, 0, 0);
  private final Intake_Subsystem itk;
  private final Joystick joy2;
   

  public IntakeManual_Command(Intake_Subsystem itk, Joystick joy2) {
    this.itk = itk;
    this.joy2 = joy2;
    addRequirements(itk);

    PID.setSetpoint(itk.getEncoderDegrees());
  }

  @Override
  public void execute() {

       itk.set(joy2.getRawButton(1) ? -0.7 : 0.0);
  }


  @Override
  public void end(boolean interrupted) {
    itk.set(0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
