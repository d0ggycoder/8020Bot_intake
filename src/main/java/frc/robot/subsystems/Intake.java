// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Consts;

public class Intake extends SubsystemBase {
  /** Creates a new intake. */
  CANSparkMax intakeMotor;
  public Intake() {
    intakeMotor=new CANSparkMax(Consts.intakeID,MotorType.kBrushless);
  }
  public void doIntake(double speed,boolean forwards){
    double power=Math.abs(speed)*((forwards)?1:-1);
    intakeMotor.set(power);
  }
  public void halt(){
    intakeMotor.set(0);
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
