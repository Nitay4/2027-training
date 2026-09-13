package frc.robot;

import com.ctre.phoenix6.hardware.TalonFX;
import org.littletonrobotics.junction.Logger;

public class TalMotorControilMission {

	private TalonFX motor;
	private int deviceId;
	private double initialPos;

	public TalMotorControilMission(int deviceId) {
		this.motor = new TalonFX(deviceId);
		this.deviceId = deviceId;
		this.initialPos = this.getPosition();
//		TalonFXConfigurator configurator = this.motor.getConfigurator();
//		TalonFXConfiguration configs = new TalonFXConfiguration();
//		configs.CurrentLimits.StatorCurrentLimit = 120;
//		configs.CurrentLimits.StatorCurrentLimitEnable = true;
//		configurator.apply(configs);
	}

	public void MoveForwardHalfPower() {
		this.motor.set(0.5);
	}

	public void MoveForwardTenthPower() {
		this.motor.set(0.1);
	}

	public void stopMotor() {
		this.motor.stopMotor();
	}

	public double getPosition() {
		return this.motor.getPosition().getValueAsDouble();
	}

	public double getSpeed() {
		return this.motor.get();
	}

	public double getVoltage() {
		return this.motor.getMotorVoltage().getValueAsDouble();
	}

	public double getCurrent() {
		return this.motor.getMotorStallCurrent().getValueAsDouble();
	}

	public void logUpdates() {
		Logger.recordOutput("Position", this.getPosition());
		Logger.recordOutput("Speed", this.getSpeed());
		Logger.recordOutput("Voltage", this.getVoltage());
		Logger.recordOutput("Current", this.getCurrent());
		Logger.recordOutput("Connected", this.motor.isConnected());
	}

	public void periodicMotorFunctions() {
		if (!canMoveForward()) {
			this.stopMotor();
		}
	}

	public boolean canMoveForward() {
		return !(this.getPosition() - this.initialPos > 180.0 * 5.0);
	}


}
