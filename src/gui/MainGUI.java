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

	private JButton homeButton =new JButton("Home");

	private JButton pauseButton = new JButton("Pause");
	private JPanel control = new JPanel();

	//Used for button stop and run method
	private boolean stop=true;

	public MainGUI(String title) {
		super(title);
		init();
	}

	private void init() {

		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());

		//Button pause
//		pauseButton.addActionListener(new PauseAction());
//		control.setLayout(new FlowLayout(FlowLayout.RIGHT));
//		control.add(pauseButton);
		homeButton.addActionListener(new HomeListener());
		control.setLayout(new FlowLayout(FlowLayout.RIGHT));
		control.add(homeButton);

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
		//Button pause
//		contentPane.add(BorderLayout.NORTH, control);
		contentPane.add(BorderLayout.NORTH, control);
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
		while (true) {
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

	private class PauseListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			/*if(stop){
				stop=false;
				pauseButton.setText("Reprendre");
			}
			else {
				stop=true;
				pauseButton.setText("Pause");
			}
			*/
		}
	}

	private class HomeListener implements ActionListener{
		//Window to be closed.
//		private JFrame window;
//
//		public HomeListener(JFrame window) {
//
//			this.window = window;
//		}
		@Override
		public void actionPerformed(ActionEvent e) {
//			if(gameWindow !=null){
//				gameWindow.dispose();
//			}
			dispose();
			StartMenu startMenu = new StartMenu("Auto Ecole");
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
