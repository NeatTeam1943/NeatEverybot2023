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
}
