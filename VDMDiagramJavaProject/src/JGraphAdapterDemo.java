/* ==========================================
 * JGraphT : a free Java graph-theory library
 * ==========================================
 *
 * Project Info:  http://jgrapht.sourceforge.net/
 * Project Creator:  Barak Naveh (http://sourceforge.net/users/barak_naveh)
 *
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
/* ----------------------
 * JGraphAdapterDemo.java
 * ----------------------
 * (C) Copyright 2003-2008, by Barak Naveh and Contributors.
 *
 * Original Author:  Barak Naveh
 * Contributor(s):   -
 *
 * $Id: JGraphAdapterDemo.java 725 2010-11-26 01:24:28Z perfecthash $
 *
 * Changes
 * -------
 * 03-Aug-2003 : Initial revision (BN);
 * 07-Nov-2003 : Adaptation to JGraph 3.0 (BN);
 *
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.util.Vector;

import javax.swing.*;

import jp.co.csk.vdm.toolbox.VDM.CGException;

import org.jgraph.*;
import org.jgraph.graph.*;

import org.jgrapht.*;
import org.jgrapht.ext.*;
import org.jgrapht.graph.*;

// resolve ambiguity
import org.omg.CORBA.SystemException;


/**
 * A demo applet that shows how to use JGraph to visualize JGraphT graphs.
 *
 * @author Barak Naveh
 * @since Aug 3, 2003
 */
