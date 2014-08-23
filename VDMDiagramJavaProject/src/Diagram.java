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



public class Diagram implements EvaluatePP {

// ***** VDMTOOLS START Name=vdmComp KEEP=NO
  static UTIL.VDMCompare vdmComp = new UTIL.VDMCompare();
// ***** VDMTOOLS END Name=vdmComp

// ***** VDMTOOLS START Name=actors KEEP=NO
  public volatile HashSet actors = new HashSet();
// ***** VDMTOOLS END Name=actors

// ***** VDMTOOLS START Name=objects KEEP=NO
  public volatile HashSet objects = new HashSet();
// ***** VDMTOOLS END Name=objects

// ***** VDMTOOLS START Name=fragments KEEP=NO
  public volatile HashSet fragments = new HashSet();
// ***** VDMTOOLS END Name=fragments

// ***** VDMTOOLS START Name=gates KEEP=NO
  public volatile HashSet gates = new HashSet();
// ***** VDMTOOLS END Name=gates

// ***** VDMTOOLS START Name=messages KEEP=NO
  public volatile HashSet messages = new HashSet();
// ***** VDMTOOLS END Name=messages

// ***** VDMTOOLS START Name=sentinel KEEP=NO
  volatile Sentinel sentinel;
// ***** VDMTOOLS END Name=sentinel


// ***** VDMTOOLS START Name=DiagramSentinel KEEP=NO
  class DiagramSentinel extends Sentinel {

    public final int Diagram = 0;

    public final int addGates = 1;

    public final int remGates = 2;

    public final int addActors = 3;

    public final int remActors = 4;

    public final int addObjects = 5;

    public final int remObjects = 6;

    public final int addMessages = 7;

    public final int remMessages = 8;

    public final int sendMessage = 9;

    public final int addFragments = 10;

    public final int remFragments = 11;

    public final int addGateToLifeline = 12;

    public final int sendMessageToSelf = 13;

    public final int addFragmentToLifeline = 14;

    public final int nr_functions = 15;


    public DiagramSentinel () throws CGException {}


    public DiagramSentinel (EvaluatePP instance) throws CGException {
      init(nr_functions, instance);
    }

  }
// ***** VDMTOOLS END Name=DiagramSentinel
;

// ***** VDMTOOLS START Name=evaluatePP KEEP=NO
  public Boolean evaluatePP (int fnr) throws CGException {
    return new Boolean(true);
  }
// ***** VDMTOOLS END Name=evaluatePP


// ***** VDMTOOLS START Name=setSentinel KEEP=NO
  public void setSentinel () {
    try {
      sentinel = new DiagramSentinel(this);
    }
    catch (CGException e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=setSentinel


// ***** VDMTOOLS START Name=Diagram KEEP=NO
  public Diagram () throws CGException {

    try {

      setSentinel();
      actors = new HashSet();
      objects = new HashSet();
      fragments = new HashSet();
      gates = new HashSet();
      messages = new HashSet();
    }
    catch (Exception e){

      e.printStackTrace(System.out);
      System.out.println(e.getMessage());
    }
    try {

      {

        actors = (HashSet) UTIL.clone(new HashSet());
        objects = (HashSet) UTIL.clone(new HashSet());
        fragments = (HashSet) UTIL.clone(new HashSet());
        gates = (HashSet) UTIL.clone(new HashSet());
        messages = (HashSet) UTIL.clone(new HashSet());
      }
      setSentinel();
    }
    catch (Throwable e) {
      System.out.println(e.getMessage());
    }
  }
// ***** VDMTOOLS END Name=Diagram


// ***** VDMTOOLS START Name=addActors KEEP=NO
  public void addActors (final Actor a) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addActors);
    try {
      actors.add(a);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addActors);
    }
  }
// ***** VDMTOOLS END Name=addActors


// ***** VDMTOOLS START Name=addObjects KEEP=NO
  public void addObjects (final vdm_Object o) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addObjects);
    try {
      objects.add(o);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addObjects);
    }
  }
// ***** VDMTOOLS END Name=addObjects


// ***** VDMTOOLS START Name=addFragments KEEP=NO
  public void addFragments (final Fragment f) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addFragments);
    try {
      fragments.add(f);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addFragments);
    }
  }
// ***** VDMTOOLS END Name=addFragments


