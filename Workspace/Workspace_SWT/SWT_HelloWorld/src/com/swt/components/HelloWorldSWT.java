package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * @author Allianz3076
 *
 */
public class HelloWorldSWT {

	public static void main(String[] args) {

		// Create base display and shell for components to publish
		Display display = new Display();
		Shell shell = new Shell(display);

		// This is necessary, else only one component is shown, others go out of canvas
		// to render (not visible to user)
		shell.setLayout(new FillLayout());

		// Label Creation
		Label label = new Label(shell, SWT.CENTER);
		label.setText("Hello World Label");
		label.setBounds(shell.getClientArea());

		/**
		 * We need to have a custom canvas to have collated buttons So we create a
		 * composite layout (like a wrapper)
		 */
		Composite parent = new Composite(shell, SWT.NONE);

		// Vertical fillLayout for composite canvas to put buttons in
		FillLayout fillLayout = new FillLayout();
		fillLayout.type = SWT.VERTICAL;

		// Composite layout is set with the layout
		parent.setLayout(fillLayout);

		/**
		 * Buttons added to custom composite canvas
		 */
		Button pushButton = new Button(parent, SWT.PUSH);
		pushButton.setText("Push Button");

		pushButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			
				System.out.println("Push button clicked");
			}
		});

		Button checkButton = new Button(parent, SWT.CHECK);
		checkButton.setText("Check Button");

		checkButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("Check button clicked");
			}
		});

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
