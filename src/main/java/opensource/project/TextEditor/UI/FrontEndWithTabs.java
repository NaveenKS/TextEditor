package opensource.project.TextEditor.UI;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import opensource.project.TextEditor.Actions.ButtonAction;
import opensource.project.TextEditor.Util.TextEditorConfig;

public class FrontEndWithTabs {

	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {

		// os specific look and feel
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame frame = new JFrame("Text Editor");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		Dimension dimension = new Dimension(1100, 500);
		frame.setPreferredSize(dimension);

		JLabel tabLabel = new JLabel("Untitled");
		JButton closeButton = new JButton("X");

		JPanel tabLabelPanel = new JPanel();
		tabLabelPanel.add(tabLabel);
		tabLabelPanel.add(closeButton);

		JTabbedPane tabbedPane = new JTabbedPane();

		JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("tab", scrollPane);
		tabbedPane.setTabComponentAt(0, tabLabelPanel);
		tabbedPane.setSelectedIndex(0);

		JPanel tabbedPanel = new JPanel(new BorderLayout());
		tabbedPanel.add(tabbedPane, BorderLayout.CENTER);
		frame.add(tabbedPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		closeButton.addActionListener(new ButtonAction(tabbedPane, TextEditorConfig.CLOSE));

		JButton newButton = new JButton("new");
		newButton.addActionListener(new ButtonAction(tabbedPane, frame, TextEditorConfig.NEW));

		JButton saveButton = new JButton("save");
		saveButton.addActionListener(new ButtonAction(tabbedPane, TextEditorConfig.SAVE));

		JButton saveAsButton = new JButton("save as");
		saveAsButton.addActionListener(new ButtonAction(tabbedPane, TextEditorConfig.SAVE_AS));

		JButton openButton = new JButton("open");
		openButton.addActionListener(new ButtonAction(tabbedPane, frame, TextEditorConfig.OPEN));

		JButton clearButton = new JButton("clear");
		clearButton.addActionListener(new ButtonAction(tabbedPane, TextEditorConfig.CLEAR));

		JLabel searchLabel = new JLabel("search");
		JTextField searchEnterField = new JTextField(20);
		searchEnterField.addActionListener(new ButtonAction(tabbedPane, searchEnterField, TextEditorConfig.SEARCH));

		buttonPanel.add(newButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(saveAsButton);
		buttonPanel.add(openButton);
		buttonPanel.add(clearButton);
		buttonPanel.add(searchLabel);
		buttonPanel.add(searchEnterField);

		frame.add(buttonPanel, BorderLayout.SOUTH);
		frame.pack();

	}

}
