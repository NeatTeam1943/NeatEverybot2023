package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {
  private Spark m_armMotor;

  public Arm() {
    m_armMotor = new Spark(ArmConstants.kArmMotor);
  }

  public void set(double speed) {
    m_armMotor.set(speed);
  }
}
