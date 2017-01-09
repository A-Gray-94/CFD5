// STAR-CCM+ macro: export_animations.java
// Written by STAR-CCM+ 10.04.008
package macro;

import java.util.*;

import star.common.*;
import star.base.neo.*;
import star.vis.*;
import star.flow.*;
import star.post.*;

public class export_animations_CM extends StarMacro {

  public void execute() {
    execute0();
  }

  private void execute0() {

    Simulation simulation_0 = 
      getActiveSimulation();

    Scene scene_0 = 
      simulation_0.getSceneManager().getScene("Normalised Velocity");

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

    scene_0.open(true);

    CurrentView currentView_0 = 
      scene_0.getCurrentView();

    currentView_0.setInput(new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, 0.0030673099279218685}), new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, -0.9969326900720781}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.06349979763655418, 1);

    SimpleAnnotation simpleAnnotation_0 = 
      ((SimpleAnnotation) simulation_0.getAnnotationManager().getObject("CD"));

    scene_0.getAnnotationPropManager().removePropForAnnotation(simpleAnnotation_0);

    FixedAspectAnnotationProp fixedAspectAnnotationProp_0 = 
      (FixedAspectAnnotationProp) scene_0.getAnnotationPropManager().createPropForAnnotation(simpleAnnotation_0);

    scene_0.getAnnotationPropManager().removePropForAnnotation(simpleAnnotation_0);

    simpleAnnotation_0.setText("CD = $CDReport");

    FixedAspectAnnotationProp fixedAspectAnnotationProp_1 = 
      (FixedAspectAnnotationProp) scene_0.getAnnotationPropManager().createPropForAnnotation(simpleAnnotation_0);

    scalarDisplayer_0.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 1.5}));

    scalarDisplayer_0.getScalarDisplayQuantity().setClip(0);

    currentView_0.setInput(new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, 0.0030673099279218685}), new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, -0.9969326900720781}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.06349979763655418, 1);

    SolutionHistory solutionHistory_0 = 
      ((SolutionHistory) simulation_0.get(SolutionHistoryManager.class).getObject("DWing-waves-CM"));

    RecordedSolutionView recordedSolutionView_0 = 
      solutionHistory_0.createRecordedSolutionView();

    SolutionRepresentation solutionRepresentation_0 = 
      ((SolutionRepresentation) simulation_0.getRepresentationManager().getObject("DWing-waves-CM"));

    partDisplayer_0.setRepresentation(solutionRepresentation_0);

    scalarDisplayer_0.setRepresentation(solutionRepresentation_0);

    SolutionStateAnnotationProp solutionStateAnnotationProp_0 = 
      ((SolutionStateAnnotationProp) scene_0.getAnnotationPropManager().getAnnotationProp("Solution Time"));

    solutionStateAnnotationProp_0.setRepresentation(solutionRepresentation_0);

    SolutionAnimation solutionAnimation_0 = 
      recordedSolutionView_0.getSolutionAnimation();

    solutionAnimation_0.setAnimationMode(3);

    AnimationDirector animationDirector_0 = 
      scene_0.getAnimationDirector();

    animationDirector_0.setIsRecording(true);

    animationDirector_0.record(1920, 1080, 25.0, 0.0, 10.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\Normalised Velocity"), 1);

    animationDirector_0.setIsRecording(false);

    scene_0.close(true);

    Scene scene_1 = 
      simulation_0.getSceneManager().getScene("CP");

    scene_1.initializeAndWait();

    scene_1.open(true);

    PartDisplayer partDisplayer_3 = 
      ((PartDisplayer) scene_1.getCreatorDisplayer());

    partDisplayer_3.initialize();

    PartDisplayer partDisplayer_2 = 
      ((PartDisplayer) scene_1.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_2.initialize();

    ScalarDisplayer scalarDisplayer_1 = 
      ((ScalarDisplayer) scene_1.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_1.initialize();

    CurrentView currentView_1 = 
      scene_1.getCurrentView();

    currentView_1.setInput(new DoubleVector(new double[] {0.44697007330318467, -0.22566568796068795, 0.02323358338204934}), new DoubleVector(new double[] {0.5077017413284398, -0.12047535331253968, 0.02323358338204934}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.031708293498035285, 0);

    currentView_1.setInput(new DoubleVector(new double[] {0.44697007330318467, -0.22566568796068795, 0.02323358338204934}), new DoubleVector(new double[] {0.5067790908400509, -0.12207343080737498, 0.044325470060958286}), new DoubleVector(new double[] {0.08682408885122124, 0.1503837305120674, -0.9848077534181122}), 0.03170829349803529, 0);

    currentView_1.setInput(new DoubleVector(new double[] {0.44697007330318467, -0.22566568796068795, 0.02323358338204934}), new DoubleVector(new double[] {0.5040391736866141, -0.1268191064186008, 0.06477649015792142}), new DoubleVector(new double[] {0.171010066498029, 0.2961981278275689, -0.9396926232698557}), 0.03170829349803529, 0);

    currentView_1.setInput(new DoubleVector(new double[] {0.44697007330318467, -0.22566568796068795, 0.02323358338204934}), new DoubleVector(new double[] {0.4995652410371004, -0.13456818593333295, 0.08396525106816304}), new DoubleVector(new double[] {0.2499999903062041, 0.4330127042648601, -0.8660254053964762}), 0.03170829349803529, 0);

    currentView_1.setInput(new DoubleVector(new double[] {0.44697007330318467, -0.22566568796068795, 0.02323358338204934}), new DoubleVector(new double[] {0.49349323078640567, -0.1450852165197285, 0.10130871030902498}), new DoubleVector(new double[] {0.3213937966666064, 0.5566703990277092, -0.7660444466938947}), 0.031708293498035285, 0);

    partDisplayer_2.setVisibilityOverrideMode(0);

    Region region_0 = 
      simulation_0.getRegionManager().getRegion("Fluid");

    Boundary boundary_0 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.LE-lower");

    Boundary boundary_1 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.LE-upper");

    Boundary boundary_2 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.TE-lower");

    Boundary boundary_3 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.TE-upper");

    Boundary boundary_4 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.wing-lower");

    Boundary boundary_5 = 
      region_0.getBoundaryManager().getBoundary("fluid domain.wing-upper");

    partDisplayer_2.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5);

    LabCoordinateSystem labCoordinateSystem_0 = 
      simulation_0.getCoordinateSystemManager().getLabCoordinateSystem();

    CartesianCoordinateSystem cartesianCoordinateSystem_0 = 
      ((CartesianCoordinateSystem) labCoordinateSystem_0.getLocalCoordinateSystemManager().getObject("wing coordiantes"));

    currentView_1.setCoordinateSystem(cartesianCoordinateSystem_0);

    currentView_1.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    Legend legend_0 = 
      scalarDisplayer_1.getLegend();

    legend_0.updateLayout(new DoubleVector(new double[] {0.13722943722943737, 0.0673611111111111}), 0.5999999999999994, 0.043999999999999984, 0);

    legend_0.updateLayout(new DoubleVector(new double[] {0.14502164502164516, 0.0673611111111111}), 0.6000000000000003, 0.043999999999999984, 0);

    scalarDisplayer_1.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-3.0, 1.0}));

    partDisplayer_2.setRepresentation(solutionRepresentation_0);

    scalarDisplayer_1.setRepresentation(solutionRepresentation_0);

    SolutionStateAnnotationProp solutionStateAnnotationProp_1 = 
      ((SolutionStateAnnotationProp) scene_1.getAnnotationPropManager().getAnnotationProp("Solution Time"));

    solutionStateAnnotationProp_1.setRepresentation(solutionRepresentation_0);

    AnimationDirector animationDirector_1 = 
      scene_1.getAnimationDirector();

    animationDirector_1.setIsRecording(true);

    animationDirector_1.record(1920, 1080, 25.0, 0.0, 10.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\Surface Pressure"), 1);

    animationDirector_1.setIsRecording(false);

    scene_1.close(true);

    Scene scene_2 = 
      simulation_0.getSceneManager().getScene("CF");

    scene_2.initializeAndWait();

    PartDisplayer partDisplayer_5 = 
      ((PartDisplayer) scene_2.getCreatorDisplayer());

    partDisplayer_5.initialize();

    PartDisplayer partDisplayer_4 = 
      ((PartDisplayer) scene_2.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_4.initialize();

    ScalarDisplayer scalarDisplayer_2 = 
      ((ScalarDisplayer) scene_2.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_2.initialize();

    scene_2.open(true);

    CurrentView currentView_2 = 
      scene_2.getCurrentView();

    currentView_2.setInput(new DoubleVector(new double[] {0.4396747527927139, -0.22134178717260566, -0.0016440059078331394}), new DoubleVector(new double[] {0.9394872135059904, 0.6443587735010188, -0.0016440059078331394}), new DoubleVector(new double[] {-0.8660253998985328, 0.5000000067305866, 0.0}), 0.06625041191093173, 1);

    currentView_2.setCoordinateSystem(cartesianCoordinateSystem_0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    Legend legend_1 = 
      scalarDisplayer_2.getLegend();

    legend_1.updateLayout(new DoubleVector(new double[] {0.036838551396610575, 0.13854166666666615}), 0.6000000000000001, 0.04400000000000026, 0);

    partDisplayer_4.setVisibilityOverrideMode(0);

    partDisplayer_4.getInputParts().setObjects(boundary_0, boundary_1, boundary_2, boundary_3, boundary_4, boundary_5);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 0.2}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 0.1}));

    PrimitiveFieldFunction primitiveFieldFunction_0 = 
      ((PrimitiveFieldFunction) simulation_0.getFieldFunctionManager().getFunction("WallShearStress"));

    VectorComponentFieldFunction vectorComponentFieldFunction_0 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getComponentFunction(2));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-5.0, 13.657176490612613}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-5.0, 5.0}));

    VectorComponentFieldFunction vectorComponentFieldFunction_1 = 
      ((VectorComponentFieldFunction) primitiveFieldFunction_0.getFunctionInCoordinateSystem(cartesianCoordinateSystem_0).getComponentFunction(1));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_1);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-2.464756008938704, 5.0}));

    SkinFrictionCoefficientFunction skinFrictionCoefficientFunction_0 = 
      ((SkinFrictionCoefficientFunction) simulation_0.getFieldFunctionManager().getFunction("SkinFrictionCoefficient"));

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(skinFrictionCoefficientFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 0.24605931932723665}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 0.15}));

    SymmetricRepeat symmetricRepeat_0 = 
      ((SymmetricRepeat) simulation_0.getTransformManager().getObject("fluid domain.sym 2"));

    partDisplayer_4.setVisTransform(symmetricRepeat_0);

    partDisplayer_4.setRepresentation(solutionRepresentation_0);

    scalarDisplayer_2.setRepresentation(solutionRepresentation_0);

    SolutionStateAnnotationProp solutionStateAnnotationProp_2 = 
      ((SolutionStateAnnotationProp) scene_2.getAnnotationPropManager().getAnnotationProp("Solution Time"));

    solutionStateAnnotationProp_2.setRepresentation(solutionRepresentation_0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    AnimationDirector animationDirector_2 = 
      scene_2.getAnimationDirector();

    animationDirector_2.setIsRecording(true);

    animationDirector_2.record(1920, 1080, 25.0, 0.0, 5.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\CF"), 1);

    animationDirector_2.setIsRecording(false);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {0.0, 0.05}));

    PhysicalTimeStateSelector physicalTimeStateSelector_0 = 
      recordedSolutionView_0.getPhysicalTimeStateSelector();

    physicalTimeStateSelector_0.getPhysicalTimeQuantity().setValue(1.0);

    currentView_2.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    scalarDisplayer_2.getScalarDisplayQuantity().setFieldFunction(vectorComponentFieldFunction_0);

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-2.5, 13.644426696898206}));

    scalarDisplayer_2.getScalarDisplayQuantity().setRange(new DoubleVector(new double[] {-2.5, 10.0}));

    animationDirector_2.setIsRecording(true);

    animationDirector_2.record(1920, 1080, 25.0, 0.0, 5.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\CF"), 1);

    animationDirector_2.setIsRecording(false);

    scene_2.close(true);

    Scene scene_3 = 
      simulation_0.getSceneManager().getScene("Streaklines");

    scene_3.initializeAndWait();

    scene_3.open(true);

    PartDisplayer partDisplayer_7 = 
      ((PartDisplayer) scene_3.getCreatorDisplayer());

    partDisplayer_7.initialize();

    PartDisplayer partDisplayer_6 = 
      ((PartDisplayer) scene_3.getDisplayerManager().getDisplayer("Outline 1"));

    partDisplayer_6.initialize();

    ScalarDisplayer scalarDisplayer_3 = 
      ((ScalarDisplayer) scene_3.getDisplayerManager().getDisplayer("Scalar 1"));

    scalarDisplayer_3.initialize();

    StreamDisplayer streamDisplayer_0 = 
      ((StreamDisplayer) scene_3.getDisplayerManager().getDisplayer("Oil Streaklines"));

    streamDisplayer_0.initialize();

    StreamDisplayer streamDisplayer_1 = 
      ((StreamDisplayer) scene_3.getDisplayerManager().getDisplayer("Flow Streamlines"));

    streamDisplayer_1.initialize();

    VectorDisplayer vectorDisplayer_0 = 
      ((VectorDisplayer) scene_3.getDisplayerManager().getDisplayer("Vector 1"));

    vectorDisplayer_0.initialize();

    CurrentView currentView_3 = 
      scene_3.getCurrentView();

    currentView_3.setInput(new DoubleVector(new double[] {0.44380256815598074, -0.22415810244508566, -0.0013232603194364635}), new DoubleVector(new double[] {0.9438025748865674, 0.641867297453447, -0.0013232603194364635}), new DoubleVector(new double[] {-0.8660253998985328, 0.5000000067305866, 0.0}), 0.0547552428844825, 1);

    currentView_3.setCoordinateSystem(cartesianCoordinateSystem_0);

    currentView_3.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    partDisplayer_6.setOutline(true);

    IdentityTransform identityTransform_0 = 
      ((IdentityTransform) simulation_0.getTransformManager().getObject("Identity"));

    partDisplayer_6.setVisTransform(identityTransform_0);

    streamDisplayer_0.setVisTransform(identityTransform_0);

    GraphicsSymmetricRepeat graphicsSymmetricRepeat_0 = 
      ((GraphicsSymmetricRepeat) simulation_0.getTransformManager().getObject("Symmetry"));

    partDisplayer_6.setVisTransform(graphicsSymmetricRepeat_0);

    streamDisplayer_0.setVisTransform(graphicsSymmetricRepeat_0);

    currentView_3.setCoordinateSystem(cartesianCoordinateSystem_0);

    currentView_3.setInput(new DoubleVector(new double[] {0.445009960080313, -0.2250777507739202, -7.391996303184121E-4}), new DoubleVector(new double[] {0.541147111202406, -0.05856332053552721, -7.391996303184121E-4}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.050193665067401964, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.44353924955508656, -0.2365147291561729, 0.003964451580985929}), new DoubleVector(new double[] {0.5353865575351469, -0.07743052519628144, 0.003964451580985929}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.04795391750519865, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.44826931246683654, -0.22767680298508114, 5.770629350327072E-4}), new DoubleVector(new double[] {0.5351071704284909, -0.07726922097504557, 5.770629350327072E-4}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.045338459761121885, 0);

    currentView_3.setInput(new DoubleVector(new double[] {0.44583945808587133, -0.22676930289683217, 1.3739539876849024E-4}), new DoubleVector(new double[] {0.54149888543067, -0.061082314512696495, 1.3739539876849024E-4}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.04994424320506919, 0);

    currentView_3.setCoordinateSystem(cartesianCoordinateSystem_0);

    currentView_3.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    partDisplayer_6.setRepresentation(solutionRepresentation_0);

    scalarDisplayer_3.setRepresentation(solutionRepresentation_0);

    streamDisplayer_0.setRepresentation(solutionRepresentation_0);

    streamDisplayer_1.setRepresentation(solutionRepresentation_0);

    vectorDisplayer_0.setRepresentation(solutionRepresentation_0);

    SolutionStateAnnotationProp solutionStateAnnotationProp_3 = 
      ((SolutionStateAnnotationProp) scene_3.getAnnotationPropManager().getAnnotationProp("Solution Time"));

    solutionStateAnnotationProp_3.setRepresentation(solutionRepresentation_0);

    currentView_3.setInput(new DoubleVector(new double[] {0.4475671841219107, -0.2273137007492091, 0.020824341981608784}), new DoubleVector(new double[] {0.5033619894102255, -0.13067426319143516, 0.020824341981608784}), new DoubleVector(new double[] {0.0, 0.0, -1.0}), 0.02913073391977171, 0);

    AnimationDirector animationDirector_3 = 
      scene_3.getAnimationDirector();

    animationDirector_3.setIsRecording(true);

    animationDirector_3.record(1920, 1080, 25.0, 0.0, 5.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\streaklines"), 1);

    animationDirector_3.setIsRecording(false);

    scene_1.open(true);

    currentView_1.setCoordinateSystem(labCoordinateSystem_0);

    currentView_1.setInput(new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, 0.0030673099279218685}), new DoubleVector(new double[] {0.4850064074687024, -0.21109422617780835, -0.9969326900720781}), new DoubleVector(new double[] {0.0, 1.0, 0.0}), 0.06349979763655418, 1);

    legend_0.updateLayout(new DoubleVector(new double[] {0.04112554112554123, 0.8503472222222218}), 0.6, 0.04400000000000004, 0);

    animationDirector_1.setIsRecording(true);

    animationDirector_1.record(1920, 1080, 25.0, 0.0, 5.0, resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\sym pressure"), 1);

    scene_3.close(true);

    animationDirector_1.setIsRecording(false);

    scene_1.close(true);

    HistogramPlot histogramPlot_0 = 
      ((HistogramPlot) simulation_0.getPlotManager().getPlot("wall Y+ Histogram"));

    histogramPlot_0.open();

    FvRepresentation fvRepresentation_0 = 
      ((FvRepresentation) simulation_0.getRepresentationManager().getObject("Volume Mesh"));

    histogramPlot_0.setRepresentation(fvRepresentation_0);

    histogramPlot_0.encode(resolvePath("C:\\Users\\Ali\\Documents\\MEGA\\University\\5th_Year\\CFD 5\\Assignment 2\\Simulations\\CM\\wall Y+ Histogram.png"), "png", 1156, 577);
  }
}
