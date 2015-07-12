package opensource.project.TextEditor.Actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

import javax.swing.JTextField;

import opensource.project.TextEditor.Util.TextEditorConfig;

public class ButtonAction implements ActionListener {
	private String actionPerformed;
	private JTextField textField;
	private JTabbedPane tabbedPane;
	private JFrame frame;

	public ButtonAction(JTabbedPane tabbedPane, JFrame frame, String actionPerformed) {
		this.tabbedPane = tabbedPane;
		this.frame = frame;
		this.actionPerformed = actionPerformed;
	}

	public ButtonAction(JTabbedPane tabbedPane, String actionPerformed) {
		this.tabbedPane = tabbedPane;
		this.actionPerformed = actionPerformed;
	}

	public ButtonAction(JTabbedPane tabbedPane, JTextField searchEnterField, String actionPerformed) {
		this.tabbedPane = tabbedPane;
		this.actionPerformed = actionPerformed;
		this.textField = searchEnterField;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("-----------" + actionPerformed);
		switch (actionPerformed) {
		case TextEditorConfig.SAVE:
			System.out.println("save entered");
			SaveImpl save = new SaveImpl();
			save.SaveAction(tabbedPane, TextEditorConfig.SAVE);
			break;
		case TextEditorConfig.SAVE_AS:
			System.out.println("save as pressed");
			SaveImpl saveAs = new SaveImpl();
			saveAs.SaveAction(tabbedPane, TextEditorConfig.SAVE_AS);
			break;
		case TextEditorConfig.OPEN:
			System.out.println("open pressed");
			OpenImpl open = new OpenImpl();
			open.openAction(tabbedPane, frame);
			break;
		case TextEditorConfig.CLEAR:
			System.out.println("clear pressed");
			ClearImpl clear = new ClearImpl();
			clear.clearAction(tabbedPane);
			break;
		case TextEditorConfig.SEARCH:
			System.out.println("search pressed");
			SearchImpl search = new SearchImpl();
			search.searchAction(tabbedPane, textField);
			break;
		case TextEditorConfig.NEW:
			System.out.println("new button pressed");
			NewImpl newFile = new NewImpl();
			newFile.newAction(tabbedPane, frame, "Untitled");
			break;
		case TextEditorConfig.CLOSE:
			System.out.println("close button pressed");
			CloseImpl close = new CloseImpl();
			close.closeAction(tabbedPane);
			break;
		default:
			break;
		}

	}

}
