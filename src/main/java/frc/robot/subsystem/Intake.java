package frc.robot.subsystem;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  private Spark m_intakeMotor;
  כ
  public Intake() {
    m_intakeMotor = new Spark(IntakeConstants.kIntakeMotor);
  }

  public void eject(){
    m_intakeMotor.set(IntakeConstants.kEjectSpeed);
  }

  public void eat(){
    m_intakeMotor.set(IntakeConstants.kEatSpeed);
  }

  public void reset(){
    m_intakeMotor.set(0);
  }
}
