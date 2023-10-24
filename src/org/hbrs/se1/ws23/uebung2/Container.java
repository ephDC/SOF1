package org.hbrs.se1.ws23.uebung2;

import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Container {
    private static final List<Member> memberList = new ArrayList <Member>();

    public static void addMember(Member member) throws ContainerException{
        if(memberList.contains(member)){
            throw new ContainerException("„Das Member-Objekt mit der ID " + member.getID() +
                    " ist bereits vorhanden!");
        }
        memberList.add(member);
    }

    public static String deleteMember(Integer id){

        String s = "";
        if(memberList.stream().anyMatch(p -> p.getID().equals(id))){
            // Dieser Art von Fehlerbehandlung ist nicht besser als Exceptions weil,
            // Exceptions stellen sicher, dass Fehler nicht unbemerkt bleiben,
            // weil der aufrufende Code keinen Rückkehrcode überprüft hat

            memberList.removeIf(e -> e.getID().equals(id));
            // eindeutige ID des Objekts vom Typ Member
            for (Member member : memberList) {
                s += (member.getID());
            }
            return s;
        }
            return ("Dieser Member existiert nicht!");

    }

    public static int size(){
        return memberList.size();
    }

    public static void dump(){
        for (Member member : memberList) {
            System.out.println(String.valueOf("Member ID = " + member.getID().toString()));

        }
    }
}
