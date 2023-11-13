package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.ArmConstants;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Arm.ArmState;

public class ArmHandler extends CommandBase {
  private Arm m_arm;
  private PIDController m_controller;

  private double m_setPoint;

  public ArmHandler(Arm arm, ArmState state) {
    m_arm = arm;
    m_controller = new PIDController(ArmConstants.kP, ArmConstants.kI, ArmConstants.kD);

    m_setPoint = state.getSetPoint(); 

    addRequirements(m_arm);
  }

  @Override
  public void initialize() {
    m_arm.resetEncoder();
    m_controller.reset();

    m_controller.setSetpoint(m_setPoint);
  }

  @Override
  public void execute() {
    double distance = m_arm.getMetersFromRevs();
    double speed = m_controller.calculate(distance);

    m_arm.set(speed);
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("=======Got To Distance=======");
  }

  @Override
  public boolean isFinished() {
    return m_controller.atSetpoint();
  }

  
}


