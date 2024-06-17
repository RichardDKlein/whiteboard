package com.whiteboard.java;

import java.util.*;

public final class CreateNestedFolders {
    static class FolderNode {
        String folderName;
        Set<FolderNode> subFolders;

        FolderNode(String folderName) {
            this.folderName = folderName;
            subFolders = new HashSet<>();
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

    /**
     * Given an array of folders and subfolders in no particular order,
     * reorder the array so that it is in a valid creation order, i.e.
     * so that parents are created before their children.
     *
     * @param folderNames An array of folder and subfolder names, in no
     *                    particular order.
     * @param parentFolderNames An array of specifying the names of the
     *                          corresponding parent folders. (The top
     *                          level folder will have a parent folder
     *                          name of `null` or the empty string.)
     * @return A list containing the folder names in a valid creation
     * order. (Note: There may be more than one solution.)
     */
    public static List<String> createNestedFolders(String[] folderNames, String[] parentFolderNames) {
        Object[] result = buildFolderTree(folderNames, parentFolderNames);
        Map<String, FolderNode> folderTree = (Map<String, FolderNode>)result[0];
        FolderNode rootFolder = (FolderNode)result[1];
        return traverseFolderTreeInPreOrder(folderTree, rootFolder);
    }

    private static Object[] buildFolderTree(String[] folderNames, String[] parentFolderNames) {
        Map<String, FolderNode> folderTree = new HashMap<>();
        FolderNode rootFolder = null;
        for (int i = 0; i < folderNames.length; i++) {
            FolderNode folderNode = folderTree.computeIfAbsent(folderNames[i], FolderNode::new);
            if (parentFolderNames[i] == null || parentFolderNames[i].isEmpty()) {
                rootFolder = folderNode;
            } else {
                FolderNode parentFolderNode = folderTree.computeIfAbsent(parentFolderNames[i], FolderNode::new);
                parentFolderNode.subFolders.add(folderNode);
            }
        }
        return new Object[] {folderTree, rootFolder};
    }

    private static List<String> traverseFolderTreeInPreOrder(Map<String, FolderNode> folderTree, FolderNode rootFolder) {
        List<String> folderCreationList = new ArrayList<>();
        // base case
        if (rootFolder == null) {
            return folderCreationList;
        }
        // recursive step
        folderCreationList.add(rootFolder.folderName);
        for (FolderNode subFolderNode : rootFolder.subFolders) {
            folderCreationList.addAll(traverseFolderTreeInPreOrder(folderTree, subFolderNode));
        }
        return folderCreationList;
    }
}
