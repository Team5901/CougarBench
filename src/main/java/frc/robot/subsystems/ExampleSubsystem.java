// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ExampleSubsystem extends SubsystemBase {
  Solenoid solenoid1 = new Solenoid(PneumaticsModuleType.CTREPCM, 0);


  /** Creates a new ExampleSubsystem. */
  public ExampleSubsystem() {}

  public void pistonOut(){
    solenoid1.set(true);
  }

  public void pistonIn(){
    solenoid1.set(false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
