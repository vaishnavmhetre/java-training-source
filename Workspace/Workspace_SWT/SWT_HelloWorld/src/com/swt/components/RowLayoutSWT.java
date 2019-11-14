/**
 * 
 */
package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Allianz3076
 *
 */
public class RowLayoutSWT {

	public static void main(String[] args) {

		Display display = new Display();

		Shell shell = new Shell(display);

		RowLayout rowLayout = new RowLayout(SWT.HORIZONTAL);
		rowLayout.marginTop = 10;
		rowLayout.marginBottom = 10;
		rowLayout.marginLeft = 5;
		rowLayout.marginRight = 8;
		rowLayout.spacing = 10;

		shell.setLayout(rowLayout);

		
		/**
		 * Buttons added to shell canvas
		 */
		Button pushButton = new Button(shell, SWT.PUSH);
		pushButton.setText("Push Button");
		
		Button checkButton = new Button(shell, SWT.CHECK);
		checkButton.setText("Check Button");
		
		Button noneButton = new Button(shell, SWT.NONE);
		noneButton.setText("None Button");
		
		
		shell.pack();
		
		// Open the shell (make shell visible)
		shell.open();

		
		
		// Check if shell is disposed(released/closed)
		while (!shell.isDisposed())
			
			// Check if has any changes
			if (!display.readAndDispatch())
			
				// If no changes, then keep showing old window
				display.sleep();

		
		
		// If anything and everything is closed, close the foundation display
		display.dispose();
	}
}
