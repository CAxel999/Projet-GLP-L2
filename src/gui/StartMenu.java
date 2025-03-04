package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartMenu extends JFrame{
    private final static Dimension preferedDimension = new Dimension(config.GameConfiguration.WINDOW_WIDTH, config.GameConfiguration.WINDOW_HEIGHT);
    private JPanel dashboard;
    private JButton training = new JButton("Entrainement");
    private JButton exam = new JButton("Examen");
    private JButton quit = new JButton("Quitter");
    private JPanel bottomPanel;
    private JPanel buttonPanel;
    private JPanel commandDashboard;


    public StartMenu(String title) {
        super(title);
        initStartMenu();
    }

    public void initStartMenu() {
        Container contentPane=getContentPane();
        dashboard=new JPanel();
        contentPane.setLayout(new BorderLayout());



        buttonPanel=new JPanel(new GridLayout(3,1));
        commandDashboard=new JPanel();

        training.addActionListener(new TrainingListener(this));
        exam.addActionListener(new ExamListener(this));
        quit.addActionListener(new QuitListener(this));

        buttonPanel.add(training);
        buttonPanel.add(exam);
        buttonPanel.add(quit);

        bottomPanel=new JPanel(new GridLayout());
        bottomPanel.add(buttonPanel);
        bottomPanel.add(commandDashboard);

        contentPane.add(dashboard, BorderLayout.NORTH);
        contentPane.add(bottomPanel);

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

