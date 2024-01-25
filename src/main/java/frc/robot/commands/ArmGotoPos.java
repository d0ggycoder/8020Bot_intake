// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Arm;

public class ArmGotoPos extends Command {
  /** Creates a new ControllerArm. */
  private Arm subsytem; 
  private double endPos;
  public ArmGotoPos(Arm subsystem,double endPos) {
    this.subsytem=subsystem;
    this.endPos=endPos;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    subsytem.gotoPos(endPos);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsytem.halt(!interrupted);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Math.abs(subsytem.getError())<0.15){
      return true;
    } else {
      return false;
    }
  }
}