// ***** VDMTOOLS START Name=pre_addFragments KEEP=NO
  public Boolean pre_addFragments (final Fragment f) throws CGException {

    Boolean varRes_2 = null;
    {
      if (!(varRes_2 = new Boolean((new Integer(actors.size()).intValue()) > (new Integer(0).intValue()))).booleanValue()) 
        varRes_2 = new Boolean((new Integer(objects.size()).intValue()) > (new Integer(0).intValue()));
    }
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addFragments


// ***** VDMTOOLS START Name=addGates KEEP=NO
  public void addGates (final Gate g) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addGates);
    try {
      gates.add(g);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addGates);
    }
  }
// ***** VDMTOOLS END Name=addGates


// ***** VDMTOOLS START Name=pre_addGates KEEP=NO
  public Boolean pre_addGates (final Gate g) throws CGException {

    Boolean varRes_2 = null;
    {
      if (!(varRes_2 = new Boolean((new Integer(actors.size()).intValue()) > (new Integer(0).intValue()))).booleanValue()) 
        varRes_2 = new Boolean((new Integer(objects.size()).intValue()) > (new Integer(0).intValue()));
    }
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addGates


// ***** VDMTOOLS START Name=addMessages KEEP=NO
  public void addMessages (final Message m) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addMessages);
    try {
      messages.add(m);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addMessages);
    }
  }
// ***** VDMTOOLS END Name=addMessages


// ***** VDMTOOLS START Name=pre_addMessages KEEP=NO
  public Boolean pre_addMessages (final Message m) throws CGException {

    Boolean varRes_2 = null;
    {
      if (!(varRes_2 = new Boolean((new Integer(actors.size()).intValue()) > (new Integer(0).intValue()))).booleanValue()) 
        varRes_2 = new Boolean((new Integer(objects.size()).intValue()) > (new Integer(0).intValue()));
    }
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_addMessages


// ***** VDMTOOLS START Name=remActors KEEP=NO
  public void remActors (final Actor a) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).remActors);
    try {

      HashSet rhs_2 = new HashSet();
      HashSet var2_4 = new HashSet();
      var2_4 = new HashSet();
      var2_4.add(a);
      rhs_2 = (HashSet) actors.clone();
      rhs_2.removeAll(var2_4);
      actors = (HashSet) UTIL.clone(rhs_2);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).remActors);
    }
  }
// ***** VDMTOOLS END Name=remActors


// ***** VDMTOOLS START Name=pre_remActors KEEP=NO
  public Boolean pre_remActors (final Actor a) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(actors.contains(a));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remActors


// ***** VDMTOOLS START Name=remObjects KEEP=NO
  public void remObjects (final vdm_Object o) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).remObjects);
    try {

      HashSet rhs_2 = new HashSet();
      HashSet var2_4 = new HashSet();
      var2_4 = new HashSet();
      var2_4.add(o);
      rhs_2 = (HashSet) objects.clone();
      rhs_2.removeAll(var2_4);
      objects = (HashSet) UTIL.clone(rhs_2);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).remObjects);
    }
  }
// ***** VDMTOOLS END Name=remObjects


// ***** VDMTOOLS START Name=pre_remObjects KEEP=NO
  public Boolean pre_remObjects (final vdm_Object o) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(objects.contains(o));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remObjects


// ***** VDMTOOLS START Name=remFragments KEEP=NO
  public void remFragments (final Fragment f) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).remFragments);
    try {

      HashSet rhs_2 = new HashSet();
      HashSet var2_4 = new HashSet();
      var2_4 = new HashSet();
      var2_4.add(f);
      rhs_2 = (HashSet) fragments.clone();
      rhs_2.removeAll(var2_4);
      fragments = (HashSet) UTIL.clone(rhs_2);
      {

        Actor x = null;
        for (Iterator enm_16 = actors.iterator(); enm_16.hasNext(); ) {

          Actor elem_7 = (Actor) enm_16.next();
          x = (Actor) elem_7;
          {

            Boolean cond_10 = null;
            HashMap var2_12 = new HashMap();
            var2_12 = x.fragments;
            cond_10 = new Boolean(var2_12.containsValue(f));
            if (cond_10.booleanValue()) 
              x.remFragment((Fragment) f);
          }
        }
      }
      {

        vdm_Object x = null;
        for (Iterator enm_27 = objects.iterator(); enm_27.hasNext(); ) {

          vdm_Object elem_18 = (vdm_Object) enm_27.next();
          x = (vdm_Object) elem_18;
          {

            Boolean cond_21 = null;
            HashMap var2_23 = new HashMap();
            var2_23 = x.fragments;
            cond_21 = new Boolean(var2_23.containsValue(f));
            if (cond_21.booleanValue()) 
              x.remFragment((Fragment) f);
          }
        }
      }
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).remFragments);
    }
  }
