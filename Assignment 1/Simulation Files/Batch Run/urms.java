// STAR-CCM+ macro: urms.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class urms extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));

    UserFieldFunction userFieldFunction_0 = 
      ((UserFieldFunction) simulation_0.getFieldFunctionManager().getFunction("UserFieldFunction_4"));

    userFieldFunction_0.setDefinition("pow(2*${TurbulentKineticEnergy}/pow(3,0.5),0.5)\n");
  }
}
