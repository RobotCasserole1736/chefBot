package frc.robot;

import java.util.ArrayList;

import edu.wpi.first.wpilibj.Spark;

public class RobotHardwareOutputs{
    
    private static RobotHardwareOutputs instance = null;
	public static synchronized RobotHardwareOutputs getInstance() {
		if(instance == null){
            instance = new RobotHardwareOutputs();
        }
		return instance;
    }

    final int NUM_SPARKS = 10;
    ArrayList<Spark> sparkOutputs;


    private RobotHardwareOutputs(){
        sparkOutputs = new ArrayList<Spark>();
        for(int i = 0; i < NUM_SPARKS; i++){
            sparkOutputs.add(i, new Spark(i));
        }
    }

    public void setOutput(int idx, double value){
        sparkOutputs.get(idx).set(value);
    }

    public int getNumOutputs(){
        return NUM_SPARKS;
    }


}