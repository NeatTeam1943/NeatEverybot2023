package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxRelativeEncoder.Type;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {
  private CANSparkMax m_armMotor;

  public Arm() {
    m_armMotor = new CANSparkMax(ArmConstants.kArmMotor, MotorType.kBrushless);
  }

  public enum ArmState {
    HUMAN(ArmConstants.kDistanceToHumanGrid),
    TOP(ArmConstants.kDistanceToTopGrid),
    MID(ArmConstants.kDistanceToMidGrid),
    LOW(ArmConstants.kDistanceToLowGrid),
    RESET(ArmConstants.kResetDistance);

    private final double setPoint;

    ArmState(double setPoint) {
      this.setPoint = setPoint;
    }

    public double getSetPoint() {
      return setPoint;
    }
  }

  public void set(double speed) {
    m_armMotor.set(speed);
  }

  public RelativeEncoder getEncoder() {
    return m_armMotor.getEncoder(Type.kHallSensor, ArmConstants.kCountsPerRev);
  }

  public double getMetersFromRevs() {
    double distancePerRevolution = Math.PI * ArmConstants.kWheelDiameter / ArmConstants.kGearRatio;

    return distancePerRevolution * getEncoder().getPosition();
  }

  public void resetEncoder() {
    m_armMotor.getEncoder().setPosition(0);
  }

  public CANSparkMax getMotor() {
    return m_armMotor;
  }
}
