package org.usfirst.frc.team2169.robot.subsystems;

import org.usfirst.frc.team2169.robot.ActuatorMap;
import org.usfirst.frc.team2169.robot.Constants;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SampleSubsystem extends Subsystem {

	CANTalon sampleTalon;
	
	public SampleSubsystem(){
		
		sampleTalon = new CANTalon(ActuatorMap.sampleMotorPort);	
		sampleTalon.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
		sampleTalon.changeControlMode(CANTalon.TalonControlMode.Speed);
		sampleTalon.setPID(Constants.P, Constants.I, Constants.D);
		
	}
	
	public void runMotor(double power) {
	
		sampleTalon.set(power);
		
	}
	
	public double getRPM() {
		
		return sampleTalon.get();
	}
	
	@Override
	public void outputToSmartDashboard() {
		
		SmartDashboard.putNumber("Motor RPM", getRPM());
		
	}

	@Override
	public void stop() {
		
		sampleTalon.set(0);
		sampleTalon.enableBrakeMode(true);
		
	}

	@Override
	public void zeroSensors() {
		
		sampleTalon.setEncPosition(0);
		
	}

}
