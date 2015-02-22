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
    String currTopUrl = "../quinnectViews/icons/twitter_small_transparent.png";
    String currMainUrl = "../quinnectViews/icons/google_big_transparent.png";
    String currBottomUrl = "../quinnectViews/icons/youtube_small_transparent.png";
    /* Transparent Small Icons */
    String currTransparentSmallTopUrl = "../quinnectViews/icons/twitter_small_transparent.png";
    String currTransparentSmallMainUrl = "../quinnectViews/icons/google_small_transparent.png";
    String currTransparentSmallBottomUrl = "../quinnectViews/icons/youtube_small_transparent.png";
    /* Transparent Big Icons */
    String currTransparentBigTopUrl = "../quinnectViews/icons/twitter_big_transparent.png";
    String currTransparentBigMainUrl = "../quinnectViews/icons/google_big_transparent.png";
    String currTransparentBigBottomUrl = "../quinnectViews/icons/youtube_big_transparent.png";
    
    String currTextBoard = "../quinnectViews/icons/google_board.png";

    String mode = "";
    private int count = 0;
    

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
                    w.getTextBoard().setVisible(false);
                    w.getSearchField().setVisible(false);
                    w.getTop().setVisible(false);
                    w.getBottom().setVisible(false);
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
        w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTransparentBigMainUrl)));
        w.getTextBoard().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTextBoard)));
        w.getBottom().setVisible(false);
        mouselistener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                //refresh();
                if (e.getSource() == w.getTop()) {
                    switchMode();
                } else if (e.getSource() == w.getMain()) {
                    switchMode();
                } else if (e.getSource() == w.getBottom()) {
                    switchMode();
                }
                count++;
                System.out.println("----------------------");
                System.out.println("Current Mode: " + mode);
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
                    w.getTextBoard().setVisible(true);
                    w.getSearchField().setVisible(true);
                    w.getTop().setVisible(true);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currMainUrl)));
                    w.getBottom().setVisible(true);
                } else if (e.getSource() == w.getTop()) {
                    
                } else if (e.getSource() == w.getBottom()) {
                    
                }
                w.getTop().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTopUrl)));
                w.getBottom().setIcon(new javax.swing.ImageIcon(getClass().getResource(currBottomUrl)));
                w.getTextBoard().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTextBoard)));
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (e.getSource() == w.getMain()) {                    
                    w.getTop().setVisible(false);
                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTransparentBigMainUrl)));
                    w.getBottom().setVisible(false);
                } else if (e.getSource() == w.getTop()) {
//                    w.getTop().setVisible(false);
//                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTransparentBigMainUrl)));
//                    //w.getBottom().setVisible(false);
                } else if (e.getSource() == w.getBottom()) {
//                    //w.getTop().setVisible(false);
//                    w.getMain().setIcon(new javax.swing.ImageIcon(getClass().getResource(currTransparentBigMainUrl)));
//                    w.getBottom().setVisible(false);
                }
            }
        };

        w.getTop().addMouseListener(mouselistener);
        w.getMain().addMouseListener(mouselistener);
        w.getBottom().addMouseListener(mouselistener);
        w.getSearchField().addMouseListener(mouselistener);
        w.getTextBoard().addMouseListener(mouselistener);

    }

    /**
     *
     * @param wc
     */
    public void switchMode() {        
        if (turnTable()==2) {
            mode = "twitter";
            currTopUrl = "../quinnectViews/icons/youtube_small.png";
            currMainUrl = "../quinnectViews/icons/twitter_big.png";
            currBottomUrl = "../quinnectViews/icons/google_small.png";


            /* Transparent Small */
            currTransparentSmallTopUrl = "../quinnectViews/icons/youtube_small_transparent.png";
            currTransparentSmallMainUrl = "../quinnectViews/icons/twitter_small_transparent.png";
            currTransparentSmallBottomUrl = "../quinnectViews/icons/google_small_transparent.png";

            /* Transparent Big */
            currTransparentBigTopUrl = "../quinnectViews/icons/youtube_big_transparent.png";
            currTransparentBigMainUrl = "../quinnectViews/icons/twitter_big_transparent.png";
            currTransparentBigBottomUrl = "../quinnectViews/icons/google_big_transparent.png";
            
            /* TextBoard Animation */
            currTextBoard = "../quinnectViews/icons/twitter_board.png";

        } else if (turnTable()==0) {
            mode = "google";
            currTopUrl = "../quinnectViews/icons/twitter_small.png";
            currMainUrl = "../quinnectViews/icons/google_big.png";
            currBottomUrl = "../quinnectViews/icons/youtube_small.png";

            /* Transparent Small */
            currTransparentSmallTopUrl = "../quinnectViews/icons/twitter_small_transparent.png";
            currTransparentSmallMainUrl = "../quinnectViews/icons/google_small_transparent.png";
            currTransparentSmallBottomUrl = "../quinnectViews/icons/youtube_small_transparent.png";

            /* Transparent Big */
            currTransparentBigTopUrl = "../quinnectViews/icons/twitter_big_transparent.png";
            currTransparentBigMainUrl = "../quinnectViews/icons/google_big_transparent.png";
            currTransparentBigBottomUrl = "../quinnectViews/icons/youtube_big_transparent.png";
            
            /* TextBoard Animation */
            currTextBoard = "../quinnectViews/icons/google_board.png";
        } else if (turnTable()==1) {
            mode = "youtube";
            currTopUrl = "../quinnectViews/icons/google_small.png";
            currMainUrl = "../quinnectViews/icons/youtube_big.png";
            currBottomUrl = "../quinnectViews/icons/twitter_small.png";

            /* Transparent Small */
            currTransparentSmallTopUrl = "../quinnectViews/icons/google_small_transparent.png";
            currTransparentSmallMainUrl = "../quinnectViews/icons/youtube_small_transparent.png";
            currTransparentSmallBottomUrl = "../quinnectViews/icons/twitter_small_transparent.png";

            /* Transparent Big */
            currTransparentBigTopUrl = "../quinnectViews/icons/google_big_transparent.png";
            currTransparentBigMainUrl = "../quinnectViews/icons/youtube_big_transparent.png";
            currTransparentBigBottomUrl = "../quinnectViews/icons/twitter_big_transparent.png";
            
            /* TextBoard Animation */
            currTextBoard = "../quinnectViews/icons/youtube_board.png";
        }
        refresh();
    }

    /**
     * Check the current state
     *
     * @return
     */
    public int turnTable() {        
        return count%3;
    }
    
    private void refresh(){
        w.getTop().setVisible(false);
        w.getMain().setVisible(false);
        w.getBottom().setVisible(false);
        w.getTextBoard().setVisible(false);
        
        w.getTop().setVisible(true);
        w.getMain().setVisible(true);
        w.getBottom().setVisible(true);
        w.getTextBoard().setVisible(true);
        w.dispose();
        w.setVisible(true);
    }
    
    public String getMode(){
        return mode;
    }

}
