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

    private static List<Folder> folders = new ArrayList<>();
    private static Map<String, FolderNode> folderMap = new HashMap<>();

    /**
     * Given an array of folders and subfolders in no particular order,
     * reorder the array so that it is in a valid creation order, i.e.
     * so that parents are created before their children.
     *
     * @param folderNames An array of folder and subfolder names, in no
     *                    particular order.
     * @param parentFolderNames An array of specifying the names of the
     *                          corresponding parent folders.
     * @return An array containing the folder names in a valid creation
     * order.
     */
    public static String[] createNestedFolders(String[] folderNames, String[] parentFolderNames) {
        saveCallingParameters(folderNames, parentFolderNames);
        FolderNode root = buildFolderMap();
        return traverseFolderTreeInPreOrder(root);
    }

    private static void saveCallingParameters(String[] folderNames, String[] parentFolderNames) {
        for (int i = 0; i < folderNames.length; ++i) {
            Folder folder = new Folder(folderNames[i], parentFolderNames[i]);
            folders.add(folder);
        }
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

    private static String[] traverseFolderTreeInPreOrder(FolderNode root) {
        List<String> list = traverseFolderTreeInPreOrderHelper(root);
        String[] result = new String[list.size()];
        return list.toArray(result);
    }

    private static List<String> traverseFolderTreeInPreOrderHelper(FolderNode root) {
        List<String> result = new ArrayList<>();
        // base case
        if (root == null) {
            return result;
        }
        // recursive step
        result.add(root.folderName);
        for (FolderNode childFolderNode : root.childFolderNodes) {
            result.addAll(traverseFolderTreeInPreOrderHelper(childFolderNode));
        }
        return result;
    }
}
