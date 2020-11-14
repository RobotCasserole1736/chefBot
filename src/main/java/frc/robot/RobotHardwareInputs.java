package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class RobotHardwareInputs{
    
    private static RobotHardwareInputs instance = null;
	public static synchronized RobotHardwareInputs getInstance() {
		if(instance == null){
            instance = new RobotHardwareInputs();
        }
		return instance;
    }

    final int NUM_SUPPORTED_INPUTS = 5;
    Joystick joyIn;


    private RobotHardwareInputs(){
        joyIn = new Joystick(0); 
    }

    public double getInput(int idx){
        double retVal = 0.0;
        switch(idx){
            case 0:
                retVal = joyIn.getY(Hand.kLeft);
            break;
            case 1:
                retVal = joyIn.getX(Hand.kRight);
            break;
            case 2:
                retVal = joyIn.getRawButton(1) ? 1.0 : 0.0;
            break;
            case 3:
                retVal = joyIn.getRawButton(2) ? 1.0 : 0.0;
            break;
            case 4:
                retVal = joyIn.getRawButton(3) ? 1.0 : 0.0;
            break;
            default: //ummmm nothing?
            break;
        }
        return retVal;
    }

    public int getNumInputs(){
        return NUM_SUPPORTED_INPUTS;
    }


}