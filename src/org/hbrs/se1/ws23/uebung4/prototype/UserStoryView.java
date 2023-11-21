package org.hbrs.se1.ws23.uebung4.prototype;

import org.hbrs.se1.ws23.uebung2.Member;

import java.util.List;

public class UserStoryView {
    public static void dump(List<UserStory> liste) {
        for (UserStory userStory : liste) {
            System.out.println(String.valueOf("Member ID = " + userStory.getRisk()));
        }
    }
}
