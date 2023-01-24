package java.com.whiteboard;

import org.junit.Test;

import java.util.*;

import java.com.whiteboard.CreateNestedFolders.Folder;

public class CreateNestedFoldersTest {
    @Test
    public void createNestedFoldersTest() {
        System.out.println();
        System.out.println("Test CreateNestedFolders:");
        System.out.println("=========================");

        Folder[] folderArray = {
            new Folder("root",     null),
            new Folder("I",        "root"),
            new Folder("I.A",      "I"),
            new Folder("I.A.1",    "I.A"),
            new Folder("I.A.2",    "I.A"),
            new Folder("I.A.3",    "I.A"),
            new Folder("I.B",      "I"),
            new Folder("I.B.1",    "I.B"),
            new Folder("I.B.1.a",  "I.B.1"),
            new Folder("I.B.1.b",  "I.B.1"),
            new Folder("I.B.2",    "I.B"),
            new Folder("II",       "root"),
            new Folder("II.A",     "II"),
            new Folder("II.A.1",   "II.A"),
            new Folder("II.A.2",   "II.A"),
            new Folder("II.A.2.a", "II.A.2"),
            new Folder("II.A.2.b", "II.A.2"),
            new Folder("II.A.2.c", "II.A.2"),
            new Folder("II.B",     "II"),
            new Folder("II.B.1",   "II.B"),
            new Folder("II.B.2",   "II.B"),
            new Folder("II.B.3",   "II.B")
        };

        List<Folder> folderList = new LinkedList<>();
        for (Folder folder : folderArray) {
            folderList.add(folder);
        }

        ShuffleList.shuffleList(folderList);
        List<String> reorderedList = CreateNestedFolders.createNestedFolders(folderList);

        Map<String, String> parentFolderMap = new HashMap<>();
        for (Folder folder : folderArray) {
            parentFolderMap.put(folder.folderName, folder.parentFolderName);
        }
        for (String folderName : reorderedList) {
            if (folderName.equals("root")) {
                assert(reorderedList.indexOf(folderName) == 0);
                continue;
            }
            String parentName = parentFolderMap.get(folderName);
            assert(reorderedList.indexOf(parentName) < reorderedList.indexOf(folderName));
        }

        System.out.println("Creation order:");
        for (String folderName : reorderedList) {
            System.out.println("\t" + folderName);
        }
    }
}
