package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.ArmConstants;

public class Arm extends SubsystemBase {
  private CANSparkMax m_armMotor;
  
  public Arm() {
    m_armMotor = new CANSparkMax(ArmConstants.kArmMotor, MotorType.kBrushless);
  }

  public enum ArmState {
    HUMAN_PLAYER,
    TOP,
    MID,
    BOTTOM,
    RESET
  }

  private void set(double speed) {
    m_armMotor.set(speed);
  }

  public void toggleState(ArmState state) {
    switch (state) {
      case HUMAN_PLAYER:
        this.set(ArmConstants.kHumanPlayerSpeed);
        break;

      case TOP:
        this.set(ArmConstants.kTopSpeed);
        break;

      case MID:
        this.set(ArmConstants.kMidSpeed);
        break;

      case BOTTOM:
        this.set(ArmConstants.kBottomSpeed);
        break;

      case RESET:
        this.set(ArmConstants.kResetToDefault);
        break;

      default:
        this.set(0);
        break;
    }
  }
}