public class JGraphAdapterDemo
    extends JApplet implements ActionListener
{
    //~ Static fields/initializers ---------------------------------------------

    private static final long serialVersionUID = 3256444702936019250L;
    private static final Color DEFAULT_BG_COLOR = Color.decode("#FAFBFF");
    private static final Dimension DEFAULT_SIZE = new Dimension(530, 320);
    

    // create a JGraphT graph
    public static ListenableGraph<String, graphMessage> g =
        new ListenableDirectedMultigraph<String, graphMessage>(graphMessage.class);
    public static JGraphAdapterDemo applet = new JGraphAdapterDemo();
    public static JFrame buttonFrame=new JFrame("Options");
    public static JFrame frame = new JFrame("Sequence Diagram");
    public static JFrame addActorFrame = new JFrame("Add Actor");
    public static JFrame addObjectFrame = new JFrame("Add Object");
    public static JFrame addFragmentFrame = new JFrame("Add Fragment");
    public static JFrame sendMessageFrame = new JFrame("Send Message");
    public static JFrame remActorFrame = new JFrame("Remove Actor");
    public static JFrame remObjectFrame = new JFrame("Remove Object");
    public static JFrame remGateFrame = new JFrame("Remove Object");
    public static JFrame remFragmentFrame = new JFrame("Remove Fragment");
    
    public static JButton addObject = new JButton("Add Object");
    public static JButton addActor = new JButton("Add Actor");
    public static JButton addFragment = new JButton("Add Fragment");
    public static JButton sendMessage = new JButton("Send Message");
    public static JButton remObject = new JButton("Remove Object");
    public static JButton remActor = new JButton("Remove Actor");
    public static JButton remGate = new JButton("Remove Gate");
    public static JButton remFragment = new JButton("Remove Fragment");
    public static JButton okButton1 = new JButton("Ok");
    public static JButton okButton2 = new JButton("Ok");
    public static JButton okButton3 = new JButton("Ok");
    public static JButton okButton4 = new JButton("Ok");
    public static JButton okButton5 = new JButton("Ok");
    public static JButton okButton6 = new JButton("Ok");
    public static JButton okButton7 = new JButton("Ok");
    public static JButton okButton8 = new JButton("Ok");
    
    public static JTextField addactorName = new JTextField("Actor's Name");
    public static JTextField addobjectName = new JTextField("Object's Name");
    public static JTextField addFragmentName = new JTextField("Fragment's Name");
    public static JTextField remFragmentName = new JTextField("Fragment's Name");
    public static JTextField addFragmentCharacteristic = new JTextField("Fragment's Characteristic");
    public static JTextField sendmessageText = new JTextField("Message");
    public static JTextField remactorName = new JTextField("Actor's Name");
    public static JTextField remobjectName = new JTextField("Object's Name");
    public static JTextField addobjectDescription = new JTextField("Object's Description");
    
    public static JComboBox<String> LifelineList1 = new JComboBox<String>();
    public static JComboBox<String> LifelineList2 = new JComboBox<String>();
    public static JComboBox<String> GateList = new JComboBox<String>();
    public static JComboBox<String> addFragmentLifeline = new JComboBox<String>();
    
    public static Vector<Actor> localactors= new Vector<Actor>();
    public static Vector<vdm_Object> localobjects= new Vector<vdm_Object>();
    public static Vector<Gate> localgates= new Vector<Gate>();
    public static Vector<Fragment> localfragments= new Vector<Fragment>();
    public static Vector<Message> localmessages= new Vector<Message>();
    
    
    
    
    public static Diagram sequenceDiagram;

    //~ Instance fields --------------------------------------------------------

    //
    private JGraphModelAdapter<String, graphMessage> jgAdapter;

    //~ Methods ----------------------------------------------------------------

    /**
     * An alternative starting point for this demo, to also allow running this
     * applet as an application.
     *
     * @param args ignored.
     */
    public static void main(String [] args)
    {
        applet.init();
        

    }

    /**
     * {@inheritDoc}
     */
    public void init()
    {
    	try{
    		sequenceDiagram=new Diagram();
    	}catch(CGException e){
    		e.printStackTrace();
    	}
        // create a visualization using JGraph, via an adapter
        jgAdapter = new JGraphModelAdapter<String, graphMessage>(g);

        JGraph jgraph = new JGraph(jgAdapter);

        adjustDisplaySettings(jgraph);
        getContentPane().add(jgraph);
        resize(DEFAULT_SIZE);

        
        addObject.setActionCommand("addobject");
        addObject.addActionListener(applet);
        addObject.setEnabled(true);
        
        addActor.setActionCommand("addactor");
        addActor.addActionListener(applet);
        addActor.setEnabled(true);
        
        sendMessage.setActionCommand("sendmessage");
        sendMessage.addActionListener(applet);
        sendMessage.setEnabled(true);
        
        addFragment.setActionCommand("addfragment");
        addFragment.addActionListener(applet);
        addFragment.setEnabled(true);
        
        remActor.setActionCommand("remactor");
        remActor.addActionListener(applet);
        remActor.setEnabled(true);
        
        remObject.setActionCommand("remobject");
        remObject.addActionListener(applet);
        remObject.setEnabled(true);
        
        remGate.setActionCommand("remgate");
        remGate.addActionListener(applet);
        remGate.setEnabled(true);
        
        remFragment.setActionCommand("remfragment");
        remFragment.addActionListener(applet);
        remFragment.setEnabled(true);
        

        buttonFrame.setLayout(new FlowLayout());
        buttonFrame.add(addObject);
        buttonFrame.add(addActor);
        buttonFrame.add(sendMessage);
        buttonFrame.add(addFragment);
        buttonFrame.add(remObject);
        buttonFrame.add(remActor);
        buttonFrame.add(remGate);
        buttonFrame.add(remFragment);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        buttonFrame.setLocation(dim.width/2-buttonFrame.getSize().width/2, dim.height/2-buttonFrame.getSize().height/2);
        buttonFrame.pack();
        buttonFrame.setVisible(true);
        
        frame.getContentPane().add(applet);
        frame.setTitle("Modelo de Sequencias");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        
        
        okButton1.setActionCommand("okbutton1");
        okButton1.addActionListener(applet);
        okButton1.setEnabled(true);
        
        
        
        addActorFrame.setLayout(new FlowLayout());
        addActorFrame.add(addactorName);
        addActorFrame.add(okButton1);
        addActorFrame.setLocation(dim.width/2-addActorFrame.getSize().width/2, dim.height/2-addActorFrame.getSize().height/2);
        addActorFrame.pack();
        addActorFrame.setVisible(false);
        
        
        okButton2.setActionCommand("okbutton2");
        okButton2.addActionListener(applet);
        okButton2.setEnabled(true);
        
        
        
        addObjectFrame.setLayout(new FlowLayout());
        addObjectFrame.add(addobjectName);
        addObjectFrame.add(addobjectDescription);
        addObjectFrame.add(okButton2);
        addObjectFrame.setLocation(dim.width/2-addObjectFrame.getSize().width/2, dim.height/2-addObjectFrame.getSize().height/2);
        addObjectFrame.pack();
        addObjectFrame.setVisible(false);
        
        
        okButton3.setActionCommand("okbutton3");
        okButton3.addActionListener(applet);
        okButton3.setEnabled(true);
        
        
        
        remActorFrame.setLayout(new FlowLayout());
        remActorFrame.add(remactorName);
        remActorFrame.add(okButton3);
        remActorFrame.setLocation(dim.width/2-remActorFrame.getSize().width/2, dim.height/2-remActorFrame.getSize().height/2);
        remActorFrame.pack();
        remActorFrame.setVisible(false);
        
        
        okButton4.setActionCommand("okbutton4");
        okButton4.addActionListener(applet);
        okButton4.setEnabled(true);
        
        
        
        remObjectFrame.setLayout(new FlowLayout());
        remObjectFrame.add(remobjectName);
        remObjectFrame.add(okButton4);
        remObjectFrame.setLocation(dim.width/2-remObjectFrame.getSize().width/2, dim.height/2-remObjectFrame.getSize().height/2);
        remObjectFrame.pack();
        remObjectFrame.setVisible(false);
        
        
        okButton5.setActionCommand("okbutton5");
        okButton5.addActionListener(applet);
        okButton5.setEnabled(true);
        
        sendMessageFrame.setLayout(new FlowLayout());
        sendMessageFrame.add(LifelineList1);
        sendMessageFrame.add(LifelineList2);
        sendMessageFrame.add(sendmessageText);
        sendMessageFrame.add(okButton5);
        sendMessageFrame.setLocation(dim.width/2-sendMessageFrame.getSize().width/2,  dim.height/2-sendMessageFrame.getSize().height/2);
        
        
        
        okButton6.setActionCommand("okbutton6");
        okButton6.addActionListener(applet);
        okButton6.setEnabled(true);
        
        remGateFrame.setLayout(new FlowLayout());
        remGateFrame.add(GateList);
        remGateFrame.add(okButton6);
        remGateFrame.setLocation(dim.width/2-remGateFrame.getSize().width/2,  dim.height/2-remGateFrame.getSize().height/2);
        
        okButton7.setActionCommand("okbutton7");
        okButton7.addActionListener(applet);
        okButton7.setEnabled(true);
        
        addFragmentFrame.setLayout(new FlowLayout());
        addFragmentFrame.add(addFragmentLifeline);
        addFragmentFrame.add(addFragmentName);
        addFragmentFrame.add(addFragmentCharacteristic);
        addFragmentFrame.add(okButton7);
        addFragmentFrame.setLocation(dim.width/2-addFragmentFrame.getSize().width/2,  dim.height/2-addFragmentFrame.getSize().height/2);
        
        okButton8.setActionCommand("okbutton8");
        okButton8.addActionListener(applet);
        okButton8.setEnabled(true);
        
        remFragmentFrame.setLayout(new FlowLayout());
        remFragmentFrame.add(remFragmentName);
        remFragmentFrame.add(okButton8);
        remFragmentFrame.setLocation(dim.width/2-remFragmentFrame.getSize().width/2,  dim.height/2-remFragmentFrame.getSize().height/2);
        
        
 
        
        
        /*
         * String v1 = "v1";
        String v2 = "v2";
        String v3 = "v3";
        String v4 = "v4";

        // add some sample data (graph manipulated via JGraphT)
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);

        g.addEdge(v1, v2);
        g.addEdge(v2, v3);
        g.addEdge(v3, v1);
        g.addEdge(v4, v3);

        // position vertices nicely within JGraph component
        positionVertexAt(v1, 130, 40);
        positionVertexAt(v2, 60, 200);
        positionVertexAt(v3, 310, 230);
        positionVertexAt(v4, 380, 70);
*/
        // that's all there is to it!...
    }
    
    
    @SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent e) {
        if("addobject".equals(e.getActionCommand())) {
          addObjectFrame.setVisible(true);
        } 
        
        
        else if ("addactor".equals(e.getActionCommand())) {
          addActorFrame.setVisible(true);
        }
        
        
        else if ("sendmessage".equals(e.getActionCommand())) {
            if(sequenceDiagram.actors.size()+sequenceDiagram.objects.size()==0)
            	System.out.println("There are no Lifelines to associate with");
            else
            	createGateFrame();
          }
        
        
        else if ("addfragment".equals(e.getActionCommand())) {
            if(sequenceDiagram.actors.size()+sequenceDiagram.objects.size()==0)
            	System.out.println("There are no Lifelines to associate with");
            else
            	{
            		createFragmentFrame();
            		addFragmentFrame.setVisible(true);
            	}
          }
        
        else if("remobject".equals(e.getActionCommand())) {
            if(sequenceDiagram.objects.size()==0)
            {
            	System.out.println("There are no Objects to Remove");
            }
            else remObjectFrame.setVisible(true);
          } 
        
        
        else if ("remactor".equals(e.getActionCommand())) {
            if(sequenceDiagram.actors.size()==0)
            {
            	System.out.println("There are no Actors to Remove");
            }
            else remActorFrame.setVisible(true);
          }
        
        
          else if ("remgate".equals(e.getActionCommand())) {
              if(sequenceDiagram.gates.size()==0)
              	System.out.println("There are no Gates");
              else
                 CreateremGateFrame();	
            }
        
        
          else if ("remfragment".equals(e.getActionCommand())) {
              if(sequenceDiagram.fragments.size()==0)
                	System.out.println("There are no Fragments");
                else
                   remFragmentFrame.setVisible(true);
            }
        

        
        else if ("okbutton1".equals(e.getActionCommand())) {
            if(!addactorName.getText().isEmpty()&& !localactors.contains(getActorByName(addactorName.getText())))
            	{
            		Actor a;
            		try {
						a = new Actor();
						a.name=addactorName.getText();
	            		g.addVertex(addactorName.getText());
						sequenceDiagram.addActors(a);
						localactors.add(a);
					} catch (CGException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            else
            	System.out.println("Actor Needs a Name that is Not in Use!");
            addActorFrame.setVisible(false);
          }
        
        
        else if ("okbutton2".equals(e.getActionCommand())) {
            if(!addobjectName.getText().isEmpty()&& !localobjects.contains(getObjectByName(addobjectName.getText())))
            	{
            		vdm_Object o;
            		try {
						o = new vdm_Object();
						o.name=addobjectName.getText();
	            		if(!addobjectDescription.getText().equals("Object's Description"))
	            			{
	            				o.description=addobjectDescription.getText();
	            				g.addVertex(addobjectName.getText()+"("+addobjectDescription.getText()+")");
	            				sequenceDiagram.addObjects(o);
	            			}
	            		else
	            			{
	            				o.description="";
            					g.addVertex(addobjectName.getText()+"()");
	            				sequenceDiagram.addObjects(o);
	            			}
						localobjects.add(o);
					} catch (CGException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            else
            	System.out.println("Object Needs a Name that is Not in Use!");
            addObjectFrame.setVisible(false);
          }
        
        
        else if ("okbutton3".equals(e.getActionCommand())) {
            if(!remactorName.getText().isEmpty())
            	{
            		Actor a;
            		boolean removed=false;
            		try {
						a = new Actor();
						for (int i = 0; i < localactors.size(); i++) {
							if(localactors.get(i).name.equals(remactorName.getText()))
							{
								a=localactors.get(i);
								for(int j=0;j<localfragments.size();j++)
								{
									if(a.fragments.containsValue(localfragments.get(j)))
									{
										System.out.println(localfragments.size());
										Fragment f=localfragments.get(j);
										sequenceDiagram.remFragments(f);
										g.removeVertex("Fragment {"+f.name+" ("+f.characteristic+")}");
										localfragments.remove(f);
										j--;
									}
								}
								for(int j=0;j<localgates.size();j++)
								{
									if(a.gates.contains(localgates.get(j)))
									{
										Gate g1=localgates.get(j);
										sequenceDiagram.remGates(g1);
										//sequenceDiagram.remGates(g1);
										Message m;
										if(g1.msgToReceive.identifier!=9999)
										m = getMessageById(Integer.toString(g1.msgToReceive.identifier));
										else
										m = getMessageById(Integer.toString(g1.msgToSend.identifier));
										if(g1.msgToReceive.identifier!=9999&&g1.msgToSend.identifier!=9999)
										{
											localmessages.remove(m);
										}
										for(int k=0;k<localgates.size();k++)
										{
											if(localgates.get(k).msgToReceive.identifier!=9999&&localgates.get(k).msgToReceive.identifier==m.identifier)
											{
												localgates.get(k).msgToSend=m;
												g.addEdge("Gate "+localgates.get(k).identifier+":", "Gate "+localgates.get(k).identifier+":").MyLabel(m.text);
											}
											if(localgates.get(k).msgToSend.identifier!=9999&&localgates.get(k).msgToSend.identifier==m.identifier)
											{
												localgates.get(k).msgToReceive=m;
												g.addEdge("Gate "+localgates.get(k).identifier+":", "Gate "+localgates.get(k).identifier+":").MyLabel(m.text);
											}
										}
										g.removeVertex("Gate "+g1.identifier+":");
										localgates.remove(g1);
										j--;
									}
								}
								sequenceDiagram.actors.remove(a);
								g.removeVertex(a.name);
								localactors.remove(a);
								System.out.println("Removed Actor Successfully");
								removed=true;
								break;
							}
						}
						if(!removed)
						{
							System.out.println("No Actor with that name");
						}
	            			//g.addVertex(addobjectName.getText()+"\n"+"()");
					} catch (CGException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            else
            	System.out.println("Actor Needs a Name!");
            remActorFrame.setVisible(false);
          }
        
        else if ("okbutton4".equals(e.getActionCommand())) {
            if(!remobjectName.getText().isEmpty())
            	{
            		vdm_Object o;
            		boolean removed=false;
            		try {
						o = new vdm_Object();
						for (int i = 0; i < localobjects.size(); i++) {
							if(localobjects.get(i).name.equals(remobjectName.getText()))
							{
								for(int j=0;j<localfragments.size();j++)
								{
									if(localobjects.get(i).fragments.containsValue(localfragments.get(j)))
									{
										Fragment f=localfragments.get(j);
										sequenceDiagram.remFragments(f);
										g.removeVertex("Fragment {"+f.name+" ("+f.characteristic+")}");
										localfragments.remove(f);
										j--;
									}
								}
								for(int j=0;j<localgates.size();j++)
								{
									if(localobjects.get(i).gates.contains(localgates.get(j)))
									{
										Gate g1=localgates.get(j);
										sequenceDiagram.remGates(g1);
										//sequenceDiagram.remGates(g1);
										Message m;
										if(g1.msgToReceive.identifier!=9999)
										m = getMessageById(Integer.toString(g1.msgToReceive.identifier));
										else
										m = getMessageById(Integer.toString(g1.msgToSend.identifier));
										if(g1.msgToReceive.identifier!=9999&&g1.msgToSend.identifier!=9999)
										{
											localmessages.remove(m);
										}
										for(int k=0;k<localgates.size();k++)
										{
											if(localgates.get(k).msgToReceive.identifier!=9999&&localgates.get(k).msgToReceive.identifier==m.identifier)
											{
												localgates.get(k).msgToSend=m;
												g.addEdge("Gate "+localgates.get(k).identifier+":", "Gate "+localgates.get(k).identifier+":").MyLabel(m.text);
											}
											if(localgates.get(k).msgToSend.identifier!=9999&&localgates.get(k).msgToSend.identifier==m.identifier)
											{
												localgates.get(k).msgToReceive=m;
												g.addEdge("Gate "+localgates.get(k).identifier+":", "Gate "+localgates.get(k).identifier+":").MyLabel(m.text);
											}
										}
										g.removeVertex("Gate "+g1.identifier+":");
										localgates.remove(g1);
										j--;
									}
								}
								o=localobjects.get(i);
								sequenceDiagram.objects.remove(o);
								g.removeVertex(o.name+"("+o.description+")");
								localobjects.remove(o);
								System.out.println("Removed Object Successfully");
								removed=true;
								break;
							}
						}
						if(!removed)
						{
							System.out.println("No Object with that name");
						}
	            			//g.addVertex(addobjectName.getText()+"\n"+"()");
					} catch (CGException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            else
            	System.out.println("Object Needs a Name!");
            remObjectFrame.setVisible(false);
          }
        
        else if ("okbutton5".equals(e.getActionCommand())) {
            sendMessage();	
          }
        
        else if ("okbutton6".equals(e.getActionCommand())) {
            remGate();	
          }
        else if ("okbutton7".equals(e.getActionCommand())) {
            if(!addFragmentName.getText().isEmpty()&& !localfragments.contains(getFragmentByName(addFragmentName.getText())))
        	{
        		Fragment f;
        		try {
					f = new Fragment();
					f.name=addFragmentName.getText();
            		if(!addFragmentCharacteristic.getText().equals("Fragment's Characteristic"))
            			{
            				f.characteristic=addFragmentCharacteristic.getText();
            				g.addVertex("Fragment {"+f.name+" ("+addFragmentCharacteristic.getText()+")}");
            				g.addEdge("Fragment {"+f.name+" ("+addFragmentCharacteristic.getText()+")}", (String)addFragmentLifeline.getSelectedItem());
            				sequenceDiagram.addFragments(f);
            				Actor a;
            				vdm_Object o;
            				if(getActorByName((String)addFragmentLifeline.getSelectedItem())!=null)
            					{
            						a=getActorByName((String)addFragmentLifeline.getSelectedItem());
                    				sequenceDiagram.addFragmentToLifeline(a,f);
            					}
            					else
            					{
            						o=getObjectByName((String)addFragmentLifeline.getSelectedItem());
            						sequenceDiagram.addFragmentToLifeline(o,f);
            					}
            			}
            		else
            			{
            				f.characteristic="";
        					g.addVertex("Fragment {"+f.name+" ()}");
        					if(getObjectByName((String)addFragmentLifeline.getSelectedItem())!=null)
        					{
        						vdm_Object o=getObjectByName((String)addFragmentLifeline.getSelectedItem());
            					g.addEdge("Fragment {"+f.name+" ()}", o.name+"("+o.description+")");
        					}
        					else
        						g.addEdge("Fragment {"+f.name+" ()}", (String)addFragmentLifeline.getSelectedItem());
            				sequenceDiagram.addFragments(f);
            				Actor a;
            				vdm_Object o;
            				if(getActorByName((String)addFragmentLifeline.getSelectedItem())!=null)
            					{
            						a=getActorByName((String)addFragmentLifeline.getSelectedItem());
                    				sequenceDiagram.addFragmentToLifeline(a,f);
            					}
            					else
            					{
            						o=getObjectByName((String)addFragmentLifeline.getSelectedItem());
            						sequenceDiagram.addFragmentToLifeline(o,f);
            					}
            			}
					localfragments.add(f);
				} catch (CGException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        else
        	System.out.println("Fragment Needs a Name that is Not in Use!");
        addFragmentFrame.setVisible(false);
          }
          
          else if ("okbutton8".equals(e.getActionCommand())) {
        	  if(!remFragmentName.getText().isEmpty())
          	{
          		Fragment f;
          		boolean removed=false;
          		try {
						f = new Fragment();
						for (int i = 0; i < localfragments.size(); i++) {
							if(localfragments.get(i).name.equals(remFragmentName.getText()))
							{
								f=localfragments.get(i);
								sequenceDiagram.remFragments(f);
								g.removeVertex("Fragment {"+f.name+" ("+f.characteristic+")}");
								localfragments.remove(f);
								System.out.println("Removed Fragment Successfully");
								removed=true;
								break;
							}
						}
						if(!removed)
						{
							System.out.println("No Fragment with that name");
						}
	            			//g.addVertex(addobjectName.getText()+"\n"+"()");
					} catch (CGException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
          	}
          else
          	System.out.println("Fragment Needs a Name!");
          remFragmentFrame.setVisible(false);
            }

    }
    
    
    private void createGateFrame()
    {
    	LifelineList1.removeAllItems();
    	LifelineList2.removeAllItems();
        for(int i = 0; i<localactors.size();i++)
        {
        	LifelineList1.addItem(localactors.get(i).name);
        	LifelineList2.addItem(localactors.get(i).name);
        }
        for(int i = 0; i<localobjects.size();i++)
        {
        	LifelineList1.addItem(localobjects.get(i).name);
        	LifelineList2.addItem(localobjects.get(i).name);
        }
        
        
        sendMessageFrame.pack();
        sendMessageFrame.setVisible(true);
    }
    
    private void CreateremGateFrame()
    {
    	GateList.removeAllItems();
        for(int i = 0; i<localgates.size();i++)
        {
        	GateList.addItem(Integer.toString(localgates.get(i).identifier));
        }

        
        
        remGateFrame.pack();
        remGateFrame.setVisible(true);
    }
    
    private void createFragmentFrame()
    {
    	addFragmentLifeline.removeAllItems();
        for(int i = 0; i<localactors.size();i++)
        {
        	addFragmentLifeline.addItem(localactors.get(i).name);
        }
        for(int i = 0; i<localobjects.size();i++)
        {
        	addFragmentLifeline.addItem(localobjects.get(i).name);
        }

        
        
        addFragmentFrame.pack();
        addFragmentFrame.setVisible(true);
    }
    
    private void remGate()
    {
    	try {
			Gate g1=getGateById((String)GateList.getSelectedItem());
			sequenceDiagram.remGates(g1);
			//sequenceDiagram.remGates(g1);
			Message m;
			if(g1.msgToReceive.identifier!=9999)
			m = getMessageById(Integer.toString(g1.msgToReceive.identifier));
			else
			m = getMessageById(Integer.toString(g1.msgToSend.identifier));
			if(g1.msgToReceive.identifier!=9999&&g1.msgToSend.identifier!=9999)
			{
				localmessages.remove(m);
			}
			for(int i=0;i<localgates.size();i++)
			{
				if(localgates.get(i).msgToReceive.identifier!=9999&&localgates.get(i).msgToReceive.identifier==m.identifier)
				{
					localgates.get(i).msgToSend=m;
					g.addEdge("Gate "+localgates.get(i).identifier+":", "Gate "+localgates.get(i).identifier+":").MyLabel(m.text);
				}
				if(localgates.get(i).msgToSend.identifier!=9999&&localgates.get(i).msgToSend.identifier==m.identifier)
				{
					localgates.get(i).msgToReceive=m;
					g.addEdge("Gate "+localgates.get(i).identifier+":", "Gate "+localgates.get(i).identifier+":").MyLabel(m.text);
				}
			}
			for(int i = 0; i< localactors.size();i++)
			{
				if(localactors.get(i).gates.contains(g))
				{
					localactors.get(i).gates.remove(g);
					break;
				}
			
			}
			
			for(int i = 0; i< localobjects.size();i++)
			{
				if(localobjects.get(i).gates.contains(g))
				{
					localobjects.get(i).gates.remove(g);
					break;
				}
			
			}
			
			g.removeVertex("Gate "+g1.identifier+":");
			localgates.remove(g1);
			//sequenceDiagram.addGates(g);
			//localactors.add(a);
    		//g.addVertex(addactorName.getText());
		} catch (CGException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		remGateFrame.setVisible(false);
    }

    
    @SuppressWarnings("unchecked")
	private void sendMessage()
    {
    	Message m;
		try {
			m = new Message(localmessages.size(),sendmessageText.getText());
			sequenceDiagram.addMessages(m);
			if(getActorByName((String)LifelineList1.getSelectedItem())!=null)
			{
				if(getActorByName((String)LifelineList2.getSelectedItem())!=null)
				{
					Actor l=getActorByName((String)LifelineList1.getSelectedItem().toString());
					Actor l2=getActorByName((String)LifelineList2.getSelectedItem());
					
					if(l.name.equals(l2.name))
					{
						sequenceDiagram.sendMessageToSelf(l, m);
						Gate newgate1= new Gate(localgates.size(),m,m);
						l.gates.add(newgate1);
						localactors.set(localactors.indexOf(l2), l);
						localgates.add(newgate1);
						String gatename="Gate "+newgate1.identifier+":";
						g.addVertex(gatename);
						g.addEdge(l.name, gatename);
						g.addEdge(gatename, gatename).MyLabel(m.identifier+":"+m.text);
					}
					else{
						sequenceDiagram.sendMessage(l,l2, m);
						Gate newgate1= new Gate(localgates.size(),m,0);
						Actor newl=l;
						newl.gates.add(newgate1);
						localactors.set(localactors.indexOf(l), newl);
						localgates.add(newgate1);
						Gate newgate2= new Gate(localgates.size(),m,1);
						newl=l2;
						newl.gates.add(newgate2);
						localactors.set(localactors.indexOf(l2), newl);
						localgates.add(newgate2);
						String gatename1="Gate "+newgate1.identifier+":";
						String gatename2="Gate "+newgate2.identifier+":";
						g.addVertex(gatename1);
						g.addEdge(l.name, gatename1);
						g.addVertex(gatename2);
						g.addEdge(l2.name, gatename2);
						g.addEdge(gatename1, gatename2).MyLabel(m.identifier+":"+m.text);
					}
				}
				else if(getObjectByName((String)LifelineList2.getSelectedItem())!=null)
				{
					Actor l=getActorByName((String)LifelineList1.getSelectedItem());
					vdm_Object l2=getObjectByName((String)LifelineList2.getSelectedItem());
						sequenceDiagram.sendMessage(l,l2, m);
						Gate newgate1= new Gate(localgates.size(),m,0);
						Actor newl=l;
						newl.gates.add(newgate1);
						localactors.set(localactors.indexOf(l), newl);
						localgates.add(newgate1);
						Gate newgate2= new Gate(localgates.size(),m,1);
						vdm_Object newl1=l2;
						newl1.gates.add(newgate2);
						localobjects.set(localobjects.indexOf(l2), newl1);
						localgates.add(newgate2);
						String gatename1="Gate "+newgate1.identifier+":";
						String gatename2="Gate "+newgate2.identifier+":";;
						g.addVertex(gatename1);
						g.addVertex(gatename2);
						g.addEdge(l.name, gatename1);
						g.addEdge(l2.name+"("+l2.description+")", gatename2);
						g.addEdge(gatename1, gatename2).MyLabel(m.identifier+":"+m.text);
				}
			}
			else if(getObjectByName((String)LifelineList1.getSelectedItem())!=null)
			{
				if(getActorByName((String)LifelineList2.getSelectedItem())!=null)
				{
					vdm_Object l=getObjectByName((String)LifelineList1.getSelectedItem());
					Actor l2=getActorByName((String)LifelineList2.getSelectedItem());
						sequenceDiagram.sendMessage(l,l2, m);
						Gate newgate1= new Gate(localgates.size(),m,0);
						vdm_Object newl=l;
						newl.gates.add(newgate1);
						localobjects.set(localobjects.indexOf(l), newl);
						localgates.add(newgate1);
						Gate newgate2= new Gate(localgates.size(),m,1);
						Actor newl1=l2;
						newl.gates.add(newgate2);
						localactors.set(localactors.indexOf(l2), newl1);
						localgates.add(newgate2);
						String gatename1="Gate "+newgate1.identifier+":";
						String gatename2="Gate "+newgate2.identifier+":";
						g.addVertex(gatename1);
						g.addVertex(gatename2);
						g.addEdge(l.name+"("+l.description+")", gatename1);
						g.addEdge(l2.name, gatename2);
						g.addEdge(gatename1, gatename2).MyLabel(m.identifier+":"+m.text);
				}
				else if(getObjectByName((String)LifelineList2.getSelectedItem())!=null)
				{
					vdm_Object l=getObjectByName((String)LifelineList1.getSelectedItem());
					vdm_Object l2=getObjectByName((String)LifelineList2.getSelectedItem());
					System.out.println(l.name+"("+l.description+")");
					if(l.name.equals(l2.name))
					{
						sequenceDiagram.sendMessageToSelf(l, m);
						Gate newgate1= new Gate(localgates.size(),m,m);
						l.gates.add(newgate1);
						localobjects.set(localobjects.indexOf(l2), l);
						localgates.add(newgate1);
						String gatename="Gate "+newgate1.identifier+":";
						String objectname=l.name+"("+l.description+")";
						g.addVertex(gatename);
						g.addEdge(objectname, gatename);
						g.addEdge(gatename, gatename).MyLabel(m.identifier+":"+m.text);
					}
					else{
						sequenceDiagram.sendMessage(l,l2, m);
						Gate newgate1= new Gate(localgates.size(),m,0);
						vdm_Object newl=l;
						newl.gates.add(newgate1);
						localobjects.set(localobjects.indexOf(l), newl);
						localgates.add(newgate1);
						Gate newgate2= new Gate(localgates.size(),m,1);
						newl=l2;
						newl.gates.add(newgate2);
						localobjects.set(localobjects.indexOf(l2), newl);
						localgates.add(newgate2);
						String gatename1="Gate "+newgate1.identifier+":";
						String gatename2="Gate "+newgate2.identifier+":";
						String objectname=l.name+"("+l.description+")";
						String objectname2=l2.name+"("+l2.description+")";
						g.addVertex(gatename1);
						g.addVertex(gatename2);
						g.addEdge(objectname, gatename1);
						g.addEdge(objectname2, gatename2);
						g.addEdge(gatename1, gatename2).MyLabel(m.identifier+":"+m.text);
					}
				}
			}
			localmessages.add(m);
			//sequenceDiagram.addGates(g);
			//localactors.add(a);
    		//g.addVertex(addactorName.getText());
		} catch (CGException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sendMessageFrame.setVisible(false);
    }
    
    private Actor getActorByName(String name){
    	for(int i=0; i<localactors.size();i++)
    	{
    		if (localactors.get(i).name.equals(name))
    			return localactors.get(i);
    	}
    	return null;
    }
    
    private vdm_Object getObjectByName(String name){
    	for(int i=0; i<localobjects.size();i++)
    	{
    		if (localobjects.get(i).name.equals(name))
    			return localobjects.get(i);
    	}
    	return null;
    }
    
    private Fragment getFragmentByName(String name){
    	for(int i=0; i<localfragments.size();i++)
    	{
    		if (localfragments.get(i).name.equals(name))
    			return localfragments.get(i);
    	}
    	return null;
    }
    
    
    private Gate getGateById(String name){
    	for(int i=0; i<localgates.size();i++)
    	{
    		if (Integer.toString(localgates.get(i).identifier).equals(name))
    			return localgates.get(i);
    	}
    	return null;
    }
    
    private Message getMessageById(String name){
    	for(int i=0; i<localmessages.size();i++)
    	{
    		if (Integer.toString(localmessages.get(i).identifier).equals(name))
    			return localmessages.get(i);
    	}
    	return null;
    }

    private void adjustDisplaySettings(JGraph jg)
    {
        jg.setPreferredSize(DEFAULT_SIZE);

        Color c = DEFAULT_BG_COLOR;
        String colorStr = null;

        try {
            colorStr = getParameter("bgcolor");
        } catch (Exception e) {
        }

        if (colorStr != null) {
            c = Color.decode(colorStr);
        }

        jg.setBackground(c);
    }

    @SuppressWarnings("unchecked") // FIXME hb 28-nov-05: See FIXME below
    private void positionVertexAt(Object vertex, int x, int y)
    {
        DefaultGraphCell cell = jgAdapter.getVertexCell(vertex);
        AttributeMap attr = cell.getAttributes();
        Rectangle2D bounds = GraphConstants.getBounds(attr);

        Rectangle2D newBounds =
            new Rectangle2D.Double(
                x,
                y,
                bounds.getWidth(),
                bounds.getHeight());

        GraphConstants.setBounds(attr, newBounds);

        // TODO: Clean up generics once JGraph goes generic
        AttributeMap cellAttr = new AttributeMap();
        cellAttr.put(cell, attr);
        jgAdapter.edit(cellAttr, null, null, null);
    }

    //~ Inner Classes ----------------------------------------------------------

    /**
     * a listenable directed multigraph that allows loops and parallel edges.
     */
    private static class ListenableDirectedMultigraph<V, E>
        extends DefaultListenableGraph<V, E>
        implements DirectedGraph<V, E>
    {
        private static final long serialVersionUID = 1L;

        ListenableDirectedMultigraph(Class<E> edgeClass)
        {
            super(new DirectedMultigraph<V, E>(edgeClass));
        }
    }
}

// End JGraphAdapterDemo.java