// ***** VDMTOOLS END Name=remFragments


// ***** VDMTOOLS START Name=pre_remFragments KEEP=NO
  public Boolean pre_remFragments (final Fragment f) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(fragments.contains(f));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remFragments


// ***** VDMTOOLS START Name=remGates KEEP=NO
  public void remGates (final Gate g) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).remGates);
    try {

      HashSet rhs_2 = new HashSet();
      HashSet var2_4 = new HashSet();
      var2_4 = new HashSet();
      var2_4.add(g);
      rhs_2 = (HashSet) gates.clone();
      rhs_2.removeAll(var2_4);
      gates = (HashSet) UTIL.clone(rhs_2);
      {

        Actor x = null;
        for (Iterator enm_19 = actors.iterator(); enm_19.hasNext(); ) {

          Actor elem_7 = (Actor) enm_19.next();
          x = (Actor) elem_7;
          {

            Boolean cond_10 = null;
            HashSet var2_12 = new HashSet();
            Vector unArg_13 = null;
            unArg_13 = x.gates;
            HashSet set_15 = new HashSet();
            Enumeration enm_16 = unArg_13.elements();
            while ( enm_16.hasMoreElements())
              set_15.add(enm_16.nextElement());
            var2_12 = set_15;
            cond_10 = new Boolean(var2_12.contains(g));
            if (cond_10.booleanValue()) 
              x.remGate((Gate) g);
          }
        }
      }
      {

        vdm_Object x = null;
        for (Iterator enm_33 = objects.iterator(); enm_33.hasNext(); ) {

          vdm_Object elem_21 = (vdm_Object) enm_33.next();
          x = (vdm_Object) elem_21;
          {

            Boolean cond_24 = null;
            HashSet var2_26 = new HashSet();
            Vector unArg_27 = null;
            unArg_27 = x.gates;
            HashSet set_29 = new HashSet();
            Enumeration enm_30 = unArg_27.elements();
            while ( enm_30.hasMoreElements())
              set_29.add(enm_30.nextElement());
            var2_26 = set_29;
            cond_24 = new Boolean(var2_26.contains(g));
            if (cond_24.booleanValue()) 
              x.remGate((Gate) g);
          }
        }
      }
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).remGates);
    }
  }
// ***** VDMTOOLS END Name=remGates


// ***** VDMTOOLS START Name=pre_remGates KEEP=NO
  public Boolean pre_remGates (final Gate g) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(gates.contains(g));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remGates


// ***** VDMTOOLS START Name=remMessages KEEP=NO
  public void remMessages (final Message m) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).remMessages);
    try {

      HashSet rhs_2 = new HashSet();
      HashSet var2_4 = new HashSet();
      var2_4 = new HashSet();
      var2_4.add(m);
      rhs_2 = (HashSet) messages.clone();
      rhs_2.removeAll(var2_4);
      messages = (HashSet) UTIL.clone(rhs_2);
      {

        Gate x = null;
        for (Iterator enm_22 = gates.iterator(); enm_22.hasNext(); ) {

          Gate elem_7 = (Gate) enm_22.next();
          x = (Gate) elem_7;
          {

            Boolean cond_10 = null;
            Message var2_12 = null;
            var2_12 = x.msgToSend;
            cond_10 = new Boolean(UTIL.equals(m, var2_12));
            if (cond_10.booleanValue()) 
              x.remMsgToSend((Message) m);
            Boolean cond_16 = null;
            Message var2_18 = null;
            var2_18 = x.msgToReceive;
            cond_16 = new Boolean(UTIL.equals(m, var2_18));
            if (cond_16.booleanValue()) 
              x.remMsgToReceive((Message) m);
          }
        }
      }
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).remMessages);
    }
  }
// ***** VDMTOOLS END Name=remMessages


// ***** VDMTOOLS START Name=pre_remMessages KEEP=NO
  public Boolean pre_remMessages (final Message m) throws CGException {

    Boolean varRes_2 = null;
    varRes_2 = new Boolean(messages.contains(m));
    return varRes_2;
  }
