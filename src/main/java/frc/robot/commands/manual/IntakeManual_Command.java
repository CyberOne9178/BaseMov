package frc.robot.commands.manual;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joy;
import frc.robot.subsystems.Garras.Intake_Subsystem;

public class IntakeManual_Command extends Command {

  private final Intake_Subsystem itk;
  private final Joy joy = new Joy(0); // joystick porta 0

  public IntakeManual_Command(Intake_Subsystem itk) {
    this.itk = itk;
    addRequirements(itk);
  }

  @Override
  public void execute() {


    if (joy.getRawButton(1)) {
      itk.set(0.3);   
    } else {
      itk.set(0);    
    }
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
