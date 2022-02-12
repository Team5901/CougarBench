# CougarBench
This repo contains basic example code that can be run on our test bench for illustrative purposes.

# Program flow - How to program a motor command and tie it to a controller button

- Controllers, buttons, and their associated commands are defined (SeeL **RobotContainer.java**)

     XboxController Controller1 = new XboxController(0);
     new JoystickButton(Controller1, Button.kA.value).whenHeld(new SpinIntakeIn(m_IntakeSubsystem));
    
- Commands call upon methods defined in the associated subsytem (Example: **SpinIntakeIn.java**)

       public SpinIntakeIn(IntakeSubsystem subsystem) {
         // Use addRequirements() here to declare subsystem dependencies.
         m_IntakeSubsystem = subsystem;
         addRequirements(subsystem);
       }
       ...
       
       // Called every time the scheduler runs while the command is scheduled.
       @Override
       **public void execute() {
        m_IntakeSubsystem.IntakeIn();
       }**

       // Called once the command ends or is interrupted.
       @Override
       **public void end(boolean interrupted) {
         m_IntakeSubsystem.IntakeStop();
       }**

       // Returns true when the command should end.
       @Override
       public boolean isFinished() {
         return false;
       }

- Subsystems contain the methods to actuate motors/pneumatics as well as the controller definitions and declarations (Example: **IntakeSubsystem.java**)

       private final WPI_TalonSRX IntakeMotor = new WPI_TalonSRX(6);
       
       ...
       
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

# Additional Resources
 - 5901 Programming guide: https://team5901.github.io/Programming-Guide/
