// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import frc.robot.Constants.ShooterConstants;


public class Shooter extends SubsystemBase {
  /** Creates a new Gun. */
  private final CANSparkMax topMotor;
  private final CANSparkMax bottomMotor;
  public Shooter() {
    topMotor = new CANSparkMax(ShooterConstants.TOP_MOTOR, MotorType.kBrushless);
    bottomMotor = new CANSparkMax(ShooterConstants.BOTTOM_MOTOR, MotorType.kBrushless);
  }

  public void shoot(double tSpeed, double bSpeed)
  {
    topMotor.set(tSpeed);
    bottomMotor.set(bSpeed);
  }

  public void stopShoot()
  {
    topMotor.stopMotor();
    bottomMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
