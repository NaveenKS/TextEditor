package opensource.project.TextEditor.Actions;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.util.Scanner;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import opensource.project.TextEditor.ActionInterfaces.SearchInterface;
import opensource.project.TextEditor.Util.TextEditorUtil;

public class SearchImpl implements SearchInterface {
	public void searchAction(JTabbedPane tabbedPane, JTextField textField) {
		if (tabbedPane.getSelectedIndex() == -1) {
			TextEditorUtil.createMessageDialogBox("No tab opened");
		} else {
			JTextArea textArea = TextEditorUtil.getTextArea(tabbedPane);
			String data = textArea.getText();
			String searchData = textField.getText();
			textArea.setText(data);
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data.getBytes());
			Scanner scanner = new Scanner(inputStream);
			int lineNo = 0;
			boolean found = false;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (line.contains(searchData)) {
					found = true;
					try {
						int lineIndex = textArea.getLineStartOffset(lineNo);
						int startIndex = line.indexOf(searchData) + lineIndex;
						int endIndex = searchData.length() + startIndex;
						Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.YELLOW);
						textArea.getHighlighter().addHighlight(startIndex, endIndex, painter);
					} catch (BadLocationException e) {
						e.printStackTrace();
					}
				}
				lineNo++;
			}
			if (found == false) {
				TextEditorUtil.createMessageDialogBox("not found");
			}
			scanner.close();
		}
	}

}
