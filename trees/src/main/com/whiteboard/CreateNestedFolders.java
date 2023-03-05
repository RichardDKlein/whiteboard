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

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Folder other)) {
                return false;
            }
            return this.folderName.equals(other.folderName);
        }

        @Override
        public int hashCode() {
            return folderName.hashCode();
        }
    }

    static class FolderNode {
        String folderName;
        Set<FolderNode> subFolders = new HashSet<>();

        FolderNode(String folderName) {
            this.folderName = folderName;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof FolderNode other)) {
                return false;
            }
            return this.folderName.equals(other.folderName);
        }

        @Override
        public int hashCode() {
            return folderName.hashCode();
        }
    }

    private static Folder[] folders;
    private static Map<String, FolderNode> folderTree = new HashMap<>();

    /**
     * Given an array of folders and subfolders in no particular order,
     * reorder the array so that it is in a valid creation order, i.e.
     * so that parents are created before their children.
     *
     * @param folderNames An array of folder and subfolder names, in no
     *                    particular order.
     * @param parentFolderNames An array of specifying the names of the
     *                          corresponding parent folders. (The top-
     *                          level folder will have a parent folder
     *                          name of null or the empty string.)
     * @return A list containing the folder names in a valid creation
     * order.
     */
    public static List<String> createNestedFolders(String[] folderNames, String[] parentFolderNames) {
        saveCallingParameters(folderNames, parentFolderNames);
        FolderNode root = buildFolderTree();
        return traverseFolderTreeInPreOrder(root);
    }

    private static void saveCallingParameters(String[] folderNames, String[] parentFolderNames) {
        folders = new Folder[folderNames.length];
        for (int i = 0; i < folderNames.length; ++i) {
            folders[i] = new Folder(folderNames[i], parentFolderNames[i]);
        }
    }

    private static FolderNode buildFolderTree() {
        folderTree.clear();
        FolderNode root = null;
        for (Folder folder : folders) {
            FolderNode folderNode = findOrCreateFolderNode(folder.folderName);
            FolderNode parentFolderNode = findOrCreateFolderNode(folder.parentFolderName);
            if (parentFolderNode == null) {
                root = folderNode;
            } else {
                parentFolderNode.subFolders.add(folderNode);
            }
        }
        return root;
    }

    private static FolderNode findOrCreateFolderNode(String folderName) {
        if (folderName == null || folderName.isEmpty()) {
            return null;
        }
        FolderNode folderNode = folderTree.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName);
            folderTree.put(folderName, folderNode);
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
        for (FolderNode subFolder : root.subFolders) {
            result.addAll(traverseFolderTreeInPreOrder(subFolder));
        }
        return result;
    }
}
