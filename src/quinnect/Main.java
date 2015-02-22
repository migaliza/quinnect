/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quinnect;

import quinnectControllers.WidgetAnimations;
import quinnectControllers.WidgetController;
import quinnectModels.Models;
import quinnectViews.Widget;

/**
 *
 * @author Prophet
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Widget w = new Widget();
        Models m = new Models();
        WidgetAnimations wa = new WidgetAnimations(w);
        WidgetController wc = new WidgetController(w,m);
        //wa.switchMode(wc);
        
        
    }
    
}
