package opensource.project.TextEditor;

import java.io.File;

import javax.swing.JFileChooser;

public class FileChoose {

	public static void main(String[] args) {
		JFileChooser fileChooser = new JFileChooser(".");
		int returnValue = fileChooser.showSaveDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			System.out.println("selected File :" + file.toString());
		} else {
			System.out.println("cancelled");
		}
	}

}
