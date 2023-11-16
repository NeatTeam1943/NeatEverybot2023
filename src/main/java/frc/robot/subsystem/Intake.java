package frc.robot.subsystem;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;

public class Intake extends SubsystemBase {
  private Spark m_intakeMotor;
  
  public Intake() {
    m_intakeMotor = new Spark(IntakeConstants.kIntakeMotor);
  }

  public enum IntakeState{
    EJECT(IntakeConstants.kEjectSpeed),
    EAT(IntakeConstants.kEatSpeed),
    RESET(0);

    private final int m_speed;

    IntakeState(int speed){
      m_speed = speed;  
    }

    public int getSpeed(){
      return m_speed;
    }
  }

  public void set(int speed){
    m_intakeMotor.set(speed);
  }
}
