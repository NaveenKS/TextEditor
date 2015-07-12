package opensource.project.TextEditor.Actions;

import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import opensource.project.TextEditor.ActionInterfaces.ClearInterface;
import opensource.project.TextEditor.Util.TextEditorUtil;

public class ClearImpl implements ClearInterface {
	@Override
	public void clearAction(JTabbedPane tabbedPane) {
		if (tabbedPane.getSelectedIndex() == -1) {
			TextEditorUtil.createMessageDialogBox("No tab opened");
		} else {
			JTextArea textArea = TextEditorUtil.getTextArea(tabbedPane);
			textArea.setText("");
		}

	}

}
