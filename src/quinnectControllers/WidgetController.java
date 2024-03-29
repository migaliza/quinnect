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
import quinnectModels.WebBrowser;
import quinnectModels.YouTube;

/**
 *
 * @author Prophet
 */
public class WidgetController {

    private Widget w;
    private WebBrowser wb;
    private YouTube yt;
    private WidgetAnimations wa;
    private Models m;
    MouseListener mouseListener;
    KeyListener keyListener;
    String mode = "google";

    public WidgetController(Widget w, WidgetAnimations wa, Models m) {
        this.w = w;
        this.wa = wa;
        this.m = m;
        wb = new WebBrowser();
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

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (wa.getMode().equals("google")) {
                        try {
                            search(w.getSearchField().getText());
                        } catch (IOException ex) {
                            Logger.getLogger(WidgetController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (wa.getMode().equals("youtube")) {
                        searchYoutube(w.getSearchField().getText());
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };

        mouseListener = new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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

    /**
     * A method that allows you to search google
     *
     * @param words
     * @throws IOException
     */
    public void search(String words) throws IOException {
        if (!wb.isWebsite(words)) {
            String newWord = convertToSearchable(words);
            try {
                //Set your page url in this string. For eg, I m using URL for Google Search engine
                String url = "https://www.google.com/search?q=" + newWord;
                java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
                System.out.println("About to search: " + newWord);
            } catch (java.io.IOException ex) {
                System.out.println(ex.getMessage());
            }
        } else {
            String url = wb.urlReturned(words);
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
            System.out.println("About to open a website: " + words);
           
        }
    }

    /**
     * A method that allows you to search youtube
     *
     * @param words
     */
    public void searchYoutube(String words) {
        String newWord = convertToSearchable(words);
        try {
            //Set your page url in this string. For eg, I m using URL for Google Search engine
            String url = "https://www.youtube.com/results?search_query=" + newWord;
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
        return words.replaceAll(" ", "+");
    }

}
