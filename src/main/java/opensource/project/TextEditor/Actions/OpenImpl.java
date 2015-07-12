package opensource.project.TextEditor.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import opensource.project.TextEditor.ActionInterfaces.OpenInterface;
import opensource.project.TextEditor.Util.RegisterFile;
import opensource.project.TextEditor.Util.TextEditorUtil;

public class OpenImpl implements OpenInterface {

	@Override
	public void openAction(JTabbedPane tabbedPane, JFrame frame) {
		JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			if (selectedFile.isDirectory()) {
				TextEditorUtil.createMessageDialogBox("Check the path");
			} else {
				NewImpl openNewFile = new NewImpl();
				openNewFile.newAction(tabbedPane, frame, selectedFile.getName());
				JTextArea textArea = TextEditorUtil.getTextArea(tabbedPane);
				RegisterFile.addFilePath(tabbedPane.getSelectedIndex(), selectedFile.toString());
				try {
					Path path = selectedFile.toPath();
					byte[] data = Files.readAllBytes(path);
					String text = new String(data);
					textArea.setText(text);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("No file selected");
		}

	}
}
