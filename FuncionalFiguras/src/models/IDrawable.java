package models;

import java.awt.*;

@FunctionalInterface
public interface IDrawable<T> {
    void draw(Graphics graphics, T object);
}
