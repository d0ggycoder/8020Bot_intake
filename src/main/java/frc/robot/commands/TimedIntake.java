// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.Consts;
import frc.robot.subsystems.Intake;

public class TimedIntake extends Command {
  private Intake subsystem;
  private double duration;
  private Timer runTimer;
  public TimedIntake(Intake subsystem,double duration) {
    this.subsystem=subsystem;
    this.duration=duration;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    this.runTimer=new Timer();
    runTimer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double power=Consts.intakeSpeed;
    subsystem.doIntake(power, true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    subsystem.halt();
    System.out.println("Halting");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(runTimer.get()>=duration){
      return true;
    } else {
      return false;
    }
  }
}
