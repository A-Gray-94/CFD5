// STAR-CCM+ macro: settings2.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;

public class settings2 extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("CP"));

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_0 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("Region: Body 1.upper"));

    LineStyle lineStyle_0 = 
      internalDataSet_0.getLineStyle();

    lineStyle_0.setWidth(1);

    SymbolStyle symbolStyle_0 = 
      internalDataSet_0.getSymbolStyle();

    symbolStyle_0.setSize(6);

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\cp_upper.csv"), ",");

    InternalDataSet internalDataSet_1 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("Region: Body 1.chamfer"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_1, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\cp_lower.csv"), ",");

    InternalDataSet internalDataSet_2 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("Region: Body 1.lower"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_2, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\cp_loower.csv"), ",");

    Units units_0 = 
      simulation_0.getUnitsManager().getPreferredUnits(new IntVector(new int[] {0, 2, -2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
  }
}
