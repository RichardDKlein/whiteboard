package com.whiteboard;

import java.util.*;

/**
 * Given a list of folders and subfolders in no particular order,
 * reorder the list so that it is in a valid creation order, i.e.
 * so that parents are created before their children.
 */
public class CreateNestedFolders {
    private List<Folder> folders_;
    private Map<String, FolderNode> folderMap_ = new HashMap<>();

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
        FolderNode root = buildFolderTree();
        return traverseFolderTreePreOrder(root);
    }

    private FolderNode buildFolderTree() {
        FolderNode root = null;
        for (Folder folder : folders_) {
            FolderNode folderNode = findOrCreateFolderNode(folder.folderName_);
            FolderNode parentNode = findOrCreateFolderNode(folder.parentName_);
            folderNode.parentNode_ = parentNode;
            if (parentNode == null) {
                root = folderNode;
            } else {
                parentNode.childNodes_.add(folderNode);
            }
        }
        return root;
    }

    private FolderNode findOrCreateFolderNode(String folderName) {
        if (folderName == null || folderName.isEmpty()) {
            // this is the root folder
            return null;
        }
        FolderNode folderNode = folderMap_.get(folderName);
        if (folderNode == null) {
            folderNode = new FolderNode(folderName, null);
            folderMap_.put(folderName, folderNode);
        }
        return folderNode;
    }

    private List<Folder> traverseFolderTreePreOrder(FolderNode root) {
        List<Folder> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(new Folder(root));
        for (FolderNode childNode : root.childNodes_) {
            result.addAll(traverseFolderTreePreOrder(childNode));
        }
        return result;
    }

    static class Folder {
        String folderName_;
        String parentName_;

        Folder(String folderName, String parentName) {
            folderName_ = folderName;
            parentName_ = parentName;
        }
        Folder(FolderNode folderNode) {
            folderName_ = folderNode.folderName_;
            if (folderNode.parentNode_ != null) {
                parentName_ = folderNode.parentNode_.folderName_;
            }
        }
    }

    static class FolderNode {
        String folderName_;
        FolderNode parentNode_;
        Set<FolderNode> childNodes_ = new HashSet<>();

        FolderNode(String folderName, FolderNode parentNode) {
            folderName_ = folderName;
            parentNode_ = parentNode;
        }
    }
}
