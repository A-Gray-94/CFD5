// STAR-CCM+ macro: cl_export.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.base.report.*;

public class cl_export extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    ReportMonitor reportMonitor_0 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("CL Monitor"));

    simulation_0.getMonitorManager().export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\CL_hist.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_0}));

    ReportMonitor reportMonitor_1 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("CL_Pressure Monitor"));

    simulation_0.getMonitorManager().export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\CLP_hist.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_1}));

    ReportMonitor reportMonitor_2 = 
      ((ReportMonitor) simulation_0.getMonitorManager().getMonitor("CL_Shear Monitor"));

    simulation_0.getMonitorManager().export(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\CLS_hist.csv"), ",", new NeoObjectVector(new Object[] {reportMonitor_2}));
  }
}
