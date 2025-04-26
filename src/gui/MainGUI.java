package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.*;

import config.GameConfiguration;
import engine.counters.LimitReachedException;
import engine.map.City;
import engine.map.roads.TrafficLight;
import engine.map.roads.TrafficLightEnum;
import engine.process.GameBuilder;
import engine.process.MobileInterface;
import engine.process.ScoreManager;
import exception.CarCrashException;

/**
 * GUI used for the execution of the driving simulation
 *
 * This gui displays the city, the cars and the important information for each round.
 */
public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private City city;

	private final static Dimension dashboardPreferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);
	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH+100, GameConfiguration.WINDOW_HEIGHT);

	private MobileInterface manager;
	private ScoreManager scoreManager;

	private GameDisplay dashboard;
	private SpeedDisplay speedDisplay;

	private JTextField textField;

	private boolean run ;

	// Content of top JPanel
	private JPanel rightControlPanel = new JPanel();
	private JButton homeButton = new JButton("Accueil");
	private JButton clignoGaucheButton = new JButton("Clignotant gauche");
	private JButton clignoDroitButton = new JButton("Clignotant droit");
	private JButton angleMortDroitButton = new JButton("Angle Mort droit");
	private JButton angleMortGaucheButton = new JButton("Angle Mort gauche");

	public MainGUI(String title) throws IOException {
		super(title);
		init();
	}

	/**
	 * Initialize the JFrame with it's component.
	 *
	 * @throws IOException
	 */
	private void init() throws IOException {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);

		//rightControlPanel components
		homeButton.addActionListener(new HomeListener());
		clignoGaucheButton.addActionListener(new ClignoGaucheListener());
		clignoDroitButton.addActionListener(new ClignoDroitListener());
		angleMortGaucheButton.addActionListener(new AngleMortGaucheListener());
		angleMortDroitButton.addActionListener(new AngleMortDroitListener());


		scoreManager = GameBuilder.buildScore();
		city = GameBuilder.buildMap(scoreManager);
		manager = GameBuilder.buildInitMobile(city, scoreManager);
		dashboard = new GameDisplay(city, manager);
		speedDisplay = new SpeedDisplay(manager);

		/*MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);*/
		rightControlPanel.setLayout(new GridLayout(6,1));
		rightControlPanel.add(homeButton);
		rightControlPanel.add(angleMortGaucheButton);
		rightControlPanel.add(angleMortDroitButton);
		rightControlPanel.add(clignoGaucheButton);
		rightControlPanel.add(clignoDroitButton);
		rightControlPanel.add(speedDisplay);
		dashboard.setPreferredSize(dashboardPreferredSize);
		contentPane.add(BorderLayout.EAST, rightControlPanel);
		contentPane.add(BorderLayout.WEST, dashboard);


		textField.requestFocusInWindow();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	/**
	 * The application main loop.
	 * Updates the application state every incrementation of the loop.
	 * Handles traffic light transitions and calls nextRound() and repaint().
	 */
	@Override
	public void run() {
		int interval = 0;
		run = true;
		GameConfiguration.END = false;
		GameConfiguration.CRASH = false;
		while (run) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			interval +=1;
			if(interval%300==0){

				GameBuilder.addNPCCar2(city,manager.getNPCCars());
			}
			if(interval==450){
				for(TrafficLight light : city.getLights()){
					if(light.getColor().equals(TrafficLightEnum.GREEN)){
						light.setColor(TrafficLightEnum.ORANGE);
					}
				}
				GameBuilder.addNPCCar1(city,manager.getNPCCars());
			}
			if(interval==900){
				interval = 0;
				for(TrafficLight light : city.getLights()){
					if(light.getColor().equals(TrafficLightEnum.ORANGE)){
						light.setColor(TrafficLightEnum.RED);
					} else if(light.getColor().equals(TrafficLightEnum.RED)){
						light.setColor(TrafficLightEnum.GREEN);
					}
				}
			}
			if(GameConfiguration.END && GameConfiguration.EXAM){
				dispose();
				run=false;
				ScoreDisplay scoreDisplay = new ScoreDisplay("Note", scoreManager);
			}
			else if(GameConfiguration.END){
				System.err.println("PresqueFIN");
				dashboard.repaint();
				run=false;
			} else {
				try {
					manager.nextRound();
					dashboard.repaint();
					speedDisplay.repaint();
				} catch (CarCrashException e) {
					run = false;
					GameConfiguration.CRASH = true;
					dashboard.repaint();
				}
			}
        }
	}

	/**
	 * Private class that implements KeyListeners to handle keyboard input.
	 *
	 */
	private class KeyControls implements KeyListener {

		/**
		 * Method is called depending on which key is pressed and other methods are called to control actions such as accelerating, slowing, braking, and turning to the left or right.
		 *
		 * @param event the event to be processed
		 */
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

		/**
		 * Called when a key is released.
		 * Handles stopping the braking action when the spacebar is released.
		 *
		 * @param event the KeyEvent triggered by the key release
		 */
        @Override
        public void keyReleased(KeyEvent event) {
            char keyChar = event.getKeyChar();
            switch (keyChar) {
                case ' ':
                    manager.getA().setBraking(false);
                    break;
                default:
                    break;
            }

		}
	}

	/**
	 * Private Class that implements an ActionListener for the homebutton to close the MainGUI, stop the game thread window and open StartMenu.
	 *
	 */
	private class HomeListener implements ActionListener {

		/**
		 * Method called to dispose of the MainGUI window.
		 * Stop the game thread.
		 * Open StartMenu.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			run=false;
			StartMenu startMenu = new StartMenu("Auto Ecole");
		}
	}

	/**
	 * Private class that implements an ActionListener for AngleMortGaucheButton.
	 */
	private class AngleMortGaucheListener implements ActionListener{

		/**
		 * Method called when button is trigerred and set the boolean on true when its false and false when it's true.
		 * Boolean is used to draw the left blind spot of users car.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manager.getA().setClignoGauche(false);
			manager.getA().setClignoDroit(false);
			manager.getA().setAngleMortDroit(false);

			if(manager.getA().isAngleMortGauche()){
				manager.getA().setAngleMortGauche(false);
			}
			else{
				manager.getA().setAngleMortGauche(true);
			}
			textField.requestFocusInWindow();
		}
	}

	/**
	 * Private class that implements an ActionListener for AngleMortDroitButton.
	 */
	private class AngleMortDroitListener implements ActionListener{

		/**
		 * Method called when button is trigerred and set the boolean on true when its false and false when it's true.
		 * Boolean is used to draw the right blind spot of users car.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manager.getA().setClignoGauche(false);
			manager.getA().setClignoDroit(false);
			manager.getA().setAngleMortGauche(false);

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

		/**
		 * Method called when button is trigerred and set the boolean on true when its false and false when it's true.
		 * Boolean is used to draw the left turn signal of users car.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manager.getA().setClignoDroit(false);
			manager.getA().setAngleMortGauche(false);
			manager.getA().setAngleMortDroit(false);
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

		/**
		 * Method called when button is trigerred and set the boolean on true when its false and false when it's true.
		 * Boolean is used to draw the right turn signal of users car.
		 *
		 * @param e the event to be processed
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			manager.getA().setClignoGauche(false);
			manager.getA().setAngleMortGauche(false);
			manager.getA().setAngleMortDroit(false);
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
