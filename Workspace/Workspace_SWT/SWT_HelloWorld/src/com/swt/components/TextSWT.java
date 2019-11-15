/**
 * 
 */
package com.swt.components;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.swt.components.support.DisplayManager;

/**
 * @author Allianz3076
 *
 */
public class TextSWT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = DisplayManager.display;

		Shell shell = new Shell(display);

		Text text = new Text(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		text.setText("Lol text box");
		text.setBounds(20, 40, 300, 100);

		DisplayManager.loopShowAndDispose(shell);
	}

}
