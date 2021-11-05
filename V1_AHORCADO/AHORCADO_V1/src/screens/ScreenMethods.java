/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package screens;

import java.awt.Graphics;

/**
 *
 * @author kaliw
 */
public interface ScreenMethods {
    public void render(Graphics g);
    public void mouseClick(int x, int y);
    public void mouseMov(int x, int y);
    public void mousePress(int x, int y);
    public void mouseReleas(int x, int y);
}
