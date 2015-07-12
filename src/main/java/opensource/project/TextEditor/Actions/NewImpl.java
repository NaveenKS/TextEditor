package opensource.project.TextEditor.Actions;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import opensource.project.TextEditor.ActionInterfaces.NewInterface;
import opensource.project.TextEditor.Util.TextEditorConfig;

public class NewImpl implements NewInterface {

	@Override
	public void newAction(JTabbedPane tabbedPane, JFrame frame, String fileName) {
		JLabel tabLabel = new JLabel(fileName);
		JButton closeButton = new JButton("x");
		closeButton.addActionListener(new ButtonAction(tabbedPane, TextEditorConfig.CLOSE));
		JPanel tabLabelPanel = new JPanel();
		tabLabelPanel.add(tabLabel);
		tabLabelPanel.add(closeButton);

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("tab", scrollPane);
		tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tabLabelPanel);

		JPanel tabbedPanel = new JPanel(new BorderLayout());
		tabbedPanel.add(tabbedPane, BorderLayout.CENTER);
		frame.add(tabbedPanel, BorderLayout.CENTER);

		int count = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(count - 1);
	}
}
