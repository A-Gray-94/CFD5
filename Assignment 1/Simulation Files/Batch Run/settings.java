// STAR-CCM+ macro: settings.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.coupledflow.*;

public class settings extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    CoupledImplicitSolver coupledImplicitSolver_0 = 
      ((CoupledImplicitSolver) simulation_0.getSolverManager().getSolver(CoupledImplicitSolver.class));

    AMGLinearSolver aMGLinearSolver_0 = 
      coupledImplicitSolver_0.getAMGLinearSolver();

    aMGLinearSolver_0.setConvergeTol(0.1);

    coupledImplicitSolver_0.setCFL(100.0);

    coupledImplicitSolver_0.getRampCalculatorManager().getRampCalculatorOption().setSelected(RampCalculatorOption.LINEAR_RAMP);

    LinearRampCalculator linearRampCalculator_0 = 
      ((LinearRampCalculator) coupledImplicitSolver_0.getRampCalculatorManager().getCalculator());

    linearRampCalculator_0.setEndIteration(200);

    linearRampCalculator_0.setInitialRampValue(1.0);

    StepStoppingCriterion stepStoppingCriterion_0 = 
      ((StepStoppingCriterion) simulation_0.getSolverStoppingCriterionManager().getSolverStoppingCriterion("Maximum Steps"));

    stepStoppingCriterion_0.setIsUsed(true);

    stepStoppingCriterion_0.setMaximumNumberSteps(10000);

}
}