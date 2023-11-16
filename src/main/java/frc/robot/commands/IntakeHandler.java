package frc.robot.commands;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Intake.IntakeState;

public class IntakeHandler extends CommandBase {
  private Intake m_intake; 
  private int m_speed;

  public IntakeHandler(Intake intake, IntakeState state) {
    m_intake = intake;

    m_speed = state.getSpeed();
  }

  @Override
  public void initialize() {
    m_intake.set(m_speed);
  }
}
