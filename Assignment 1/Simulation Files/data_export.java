// STAR-CCM+ macro: data_export.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.base.report.*;


public class data_export extends StarMacro {

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

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_1, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\cp_chamfer.csv"), ",");

    InternalDataSet internalDataSet_2 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("Region: Body 1.lower"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_2, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\cp_lower.csv"), ",");

    XYPlot xYPlot_1 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Post Attachment RMS Velocity"));

    YAxisType yAxisType_0 = 
      ((YAxisType) xYPlot_1.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_0 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("x/c = 0.5"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.5c_urms.csv"), ",");

    InternalDataSet internalDataSet_1 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("x/c = 0.625"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_1, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.625c_urms.csv"), ",");

    InternalDataSet internalDataSet_2 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("x/c = 0.75"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_2, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.75c_urms.csv"), ",");

    InternalDataSet internalDataSet_3 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("x/c = 0.875"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_3, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.875c_urms.csv"), ",");

    InternalDataSet internalDataSet_4 = 
      ((InternalDataSet) yAxisType_0.getDataSetManager().getDataSet("x/c = 1"));

    yAxisType_0.getDataSetManager().writeCSVDataSet(internalDataSet_4, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\1c_urms.csv"), ",");

    XYPlot xYPlot_2 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Post Attachment TKE"));

    YAxisType yAxisType_1 = 
      ((YAxisType) xYPlot_2.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_5 = 
      ((InternalDataSet) yAxisType_1.getDataSetManager().getDataSet("x/c = 0.5"));

    yAxisType_1.getDataSetManager().writeCSVDataSet(internalDataSet_5, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.5c_tke.csv"), ",");

    InternalDataSet internalDataSet_6 = 
      ((InternalDataSet) yAxisType_1.getDataSetManager().getDataSet("x/c = 0.625"));

    yAxisType_1.getDataSetManager().writeCSVDataSet(internalDataSet_6, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.625c_tke.csv"), ",");

    InternalDataSet internalDataSet_7 = 
      ((InternalDataSet) yAxisType_1.getDataSetManager().getDataSet("x/c = 0.75"));

    yAxisType_1.getDataSetManager().writeCSVDataSet(internalDataSet_7, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.75c_tke.csv"), ",");

    InternalDataSet internalDataSet_8 = 
      ((InternalDataSet) yAxisType_1.getDataSetManager().getDataSet("x/c = 0.875"));

    yAxisType_1.getDataSetManager().writeCSVDataSet(internalDataSet_8, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.875c_tke.csv"), ",");

    InternalDataSet internalDataSet_9 = 
      ((InternalDataSet) yAxisType_1.getDataSetManager().getDataSet("x/c = 1"));

    yAxisType_1.getDataSetManager().writeCSVDataSet(internalDataSet_9, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\1c_tke.csv"), ",");

    XYPlot xYPlot_3 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Post Attachment Velocity Profiles"));

    YAxisType yAxisType_2 = 
      ((YAxisType) xYPlot_3.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_10 = 
      ((InternalDataSet) yAxisType_2.getDataSetManager().getDataSet("x/c = 0.5"));

    yAxisType_2.getDataSetManager().writeCSVDataSet(internalDataSet_10, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.5c_u.csv"), ",");

    InternalDataSet internalDataSet_11 = 
      ((InternalDataSet) yAxisType_2.getDataSetManager().getDataSet("x/c = 0.625"));

    yAxisType_2.getDataSetManager().writeCSVDataSet(internalDataSet_11, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.625c_u.csv"), ",");

    InternalDataSet internalDataSet_12 = 
      ((InternalDataSet) yAxisType_2.getDataSetManager().getDataSet("x/c = 0.75"));

    yAxisType_2.getDataSetManager().writeCSVDataSet(internalDataSet_12, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.75c_u.csv"), ",");

    InternalDataSet internalDataSet_13 = 
      ((InternalDataSet) yAxisType_2.getDataSetManager().getDataSet("x/c = 0.875"));

    yAxisType_2.getDataSetManager().writeCSVDataSet(internalDataSet_13, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.875c_u.csv"), ",");

    InternalDataSet internalDataSet_14 = 
      ((InternalDataSet) yAxisType_2.getDataSetManager().getDataSet("x/c = 1"));

    yAxisType_2.getDataSetManager().writeCSVDataSet(internalDataSet_14, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\1c_u.csv"), ",");

    XYPlot xYPlot_4 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Pre Attachment RMS Velocity"));

    YAxisType yAxisType_3 = 
      ((YAxisType) xYPlot_4.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_15 = 
      ((InternalDataSet) yAxisType_3.getDataSetManager().getDataSet("x/c = 0.031"));

    yAxisType_3.getDataSetManager().writeCSVDataSet(internalDataSet_15, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.031c_urms.csv"), ",");

    InternalDataSet internalDataSet_16 = 
      ((InternalDataSet) yAxisType_3.getDataSetManager().getDataSet("x/c = 0.125"));

    yAxisType_3.getDataSetManager().writeCSVDataSet(internalDataSet_16, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.125c_urms.csv"), ",");

    InternalDataSet internalDataSet_17 = 
      ((InternalDataSet) yAxisType_3.getDataSetManager().getDataSet("x/c = 0.25"));

    yAxisType_3.getDataSetManager().writeCSVDataSet(internalDataSet_17, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.25c_urms.csv"), ",");

    InternalDataSet internalDataSet_18 = 
      ((InternalDataSet) yAxisType_3.getDataSetManager().getDataSet("x/c = 0.375"));

    yAxisType_3.getDataSetManager().writeCSVDataSet(internalDataSet_18, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.375c_urms.csv"), ",");

    XYPlot xYPlot_5 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Pre Attachment TKE"));

    YAxisType yAxisType_4 = 
      ((YAxisType) xYPlot_5.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_19 = 
      ((InternalDataSet) yAxisType_4.getDataSetManager().getDataSet("x/c = 0.031"));

    yAxisType_4.getDataSetManager().writeCSVDataSet(internalDataSet_19, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.031c_tke.csv"), ",");

    InternalDataSet internalDataSet_20 = 
      ((InternalDataSet) yAxisType_4.getDataSetManager().getDataSet("x/c = 0.125"));

    yAxisType_4.getDataSetManager().writeCSVDataSet(internalDataSet_20, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.125c_tke.csv"), ",");

    InternalDataSet internalDataSet_21 = 
      ((InternalDataSet) yAxisType_4.getDataSetManager().getDataSet("x/c = 0.25"));

    yAxisType_4.getDataSetManager().writeCSVDataSet(internalDataSet_21, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.25c_tke.csv"), ",");

    InternalDataSet internalDataSet_22 = 
      ((InternalDataSet) yAxisType_4.getDataSetManager().getDataSet("x/c = 0.375"));

    yAxisType_4.getDataSetManager().writeCSVDataSet(internalDataSet_22, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.375c_tke.csv"), ",");

    XYPlot xYPlot_6 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Pre Attachment Velocity Profiles"));

    YAxisType yAxisType_5 = 
      ((YAxisType) xYPlot_6.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_23 = 
      ((InternalDataSet) yAxisType_5.getDataSetManager().getDataSet("x/c = 0.031"));

    yAxisType_5.getDataSetManager().writeCSVDataSet(internalDataSet_23, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.031c_u.csv"), ",");

    InternalDataSet internalDataSet_24 = 
      ((InternalDataSet) yAxisType_5.getDataSetManager().getDataSet("x/c = 0.125"));

    yAxisType_5.getDataSetManager().writeCSVDataSet(internalDataSet_24, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.125c_u.csv"), ",");

    InternalDataSet internalDataSet_25 = 
      ((InternalDataSet) yAxisType_5.getDataSetManager().getDataSet("x/c = 0.25"));

    yAxisType_5.getDataSetManager().writeCSVDataSet(internalDataSet_25, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.25c_u.csv"), ",");

    InternalDataSet internalDataSet_26 = 
      ((InternalDataSet) yAxisType_5.getDataSetManager().getDataSet("x/c = 0.375"));

    yAxisType_5.getDataSetManager().writeCSVDataSet(internalDataSet_26, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\0.375c_u.csv"), ",");

    XYPlot xYPlot_0 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Upper Surface Cf"));

    YAxisType yAxisType_6 = 
      ((YAxisType) xYPlot_0.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_27 = 
      ((InternalDataSet) yAxisType_6.getDataSetManager().getDataSet("Region: Body 1.upper"));

    yAxisType_6.getDataSetManager().writeCSVDataSet(internalDataSet_27, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\upper_cf.csv"), ",");

    XYPlot xYPlot_7 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Upper Surface Chordwise Shear Stress"));

    YAxisType yAxisType_7 = 
      ((YAxisType) xYPlot_7.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_28 = 
      ((InternalDataSet) yAxisType_7.getDataSetManager().getDataSet("Region: Body 1.upper"));

    yAxisType_7.getDataSetManager().writeCSVDataSet(internalDataSet_28, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\upper_tau.csv"), ",");

    XYPlot xYPlot_8 = 
      ((XYPlot) simulation_0.getPlotManager().getPlot("Wall Y+"));

    YAxisType yAxisType_8 = 
      ((YAxisType) xYPlot_8.getYAxes().getAxisType("Y Type 1"));

    InternalDataSet internalDataSet_29 = 
      ((InternalDataSet) yAxisType_8.getDataSetManager().getDataSet("Region: Body 1.upper"));

    yAxisType_8.getDataSetManager().writeCSVDataSet(internalDataSet_29, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th Year\\CFD 5\\Assignment 1\\Simulation Files\\Data Export\\upper_y+.csv"), ",");

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
