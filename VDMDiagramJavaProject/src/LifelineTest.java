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



public class LifelineTest extends Test {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp


// ***** VDMTOOLS START Name=LifelineTestSentinel KEEP=NO
  class LifelineTestSentinel extends TestSentinel {

    public final int oneLifeline = 1;

    public final int nr_functions = 2;


    public LifelineTestSentinel () throws CGException {}


    public LifelineTestSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=LifelineTestSentinel
;

// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new LifelineTestSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=LifelineTest KEEP=NO
  public LifelineTest () throws CGException {}
// ***** VDMTOOLS END Name=LifelineTest


// ***** VDMTOOLS START Name=oneLifeline KEEP=NO
  public void oneLifeline () throws CGException {

    sentinel.entering(((LifelineTestSentinel) sentinel).oneLifeline);
    try {

      Lifeline l = new Lifeline(new String("aLifeline"));
      Boolean tmpArg_v_3 = null;
      String var1_4 = null;
      var1_4 = l.name;
      tmpArg_v_3 = new Boolean(UTIL.equals(var1_4, new String("aLifeline")));
      Assert(tmpArg_v_3);
    }
    finally {
      sentinel.leaving(((LifelineTestSentinel) sentinel).oneLifeline);
    }
  }
// ***** VDMTOOLS END Name=oneLifeline

}
;
