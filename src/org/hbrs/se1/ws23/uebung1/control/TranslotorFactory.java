package org.hbrs.se1.ws23.uebung1.control;

public class TranslotorFactory {
    public static GermanTranslator createGermanTranslator() {

        return new GermanTranslator();
    }
}
