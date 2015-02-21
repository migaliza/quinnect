/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quinnectControllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import quinnectModels.Models;
import quinnectViews.Widget;

/**
 *
 * @author Prophet
 */
public class WidgetController {

    private Widget w;
    private Models m;
    MouseListener mouseListener;
    KeyListener keyListener;
    String mode = "google";

    public WidgetController(Widget w, Models m) {
        this.w = w;
        this.m = m;
        control();

    }

    /**
     * The control contains all the methods and functions that allow this class
     * to function
     */
    private void control() {

        keyListener = new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER) {
                    try {
                        search(w.getSearchField().getText());
                    } catch (IOException ex) {
                        Logger.getLogger(WidgetController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };

        mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == w.getTop()) {
                    mode = "twitter";
                }else if(e.getSource() == w.getMain()){
                    mode = "google";
                }else{
                    mode = "youtube";
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        /**
         * A method that does a normal search
         */
        
        w.getTop().addMouseListener(mouseListener);
        w.getMain().addMouseListener(mouseListener);
        w.getBottom().addMouseListener(mouseListener);
        w.getSearchField().addKeyListener(keyListener);
   

}
    
     public void search(String words) throws IOException {
        String newWord = convertToSearchable(words);        
        try {
            //Set your page url in this string. For eg, I m using URL for Google Search engine
            String url = "https://www.google.com/search?q=" + newWord;
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            System.out.println("About to search: " + newWord);
        } catch (java.io.IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     /**
      * A helper method to prevent errors
      */
     private String convertToSearchable(String words) {
        return  words.replaceAll(" ","+");
    }
     
     /**
      * Check the current state
      * @return 
      */
     public String getMode(){
         return mode;
     }

}
