// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArmHandler;
import frc.robot.commands.IntakeHandler;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Chassis;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Arm.ArmState;
import frc.robot.subsystems.Intake.IntakeState;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class RobotContainer {
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  private final Chassis m_chassis;
  private final Arm m_arm;
  private final Intake m_intake;

  public RobotContainer() {
    m_chassis = new Chassis();
    m_arm = new Arm();
    m_intake = new Intake();

    m_chassis.setDefaultCommand(new RunCommand(() -> m_chassis.move(m_driverController), m_chassis));
    
    configureBindings();
  }

  private void configureBindings() {
    m_driverController.a().whileTrue(new SequentialCommandGroup(
      new ArmHandler(m_arm, ArmState.TOP),
      new IntakeHandler(m_intake, IntakeState.EJECT),
      new WaitCommand(3),
      new IntakeHandler(m_intake, IntakeState.RESET),
      new WaitCommand(3),
      new ArmHandler(m_arm, ArmState.RESET)
    ));
  }

  public Command getAutonomousCommand() {
    return null;    
  }
}
