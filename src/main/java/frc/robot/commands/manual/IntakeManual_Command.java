package frc.robot.commands.manual;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Joy;
import frc.robot.subsystems.Garras.Intake_Subsystem;


public class IntakeManual_Command extends Command {

  Joy joy2 = new Joy(1);
  Intake_Subsystem itk;
  Intake_Subsystem suc;
  double POTENCIA_ITK;
  double POTENCIA_SUC;

  public IntakeManual_Command(Intake_Subsystem itk, Intake_Subsystem suc, double POTENCIA_ITK, double POTENCIA_SUC) {
    this.itk = itk;
    this.suc = suc;
    this.POTENCIA_ITK = POTENCIA_ITK;
    this.POTENCIA_SUC = POTENCIA_SUC;
  }

 
  @Override
  public void initialize() {}


  @Override
  public void execute() {
    
   if(joy2.button(1)){

    
   } else
   itk.set(0,0);
  }


  @Override
  public void end(boolean interrupted) {
    itk.set(0,0);
    suc.set(0,0);
  }


  @Override
  public boolean isFinished() {
    return false;
  }
}
