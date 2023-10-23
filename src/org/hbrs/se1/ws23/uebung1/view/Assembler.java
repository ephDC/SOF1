package org.hbrs.se1.ws23.uebung1.view;

import org.hbrs.se1.ws23.uebung1.control.Translator;
import org.hbrs.se1.ws23.uebung1.control.GermanTranslator;

public class Assembler {
    public static  void main(String[] args){
        Translator translator = new GermanTranslator();
        Client client = new Client(translator);
        client.display(1);

    }
}
