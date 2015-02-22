/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quinnectModels;


import java.util.Scanner;

/**
 *
 * @author MIGALIZA
 */
public class WebBrowser {

    
    /* helper method that determines whether a the passed string is a 
    text or website*/
    public boolean isWebsite(String text){
        if(text.contains("."))
            return true;
        else
            return false;
    }
    
    /* method to find open a borwer*/
    
    public String  urlReturned(String text){
        if(isWebsite(text))
            return "http://www."+text;
        else
            return null;

    }
    public static void main(String[]args){
        WebBrowser a =  new WebBrowser();
        
        Scanner input = new Scanner(System.in);
        
        String text = input.nextLine();
        System.out.println(a.urlReturned(text));
        
        
    }
}
