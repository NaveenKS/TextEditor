package opensource.project.TextEditor.Actions;

import javax.swing.JTabbedPane;

import opensource.project.TextEditor.ActionInterfaces.CloseInterface;
import opensource.project.TextEditor.Util.RegisterFile;

public class CloseImpl implements CloseInterface {
	public void closeAction(JTabbedPane tabbedPane) {
		int index = tabbedPane.getSelectedIndex();
		tabbedPane.remove(index);
		RegisterFile.removeEntry(index);
	}

}
