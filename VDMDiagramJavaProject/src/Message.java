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



public class Message implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=identifier KEEP=NO
  public volatile Integer identifier = null;
// ***** VDMTOOLS END Name=identifier

// ***** VDMTOOLS START Name=text KEEP=NO
  public volatile String text = null;
// ***** VDMTOOLS END Name=text

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=MessageSentinel KEEP=NO
  class MessageSentinel extends Sentinel {

    public final int Message_u_u1_uN = 0;

    public final int Message_u_u2_uN_us_uC = 1;

    public final int nr_functions = 2;


    public MessageSentinel () throws CGException {}


    public MessageSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=MessageSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new MessageSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Message KEEP=NO
  public Message () throws CGException {
    try {

      setSentinel();
      text = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Message


// ***** VDMTOOLS START Name=Message KEEP=NO
  public Message (final Integer newIdentifier) throws CGException {

    try {

      setSentinel();
      text = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    identifier = UTIL.NumberToInt(UTIL.clone(newIdentifier));
  }
// ***** VDMTOOLS END Name=Message


// ***** VDMTOOLS START Name=pre_Message KEEP=NO
  public Boolean pre_Message (final Integer newIdentifier) throws CGException {
    return new Boolean((newIdentifier.intValue()) > (new Integer(0).intValue()));
  }
// ***** VDMTOOLS END Name=pre_Message


// ***** VDMTOOLS START Name=Message KEEP=NO
  public Message (final Integer newIdentifier, final String newText) throws CGException {

    try {

      setSentinel();
      text = UTIL.ConvertToString(new String());
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    {

      text = UTIL.ConvertToString(UTIL.clone(newText));
      identifier = UTIL.NumberToInt(UTIL.clone(newIdentifier));
    }
  }
// ***** VDMTOOLS END Name=Message


// ***** VDMTOOLS START Name=pre_Message KEEP=NO
  public Boolean pre_Message (final Integer newIdentifier, final String newText) throws CGException {
    return new Boolean((newIdentifier.intValue()) > (new Integer(0).intValue()));
  }
// ***** VDMTOOLS END Name=pre_Message

}
;
