package org.hbrs.se1.ws23.uebung3.persistence;
import org.hbrs.se1.ws23.solutions.uebung2.Member;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class MemberView {

    public MemberView(){

    }

    public static void dump(List<org.hbrs.se1.ws23.uebung2.Member> liste) {
        for (org.hbrs.se1.ws23.uebung2.Member member : liste) {
            System.out.println(String.valueOf("Member ID = " + member.getID().toString()));
        }
    }
}
