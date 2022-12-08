// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

public class DriveTrain extends SubsystemBase {
  /** Creates a new driveTrain. */
  //motors
  private final CANSparkMax frontLeftMotor;
  private final CANSparkMax frontRightMotor;
  private final CANSparkMax backLeftMotor;
  private final CANSparkMax backRightMotor;

  private final MecanumDrive drive;

  public DriveTrain() {
    frontLeftMotor = new CANSparkMax(DriveConstants.FL_MOTOR, MotorType.kBrushless);
    frontRightMotor = new CANSparkMax(DriveConstants.FR_MOTOR, MotorType.kBrushless);
    backLeftMotor = new CANSparkMax(DriveConstants.BL_MOTOR, MotorType.kBrushless);
    backRightMotor = new CANSparkMax(DriveConstants.BR_MOTOR, MotorType.kBrushless);

    drive = new MecanumDrive(frontLeftMotor,frontRightMotor, backLeftMotor, backRightMotor);
  }

  public void trainIsDriving(double xS, double yS, double zR){
    if(Math.abs(zR) < 0.2){
      zR = 0;
    }

    if(Math.abs(yS) < 0.2){
      yS = 0;
    }

    if(Math.abs(xS) < 0.2){
      xS = 0;
    }

    drive.driveCartesian(yS, xS, zR);
  }

  public void stopDrive(){
    drive.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}