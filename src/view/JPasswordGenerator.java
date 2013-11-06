package view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import logic.chars.LowerCaseLetterChar;
import logic.chars.NumberChar;
import logic.chars.SpecialChar;
import logic.chars.UpperCaseLetterChar;

import util.GlobalConstants;
import view.components.TextComponentEventQueue;
import view.listener.ExitActionListener;
import view.listener.GeneratePasswordsActionListener;
import view.listener.AboutActionListener;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * GUI
 * @author Frank Roth
 *
 */
public class JPasswordGenerator extends javax.swing.JFrame {

	{
		//Set Look & Feel
		try {
			javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	private static final long serialVersionUID = -2298370202332833609L;

	private JPanel jPasswordGeneratorPanel;

	private static JTextArea passwordsTextArea;
	private static JCheckBox specialCharsCheckBox;
	private static JCheckBox upperCaseLettersCheckBox;
	private static JCheckBox lowerCaseLettersCheckBox;
	private static JCheckBox numbersCheckBox;
	private static JTextField lengthTextField;
	private static JTextField amountTextField;
	private static JTextField additionalSymbolsTextField;
	
	private JLabel amountLabel;
	private JLabel additionalSymbolsLabel;
	private JLabel SymbolsLabel;
	private JScrollPane passwordsScrollPane;

	private JMenuBar menuBar;
	private JMenuItem exitMenuItem;
	private JMenuItem aboutMenuItem;
	private JMenu helpMenu;
	private JMenu fileMenu;
	private JLabel lengthLabel;

	private JButton generateButton;



	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JPasswordGenerator inst = new JPasswordGenerator();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public JPasswordGenerator() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			// Right-click
			Toolkit.getDefaultToolkit().getSystemEventQueue().push(new TextComponentEventQueue());
			
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			this.setTitle(GlobalConstants.FRAME_TITLE);
			this.setIconImage(new ImageIcon(getClass().getClassLoader().getResource(GlobalConstants.FRAME_ICON)).getImage());
			{
				jPasswordGeneratorPanel = new JPanel();
				getContentPane().add(jPasswordGeneratorPanel, BorderLayout.CENTER);
				GroupLayout jPanel1Layout = new GroupLayout((JComponent)jPasswordGeneratorPanel);
				jPasswordGeneratorPanel.setLayout(jPanel1Layout);
				{
					lengthLabel = new JLabel();
					lengthLabel.setText(GlobalConstants.LABEL_LENGTH);
				}
				{
					SymbolsLabel = new JLabel();
					SymbolsLabel.setText(GlobalConstants.LABEL_CHARS);
				}
				{
					additionalSymbolsLabel = new JLabel();
					additionalSymbolsLabel.setText(GlobalConstants.LABEL_ADDITION_CHARS);
				}
				{
					amountTextField = new JTextField();
					amountTextField.setText(GlobalConstants.TEXTFIELD_DEFAULT_AMOUNT);
				}
				{
					amountLabel = new JLabel();
					amountLabel.setText(GlobalConstants.LABEL_AMOUNT);
				}
				{
					generateButton = new JButton();
					generateButton.setText(GlobalConstants.BUTTON_GENERATE);
					generateButton.addActionListener(new GeneratePasswordsActionListener());
				}
				{
					numbersCheckBox = new JCheckBox();
					numbersCheckBox.setText(GlobalConstants.LABEL_NUMBERS);
					numbersCheckBox.setSelected(true);
					NumberChar numberChar = new NumberChar();
					numbersCheckBox.setToolTipText(new String(numberChar.getNumbers()));
				}
				{
					lowerCaseLettersCheckBox = new JCheckBox();
					lowerCaseLettersCheckBox.setText(GlobalConstants.LABEL_LOWER_CASE_CHARS);
					lowerCaseLettersCheckBox.setSelected(true);
					LowerCaseLetterChar lowerCaseLetterChar = new LowerCaseLetterChar();
					lowerCaseLettersCheckBox.setToolTipText(new String(lowerCaseLetterChar.getLowerCaseLetters()));
				}
				{
					upperCaseLettersCheckBox = new JCheckBox();
					upperCaseLettersCheckBox.setText(GlobalConstants.LABEL_UPPER_CASE_CHARS);
					upperCaseLettersCheckBox.setSelected(true);
					UpperCaseLetterChar upperCaseLetterChar = new UpperCaseLetterChar();
					upperCaseLettersCheckBox.setToolTipText(new String(upperCaseLetterChar.getUpperCaseLetters()));					
				}
				{
					specialCharsCheckBox = new JCheckBox();
					specialCharsCheckBox.setText(GlobalConstants.LABEL_SPECIAL_CHARS);
					SpecialChar specialChar = new SpecialChar();
					specialCharsCheckBox.setToolTipText(new String(specialChar.getSpecialChars()));
				}				
				{
					additionalSymbolsTextField = new JTextField();
					additionalSymbolsTextField.setText(GlobalConstants.TEXTFIELD_DEFAULT_SPECIAL_CHARS);
					additionalSymbolsTextField.setToolTipText(GlobalConstants.TOOL_TIP_ADDITIONAL_CHARS_TEXTFIELD);
				}
				{
					lengthTextField = new JTextField();
					lengthTextField.setText(GlobalConstants.TEXTFIELD_DEFAULT_LENGTH);
				}
				{
					passwordsScrollPane = new JScrollPane();
					{
						passwordsTextArea = new JTextArea();
						passwordsTextArea.setFont((Font) UIManager.get("Label.font"));
						passwordsScrollPane.setViewportView(passwordsTextArea);
					}
				}

				jPanel1Layout.setHorizontalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup()
					    .addGroup(jPanel1Layout.createSequentialGroup()
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addComponent(additionalSymbolsLabel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addComponent(amountLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addGap(52))
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addComponent(lengthLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addGap(55))
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addComponent(SymbolsLabel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addGap(56)))
					        .addGap(24)
					        .addGroup(jPanel1Layout.createParallelGroup()
					            .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
					                .addComponent(numbersCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					                .addComponent(lowerCaseLettersCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					                .addComponent(upperCaseLettersCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					                .addComponent(specialCharsCheckBox, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					                .addGap(0, 105, Short.MAX_VALUE))
					            .addComponent(amountTextField, GroupLayout.Alignment.LEADING, 0, 451, Short.MAX_VALUE)
					            .addComponent(additionalSymbolsTextField, GroupLayout.Alignment.LEADING, 0, 451, Short.MAX_VALUE)
					            .addComponent(lengthTextField, GroupLayout.Alignment.LEADING, 0, 451, Short.MAX_VALUE)))
					    .addComponent(generateButton, GroupLayout.Alignment.LEADING, 0, 568, Short.MAX_VALUE)
					    .addComponent(passwordsScrollPane, GroupLayout.Alignment.LEADING, 0, 568, Short.MAX_VALUE))
					.addContainerGap());
				jPanel1Layout.setVerticalGroup(jPanel1Layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(lengthTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lengthLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(numbersCheckBox, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(lowerCaseLettersCheckBox, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(upperCaseLettersCheckBox, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(specialCharsCheckBox, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(SymbolsLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(additionalSymbolsTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(additionalSymbolsLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					    .addComponent(amountTextField, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
					    .addComponent(amountLabel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(generateButton, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
					.addComponent(passwordsScrollPane, 0, 184, Short.MAX_VALUE)
					.addContainerGap());
			}
			pack();
			this.setSize(600, 400);
			this.setMinimumSize(new Dimension(600, 400));
			{
				menuBar = new JMenuBar();
				setJMenuBar(menuBar);
				{
					fileMenu = new JMenu();
					menuBar.add(fileMenu);
					fileMenu.setText(GlobalConstants.MENU_FILE);
					{
						exitMenuItem = new JMenuItem();
						fileMenu.add(exitMenuItem);
						exitMenuItem.setText(GlobalConstants.MENU_FILE_EXIT);
						exitMenuItem.addActionListener(new ExitActionListener());
					}
				}
				{
					helpMenu = new JMenu();
					menuBar.add(helpMenu);
					helpMenu.setText(GlobalConstants.MENU_HELP);
					{
						aboutMenuItem = new JMenuItem();
						helpMenu.add(aboutMenuItem);
						aboutMenuItem.setText(GlobalConstants.MENU_HELP_ABOUT);
						aboutMenuItem.addActionListener(new AboutActionListener());
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static JCheckBox getSpecialCharsCheckBox() {
		return specialCharsCheckBox;
	}

	public static JCheckBox getUpperCaseLettersCheckBox() {
		return upperCaseLettersCheckBox;
	}

	public static JCheckBox getLowerCaseLettersCheckBox() {
		return lowerCaseLettersCheckBox;
	}

	public static JCheckBox getNumbersCheckBox() {
		return numbersCheckBox;
	}

	public static JTextField getLengthTextField() {
		return lengthTextField;
	}

	public static JTextField getAmountTextField() {
		return amountTextField;
	}

	public static JTextField getAdditionalSymbolsTextField() {
		return additionalSymbolsTextField;
	}
	
	public static JTextArea getPasswordsTextArea() {
		return passwordsTextArea;
	}
}
