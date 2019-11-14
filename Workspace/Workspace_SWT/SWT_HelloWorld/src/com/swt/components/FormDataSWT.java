/**
 * 
 */
package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Allianz3076
 *
 */
public class FormDataSWT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Display display = new Display();

		Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);
		shell.setLayout(new FormLayout());

		Button okButton = new Button(shell, SWT.PUSH);
		okButton.setText("OK");

		Button cancelButton = new Button(shell, SWT.PUSH);
		cancelButton.setText("Cancel");

		FormData cancelData = new FormData(80, 30);
		cancelData.right = new FormAttachment(98);
		cancelData.bottom = new FormAttachment(95);
		cancelButton.setLayoutData(cancelData);

		FormData okData = new FormData(80, 30);
		okData.right = new FormAttachment(cancelButton, -5, SWT.LEFT);
		okData.bottom = new FormAttachment(cancelButton, 0, SWT.BOTTOM);
		okButton.setLayoutData(okData);

		shell.setText("Buttons");
		shell.setSize(350, 200);

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
