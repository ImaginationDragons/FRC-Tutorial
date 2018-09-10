package org.usfirst.frc.team7193.robot.commands;

import org.usfirst.frc.team7193.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.*;

public class TankDrive extends Command {
	public TankDrive() {
		requires(Robot.drivebase);
	}

	// run when starts
	protected void initialize() {

	}

	// run periodically
	protected void execute() {
		double throttle = (1.0 - Robot.oi.LEFT_JOY.getThrottle()) / -2.0;
		Robot.drivebase.set(ControlMode.PercentOutput, Robot.oi.getLeftJoyY() * throttle,
				Robot.oi.getRightJoyY() * throttle);
	}

	// run when done
	protected boolean isFinished() {
		return false;
	}

	// run if another command is acting on this subsystem
	protected void interrupted() {
		end();
	}
}
