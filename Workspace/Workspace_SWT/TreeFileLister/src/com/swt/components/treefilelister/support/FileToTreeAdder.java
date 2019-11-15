/**
 * 
 */
package com.swt.components.treefilelister.support;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

/**
 * @author Allianz3076
 *
 */
public class FileToTreeAdder {

	private static Map<TreeItem, String> directoryPaths = new HashMap<TreeItem, String>();
	private static Map<TreeItem, List<TreeItem>> subTreeitems = new HashMap<TreeItem, List<TreeItem>>();

	public static List<TreeItem> exploreAndPushItem(TreeItem tree, String directoryPath) {
		File directory = new File(directoryPath);

		// Get all files from a directory.
		File[] fList = directory.listFiles();

		List<TreeItem> treeItems = new ArrayList<TreeItem>();

		if (fList != null) {

			for (File file : fList) {

				TreeItem treeItem = new TreeItem(tree, SWT.NONE);
				treeItem.setText(file.getName());

				treeItems.add(treeItem);

				if (file.isDirectory()) {
					subTreeitems.put(treeItem, Arrays.asList(getDummyTreeItem(treeItem)));
					directoryPaths.put(treeItem, file.getPath());
				}

			}
		}

		return treeItems;
	}

	private static TreeItem getDummyTreeItem(TreeItem parent) {
		TreeItem treeItem = new TreeItem(parent, SWT.NONE);
		treeItem.setText("DUMMY");

		return treeItem;
	}

	public static void setTreeListener(Tree tree) {
		tree.addListener(SWT.Expand, new Listener() {

			@Override
			public void handleEvent(Event event) {
				System.out.println(tree.toString() + " expanded");

				TreeItem treeItem = (TreeItem) event.item;

				String path = directoryPaths.get(treeItem);
				List<TreeItem> items = subTreeitems.get(treeItem);
				if (items != null) {
					TreeItem dummyItem = (TreeItem) (items.toArray()[0]);
					if (dummyItem != null)
						dummyItem.dispose();
				}

				subTreeitems.remove(treeItem);
				if (path != null)
					subTreeitems.put(treeItem, exploreAndPushItem(treeItem, path));

				System.out.println("Explored: " + treeItem.toString() + subTreeitems.get(treeItem));
			}
		});

		tree.addListener(SWT.Collapse, new Listener() {

			@Override
			public void handleEvent(Event event) {

				System.out.println(tree.toString() + " collapsed");

				TreeItem treeItem = (TreeItem) event.item;

				List<TreeItem> items = subTreeitems.get(treeItem);
				
				if (items != null) {
					items.forEach((item) -> item.dispose());
				}

				subTreeitems.remove(treeItem);
				subTreeitems.put(treeItem, Arrays.asList(getDummyTreeItem(treeItem)));

				System.out.println("After removing: " + treeItem.toString() + subTreeitems.get(treeItem));
			}
		});
	}
}
