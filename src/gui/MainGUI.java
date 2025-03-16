package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JTextField;

import config.GameConfiguration;
import engine.counters.LimitReachedException;
import engine.map.City;
import engine.map.roads.TrafficLight;
import engine.process.GameBuilder;
import engine.process.MobileInterface;

public class MainGUI extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;

	private City city;

	private final static Dimension preferredSize = new Dimension(GameConfiguration.WINDOW_WIDTH, GameConfiguration.WINDOW_HEIGHT);

	private MobileInterface manager;

	private GameDisplay dashboard;

	public MainGUI(String title) throws IOException {
		super(title);
		init();
	}

	private void init() throws IOException {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		KeyControls keyControls = new KeyControls();
		JTextField textField = new JTextField();
		textField.addKeyListener(keyControls);
		contentPane.add(textField, BorderLayout.SOUTH);

		city = GameBuilder.buildMap();
		manager = GameBuilder.buildInitMobile(city);
		dashboard = new GameDisplay(city, manager);

		/*MouseControls mouseControls = new MouseControls();
		dashboard.addMouseListener(mouseControls);*/

		dashboard.setPreferredSize(preferredSize);
		contentPane.add(dashboard, BorderLayout.CENTER);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		setPreferredSize(preferredSize);
		setResizable(false);
	}

	@Override
	public void run() {
		int interval = 0;
		while (true) {
			try {
				Thread.sleep(GameConfiguration.GAME_SPEED);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			interval +=1;
			if(interval%300==0){
				GameBuilder.addNPCCar1(city,manager.getNPCCars());
				GameBuilder.addNPCCar2(city,manager.getNPCCars());
			}
			if(interval==2100){

				interval = 0;
				for(TrafficLight light : city.getLights1()){

				}
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
		public void keyReleased(KeyEvent e) {

		}
	}

	/*private class MouseControls implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int x = e.getX();
			int y = e.getY();
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}*/

}
