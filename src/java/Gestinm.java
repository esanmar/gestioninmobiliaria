/*
 * @(#)Gestinm.java 1.0 04/03/25
 *
 * You can modify the template of this file in the
 * directory ..\JCreator\Templates\Template_1\Project_Name.java
 *
 * You can also create your own project template by making a new
 * folder in the directory ..\JCreator\Template\. Use the other
 * templates as examples.
 *
 */
package myprojects.gestinm;

import java.awt.*;
import java.awt.event.*;

class Gestinm extends Frame {
	
	public Gestinm() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		});
	}

	public static void main(String args[]) {
		System.out.println("Starting Gestinm...");
		Gestinm mainFrame = new Gestinm();
		mainFrame.setSize(400, 400);
		mainFrame.setTitle("Gestinm");
		mainFrame.setVisible(true);
	}
}
