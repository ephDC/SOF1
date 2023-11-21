package org.hbrs.se1.ws23.uebung4.prototype;

import java.util.Scanner;

public class EingabeDialog {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Bitte Befehl eingeben");
        System.out.println("> befehl");
        switch (sc.next()){
            case "help":
                //code here
                break;
            case "store":
                //code here
                break;
            case "load":
                //code here
                break;
            case "dump":
                //code here
                break;
            case "search":
                //code here
                break;
                //code here
            case "enter":
                //code here
                break;
            //code here
            case "exit":
                break;
        }
        sc.close();

    }
}
