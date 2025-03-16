package test;

import javax.swing.*;
import java.awt.*;

public class TriangleAndRectangle extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Couleur du rectangle
        g2.setColor(Color.BLUE);

        // Définition de la position et des dimensions du rectangle
        int rectX = 150;  // Position X du rectangle
        int rectY = 100;  // Position Y du rectangle
        int rectWidth = 100;  // Largeur du rectangle
        int rectHeight = 150; // Hauteur du rectangle

        // Dessiner le rectangle
        g2.fillRect(rectX, rectY, rectWidth, rectHeight);

        // Couleur du triangle
        g2.setColor(Color.RED);

        // Définition des points du triangle
        // x l'odre des positions des coordonnées : haut , gauche , droite,
        int[] xPoints = {rectX, rectX - 100, rectX - 20}; // Sommet gauche du rectangle
        int[] yPoints = {rectY + 20, rectY + 100, rectY + 100}; // Triangle aligné avec le rectangle
        int nPoints = 3;

        // Dessiner le triangle
        g2.fillPolygon(xPoints, yPoints, nPoints);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle à gauche du Rectangle");
        TriangleAndRectangle panel = new TriangleAndRectangle();

        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
