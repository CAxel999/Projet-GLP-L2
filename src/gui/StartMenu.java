package gui;

import config.GameConfiguration;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


/**
 * GUI for the start menu
 *
 * It has 2 buttons to lead to {@link MainGUI}.
 */
public class StartMenu extends JFrame {

    private final static Dimension preferedDimension = new Dimension(config.GameConfiguration.WINDOW_WIDTH, config.GameConfiguration.WINDOW_HEIGHT);
    private JButton training = new JButton("Entrainement");
    private JButton exam = new JButton("Examen");

    private JButton quit = new JButton("Quitter");

    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel buttonPanel;

    // Images et labels
    private ImageIcon controlsIcon;
    private JLabel controlsLabel;
    private ImageIcon secondIcon;
    private JLabel secondLabel;

    // Image d'arrière-plan
    private ImageIcon backgroundIcon;

    public StartMenu(String title) {
        super(title);
        initStartMenu();
    }

    public void initStartMenu() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        try {
            controlsIcon = new ImageIcon(getClass().getResource("/images/controles.png"));
            secondIcon = new ImageIcon(getClass().getResource("/images/controles1.png"));
            backgroundIcon = new ImageIcon(getClass().getResource("/images/menustart.png"));
        } catch (Exception e) {
            System.err.println("Erreur lors du chargement des images: " + e.getMessage());
        }



        // Redimensionnement des images
        Image controlsImg = controlsIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        controlsIcon = new ImageIcon(controlsImg);
        Image secondImg = secondIcon.getImage().getScaledInstance(200, 100, Image.SCALE_SMOOTH);
        secondIcon = new ImageIcon(secondImg);

        // Redimensionnement de l'image d'arrière-plan
        if (backgroundIcon != null && backgroundIcon.getImage() != null) {
            Image bgImg = backgroundIcon.getImage().getScaledInstance(600, 300, Image.SCALE_SMOOTH);
            backgroundIcon = new ImageIcon(bgImg);
        }







        // Configuration du panel central avec l'image centrale
        centerPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dessiner l'image d'arrière-plan si elle existe
                if (backgroundIcon != null && backgroundIcon.getImage() != null) {
                    g.drawImage(backgroundIcon.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
                }
            }
        };
        centerPanel.setLayout(new BorderLayout());
        centerPanel.setOpaque(false);

        // Configuration du panel des boutons (bas)
        buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(230, 230, 230));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        // Configuration des boutons et des images
        training.setPreferredSize(new Dimension(150, 75));
        training.setFont(new Font("Arial", Font.BOLD, 16));
        training.addActionListener(new TrainingListener(this));

        exam.addActionListener(new ExamListener(this));
        exam.setFont(new Font("Arial", Font.BOLD, 16));
        exam.setPreferredSize(new Dimension(150,75));

        quit.addActionListener(new QuitListener(this));
        quit.setPreferredSize(new Dimension(100,35));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.lightGray);



        controlsLabel = new JLabel(controlsIcon);
        secondLabel = new JLabel(secondIcon);

        // Création d'un panel spécifique pour la disposition horizontale
        JPanel horizontalPanel = new JPanel();
        horizontalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 0));
        horizontalPanel.setBackground(Color.WHITE);


        horizontalPanel.add(controlsLabel);
        topPanel.add(quit);
        horizontalPanel.add(training);
        horizontalPanel.add(exam);
        horizontalPanel.add(secondLabel);

        buttonPanel.add(horizontalPanel);

        // Ajout des panels au contentPane

        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(centerPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.setBackground(Color.WHITE);

        setPreferredSize(preferedDimension);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Centre la fenêtre sur l'écran
        setVisible(true);
        setResizable(false);


    }

    private class TrainingListener implements ActionListener {
        //Window to be closed.
        private JFrame window;

        public TrainingListener(JFrame window) {
            this.window = window;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            MainGUI gameMainGUI = null;
            try {
                gameMainGUI = new MainGUI("Auto Ecole");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            GameConfiguration.EXAM = false;
            Thread gameThread = new Thread(gameMainGUI);
            gameThread.start();
            setVisible(false);
        }


    }

    private class ExamListener implements ActionListener {
        //Window to be closed.
        private JFrame window;

        public ExamListener(JFrame window) {
            this.window = window;
        }


        @Override
        public void actionPerformed(ActionEvent e) {
            MainGUI gameMainGUI = null;
            try {
                gameMainGUI = new MainGUI("Auto Ecole");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            GameConfiguration.EXAM = true;
            Thread gameThread = new Thread(gameMainGUI);
            gameThread.start();
            setVisible(false);
        }


    }

    private class QuitListener implements ActionListener {
        //Window to be closed.
        private JFrame window;

        public QuitListener(JFrame window) {
            this.window = window;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            window.dispose();
            System.exit(0);
        }


    }
}