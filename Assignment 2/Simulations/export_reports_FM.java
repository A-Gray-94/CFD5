// STAR-CCM+ macro: export_reports.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;

public class export_reports_FM extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    MonitorPlot monitorPlot_0 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CD Monitor Plot"));

    monitorPlot_0.export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\FM\\CD.csv"), ",");

    MonitorPlot monitorPlot_1 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CM Monitor Plot"));

    monitorPlot_1.export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\FM\\CM.csv"), ",");

    MonitorPlot monitorPlot_2 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("CL Monitor Plot"));

    monitorPlot_2.export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\FM\\CL.csv"), ",");

    MonitorPlot monitorPlot_3 = 
      ((MonitorPlot) simulation_0.getPlotManager().getPlot("Efficiency Monitor Plot"));

    monitorPlot_3.export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\FM\\LD.csv"), ",");
  }
}
