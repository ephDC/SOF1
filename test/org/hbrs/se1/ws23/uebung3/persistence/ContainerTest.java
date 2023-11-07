package org.hbrs.se1.ws23.uebung3.persistence;
import org.hbrs.se1.ws23.uebung2.ConcreteMember;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    private Container container;
    Container a = Container.getContainer();

    @BeforeEach
    void setUp() {
        // Den Container anlegen
        container = Container.getContainer();
    }

    @Test
    void addMember() {
        Member a = new ConcreteMember(1);
        Member b = new ConcreteMember(2);
        Member c = new ConcreteMember(3);
        Member d = new ConcreteMember(1);

        assertEquals(0, container.size(),
                "Container is empty");
        try {
            container.addMember(a);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(1, container.size(),
                "Container size = 1");

        assertThrows(ContainerException.class, () -> {
            container.addMember(d); // Id ist schon vergeben
        });
    }

    @Test
    void deleteMember() {
        Member a = new ConcreteMember(1);
        Member b = new ConcreteMember(2);
        Member c = new ConcreteMember(3);

        try {
            container.addMember(a);
            container.addMember(b);
            container.addMember(c);
        } catch (ContainerException e) {
            e.printStackTrace();
        }
        assertEquals(3, container.size(),
                "Container size 3");

        String ergebnis1 = container.deleteMember(3);

        assertEquals(2, container.size(),
                "Container size 2");
    }

    @Test
    void aufNullTest() {
        assertThrows(ContainerException.class, () -> {
            container.addMember(null); // Null kann nicht angenommen werden!
        });
    }

    @Test
    void useOfPersistenceStrategyMongoDB(){

    }

    @Test
    void locationError(){
        File file = new File("codesSE2023/src/org/hbrs/se1/ws23/uebung3/location.txt");
        assertFalse(file.exists());
    }

    @Test
    public void testReadStream() throws IOException {
        InputStream inputStream = this.getClass().getResourceAsStream("codesSE2023/src/org/hbrs/se1" +
                "/ws23/uebung3/location.txt");
        assertNotNull(inputStream);
    }

}