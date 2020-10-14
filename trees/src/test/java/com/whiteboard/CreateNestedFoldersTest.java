package com.whiteboard;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CreateNestedFoldersTest {
    @Test
    void createNestedFolders() {
        System.out.println();
        System.out.println("Test CreateNestedFolders:");
        System.out.println("=========================");

        CreateNestedFolders.Folder[] folderArray = {
            new CreateNestedFolders.Folder("root",     null),
            new CreateNestedFolders.Folder("I",        "root"),
            new CreateNestedFolders.Folder("I.A",      "I"),
            new CreateNestedFolders.Folder("I.A.1",    "I.A"),
            new CreateNestedFolders.Folder("I.A.2",    "I.A"),
            new CreateNestedFolders.Folder("I.A.3",    "I.A"),
            new CreateNestedFolders.Folder("I.B",      "I"),
            new CreateNestedFolders.Folder("I.B.1",    "I.B"),
            new CreateNestedFolders.Folder("I.B.1.a",  "I.B.1"),
            new CreateNestedFolders.Folder("I.B.1.b",  "I.B.1"),
            new CreateNestedFolders.Folder("I.B.2",    "I.B"),
            new CreateNestedFolders.Folder("II",       "root"),
            new CreateNestedFolders.Folder("II.A",     "II"),
            new CreateNestedFolders.Folder("II.A.1",   "II.A"),
            new CreateNestedFolders.Folder("II.A.2",   "II.A"),
            new CreateNestedFolders.Folder("II.A.2.a", "II.A.2"),
            new CreateNestedFolders.Folder("II.A.2.b", "II.A.2"),
            new CreateNestedFolders.Folder("II.A.2.c", "II.A.2"),
            new CreateNestedFolders.Folder("II.B",     "II"),
            new CreateNestedFolders.Folder("II.B.1",   "II.B"),
            new CreateNestedFolders.Folder("II.B.2",   "II.B"),
            new CreateNestedFolders.Folder("II.B.3",   "II.B")
        };

        List<CreateNestedFolders.Folder> folderList = new LinkedList<>();
        for (CreateNestedFolders.Folder folder : folderArray) {
            folderList.add(folder);
        }

        ShuffleList.shuffleList(folderList);
        List<String> reorderedList = CreateNestedFolders.createNestedFolders(folderList);
        System.out.println("Creation order:");
        for (String folderName : reorderedList) {
            System.out.println("\t" + folderName);
        }
    }
}
