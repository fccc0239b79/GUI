/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI3;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Pawel Szymczyk
 */
public class GUI extends JFrame {
    
    String[] gridList = {"1", "2", "3", "4", "5"};
    
    JTextField width = new JTextField(10), length = new JTextField(10), height = new JTextField(10), boxNo = new JTextField(5);
    JRadioButton zero = new JRadioButton("0"), one = new JRadioButton("1"), two = new JRadioButton("2");
    JComboBox grid = new JComboBox(gridList); // add String[] gridList = {"1", "2", "3", "4", "5"};
    JCheckBox reinBorrom = new JCheckBox(" Bottom "), reinCorners = new JCheckBox(" Corners "), sealTop = new JCheckBox("sealable top");
    JButton reset = new JButton("Reset"), submit = new JButton("Submit");
    
    
    public GUI() {
      //---------------------FRAME----------------------------------------------
      // przeniesc ta czesc gdzie indziej
      setTitle("FlexBox");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      //setSize(400,250); 
      //setResizable(false);
      pack();
      setVisible(true);
      
      //---------------------GRIDBAGLAYOUT-AND-PANEL----------------------------
      JPanel window = new JPanel();
      //window.setBackground(Color.white);
      window.setLayout(new GridBagLayout());
      
      //---------------------TEXT-LABEL-----------------------------------------
      addItem(window, new JLabel("width [cm]: "), 0, 0, 1, 1, GridBagConstraints.EAST);
      addItem(window, new JLabel("length [cm]: "), 0, 1, 1, 1, GridBagConstraints.EAST);
      addItem(window, new JLabel("height [cm]: "), 0, 2, 1, 1, GridBagConstraints.EAST);
      
      //---------------------TEXT-FIELD-----------------------------------------
      addItem(window, width, 1, 0, 2, 1, GridBagConstraints.WEST);
      addItem(window, length, 1, 1, 1, 1, GridBagConstraints.WEST);
      addItem(window, height, 1, 2, 2, 1, GridBagConstraints.WEST);
      
      //---------------------COLORS---------------------------------------------
      Box sizeBox = Box.createVerticalBox();
      ButtonGroup colorGroup = new ButtonGroup();
      JLabel colorLabel = new JLabel("Please, select: ");
      colorGroup.add(zero);
      colorGroup.add(one);
      colorGroup.add(two);
      sizeBox.add(colorLabel);
      sizeBox.add(zero);
      sizeBox.add(one);
      sizeBox.add(two);
      sizeBox.setBorder(BorderFactory.createTitledBorder("No of colors")); // zamienic na normalna ramke ?
      addItem(window,sizeBox, 0, 3, 1, 1, GridBagConstraints.NORTH);
      
      //--------------------REINFORCMENT----------------------------------------
      Box reinBox = Box.createVerticalBox();
      reinBox.add(reinBorrom);
      reinBox.add(reinCorners);
      reinBox.setBorder(BorderFactory.createTitledBorder("Reinforced")); // zamienic na normalna ramke ?
      addItem(window,reinBox, 1, 3, 1, 1, GridBagConstraints.NORTH);
      
      //--------------------GRADE-----------------------------------------------
      Box gradeBox = Box.createVerticalBox();
      JLabel gridLabel = new JLabel("Please, select: ");
      gradeBox.add(gridLabel);
      gradeBox.add(grid);
      gradeBox.setBorder(BorderFactory.createTitledBorder("Grade")); // zamienic na normalna ramke ?
      addItem(window,gradeBox, 2, 3, 1, 1, GridBagConstraints.NORTH);
      
      //-------------------SEAL-TOP---------------------------------------------
      Box sealBox = Box.createVerticalBox();
      sealBox.add(sealTop);
      sealBox.setBorder(BorderFactory.createTitledBorder(""));
      addItem(window,sealBox, 1, 3, 1, 1, GridBagConstraints.SOUTH);
      
      //-------------------BOXES-QUANTITY---------------------------------------
      addItem(window, new JLabel("quantity: "), 0, 5, 1, 1, GridBagConstraints.EAST);
      addItem(window, boxNo, 1, 5, 2, 1, GridBagConstraints.WEST);
      
      //-------------------BUTTONS----------------------------------------------
      Box buttonBox = Box.createHorizontalBox();
      buttonBox.add(reset);
      buttonBox.add(Box.createHorizontalStrut(20));
      buttonBox.add(submit);
      addItem(window, buttonBox, 1, 6, 1, 1, GridBagConstraints.NORTH);
      
      //========================================================================
      
      this.add(window);
      this.pack();
      this.setVisible(true);
    }
    
    private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 100.0;
        gbc.weighty = 100.0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = align;
        gbc.fill = GridBagConstraints.NONE;
       
        p.add(c, gbc);
        
    }
    
    
    
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GUI();
            }
            
        });
    }

    
}
