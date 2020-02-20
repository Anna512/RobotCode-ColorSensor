/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.util.Color;
import com.revrobotics.ColorSensorV3; 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class ColorSensor extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private final I2C.Port i2cPort = I2C.Port.kOnboard;
  private final ColorSensorV3 colorReadingSensor = new ColorSensorV3(i2cPort);

  public void robotPeriodic() {
    Color detectedColor = colorReadingSensor.getColor();
    double IR = colorReadingSensor.getIR();
    SmartDashboard.putNumber("Red", detectedColor.red);
    SmartDashboard.putNumber("Green", detectedColor.green);
    SmartDashboard.putNumber("Blue", detectedColor.blue);
    SmartDashboard.putNumber("IR", IR);
    int proximity = colorReadingSensor.getProximity();
    SmartDashboard.putNumber("Proximity", proximity);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