// ***** VDMTOOLS END Name=pre_remMessages


// ***** VDMTOOLS START Name=addGateToLifeline KEEP=NO
  public void addGateToLifeline (final Lifeline existingLifeline, final Gate newGate) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addGateToLifeline);
    try {
      existingLifeline.addGate((Gate) newGate);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addGateToLifeline);
    }
  }
// ***** VDMTOOLS END Name=addGateToLifeline


// ***** VDMTOOLS START Name=pre_addGateToLifeline KEEP=NO
  public Boolean pre_addGateToLifeline (final Lifeline existingLifeline, final Gate newGate) throws CGException {

    Boolean varRes_3 = null;
    Boolean var1_4 = null;
    Boolean var1_5 = null;
    HashSet var2_7 = new HashSet();
    var2_7 = this.actors;
    var1_5 = new Boolean(var2_7.contains(existingLifeline));
    {
      if (!(var1_4 = var1_5).booleanValue()) {

        Boolean var2_9 = null;
        HashSet var2_11 = new HashSet();
        var2_11 = this.objects;
        var2_9 = new Boolean(var2_11.contains(existingLifeline));
        var1_4 = var2_9;
      }
    }
    {
      if ((varRes_3 = var1_4).booleanValue()) {

        Boolean var2_13 = null;
        HashSet var2_15 = new HashSet();
        var2_15 = this.gates;
        var2_13 = new Boolean(var2_15.contains(newGate));
        varRes_3 = var2_13;
      }
    }
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_addGateToLifeline


// ***** VDMTOOLS START Name=addFragmentToLifeline KEEP=NO
  public void addFragmentToLifeline (final Lifeline lifeline, final Fragment newFragment) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).addFragmentToLifeline);
    try {
      lifeline.addFragment((Fragment) newFragment);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).addFragmentToLifeline);
    }
  }
// ***** VDMTOOLS END Name=addFragmentToLifeline


// ***** VDMTOOLS START Name=pre_addFragmentToLifeline KEEP=NO
  public Boolean pre_addFragmentToLifeline (final Lifeline lifeline, final Fragment newFragment) throws CGException {

    Boolean varRes_3 = null;
    Boolean var1_4 = null;
    Boolean var1_5 = null;
    var1_5 = new Boolean(actors.contains(lifeline));
    {
      if (!(var1_4 = var1_5).booleanValue()) {

        Boolean var2_8 = null;
        var2_8 = new Boolean(objects.contains(lifeline));
        var1_4 = var2_8;
      }
    }
    {
      if ((varRes_3 = var1_4).booleanValue()) {

        Boolean var2_11 = null;
        var2_11 = new Boolean(fragments.contains(newFragment));
        varRes_3 = var2_11;
      }
    }
    return varRes_3;
  }
// ***** VDMTOOLS END Name=pre_addFragmentToLifeline


// ***** VDMTOOLS START Name=sendMessage KEEP=NO
  public void sendMessage (final Lifeline sourceLifeline, final Lifeline destinationLifeline, final Message message) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).sendMessage);
    try {

      Gate newGate = new Gate(new Integer(gates.size()), message, new Integer(0));
      Gate newGate2 = new Gate(new Integer(gates.size()), message, new Integer(1));
      this.addGates((Gate) newGate);
      this.addGates((Gate) newGate2);
      this.addGateToLifeline((Lifeline) sourceLifeline, (Gate) newGate);
      this.addGateToLifeline((Lifeline) destinationLifeline, (Gate) newGate2);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).sendMessage);
    }
  }
// ***** VDMTOOLS END Name=sendMessage


// ***** VDMTOOLS START Name=sendMessageToSelf KEEP=NO
  public void sendMessageToSelf (final Lifeline lifeline, final Message message) throws CGException {

    sentinel.entering(((DiagramSentinel) sentinel).sendMessageToSelf);
    try {

      Gate newGate = new Gate(new Integer(gates.size()), message, message);
      this.addGates((Gate) newGate);
      this.addGateToLifeline((Lifeline) lifeline, (Gate) newGate);
    }
    finally {
      sentinel.leaving(((DiagramSentinel) sentinel).sendMessageToSelf);
    }
  }
// ***** VDMTOOLS END Name=sendMessageToSelf

}
;