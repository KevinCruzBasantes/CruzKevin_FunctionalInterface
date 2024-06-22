package view;

import controller.Container;
import models.Circle;
import models.Square;
import models.Triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    private Container container;
    private JPanel drawPanel;
    private int baseSize;
    

    public Frame() {
        container = new Container();
        baseSize = 80;
        setLayout(null);

        JButton botonTriangulo = new JButton("Triangulo");
        JButton botonCuadrado = new JButton("Cuadrado");
        JButton botonCirculo = new JButton("Circulo");

        botonTriangulo.setBounds(50, 50, 100, 50);
        add(botonTriangulo);

        botonCuadrado.setBounds(50, 150, 100, 50);
        add(botonCuadrado);

        botonCirculo.setBounds(50, 250, 100, 50);
        add(botonCirculo);

        botonTriangulo.addActionListener(this);
        botonCuadrado.addActionListener(this);
        botonCirculo.addActionListener(this);

        drawPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                container.draw(g);
            }
        };
        drawPanel.setBounds(200, 50, 150, 250);
        drawPanel.setBackground(Color.WHITE);
        add(drawPanel);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int panelWidth = drawPanel.getWidth();
        int panelHeight = drawPanel.getHeight();

        if (e.getActionCommand().equals("Triangulo")) {
            int size = baseSize; // Altura del triángulo
            int[] xPoints = {panelWidth / 2, panelWidth / 2 - size / 2, panelWidth / 2 + size / 2};
            int[] yPoints = {(panelHeight - size) / 2, (panelHeight + size) / 2, (panelHeight + size) / 2};
            container.setTriangle(new Triangle(xPoints, yPoints), Color.RED);
        } else if (e.getActionCommand().equals("Cuadrado")) {
            int size = baseSize;
            int x = (panelWidth - size) / 2;
            int y = (panelHeight - size) / 2;
            container.setSquare(new Square(x, y, size), Color.GREEN);
        } else if (e.getActionCommand().equals("Circulo")) {
            int radius = baseSize / 2;
            int x = (panelWidth - radius * 2) / 2;
            int y = (panelHeight - radius * 2) / 2;
            container.setCircle(new Circle(x, y, radius), Color.BLUE);
        }
        drawPanel.repaint();
    }
}
