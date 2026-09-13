package frc.robot;

import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import frc.robot.hardware.phoenix6.Phoenix6DeviceID;
import org.littletonrobotics.junction.Logger;

public class TalMotorControilMission {

	private String logpath;
	private TalonFX talonMotor;
	private int deviceId;

	public TalMotorControilMission(int deviceId) {
		String logPath = "forLogPath";
		Phoenix6DeviceID deviceID = new Phoenix6DeviceID(1);
		SysIdRoutine.Config config = new SysIdRoutine.Config();
		this.talonMotor = new TalonFX(deviceId);
		this.deviceId = deviceId;
	}

	public void MoveForwardHalfPower() {
		this.talonMotor.set(0.5);
	}

	public void MoveForwardTenthPower() {
		this.talonMotor.set(0.1);
	}

	public void stopMotor() {
		this.talonMotor.stopMotor();
	}

	public StatusSignal<Angle> getPosition(TalonFX motor) {
		return motor.getPosition();
	}

	public double getSpeed(TalonFX motor) {
		return motor.get();
	}

	public StatusSignal<Voltage> getVoltage(TalonFX motor) {
		return motor.getMotorVoltage();
	}

	public StatusSignal<Current> getCurrent(TalonFX motor) {
		return motor.getMotorStallCurrent();
	}


}
