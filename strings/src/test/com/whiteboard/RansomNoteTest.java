package java.com.whiteboard;

import org.junit.Test;

public class RansomNoteTest {
    @Test
    public void ransomNoteTest() {
        System.out.println();
        System.out.println("Test RansomNote:");
        System.out.println("================");

        String note = "put ten dollars on the plate in the fridge or you will never see your sandwich again";

        String[] magazines = {
                "again dollars fridge in never on or plate put sandwich see ten the the will you your",
                "again dollars fridge in never on or plate put sandwich see ten the will you your"
        };

        boolean[] expected = {
                true,
                false
        };

        System.out.println("ransom note = \"" + note + "\"");
        for (int i = 0; i < magazines.length; ++i) {
            System.out.println("magazine = \"" + magazines[i] + "\"");
            boolean canCreate = RansomNote.ransomNote(note, magazines[i]);
            assert(canCreate == expected[i]);
            System.out.println("can create = " + canCreate);
        }
    }
}
