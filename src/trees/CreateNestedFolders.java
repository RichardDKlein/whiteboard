package trees;

import com.whiteboard.lists.ShuffleList;

import java.util.*;

/**
 * Given a list of folders and subfolders in no particular order,
 * reorder the list so that it is in a valid creation order, i.e.
 * so that parents are created before their children.
 */
public final class CreateNestedFolders {
    private CreateNestedFolders() {}

    private static class Folder {
        String folderName;
        String parentName;

        Folder(String folderName_, String parentName_) {
            folderName = folderName_;
            parentName = parentName_;
        }
    }

    private static class FolderNode {
        String folderName;
        FolderNode parent;
        List<FolderNode> children;

        FolderNode(String folderName_, FolderNode parent_) {
            folderName = folderName_;
            parent = parent_;
            children = new ArrayList<>();
        }
    }

    private static List<Folder> folders_ = new ArrayList<>();
    private static Map<String, FolderNode> nodeMap_ = new HashMap<>();
    private static FolderNode root_;

    /**
     * Given a list of folders and subfolders in no particular order,
     * reorder the list so that it is in a valid creation order, i.e.
     * so that parents are created before their children.
     *
     * @param folders The list of folders and subfolders, in no particular
     *                order.
     * @return The 'folders' list, but reordered so that the folders are
     * in a valid creation order.
     */
    public static List<Folder> createNestedFolders(List<Folder> folders) {
        folders_ = folders;
        buildFolderTree();
        return traverseFolderTreePreOrder();
    }

    private static void buildFolderTree() {
        for (Folder folder : folders_) {
            FolderNode folderNode = findOrCreate(folder.folderName);
            if (folder.parentName == null || folder.parentName.isEmpty()) {
                root_ = folderNode;
                folderNode.parent = null;
                continue;
            }
            FolderNode parentNode = findOrCreate(folder.parentName);
            folderNode.parent = parentNode;
            parentNode.children.add(folderNode);
        }
    }

    private static FolderNode findOrCreate(String folderName) {
        FolderNode folderNode = nodeMap_.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName, null);
            nodeMap_.put(folderName, folderNode);
        }
        return folderNode;
    }

    private static List<Folder> traverseFolderTreePreOrder() {
        return traverseFolderTreePreOrder(root_);
    }

    private static List<Folder> traverseFolderTreePreOrder(FolderNode root) {
        List<Folder> reorderedFolders = new ArrayList<>();
        if (root == null) {
            return reorderedFolders;
        }
        Folder rootFolder = new Folder(root.folderName, null);
        reorderedFolders.add(rootFolder);
        for (FolderNode child : root.children) {
            List<Folder> childFolders = traverseFolderTreePreOrder(child);
            reorderedFolders.addAll(childFolders);
        }
        return reorderedFolders;
    }

    public static void test() {
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
        List<Folder> reorderedList = createNestedFolders(folderList);
        System.out.println("Creation order:");
        for (Folder folder : reorderedList) {
            System.out.println("\t" + folder.folderName);
        }
    }
}
