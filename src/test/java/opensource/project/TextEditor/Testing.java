package opensource.project.TextEditor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.TextArea;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JViewport;

public class Testing {
	public static void main(String args[]) {
		JFrame frame = new JFrame("Text Editor");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		Dimension dimension = new Dimension(1100, 500);
		frame.setPreferredSize(dimension);

		JPanel panel = new JPanel();
		panel.setOpaque(false);

		JLabel label = new JLabel("file1");
		panel.add(label);

		JButton button = new JButton("X");
		panel.add(button);

		JTabbedPane tab = new JTabbedPane();
		JTextArea textArea = new JTextArea();
		textArea.setText("hello naveen");
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tab.addTab("test", scrollPane);
		tab.setTabComponentAt(0, panel);
		
		
		int index = tab.getSelectedIndex();
		scrollPane = (JScrollPane)tab.getComponent(index);
		textArea = (JTextArea) scrollPane.getViewport().getView();
		System.out.println(textArea.getText()+"----------");
		
		
		frame.add(tab);
		frame.pack();
	}

}
