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
import java.awt.event.MouseMotionListener;
import quinnectViews.Widget;

/**
 *
 * @author Prophet
 */
public class WidgetAnimations {
    Widget w;
    MouseMotionListener mouseMotionListener;

    public WidgetAnimations(Widget w) {
        this.w = w;
        control();
    }
    
    
    /**
     * The control contains all the methods and functions that allow this class to
     * function
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
    private void displayInCorner(){
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
    private void makeMovable(){
         mouseMotionListener = new MouseMotionListener(){

             @Override
             public void mouseDragged(MouseEvent e) {
                 if(e.getSource()==w.getMain()){
                     w.setLocation(w.xPos(),w.yPos());
                 } else if(e.getSource()==w.getTop()){
                     w.setLocation(w.xPos(),w.yPos());
                 } else if(e.getSource()==w.getBottom()){
                     w.setLocation(w.xPos(),w.yPos());
                 }     
             }

             @Override
             public void mouseMoved(MouseEvent e) {
                
             }
         };
         
         w.getMain().addMouseMotionListener(mouseMotionListener);
    }
    
    private void iconTransparency(){
        
        w.getTop().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
        w.getMain().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.5f));
        w.getBottom().setBackground(new Color(1.0f, 1.0f, 1.0f, 0.0f));
    }

}
