package com.whiteboard;

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
        String parentName;

        Folder(String folderName, String parentName) {
            this.folderName = folderName;
            this.parentName = parentName; // null => root folder
        }
        Folder(FolderNode folderNode) {
            this.folderName = folderNode.folderName;
            if (folderNode.parentNode != null) {
                this.parentName = folderNode.parentNode.folderName;
            }
        }
    }

    static class FolderNode {
        String folderName;
        FolderNode parentNode;
        Set<FolderNode> childNodes = new HashSet<>();

        FolderNode(String folderName, FolderNode parentNode) {
            this.folderName = folderName;
            this.parentNode = parentNode; // null => root folder
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
     * @return The 'folders' list, but reordered so that the folders are
     * in a valid creation order.
     */
    public static List<Folder> createNestedFolders(List<Folder> folders) {
        CreateNestedFolders.folders = folders;
        FolderNode root = buildFolderTree();
        return traverseFolderTreePreOrder(root);
    }

    private static FolderNode buildFolderTree() {
        FolderNode root = null;
        for (Folder folder : folders) {
            FolderNode folderNode = findOrCreateFolderNode(folder.folderName);
            if (folder.parentName == null) {
                root = folderNode;
            } else {
                FolderNode parentNode = findOrCreateFolderNode(folder.parentName);
                parentNode.childNodes.add(folderNode);
            }
        }
        return root;
    }

    private static FolderNode findOrCreateFolderNode(String folderName) {
        if (folderName == null || folderName.isEmpty()) {
            // this is the root folder
            return null;
        }
        FolderNode folderNode = folderMap.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName, null);
            folderMap.put(folderName, folderNode);
        }
        return folderNode;
    }

    private static List<Folder> traverseFolderTreePreOrder(FolderNode root) {
        List<Folder> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(new Folder(root));
        for (FolderNode childNode : root.childNodes) {
            result.addAll(traverseFolderTreePreOrder(childNode));
        }
        return result;
    }
}
