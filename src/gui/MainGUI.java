package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import config.GameConfiguration;
import engine.counters.LimitReachedException;
import engine.map.City;
import engine.process.GameBuilder;
import engine.process.MobileInterface;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private City city;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private MobileInterface manager;

	private GameDisplay dashboard;

	private JTextField textField;
	
	private boolean run ;

	// Content of top JPanel
	private JPanel topControlPanel = new JPanel();
	private JButton homeButton = new JButton("Accueil");
	private JButton clignoGaucheButton = new JButton("Clignotant gauche");
	private JButton clignoDroitButton = new JButton("Clignotant droit");
	private JButton angleMortDroitButton = new JButton("Angle Mort droit");
	private JButton angleMortGaucheButton = new JButton("Angle Mort gauche");
	

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		
		//topControlPanel components

		clignoGaucheButton.addActionListener(new ClignoGaucheListener());
		clignoDroitButton.addActionListener(new ClignoDroitListener());
		angleMortGaucheButton.addActionListener(new AngleMortGaucheListener());
		angleMortDroitButton.addActionListener(new AngleMortDroitListener());

		homeButton.addActionListener(new HomeListener());
		topControlPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		topControlPanel.add(angleMortGaucheButton);
		topControlPanel.add(angleMortDroitButton);
		topControlPanel.add(clignoDroitButton);
		topControlPanel.add(clignoGaucheButton);
		topControlPanel.add(homeButton);

		//
		KeyControls keyControls = new KeyControls();
		textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);

		city = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(city);
		dashboard = new GameDisplay(city, manager);

		/*MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);*/

		dashboard.setPreferredSize(preferredSize);

		contentPane.add(BorderLayout.NORTH, topControlPanel);
		contentPane.add(BorderLayout.SOUTH, dashboard);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		int interval = 0;
		run = true;
		while (run) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			interval +=1;
			if(interval%2==0){

			}
			manager.nextRound();
			dashboard.repaint();
		}
	}

	private class KeyControls implements KeyListener {

		@Override
		public void keyPressed(KeyEvent event) {
            try {
                char keyChar = event.getKeyChar();
                switch (keyChar) {
                case 'z':
                    manager.accelerate();
                    break;
                case 's':
                    manager.slow();
                    break;
                case 'q':
                    manager.turnLeft();
                    break;
                case 'd':
                    manager.turnRight();
                    break;
				case ' ':
					manager.brake();
					break;
                default:
                    break;
                }
            } catch (LimitReachedException e) {
                throw new RuntimeException(e);
            }
        }

		@Override
		public void keyTyped(KeyEvent e) {

		}

		@Override
		public void keyReleased(KeyEvent event) {
            char keyChar = event.getKeyChar();
            switch (keyChar) {
            case ' ':
                manager.getA().setBraking(false);;
                break;
            default:
                break;
            }

        }
	}

	/**
	 * Class that implements an ActionListener for the HomeButton
	 *
	 */
	private class HomeListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			run=false;
			StartMenu startMenu = new StartMenu("Auto Ecole");
		}
	}

	private class AngleMortGaucheListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(manager.getA().isAngleMortGauche()){
				manager.getA().setAngleMortGauche(false);
			}
			else{
				manager.getA().setAngleMortGauche(true);
			}
			textField.requestFocusInWindow();
		}
	}

	private class AngleMortDroitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(manager.getA().isAngleMortDroit()){
				manager.getA().setAngleMortDroit(false);
			}
			else{
				manager.getA().setAngleMortDroit(true);
			}
			textField.requestFocusInWindow();
		}
	}

	/** 
	 * Class that implements an ActionListener for the clignoGauchebutton.
	 * 
	 */
	private class ClignoGaucheListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// If clignoDroit == true set it as false when button clicked.
			if(manager.getA().isClignoGauche()) {
				manager.getA().setClignoGauche(false);
			}
			else {
				manager.getA().setClignoGauche(true);
			}
			textField.requestFocusInWindow();
		}
	}

	
	/** 
	 * Class that implements an ActionListener for the clignoDroitbutton.
	 * 
	 */
	private class ClignoDroitListener implements ActionListener {
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// If clignoDroit == true set it as false when button clicked.
			if(manager.getA().isClignoDroit()) {
				manager.getA().setClignoDroit(false);
			}
			else {
				manager.getA().setClignoDroit(true);
			}
			textField.requestFocusInWindow();
		}
	}

	


}
