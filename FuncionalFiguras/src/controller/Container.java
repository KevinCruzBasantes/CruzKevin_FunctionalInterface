package controller;

import models.Circle;
import models.IDrawable;
import models.Square;
import models.Triangle;

import java.awt.*;

public class Container {
    private IDrawable<Circle> drawCircle;
    private IDrawable<Square> drawSquare;
    private IDrawable<Triangle> drawTriangle;
    private Color color;
    private Object shape;
    public Container() {
        drawCircle = (graphics, circle) -> {
            graphics.setColor(color);
            graphics.fillOval(circle.getX(), circle.getY(), circle.getRadius() * 2, circle.getRadius() * 2);
        };

        drawSquare = (graphics, square) -> {
            graphics.setColor(color);
            graphics.fillRect(square.getX(), square.getY(), square.getSize(), square.getSize());
        };

        drawTriangle = (graphics, triangle) -> {
            graphics.setColor(color);
            graphics.fillPolygon(triangle.getXPoints(), triangle.getYPoints(), 3);
        };
    }
    public void draw(Graphics graphics) {
        if (shape instanceof Circle) {
            drawCircle.draw(graphics, (Circle) shape);
        } else if (shape instanceof Square) {
            drawSquare.draw(graphics, (Square) shape);
        } else if (shape instanceof Triangle) {
            drawTriangle.draw(graphics, (Triangle) shape);
        }
    }
    public void setCircle(Circle circle, Color color) {
        this.shape = circle;
        this.color = color;
    }

    public void setSquare(Square square, Color color) {
        this.shape = square;
        this.color = color;
    }

    public void setTriangle(Triangle triangle, Color color) {
        this.shape = triangle;
        this.color = color;
    }
}
