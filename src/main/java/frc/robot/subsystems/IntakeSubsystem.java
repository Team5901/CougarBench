// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(6);
  /** Creates a new IntakeSubsystem. */
  public IntakeSubsystem() {}

  public void IntakeIn(){
    //set motor to 100% output in positive direction
    IntakeMotor.set(.3);
  }

  public void IntakeOut(){
    //sets motor to 100% output in negative direction
    IntakeMotor.set(-0.3);
  }

  public void IntakeStop(){
    IntakeMotor.stopMotor();
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
