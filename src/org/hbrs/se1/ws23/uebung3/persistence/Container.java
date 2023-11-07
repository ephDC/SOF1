package org.hbrs.se1.ws23.uebung3.persistence;
import org.hbrs.se1.ws23.uebung2.ContainerException;
import org.hbrs.se1.ws23.uebung2.Member;
import org.hbrs.se1.ws23.uebung3.persistence.MemberView;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Container {
    private List<Member> memberList = new ArrayList <Member>();
    private static Container container = new Container();

    //private Kontruktor, sodss es nicht von aussen genutzt wird. (Singleton)
    private Container(){}

    public static Container getContainer(){
        return container;
    }

    public void addMember(Member member) throws ContainerException {

        if (member == null) {
            throw new ContainerException("Member ist null");
        }
        Integer ID = member.getID();
        for ( Member rec : memberList) {
            // wichtig: Check auf die Values innerhalb der Integer-Objekte!
            if (rec.getID().intValue() == ID.intValue()) {
                throw new ContainerException("„Das Member-Objekt mit der ID " + member.getID() +
                        " ist bereits vorhanden!");
            }
        }
        memberList.add(member);
    }

    public String deleteMember(Integer id){

        Member rec = getMember( id );
        if (rec == null) return "Member nicht enthalten - ERROR"; else {
            memberList.remove(rec);
            return "Member mit der ID " + id + " konnte nicht geloescht werden";
        }
    }

    public int size(){
        return memberList.size();
    }

    private Member getMember(Integer id) {
        for ( Member rec : memberList) {
            if (id == rec.getID().intValue() ){
                return rec;
            }
        }
        return null;
    }

    public void dump(){
        for (Member member : memberList) {
            System.out.println(String.valueOf("Member ID = " + member.getID().toString()));
        }
    }

    public void store() throws PersistenceException{
        List<Member> stored = new ArrayList <Member>();
        //stored.add(memberList.get(memberList.size() - 1));
        String s = memberList.get(memberList.size() - 1).toString();
        //if(memberList == null){
            //throw new PersistenceException(NullPointerException,"");
       // }
    }

    public void load() throws PersistenceException{
        String s = memberList.get(memberList.size() - 1).toString();
        s = null;
    }

    public void dump(List<Member> liste){
        MemberView.dump(liste);
    }

    public List<Member> getCurrentList(){
        return this.memberList;
    }

    public void setPersistenceStrategy(PersistenceStrategy p){
        p = new PersistenceStrategy() {
            @Override
            public void openConnection() throws PersistenceException {

            }

            @Override
            public void closeConnection() throws PersistenceException {

            }

            @Override
            public void save(List member) throws PersistenceException {

            }

            @Override
            public List load() throws PersistenceException {
                return null;
            }
        };
    }
}
