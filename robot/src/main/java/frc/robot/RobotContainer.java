// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.Drive;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.IOConstants;
import frc.robot.subsystems.Shooter;
import frc.robot.commands.Gun;
import frc.robot.subsystems.Puller;
import frc.robot.commands.Puller.LeftExtend;
import frc.robot.commands.Puller.RightExtend;
import frc.robot.commands.Puller.LeftPull;
import frc.robot.commands.Puller.RightPull;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  //subsystems
  private final DriveTrain car = new DriveTrain();
  private final Shooter PewPew = new Shooter();
  private final Puller winch = new Puller();

  //controller
  private final XboxController controller = new XboxController(IOConstants.xBoxController);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    car.setDefaultCommand(new Drive(car, () -> controller.getLeftY(), () -> controller.getRightX(), () -> controller.getLeftX())); //drive
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller, XboxController.Button.kB.value).whenHeld(new Gun(PewPew, 0.69, 0.69)); //shooter
    new JoystickButton(controller, XboxController.Button.kLeftBumper.value).whenHeld(new LeftExtend(winch)); //left winch up
    new JoystickButton(controller, XboxController.Button.kRightBumper.value).whenHeld(new RightExtend(winch)); //right winch up
    new JoystickButton(controller, XboxController.Button.kLeftStick.value).whenHeld(new LeftPull(winch)); //left winch down
    new JoystickButton(controller, XboxController.Button.kRightStick.value).whenHeld(new RightPull(winch)); //right winch down
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  //public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    //return; m_autoCommand;
  //}
}
