# CougarBench
This repo contains basic example code that can be run on our test bench for illustrative purposes

# Program flow
- Controllers, buttons, and their associated commands are defined in **RobotContainer.java.**
-     XboxController Controller1 = new XboxController(0);
-         new JoystickButton(Controller1, Button.kA.value)
        .whenHeld(new SpinIntakeIn(m_IntakeSubsystem));
    
- Commands call upon methods defined in the associated subsytem (Example: **SpinIntakeIn.java**)
-     public class SpinIntakeIn extends CommandBase {
  final IntakeSubsystem m_IntakeSubsystem;
  /** Creates a new SpinIntake. */
  public SpinIntakeIn(IntakeSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_IntakeSubsystem = subsystem;
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Spinning Intake In");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_IntakeSubsystem.IntakeIn();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_IntakeSubsystem.IntakeStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
- Subsystems contain the methods to actuate motors/pneumatics as well as the controller definitions and declarations (Example: **IntakeSubsystem.java**)
-     public void IntakeIn(){
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

# Additional Resources
 - 5901 Progrmaming guide: https://team5901.github.io/Programming-Guide/
