package frc.robot;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;

import edu.wpi.first.wpilibj.Filesystem;
import interpreter.Chef;
import interpreter.ChefException;

public class RecipeBook {

  ArrayList<Chef> interpreterList;

  public RecipeBook() {
    interpreterList = new ArrayList<Chef>();

    File pathPrefix;
    if (Robot.isReal()) {
      pathPrefix = Path.of(Filesystem.getDeployDirectory().toString(), "tonightsMenu").toFile();
    } else {
      pathPrefix = new File("./src/main/deploy/tonightsMenu");
    }

    for (File fileToLoad : pathPrefix.listFiles()) {
      try {
        interpreterList.add(new Chef(fileToLoad.toString()));
        System.out.println("Loaded " + fileToLoad.toString());
      } catch (ChefException e) {
        System.out.println("Error while parsing " + fileToLoad.toString());
        System.out.println(e);
        e.printStackTrace();
      } catch (FileNotFoundException e) {
        System.out.println(e);
      }
    }
  }

  public void runAll(){
      for(Chef interpreter: interpreterList){
        try{
          interpreter.bake();
        } catch(ChefException e) {
          System.out.println("Error while executing " + interpreter.getSourceFile());
          System.out.println(e);
        }
      }
    }
}