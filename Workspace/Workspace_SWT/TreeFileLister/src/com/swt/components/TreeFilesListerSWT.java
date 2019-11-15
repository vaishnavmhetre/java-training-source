/**
 * 
 */
package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tree;

import com.swt.components.support.DisplayManager;
import com.swt.components.treefilelister.support.DriveToTreeAdder;
import com.swt.components.treefilelister.support.FileToTreeAdder;

/**
 * @author Allianz3076
 *
 */
public class TreeFilesListerSWT {
	public static void main(String[] args) {
			Display display = DisplayManager.display;

			FillLayout verticalFillLayout = new FillLayout();
			verticalFillLayout.type = SWT.VERTICAL;

			Shell shell = new Shell(display);
			shell.setSize(500, 300);

			Tree tree = new Tree(shell, SWT.MULTI | SWT.BORDER);

			tree.setSize(200, 200);

			DriveToTreeAdder.addDrivesToTree(tree);
			FileToTreeAdder.setTreeListener(tree);

			shell.open();
			DisplayManager.loopShowAndDispose(shell);
	}
}
