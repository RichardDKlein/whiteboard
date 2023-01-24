package java.com.whiteboard;

import java.util.*;

/**
 * Given a list of folders and subfolders in no particular order,
 * reorder the list so that it is in a valid creation order, i.e.
 * so that parents are created before their children.
 */
public final class CreateNestedFolders {
    private CreateNestedFolders() {
    }

    static class Folder {
        String folderName;
        String parentFolderName;

        Folder(String folderName, String parentFolderName) {
            this.folderName = folderName;
            this.parentFolderName = parentFolderName;
        }
    }

    static class FolderNode {
        String folderName;
        Set<FolderNode> childFolderNodes = new HashSet<>();

        FolderNode(String folderName) {
            this.folderName = folderName;
        }
    }

    private static List<Folder> folders;
    private static Map<String, FolderNode> folderMap = new HashMap<>();

    /**
     * Given a list of folders and subfolders in no particular order,
     * reorder the list so that it is in a valid creation order, i.e.
     * so that parents are created before their children.
     *
     * @param folders The list of folders and subfolders, in no particular
     *                order.
     * @return A list of folder names in a valid creation order.
     */
    public static List<String> createNestedFolders(List<Folder> folders) {
        CreateNestedFolders.folders = folders;
        FolderNode root = buildFolderMap();
        return traverseFolderTreeInPreOrder(root);
    }

    private static FolderNode buildFolderMap() {
        FolderNode root = null;
        for (Folder folder : folders) {
            FolderNode folderNode = findOrCreateFolderNode(folder.folderName);
            FolderNode parentFolderNode = findOrCreateFolderNode(folder.parentFolderName);
            if (parentFolderNode == null) {
                root = folderNode;
            } else {
                parentFolderNode.childFolderNodes.add(folderNode);
            }
        }
        return root;
    }

    private static FolderNode findOrCreateFolderNode(String folderName) {
        if (folderName == null || folderName.isEmpty()) {
            return null;
        }
        FolderNode folderNode = folderMap.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName);
            folderMap.put(folderName, folderNode);
        }
        return folderNode;
    }

    private static List<String> traverseFolderTreeInPreOrder(FolderNode root) {
        List<String> result = new ArrayList<>();
        // base case
        if (root == null) {
            return result;
        }
        // recursive step
        result.add(root.folderName);
        for (FolderNode childFolderNode : root.childFolderNodes) {
            result.addAll(traverseFolderTreeInPreOrder(childFolderNode));
        }
        return result;
    }
}
