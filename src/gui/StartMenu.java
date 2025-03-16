package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame {

    private final static Dimension preferedDimension = new Dimension(config.GameConfiguration.WINDOW_WIDTH, config.GameConfiguration.WINDOW_HEIGHT);
    private JButton training = new JButton("Entrainement");
    private JButton exam = new JButton("Examen");

    private JButton quit = new JButton("Quitter");
    private JPanel topPanel;
    private JPanel infoPanel;
    private JPanel buttonPanel;
    private JPanel commandDashboard;



    public StartMenu(String title) {
        super(title);
        initStartMenu();
    }

    public void initStartMenu() {
        Container contentPane=getContentPane();
        contentPane.setLayout(new BorderLayout());

        //buttonPanel=new JPanel(new GridLayout(3,1));
        commandDashboard=new JPanel();

        training.addActionListener(new TrainingListener(this));
        training.setPreferredSize(new Dimension(150,75));
        exam.addActionListener(new ExamListener(this));
        exam.setPreferredSize(new Dimension(150,75));
        quit.addActionListener(new QuitListener(this));
        quit.setPreferredSize(new Dimension(100,35));

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        topPanel.setBackground(Color.lightGray);
        infoPanel = new JPanel();
        buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        topPanel.add(quit);
        buttonPanel.add(training);
        buttonPanel.add(exam);

        contentPane.add(topPanel, BorderLayout.NORTH);
        contentPane.add(infoPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setPreferredSize(preferedDimension);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
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
            MainGUI gameMainGUI = new MainGUI("Auto Ecole");
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
            MainGUI gameMainGUI = new MainGUI("Auto Ecole");
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
        }


    }
}
