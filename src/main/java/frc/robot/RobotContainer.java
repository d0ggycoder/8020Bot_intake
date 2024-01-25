// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.ArmGotoPos;
import frc.robot.commands.IntakeRoutine;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Intake;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

  private final Joystick controller = new Joystick(0);

  private final Intake intake = new Intake();
  private final Arm arm = new Arm();
  private final IntakeRoutine intakeRoutine=new IntakeRoutine(arm, intake);
  private final ArmGotoPos resetarm=new ArmGotoPos(arm, 0);
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }
  private void configureBindings() {
    new JoystickButton(controller,1).onTrue(intakeRoutine);
    new JoystickButton(controller, 2).onTrue(resetarm);
  }
}
