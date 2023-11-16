package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Constants.ChassisConstants;

public class Chassis extends SubsystemBase {
  private VictorSP m_rightRear; // Will change later to WPI_VictorSPX
  private VictorSP m_leftRear;
  
  private Spark m_rightFront;
  private Spark m_leftFront; 

  private MotorControllerGroup m_left;
  private MotorControllerGroup m_right;

  private DifferentialDrive m_drive;

  public Chassis() {
    m_rightRear = new VictorSP(ChassisConstants.kRightRear);
    m_leftRear = new VictorSP(ChassisConstants.kLeftRear);

    m_rightFront = new Spark(ChassisConstants.kRightFront);
    m_leftFront = new Spark(ChassisConstants.kLeftFront);

    m_left = new MotorControllerGroup(m_leftRear, m_leftFront);
    m_right = new MotorControllerGroup(m_rightRear, m_rightFront);

    m_drive = new DifferentialDrive(m_left, m_right);
  }

  public void move(CommandXboxController joystick){ 
    double mov = -joystick.getLeftY();
    double rot = joystick.getLeftX();

    m_drive.arcadeDrive(mov, rot);
  }

  public void move(double mov){
    m_drive.arcadeDrive(mov, 0);
  }
}
