/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quinnectModels;

/**
 *
 * @author MIGALIZA
 */
import java.util.Scanner;
public class YouTube {
    
    public String getString(String text){
        return "www.youtube.com/results?search_query="+text;
    }
    
    public static void main(String[]args){
        YouTube a = new YouTube();
        Scanner input = new Scanner(System.in);
        String text=input.nextLine();
        System.out.println(a.getString(text));
    }
    
}
