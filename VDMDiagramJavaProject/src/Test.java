//
// THIS FILE IS AUTOMATICALLY GENERATED!!
//
// Generated at Thu 06-Dec-2012 by the VDM++ to JAVA Code Generator
// (v8.0 - Mon 09-Jul-2007 09:32:40)
//
// Supported compilers:
// jdk1.4
//

// ***** VDMTOOLS START Name=HeaderComment KEEP=NO
// ***** VDMTOOLS END Name=HeaderComment

// ***** VDMTOOLS START Name=package KEEP=NO
// ***** VDMTOOLS END Name=package

// ***** VDMTOOLS START Name=imports KEEP=NO

import jp.co.csk.vdm.toolbox.VDM.*;
import java.util.*;
import jp.co.csk.vdm.toolbox.VDM.jdk.*;
// ***** VDMTOOLS END Name=imports



public class Test implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=TestSentinel KEEP=NO
  class TestSentinel extends Sentinel {

    public final int Assert = 0;

    public final int nr_functions = 1;


    public TestSentinel () throws CGException {}


    public TestSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=TestSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new TestSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Test KEEP=NO
  public Test () throws CGException {
    try {
      setSentinel();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Test


// ***** VDMTOOLS START Name=Assert KEEP=NO
  public void Assert (final Boolean expression) throws CGException {

    sentinel.entering(((TestSentinel) sentinel).Assert);
    try {
      return;
    }
    finally {
      sentinel.leaving(((TestSentinel) sentinel).Assert);
    }
  }
// ***** VDMTOOLS END Name=Assert


// ***** VDMTOOLS START Name=pre_Assert KEEP=NO
  public Boolean pre_Assert (final Boolean expression) throws CGException {
    return expression;
  }
// ***** VDMTOOLS END Name=pre_Assert

}
;
