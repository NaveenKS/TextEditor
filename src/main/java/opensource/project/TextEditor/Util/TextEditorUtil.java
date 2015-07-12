package opensource.project.TextEditor.Util;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class TextEditorUtil {
	public static JTextArea getTextArea(JTabbedPane tabbedPane) {
		JScrollPane scrollPane = (JScrollPane) tabbedPane.getSelectedComponent();
		JTextArea textArea = (JTextArea) scrollPane.getViewport().getView();
		return textArea;
	}
	
	public static void createMessageDialogBox(String message) {
		JOptionPane.showMessageDialog(new JFrame(), message);
	}
	
	public static void setTabLabel(JTabbedPane tabbedPane, String fileName) {
		int index = tabbedPane.getSelectedIndex();
		JPanel panel = (JPanel) tabbedPane.getTabComponentAt(index);
		JLabel label = (JLabel) panel.getComponent(0);
		label.setText(fileName);
	}
}
