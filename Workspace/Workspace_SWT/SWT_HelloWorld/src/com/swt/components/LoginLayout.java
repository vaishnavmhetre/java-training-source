/**
 * 
 */
package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swt.components.support.DisplayManager;

/**
 * @author Allianz3076
 *
 */
public class LoginLayout {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Display disp = DisplayManager.display;
		FillLayout verticalFillLayout = new FillLayout();
		verticalFillLayout.type = SWT.VERTICAL;
		
		FillLayout horizontalFillLayout = new FillLayout();
		horizontalFillLayout.type = SWT.HORIZONTAL;
		
		Shell shell = new Shell(disp);
		shell.setLayout(verticalFillLayout);
		shell.setBounds(0, 0, 400, 200);

		CLabel loginLabel = new CLabel(shell, SWT.CENTER);
		loginLabel.setText("Login");
		loginLabel.setBounds(shell.getBounds());

		Composite loginInputs = new Composite(shell, SWT.NONE);
		loginInputs.setLayout(verticalFillLayout);
		Composite usernameInput = new Composite(loginInputs, SWT.NONE);
		Composite passwordInput = new Composite(loginInputs, SWT.NONE);


		usernameInput.setLayout(horizontalFillLayout);
		passwordInput.setLayout(horizontalFillLayout);

		Label usernameLabel = new Label(usernameInput, SWT.RIGHT);
		usernameLabel.setText("Username");

		Label passwordLabel = new Label(passwordInput, SWT.RIGHT);
		passwordLabel.setText("Password");

		Text usernameTextBox = new Text(usernameInput, SWT.NONE);
		usernameTextBox.setBounds(usernameInput.getBounds());

		Text passwordTextBox = new Text(passwordInput, SWT.NONE);
		passwordTextBox.setBounds(passwordInput.getBounds());

		shell.open();
		DisplayManager.loopShowAndDispose(shell);
	}

}
