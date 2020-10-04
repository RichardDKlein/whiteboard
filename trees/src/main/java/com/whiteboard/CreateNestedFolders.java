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
    }

    private static class FolderNode {
        String folderName;
        Set<FolderNode> childFolderNodes = new HashSet<>();

        FolderNode(String folderName) {
            this.folderName = folderName; // null => root folder
        }
    }

    private static List<Folder> folders;
    private static final Map<String, FolderNode> folderMap = new HashMap<>();

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
        FolderNode root = buildFolderTree();
        return traverseFolderTreeInPreOrder(root);
    }

    private static FolderNode buildFolderTree() {
        FolderNode root = null;
        for (Folder folder : folders) {
            FolderNode folderNode = findOrCreateFolderNode(folder.folderName);
            if (folder.parentName == null) {
                root = folderNode;
            } else {
                FolderNode parentFolderNode = findOrCreateFolderNode(folder.parentName);
                parentFolderNode.childFolderNodes.add(folderNode);
            }
        }
        return root;
    }

    private static FolderNode findOrCreateFolderNode(String folderName) {
        FolderNode folderNode = folderMap.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName);
            folderMap.put(folderName, folderNode);
        }
        return folderNode;
    }

    private static List<String> traverseFolderTreeInPreOrder(FolderNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.folderName);
        for (FolderNode childFolder : root.childFolderNodes) {
            result.addAll(traverseFolderTreeInPreOrder(childFolder));
        }
        return result;
    }
}
