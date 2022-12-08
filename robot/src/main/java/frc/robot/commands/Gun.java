// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Shooter;

public class Gun extends CommandBase {
  private final Shooter Shooter;
  private final double TopSpeed;
  private final double BottomSpeed;
  /** Creates a new Gun. */
  public Gun(Shooter sh, double ts, double bs) {
    Shooter = sh;
    TopSpeed = ts;
    BottomSpeed = bs;
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Shooter.shoot(TopSpeed, BottomSpeed);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Shooter.stopShoot();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
