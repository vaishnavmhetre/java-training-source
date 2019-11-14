/**
 * 
 */
package com.swt.components.support;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Allianz3076
 *
 */
public class DisplayManager {

	public static Display display = new Display();
	
	public static void loopShowAndDispose(Shell shell) {
		loopShow(shell);
		
		// If anything and everything is closed, close the foundation display
		display.dispose();
	}
	
	public static void loopShow(Shell shell) {

		// Check if shell is disposed(released/closed)
		while (!shell.isDisposed())

			// Check if has any changes
			if (!display.readAndDispatch())

				// If no changes, then keep showing old window
				display.sleep();

	}
}
