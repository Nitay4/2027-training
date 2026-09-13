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
	private TalonFX motor;
	private int deviceId;

	public TalMotorControilMission(int deviceId) {
		this.motor = new TalonFX(deviceId);
		this.deviceId = deviceId;
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
        Logger.recordOutput("Position",this.getPosition());
        Logger.recordOutput("Speed",this.getSpeed());
        Logger.recordOutput("Voltage",this.getVoltage());
        Logger.recordOutput("Current",this.getCurrent());
    }



}
