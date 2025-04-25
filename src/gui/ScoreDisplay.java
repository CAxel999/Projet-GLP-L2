package gui;

import data.ScoreDescription;
import engine.process.ScoreManager;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI used for the display of the score
 *
 * This gui displays a score, and description of the {@link data.Scenario} and {@link data.Mistake}.
 */
public class ScoreDisplay extends JFrame {

    private final static Dimension preferedDimension = new Dimension(config.GameConfiguration.WINDOW_WIDTH, 450);
    private JButton homeButton;
    private JButton quit ;
    private JPanel topPanel;
    private JPanel scorePanel;
    private JLabel score;
    private ScoreManager scoreManager;
    private JTextArea scenario;
    private JTextArea mistake;
    private JTextArea eleminated;
    private ScoreDescription scoreDescription;

    public ScoreDisplay(String title, ScoreManager scoreManager) {
        super(title);
        this.scoreManager = scoreManager;
        initScoreDisplay();
    }

    public void initScoreDisplay() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        initializeComponentsOfPanels();
        setLayoutsOfPanels();
        addListenersToButtons();
        setupPanels();

        setPreferredSize(preferedDimension);  // Attention à la faute de frappe ici
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setResizable(false);
    }

    private void initializeComponentsOfPanels() {
        homeButton = new JButton("Accueil");
        homeButton.setBackground(Color.pink);
        homeButton.setForeground(Color.BLACK);
        homeButton.setFont(new Font("SansSerif", Font.BOLD, 14));
        homeButton.setPreferredSize(new Dimension(110, 35));

        quit = new JButton("Quitter");
        quit.setBackground(Color.pink);
        quit.setForeground(Color.BLACK);
        quit.setFont(new Font("SansSerif", Font.BOLD, 14));
        quit.setPreferredSize(new Dimension(110, 35));

        score = new JLabel("Note finale : " + scoreManager.getScore());
        score.setFont(new Font("SansSerif", Font.BOLD, 20));
        score.setHorizontalAlignment(SwingConstants.CENTER);


        scoreDescription = scoreManager.getScoreDescription();

        scenario = createTextArea(scoreDescription.getScenario());
        mistake = createTextArea(scoreDescription.getMistake());
        eleminated = createTextArea(scoreDescription.getEliminated());
    }

    private JTextArea createTextArea(String content) {
        JTextArea area = new JTextArea(content);
        area.setFont(new Font("SansSerif", Font.PLAIN, 16));
        area.setWrapStyleWord(true);
        area.setLineWrap(true);
        //area.setEditable(false);
        area.setBackground(new Color(250, 250, 250));
        return area;
    }

    private void setLayoutsOfPanels() {
        scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(1, 4, 10, 0));
        scorePanel.setBackground(new Color(240, 248, 255)); // Alice Blue
        scorePanel.setBorder(new EmptyBorder(15, 15, 15, 15));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(new Color(230, 230, 250)); // Lavender
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    private void addListenersToButtons() {
        homeButton.addActionListener(new HomeListener());
        quit.addActionListener(new QuitListener(this));
        homeButton.setPreferredSize(new Dimension(100, 35));
        quit.setPreferredSize(new Dimension(100, 35));
    }

    private void setupPanels() {
        topPanel.add(quit);
        topPanel.add(homeButton);

        scorePanel.add(score);
        scorePanel.add(new JScrollPane(scenario));
        scorePanel.add(new JScrollPane(mistake));
        scorePanel.add(new JScrollPane(eleminated));

        Container contentPane = getContentPane();
        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(scorePanel, BorderLayout.CENTER);
    }

    /**
     * Private Class that implements an ActionListener for the homebutton to close the ScoreDisplay window and open StartMenu.
     *
     */
    private class HomeListener implements ActionListener {

        /**
         * Method called to close ScoreDisplay window and open the StartMenu.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            StartMenu startMenu = new StartMenu("Auto Ecole");
        }
    }

    /**
     * Private Class that implements an ActionListener for the quit button to close the window and quit the application.
     */
    private class QuitListener implements ActionListener {
        //Window (JFrame) that will be closed.
        private JFrame window;

        /**
         * Constructor for QuitListener
         *
         * @param window the window that will be closed in this case is "this" window.
         */
        public QuitListener(JFrame window) {
            this.window = window;
        }

        /**
         * Method invoked when an action occurs.
         * Closes the window and exits the application.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            System.exit(0);
        }
    }

}
