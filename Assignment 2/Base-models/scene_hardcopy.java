// STAR-CCM+ macro: scene_hardcopy.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class scene_hardcopy extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Wall Shear Stress");

    scene_0.initializeAndWait();

    PartDisplayer partDisplayer_1 = 
      ((PartDisplayer) scene_0.getCreatorDisplayer());

    partDisplayer_1.initialize();

    PartDisplayer partDisplayer_0 = 
      ((PartDisplayer) scene_0.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_0.initialize();

    ScalarDisplayer scalarDisplayer_0 = 
      ((ScalarDisplayer) scene_0.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_0.initialize();

    StreamDisplayer streamDisplayer_0 = 
      ((StreamDisplayer) scene_0.getDisplayerManager().getDisplayer("Oil Streaklines"));

    streamDisplayer_0.initialize();

    StreamDisplayer streamDisplayer_1 = 
      ((StreamDisplayer) scene_0.getDisplayerManager().getDisplayer("Flow Streamlines"));

    streamDisplayer_1.initialize();

    VectorDisplayer vectorDisplayer_0 = 
      ((VectorDisplayer) scene_0.getDisplayerManager().getDisplayer("Vector 1"));

    vectorDisplayer_0.initialize();

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.44380256815598074, -0.22415810244508566, -0.0013232603194364635}), new DoubleVector(new double[] {0.9438025748865674, 0.641867297453447, -0.0013232603194364635}), new DoubleVector(new double[] {-0.8660253998985328, 0.5000000067305866, 0.0}), 0.0547552428844825, 1);

    FvRepresentation fvRepresentation_0 = 
      ((FvRepresentation) simulation_0.getRepresentationManager().getObject("Volume Mesh"));

    streamDisplayer_1.setRepresentation(fvRepresentation_0);

    streamDisplayer_0.setRepresentation(fvRepresentation_0);

    partDisplayer_0.setRepresentation(fvRepresentation_0);

    scalarDisplayer_0.setRepresentation(fvRepresentation_0);

    vectorDisplayer_0.setRepresentation(fvRepresentation_0);

    scalarDisplayer_0.setVisibilityOverrideMode(0);

    currentView_0.setInput(new DoubleVector(new double[] {0.44380256815598074, -0.22415810244508566, -0.0013232603194364635}), new DoubleVector(new double[] {0.9438025748865674, 0.641867297453447, -0.0013232603194364635}), new DoubleVector(new double[] {-0.8660253998985328, 0.5000000067305866, 0.0}), 0.0547552428844825, 1);

    scene_0.printAndWait(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Base-models\\base-model-PL-empty_Wall Shear Stress.png"), 1, 1067, 464);
  }
}
