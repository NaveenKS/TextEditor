package opensource.project.TextEditor.Actions;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import opensource.project.TextEditor.ActionInterfaces.SaveInterface;
import opensource.project.TextEditor.Util.RegisterFile;
import opensource.project.TextEditor.Util.TextEditorConfig;
import opensource.project.TextEditor.Util.TextEditorUtil;

public class SaveImpl implements SaveInterface {

	@Override
	public void SaveAction(JTabbedPane tabbedPane, String action) {
		String currentFile = RegisterFile.getFilePath(tabbedPane.getSelectedIndex());
		if (tabbedPane.getSelectedIndex() == -1) {
			TextEditorUtil.createMessageDialogBox("No tab opened");
		} else if (currentFile == null || action.equals(TextEditorConfig.SAVE_AS)) {
			JFileChooser fileChooser = new JFileChooser(System.getProperty("user.home"));
			int returnValue = fileChooser.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File saveFilePath = fileChooser.getSelectedFile();
				TextEditorUtil.setTabLabel(tabbedPane, saveFilePath.getName());
				JTextArea textArea = TextEditorUtil.getTextArea(tabbedPane);
				String data = textArea.getText();
				saveData(saveFilePath.toString(), data);
				if (RegisterFile.getFilePath(tabbedPane.getSelectedIndex()) == null) {
					RegisterFile.addFilePath(tabbedPane.getSelectedIndex(), saveFilePath.toString());
				} else {
					RegisterFile.updateEntry(tabbedPane.getSelectedIndex(), saveFilePath.toString());
				}
			} else {
				System.out.println("cancel pressed");
			}

		} else {
			JTextArea textArea = TextEditorUtil.getTextArea(tabbedPane);
			String data = textArea.getText();
			saveData(currentFile, data);
		}
	}

	private void saveData(String path, String data) {
		File file = new File(path);
		if (file.exists()) {
			file.delete();
		}
		BufferedOutputStream writer = null;
		try {
			file.createNewFile();
			writer = new BufferedOutputStream(new FileOutputStream(file));
			writer.write(data.getBytes());
			TextEditorUtil.createMessageDialogBox("saved");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
