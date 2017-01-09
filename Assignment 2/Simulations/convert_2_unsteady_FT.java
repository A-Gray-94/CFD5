// STAR-CCM+ macro: convert_2_unsteady.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.flow.*;

public class convert_2_unsteady_FT extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    PhysicsContinuum physicsContinuum_0 = 
      ((PhysicsContinuum) simulation_0.getContinuumManager().getContinuum("Physics 1"));

    SteadyModel steadyModel_1 = 
      physicsContinuum_0.getModelManager().getModel(SteadyModel.class);

    physicsContinuum_0.disableModel(steadyModel_1);

    physicsContinuum_0.enable(ImplicitUnsteadyModel.class);

    ImplicitUnsteadySolver implicitUnsteadySolver_0 = 
      ((ImplicitUnsteadySolver) simulation_0.getSolverManager().getSolver(ImplicitUnsteadySolver.class));

    implicitUnsteadySolver_0.getTimeStep().setValue(0.02);

    implicitUnsteadySolver_0.getTimeDiscretizationOption().setSelected(TimeDiscretizationOption.SECOND_ORDER);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Fluid");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.bottom");

    VelocityProfile velocityProfile_0 = 
      boundary_1.getValues().get(VelocityProfile.class);

    velocityProfile_0.setMethod(FunctionVectorProfileMethod.class);

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.in");

    VelocityProfile velocityProfile_1 = 
      boundary_2.getValues().get(VelocityProfile.class);

    velocityProfile_1.setMethod(FunctionVectorProfileMethod.class);

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.top");

    VelocityProfile velocityProfile_2 = 
      boundary_3.getValues().get(VelocityProfile.class);

    velocityProfile_2.setMethod(FunctionVectorProfileMethod.class);

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.out");

    StaticPressureProfile staticPressureProfile_0 = 
      boundary_0.getValues().get(StaticPressureProfile.class);

    staticPressureProfile_0.setMethod(FunctionScalarProfileMethod.class);

    InnerIterationStoppingCriterion innerIterationStoppingCriterion_0 = 
      ((InnerIterationStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Inner Iterations"));

    innerIterationStoppingCriterion_0.setMaximumNumberInnerIterations(50);

    PhysicalTimeStoppingCriterion physicalTimeStoppingCriterion_0 = 
      ((PhysicalTimeStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Physical Time"));

    physicalTimeStoppingCriterion_0.getMaximumTime().setValue(8.0);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(false);
  }
}
