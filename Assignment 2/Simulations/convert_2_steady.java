// STAR-CCM+ macro: convert_2_steady.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.flow.*;

public class convert_2_steady extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    ImplicitUnsteadyModel implicitUnsteadyModel_3 = 
      physicsContinuum_0.getModelManager().getModel(ImplicitUnsteadyModel.class);

    physicsContinuum_0.disableModel(implicitUnsteadyModel_3);

    physicsContinuum_0.enable(SteadyModel.class);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Fluid");

    Boundary boundary_6 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.bottom");

    VelocityProfile velocityProfile_0 = 
      boundary_6.getValues().get(VelocityProfile.class);

    velocityProfile_0.setMethod(ConstantVectorProfileMethod.class);

    Boundary boundary_7 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.in");

    VelocityProfile velocityProfile_1 = 
      boundary_7.getValues().get(VelocityProfile.class);

    velocityProfile_1.setMethod(ConstantVectorProfileMethod.class);

    Boundary boundary_8 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.top");

    VelocityProfile velocityProfile_2 = 
      boundary_8.getValues().get(VelocityProfile.class);

    velocityProfile_2.setMethod(ConstantVectorProfileMethod.class);

    Boundary boundary_9 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.out");

    StaticPressureProfile staticPressureProfile_0 = 
      boundary_9.getValues().get(StaticPressureProfile.class);

    staticPressureProfile_0.setMethod(ConstantScalarProfileMethod.class);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(true);
  }
}
