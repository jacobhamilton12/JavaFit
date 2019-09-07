import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EnumMap;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

// Bonus points: Create an icon (or find a public domain icon. Keep in mind federal Copyright law and TAMU's plagiarism policy and add it to the home screen window.
public class MainWindow {
  
  private final JFrame mainFrame = new JFrame(Config.APPLICATIONNAME);
  private final Workouts workouts;
  private final EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups;
  private JButton button1, button2, button3;

  MainWindow(Workouts workouts, EnumMap<Config.MuscleGroup, ArrayList<Config.Muscle>> muscleGroups) {
    // Code goes here.
	  this.workouts = workouts;
	  this.muscleGroups = muscleGroups;
	  launchHomeScreen();
	  
  }
  
  private void launchHomeScreen() {
    // Code goes here.
	  mainFrame.setIconImage(new ImageIcon("stickman.png").getImage());
	  mainFrame.setVisible(true);
	  mainFrame.setSize(600,400);
	  
	  
	  button1 = new JButton("Upper Body Workout");
	  button2 = new JButton("Lower Body Workout");
	  button3 = new JButton("Whole Body Workout");
	  
	  ActionListener b1Action = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  showWorkouts(muscleGroups.get(Config.MuscleGroup.UPPERBODY));
		  }
	  };
	  
	  ActionListener b2Action = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  showWorkouts(muscleGroups.get(Config.MuscleGroup.LOWERBODY));
		  }
	  };
	  
	  ActionListener b3Action = new ActionListener() {
		  public void actionPerformed(ActionEvent e) {
			  showWorkouts(muscleGroups.get(Config.MuscleGroup.WHOLEBODY));
		  }
	  };
	  
	  button1.addActionListener(b1Action);
	  button2.addActionListener(b2Action);
	  button3.addActionListener(b3Action);
	  
	  mainFrame.setLayout(new GridLayout(3,1));
	  
	  mainFrame.add(button1);
	  mainFrame.add(button2);
	  mainFrame.add(button3);
	  
	  
  }
  
  // This is the method your actionlistener should call. It should create and display a WorkoutsPanel.
  private void showWorkouts(ArrayList<Config.Muscle> muscles) {
    
  // Code goes here.
	  WorkoutsPanel panel = new WorkoutsPanel(muscles, workouts);
	  mainFrame.add(panel);
	  mainFrame.remove(button1);
	  mainFrame.remove(button2);
	  mainFrame.remove(button3);
	  mainFrame.setLayout(new GridLayout(1,1));
	  mainFrame.validate();
  }
}
