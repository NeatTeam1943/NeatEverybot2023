// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class ArmConstants {
    public static final int kArmMotor = 0;
    
    public static final int kDistanceToLowGrid = 10;
    public static final int kDistanceToMidGrid = 100;
    public static final int kDistanceToHumanGrid = 500;
    public static final int kDistanceToTopGrid = 1000;
    public static final int kResetDistance = -100;

    public static final int kP = 1;
    public static final int kI = 2;
    public static final int kD = 3;
    public static final double setp = 1;

    public static final int kWheelDiameter = 1;
    public static final int kGearRatio = 1;

    public static final int kCountsPerRev = 42;
  }

  public static class ChassisConstants{
    public static final int kRightRear = 0;
    public static final int kLeftRear = 0;
    public static final int kRightFront = 0;
    public static final int kLeftFront = 0;
  }

  public static class IntakeConstants{
    public static final int kIntakeMotor = 0;
    public static final int kEjectSpeed = 0;
    public static final int kEatSpeed = 0;
  }
  
}
