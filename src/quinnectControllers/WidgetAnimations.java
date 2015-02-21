/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quinnectControllers;

import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import quinnectViews.Widget;

/**
 *
 * @author Prophet
 */
public class WidgetAnimations {

    Widget w;
    MouseMotionListener mouseMotionListener;
    MouseListener mouselistener;
    String currTopUrl = "../quinnectViews/icons/twitter_small.png";
    String currMainUrl = "../quinnectViews/icons/google_big.png";
    String currBottomUrl = "../quinnectViews/icons/youtube_small.png";

    public WidgetAnimations(Widget w) {
        this.w = w;
        control();
    }

    /**
     * The control contains all the methods and functions that allow this class
     * to function
     */
    private void control() {
        w.dispose();
        w.setUndecorated(true);
        w.setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        iconTransparency();
        displayInCorner();
        makeMovable();
    }

    /**
     * This methods allows a popped up screen to show up in the corner
     */
    private void displayInCorner() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
        Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
        int x = (int) rect.getMaxX() - w.getWidth();
        int y = (int) rect.getMaxY() - w.getHeight();
        w.setLocation(x, y);
        w.setVisible(true);
    }

    /**
     * This method allows the widget to become mobile
     */
    private void makeMovable() {
        mouseMotionListener = new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    w.setLocation(w.xPos(), w.yPos());
                } else if (e.getSource() == w.getTop()) {
                    w.setLocation(w.xPos(), w.yPos());
                } else if (e.getSource() == w.getBottom()) {
                    w.setLocation(w.xPos(), w.yPos());
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        };

        w.getMain().addMouseMotionListener(mouseMotionListener);
    }

    private void iconTransparency() {
        w.getTop().setVisible(false);
        w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/google_big_transparent.png")));
        w.getBottom().setVisible(false);
        mouselistener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    //
                } else if (e.getSource() == w.getTop()) {
                    //
                } else if (e.getSource() == w.getBottom()) {
                    //
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    //
                } else if (e.getSource() == w.getTop()) {
                    //
                } else if (e.getSource() == w.getBottom()) {
                    //
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    //
                } else if (e.getSource() == w.getTop()) {
                    //
                } else if (e.getSource() == w.getBottom()) {
                    //
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    w.getTop().setVisible(true);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currMainUrl)));
                    w.getBottom().setVisible(true);
                } else if (e.getSource() == w.getTop()) {
                    w.getTop().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/twitter_small.png")));
                } else if (e.getSource() == w.getBottom()) {
                    w.getBottom().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/youtube_small.png")));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == w.getMain()) {
                    w.getTop().setVisible(false);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/google_big_transparent.png")));
                    w.getBottom().setVisible(false);
                } else if (e.getSource() == w.getTop()) {
                    w.getTop().setVisible(false);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/google_big_transparent.png")));
                    //w.getBottom().setVisible(false);
                } else if (e.getSource() == w.getBottom()) {
                    //w.getTop().setVisible(false);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource("../quinnectViews/icons/google_big_transparent.png")));
                    w.getBottom().setVisible(false);
                }
            }
        };

        w.getTop().addMouseListener(mouselistener);
        w.getMain().addMouseListener(mouselistener);
        w.getBottom().addMouseListener(mouselistener);

    }

    /**
     *
     * @param wc
     */
    public void switchMode(WidgetController wc) {
        if (wc.getMode().equals("twitter")) {
            currTopUrl = "../quinnectViews/icons/youtube_small.png";
            currMainUrl = "../quinnectViews/icons/twitter_big.png";
            currBottomUrl = "../quinnectViews/icons/google_small.png";
        } else if (wc.getMode().equals("google")) {
            currTopUrl = "../quinnectViews/icons/twitter.png";
            currMainUrl = "../quinnectViews/icons/google_big.png";
            currBottomUrl = "../quinnectViews/icons/youtube_small.png";
        } else {
            currTopUrl = "../quinnectViews/icons/google_small.png";
            currMainUrl = "../quinnectViews/icons/youtube_big.png";
            currBottomUrl = "../quinnectViews/icons/twitter_small.png";
        }
    }

}
