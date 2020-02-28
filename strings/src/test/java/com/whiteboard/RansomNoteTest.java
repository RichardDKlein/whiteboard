package com.whiteboard;

import org.junit.jupiter.api.Test;

class RansomNoteTest {
    @Test
    void ransomNote() {
        System.out.println();
        System.out.println("Test RansomNote:");
        System.out.println("================");

        String note = "put ten dollars on the plate in the fridge or you will never see your sandwich again";
        String[] magazines = {
                "again dollars fridge in never on or plate put sandwich see ten the the will you your",
                "again dollars fridge in never on or plate put sandwich see ten the will you your"
        };

        RansomNote instance = new RansomNote();

        System.out.println("ransom note = \"" + note + "\"");
        for (String magazine : magazines) {
            System.out.println("magazine = \"" + magazine + "\"");
            System.out.println("can construct = " + instance.ransomNote(note, magazine));
        }
    }
}
