/**
 * 
 */
package com.swt.components.treefilelister.support;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author Allianz3076
 *
 */
public class DriveToTreeAdder {
	public static void addDrivesToTree(Tree tree) {
		File[] paths = File.listRoots();

		for (File path : paths) {
			TreeItem treeItem = new TreeItem(tree, SWT.NONE);
			treeItem.setText(path.getPath());
			FileToTreeAdder.exploreAndPushItem(treeItem, path.getPath());
		}
	}
}
