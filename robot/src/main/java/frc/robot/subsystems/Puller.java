// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.PullerConstants;

public class Puller extends SubsystemBase {
  private final CANSparkMax leftMotor;
  private final CANSparkMax rightMotor;
  /** Creates a new Puller. */
  public Puller() {
    leftMotor = new CANSparkMax(PullerConstants.LEFT_ARM, MotorType.kBrushless);
    rightMotor = new CANSparkMax(PullerConstants.RIGHT_ARM, MotorType.kBrushless);
  }

  public void leftUp(){
    leftMotor.set(.1);
  }

  public void rightUp(){
    rightMotor.set(.1);
  }

  public void leftDown(){
    leftMotor.set(-.1);
  }

  public void rightDown(){
    rightMotor.set(-.1);
  }

  public void leftStop(){
    leftMotor.stopMotor();
  }

  public void rightStop(){
    rightMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
