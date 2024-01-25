// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.Consts;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  CANSparkMax armMotor;
  RelativeEncoder armEncoder;
  PIDController armPID;
  double endPos;
  public Arm() {
    armMotor=new CANSparkMax(Consts.armID, MotorType.kBrushless);
    armEncoder=armMotor.getEncoder();
    armPID=new PIDController(Consts.armPIDkp,Consts.armPIDki,Consts.armPIDkd);

    armMotor.setIdleMode(IdleMode.kCoast);
  }
  public void printPos(){
    System.out.println(armEncoder.getPosition());
  }
  public void gotoPos(double endPos){
    double power=armPID.calculate(armEncoder.getPosition(),endPos);
    power=Math.min(1,Math.max(-1,power));
    armMotor.set(power);
  }
  public void halt(boolean interrupted){
    armMotor.set(0);
    if(interrupted){
      armMotor.setIdleMode(IdleMode.kBrake);
    }
  }
  public double getError(){
    return armPID.getPositionError();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
