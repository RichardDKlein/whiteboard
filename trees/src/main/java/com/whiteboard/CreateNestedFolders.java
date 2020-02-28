package com.whiteboard;

import java.util.*;

/**
 * Given a list of folders and subfolders in no particular order,
 * reorder the list so that it is in a valid creation order, i.e.
 * so that parents are created before their children.
 */
public class CreateNestedFolders {
    private List<Folder> folders_ = new ArrayList<>();
    private Map<String, FolderNode> nodeMap_ = new HashMap<>();
    private FolderNode root_;

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
    public List<Folder> createNestedFolders(List<Folder> folders) {
        folders_ = folders;
        buildFolderTree();
        return traverseFolderTreePreOrder();
    }

    private void buildFolderTree() {
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

    private FolderNode findOrCreate(String folderName) {
        FolderNode folderNode = nodeMap_.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName, null);
            nodeMap_.put(folderName, folderNode);
        }
        return folderNode;
    }

    private List<Folder> traverseFolderTreePreOrder() {
        return traverseFolderTreePreOrder(root_);
    }

    private List<Folder> traverseFolderTreePreOrder(FolderNode root) {
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

    // ===================================================================
    // INNER CLASSES
    // ===================================================================

    static class Folder {
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
}
