package org.hbrs.se1.ws23.uebung2;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class ContainerTest {

    public static void main (String[] args){

        Member a = new ConcreteMember(1){};
        Member b = new ConcreteMember(2){};
        Member c = new ConcreteMember(3){};
        Member d = new ConcreteMember(3){};

        System.out.println(a.getID());
        System.out.println(b.getID());
        System.out.println(c.getID());
        //Try Catch zum Testen

        try {
            Container.addMember(a);
            Container.addMember(b);
            Container.addMember(c);
            System.out.println();

            System.out.println(Container.size());
            System.out.println();

            Container.dump();
            System.out.println();
            System.out.println(Container.deleteMember(3));
        }
        catch (ContainerException e){
            System.out.println(e.getMessage());
        }

    }

}
