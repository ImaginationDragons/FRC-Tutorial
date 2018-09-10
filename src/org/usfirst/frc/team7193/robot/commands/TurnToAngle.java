package org.usfirst.frc.team7193.robot.commands;

import org.usfirst.frc.team7193.robot.*;

import edu.wpi.first.wpilibj.command.*;

public class TurnToAngle extends Command {
	double Angle;

	boolean isFinished = false;
	boolean inErrorZone = false;
	int count;

	public TurnToAngle(double angle) {
		requires(Robot.drivebase);
		Angle = angle;
	}

	// run when starts
	protected void initialize() {
		Robot.drivebase.rototeDegrees(Angle);
	}

	// run periodically
	protected void execute() {
		double error = Robot.drivebase.turnController.getError();
		inErrorZone = Math.abs(error) < 2;
		if (inErrorZone) {
			count++;
			isFinished = count >= 5;
		}
		else {
			count = 0;
		}
	}

	// run when done
	protected boolean isFinished() {
		return isFinished;
	}

	// run if another command is acting on this subsystem
	protected void interrupted() {
		end();
	}
	protected void end() {
		Robot.drivebase.turnController.disable();
	}
}
