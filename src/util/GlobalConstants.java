package util;

/**
 * Global Constants
 * @author Frank Roth
 *
 */
public class GlobalConstants {
	
	public static final String CURRENT_VERSION = "1.3";
	
	public static final String EMPTY_STRING = "";

	public static final String FRAME_ICON = "view/icons/key.png";
	public static final String FRAME_TITLE = " jPasswordGenerator v" + CURRENT_VERSION;
	
	public static final String LABEL_LENGTH = "Length *";
	public static final String LABEL_CHARS = "Chars";
	public static final String LABEL_ADDITION_CHARS = "Additional chars";
	public static final String LABEL_AMOUNT = "Amount *";
	public static final String LABEL_SPECIAL_CHARS = "Special chars";
	public static final String LABEL_UPPER_CASE_CHARS = "Uppercase";
	public static final String LABEL_LOWER_CASE_CHARS = "Lowercase";
	public static final String LABEL_NUMBERS = "Numbers";
	
	public static final String TEXTFIELD_DEFAULT_AMOUNT = "5";
	public static final String TEXTFIELD_DEFAULT_SPECIAL_CHARS = "!?";
	public static final String TEXTFIELD_DEFAULT_LENGTH = "8";
	
	public static final String MENU_FILE = "File";
	public static final String MENU_FILE_EXIT = "Exit";
	
	public static final String MENU_HELP = "Help";
	public static final String MENU_HELP_ABOUT = "About";
	
	public static final String BUTTON_GENERATE = "generate";
	
	public static final String ERROR_MESSAGE_TITLE = "Error";
	
	public static final int ERROR_CODE_LENGTH_EMPTY = 0;
	public static final int ERROR_CODE_LENGTH_INVALID = 1;
	public static final int ERROR_CODE_AMOUNT_EMPTY = 2;
	public static final int ERROR_CODE_AMOUNT_INVALID = 3;
	public static final int ERROR_CODE_NO_CHARS = 4;
	
	public static final String GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_CUT = "Cut";
	public static final String GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_COPY = "Copy";
	public static final String GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_PASTE = "Paste";
	public static final String GUI_TEXT_RIGHT_CLICK_MESSAGE_HISTORY_SELECT_ALL = "Select all";
	
	public static final String ABOUT_MESSAGEBOX_TEXT = "<strong>jPasswordGenerator</strong> by Frank Roth<br/>" +
			"<h2>Version</h2>" +
			CURRENT_VERSION + " (2013-11-06)" + 
			"<h2>Contact</h2>" + 
			"<strong>Mail</strong>: frankred@web.de<br/>" +
			"<strong>Sype</strong>: frankredksc<br/>" +
			"<strong>Project page</strong>: https://github.com/frankred/jPasswordGenerator" +
			"<h2>Thanksgivings</h2>" + 
			"Creator of http://famfamfam.com.";
	
	
	
	public static final String ERROR_MESSAGE_HEAP_OUT_OF_SPACE = "Not enough memory! Amount too big!";
	public static final String ERROR_MESSAGE_NO_CHARS = "No chars selected!";
	public static final String ERROR_MESSAGE_LENGTH_EMPTY = "Please fill in the field '" + LABEL_LENGTH + "'!";
	public static final String ERROR_MESSAGE_AMOUNT_EMPTY = "Please fill in the field '" + LABEL_AMOUNT + "'!";
	public static final String ERROR_MESSAGE_LENGTH_INVALID = "Invalid values of the field '" + LABEL_LENGTH + "'.";
	public static final String ERROR_MESSAGE_AMOUNT_INVALID = "Invalid values of the field '" + LABEL_AMOUNT + "'.";
	
	public static final String TOOL_TIP_ADDITIONAL_CHARS_TEXTFIELD = "Additional special chars.";
	
}
