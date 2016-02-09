package org.usfirst.frc.team1014.robot.commands.auto;

import org.usfirst.frc.team1014.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 
 * @author Tze Hei T.
 *
 */
public class DriveForwardDistance extends CommandBase{
	
	public double speed, distance, ultraDistance;

	public DriveForwardDistance(double speed, double distance){
		this.distance = distance;
		this.speed = speed;
		requires((Subsystem)driveTrain);
	}
	
	@Override
	protected void initialize() {
		driveTrain.tankDrive(0, 0);
		
	}

	@Override
	public String getConsoleIdentity() {
		return "DriveForwardDistance";
	}

	@Override
	protected void end() {
		driveTrain.tankDrive(0, 0);
		
	}

	@Override
	protected void execute() {
		ultraDistance = driveTrain.getUltraDistance(true);
		driveTrain.tankDrive(speed, speed);
		
	}

	@Override
	protected void interrupted() {
		System.out.println("DriveForwardDistance was interrupted");
		
	}

	@Override
	protected boolean isFinished() {
		if(ultraDistance < distance){
			return true;
		}else{
		return false;
		}
	}

}