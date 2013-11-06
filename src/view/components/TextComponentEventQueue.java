package view.components;
import java.awt.AWTEvent;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.MenuSelectionManager;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import util.GlobalConstants;

public class TextComponentEventQueue extends EventQueue {
	public JPopupMenu popup;
	JTable table;
	public BasicAction cut, copy, paste, selectAll, clearHistory;

	public TextComponentEventQueue() {
		// createPopupMenu();
	}

	public void createPopupMenu(JTextComponent text) {
		popup = new JPopupMenu();
		
		cut = new CutAction(GlobalConstants.GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_CUT, null);
		cut.setTextComponent(text);
		popup.add(cut);

		copy = new CopyAction(GlobalConstants.GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_COPY, null);
		copy.setTextComponent(text);
		popup.add(copy);

		paste = new PasteAction(GlobalConstants.GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_PASTE, null);
		paste.setTextComponent(text);
		popup.add(paste);

		selectAll = new SelectAllAction(GlobalConstants.GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_SELECT_ALL, null);
		selectAll.setTextComponent(text);
		popup.addSeparator();
		popup.add(selectAll);
	}

	public void showPopup(Component parent, MouseEvent me) {
		popup.validate();
		popup.show(parent, me.getX(), me.getY());
	}

	protected void dispatchEvent(AWTEvent event) {
		super.dispatchEvent(event);
		if (!(event instanceof MouseEvent)) {
			return;
		}
		MouseEvent me = (MouseEvent) event;
		if (!me.isPopupTrigger()) {
			return;
		}
		if (!(me.getSource() instanceof Component)) {
			return;
		}
		Component comp = SwingUtilities.getDeepestComponentAt((Component) me
				.getSource(), me.getX(), me.getY());
		if (!(comp instanceof JTextComponent)) {
			return;
		}
		if (MenuSelectionManager.defaultManager().getSelectedPath().length > 0) {
			return;
		}
		createPopupMenu((JTextComponent) comp);
		showPopup((Component) me.getSource(), me);
	}

	public abstract class BasicAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JTextComponent comp;

		public BasicAction(String text, Icon icon) {
			super(text, icon);
			putValue(Action.SHORT_DESCRIPTION, text);
		}

		public void setTextComponent(JTextComponent comp) {
			this.comp = comp;
		}

		public abstract void actionPerformed(ActionEvent e);
	}

	public class CutAction extends BasicAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CutAction(String text, Icon icon) {
			super(text, icon);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl X"));
		}

		public void actionPerformed(ActionEvent e) {
			comp.cut();
		}

		public boolean isEnabled() {
			return comp != null && comp.isEditable()
					&& comp.getSelectedText() != null;
		}
	}

	public class CopyAction extends BasicAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CopyAction(String text, Icon icon) {
			super(text, icon);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl C"));
		}

		public void actionPerformed(ActionEvent e) {
			comp.copy();
		}

		public boolean isEnabled() {
			return comp != null && comp.getSelectedText() != null;
		}
	}

	public class PasteAction extends BasicAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public PasteAction(String text, Icon icon) {
			super(text, icon);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl V"));
		}

		public void actionPerformed(ActionEvent e) {
			comp.paste();
		}

		public boolean isEnabled() {
			Transferable content = Toolkit.getDefaultToolkit()
					.getSystemClipboard().getContents(null);
			return comp != null && comp.isEnabled() && comp.isEditable()
					&& content.isDataFlavorSupported(DataFlavor.stringFlavor);
		}
	}

	public class SelectAllAction extends BasicAction {
		private static final long serialVersionUID = 1L;

		public SelectAllAction(String text, Icon icon) {
			super(text, icon);
			putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl A"));
		}

		public void actionPerformed(ActionEvent e) {
			comp.selectAll();
		}

		public boolean isEnabled() {
			return comp != null
					&& comp.isEnabled()
					&& comp.getText().length() > 0
					&& (comp.getSelectedText() == null || comp
							.getSelectedText().length() < comp.getText()
							.length());
		}
	}
}