package examSystem;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

public class examSystem extends JFrame implements ActionListener,FocusListener{
	JLabel userLbl, adminLbl,adminPswLbl,pswLbl,greetLabel,adminSwitch,userSwitch,numOfquestion,quesInserted,
	register,markLabel,fname,lname,email,password,back,back2Module;
	JLabel[] dynamicQuestions;
	JTextField emailTxtLogin,signupPsw,adminTxtLogin,fnametxt,lnametxt,emailtxt,optionAtxt,optionBtxt,optionCtxt,optionDtxt;
	JPasswordField loginPsw,adminLoginPsw;
	JButton loginBtn, regBtn,adminLoginBtn,genPasswordBtn,javaBtn,cBtn,pythonBtn,
	startExam,javaScriptBtn,createQbtnJava,createQbtnC,createQbtnPython,createQbtnJs,nextBtn,prevBtn,finishBtn;
	 
	JLayeredPane rootLayer,tabLayers;
	JPanel mainPanelLogin,mainPanelSignup,mainPaneladminLogin,genTokenPanel,moduleSelection,resultPanel,
	questionPanel,imgPane1, imgPane2,imgPane3,loginPane,signupPane,btnPane,
	adminLoginPane,modulePanel,examRootPanel,dynamicRootQuestionPane;
	JPanel[] dynamicQpane;
	JTabbedPane adminTabPane;
	JTable examineeData;
	JComboBox correctAnsCombo;
	ButtonGroup btnGrp;
	ButtonGroup[] dynamicBtnGrp;
	JRadioButton[] option1,option2,option3,option4;
	String[] userAns;
	JTextArea quesTextArea;
	JRadioButton javaRadio, cSharpRadio,pythonRadio,jsRadio;
	JSeparator emailSepLogin,passwordSepLogin,fnameSep,lnameSep,emailSepSignup,pswdSepSignup,adminUserSep,adminPwdSep;
	DefaultTableModel model;
	ArrayList<QandA> QnAlist;
	int counter= 0;
	int questCounterJava = 0;
	int questCounterCs=0, questCounterJs=0,questCounterPython=0;
	int mark = 0;
	public examSystem() {
		Container c = getContentPane();
		setBounds(400,100,900,600);
		setTitle("examSystem");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		c.setLayout(null);
		
		//start of login panel
		rootLayer = new JLayeredPane();
		rootLayer.setBounds(0, 0, 900, 600);
		rootLayer.setLayout(new CardLayout());
		c.add(rootLayer);
		
		mainPanelLogin = new JPanel();
		mainPanelLogin.setSize(900, 600);
		mainPanelLogin.setLayout(null);
		rootLayer.add(mainPanelLogin);
		
		imgPane1 = new JPanel();
		imgPane1.setBounds(0,0,450,600);
		imgPane1.setBackground(new Color(0,0,0,200));
		imgPane1.setLayout(null);
		mainPanelLogin.add(imgPane1);
		
		JLabel lblLogin = new JLabel("Examinee");
		lblLogin.setForeground(new Color(255,255,255,200));
		lblLogin.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 55));
		lblLogin.setBounds(110,260,309,63);
		imgPane1.add(lblLogin);
		
		JLabel lblLoginIcon = new JLabel();
		lblLoginIcon.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\login.png"));
		lblLoginIcon.setBounds(149, 95, 134, 158);
		imgPane1.add(lblLoginIcon);
		
		JLabel image= new JLabel();
		image.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\background.jpg"));
		image.setBounds(0, 0, 450, 600);
		mainPanelLogin.add(image);
		
		loginPane = new JPanel();
		loginPane.setBounds(450,0,450,600);
		loginPane.setBackground(new Color(32,33, 35));
		loginPane.setLayout(null);
		mainPanelLogin.add(loginPane);
		
		userLbl = new JLabel("E-mail:");
		userLbl.setBounds(50,80,70,15);
		userLbl.setForeground(new Color(57,113, 177));
		userLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		loginPane.add(userLbl);
		
		emailTxtLogin = new JTextField();
		emailTxtLogin.setBounds(50,110,300,25);
		emailTxtLogin.setBackground(new Color(32,33, 35));
		emailTxtLogin.addFocusListener(this);
		emailTxtLogin.setForeground(new Color(57,113, 177));
		emailTxtLogin.setBorder(null);
		loginPane.add(emailTxtLogin);
		
		emailSepLogin = new JSeparator();
		emailSepLogin.setBounds(50,137,300,2);
		loginPane.add(emailSepLogin);
		
		
		pswLbl = new JLabel("Password:");
		pswLbl.setBounds(50,155,70,15);
		//pswLbl.setForeground(new Color(57,113, 177));
		
		pswLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		loginPane.add(pswLbl);	
		
		loginPsw = new JPasswordField();
		loginPsw.setBounds(50,175,300,25);
		loginPsw.setForeground(Color.white);
		loginPsw.setBackground(new Color(32,33, 35));
		loginPsw.setForeground(new Color(57,113, 177));
		loginPsw.addFocusListener(this);
		loginPsw.setBorder(null);
		loginPane.add(loginPsw);
		
		passwordSepLogin = new JSeparator();
		passwordSepLogin .setBounds(50,202,300,2);
		loginPane.add(passwordSepLogin );
		
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(50,245,300,35);
		btnDecoration(loginBtn);
		loginBtn.addActionListener(this);
		loginPane.add(loginBtn);
		
		adminSwitch = new JLabel("Switch to admin");
		adminSwitch.setBounds(80,300,110,15);
		underliningLabels(adminSwitch);
		adminSwitch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switchingPanels(mainPaneladminLogin);
			}
		});
		loginPane.add(adminSwitch);
	
		register= new JLabel("Register for exam");
		register.setBounds(210,300,115,15);
		underliningLabels(register);
		register.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switchingPanels(mainPanelSignup);
				
			}
		});
		loginPane.add(register);
		//end of login panel
		
		
		
		//start of Student Registration panel
		
		mainPanelSignup = new JPanel();
		mainPanelSignup.setSize(900, 600);
		mainPanelSignup.setLayout(null);
		
		
		imgPane2 = new JPanel();
		imgPane2.setBounds(0,0,450,600);
		imgPane2.setBackground(new Color(0,0,0,200));
		imgPane2.setLayout(null);
		mainPanelSignup.add(imgPane2);
		
		JLabel lblRegister = new JLabel("Register");
		lblRegister.setForeground(new Color(255,255,255,200));
		lblRegister.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 55));
		lblRegister.setBounds(110,290,309,63);
		imgPane2.add(lblRegister);
		
		JLabel lblRegisterIcon = new JLabel();
		lblRegisterIcon.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\clipboard.png"));
		lblRegisterIcon.setBounds(149, 95, 134, 158);
		imgPane2.add(lblRegisterIcon);
		
		JLabel image2= new JLabel();
		image2.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\background.jpg"));
		image2.setBounds(0, 0, 450, 600);
		mainPanelSignup.add(image2);
		
		signupPane = new JPanel();
		signupPane.setBounds(450,0,450,600);
		signupPane.setBackground(new Color(32,33, 35));
		signupPane.setLayout(null);
		mainPanelSignup.add(signupPane);
		
		
		fname = new JLabel("First name");
		fname.setBounds(50,50,70,15);
		fname.setForeground(new Color(57,113, 177));
		fname.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		signupPane.add(fname);
		
		fnametxt = new JTextField();
		fnametxt.setBounds(50,80,300,20);
		fnametxt.setBackground(new Color(32,33, 35));
		fnametxt.addFocusListener(this);
		fnametxt.setForeground(new Color(57,113, 177));
		fnametxt.setBorder(null);
		signupPane.add(fnametxt);
		
		fnameSep = new JSeparator();
		fnameSep.setBounds(50,107,300,2);
		signupPane.add(fnameSep);
		
		lname = new JLabel("Last name");
		lname.setBounds(50,130,70,15);
		lname.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		signupPane.add(lname);
		
		lnametxt = new JTextField();
		lnametxt.setBounds(50,160,300,20);
		lnametxt.setBackground(new Color(32,33, 35));
		lnametxt.setForeground(new Color(57,113, 177));
		lnametxt.addFocusListener(this);
		lnametxt.setBorder(null);
		signupPane.add(lnametxt);
		
		lnameSep = new JSeparator();
		lnameSep.setBounds(50,187,300,2);
		signupPane.add(lnameSep);
		
		email = new JLabel("Email");
		email.setBounds(50,210,70,15);
		email.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		signupPane.add(email);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(50,240,300,20);
		emailtxt.setBackground(new Color(32,33, 35));
		emailtxt.setForeground(new Color(57,113, 177));
		emailtxt.addFocusListener(this);
		emailtxt.setBorder(null);
		signupPane.add(emailtxt);
		
		emailSepSignup = new JSeparator();
		emailSepSignup.setBounds(50,267,300,2);
		signupPane.add(emailSepSignup);
		
		password = new JLabel("Password");
		password.setBounds(50,290,70,15);
		password.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		signupPane.add(password);
		
		signupPsw = new JTextField();
		signupPsw.setBounds(50,320,300,20);
		signupPsw.setBorder(null);
		signupPsw.setBackground(new Color(32,33, 35));
		signupPsw.addFocusListener(this);
		signupPsw.setForeground(new Color(57,113, 177));
		signupPsw.setEditable(false);
		signupPsw.setForeground(new Color(57,113,177));
		signupPane.add(signupPsw);
		
		pswdSepSignup = new JSeparator();
		pswdSepSignup.setBounds(50,347,300,2);
		signupPane.add(pswdSepSignup);
		
		genPasswordBtn = new JButton("Generate");
		genPasswordBtn.setBounds(110,370,90,30);
		genPasswordBtn.addActionListener(this);
		btnDecoration(genPasswordBtn);
		signupPane.add(genPasswordBtn);
		
		regBtn = new JButton("Register");
		regBtn.setBounds(210,370,90,30);
		regBtn.addActionListener(this);
		btnDecoration(regBtn);
		signupPane.add(regBtn);
		
		back = new JLabel("Back to login");
		back.setBounds(310,500,85,17);
		back.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		underliningLabels(back);
		back.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switchingPanels(mainPanelLogin);
			}
		});
		signupPane.add(back);
		//end of student registration panel
		
		
		/*start of admin login pane  */
		mainPaneladminLogin = new JPanel();
		mainPaneladminLogin.setSize(900, 600);
		mainPaneladminLogin.setLayout(null);
		
		
		imgPane3 = new JPanel();
		imgPane3.setBounds(0,0,450,600);
		imgPane3.setBackground(new Color(0,0,0,200));
		mainPaneladminLogin.add(imgPane3);
		imgPane3.setLayout(null);
		
		JLabel lblAdminLogin = new JLabel("Admin login");
		lblAdminLogin.setForeground(new Color(255,255,255,200));
		lblAdminLogin.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 55));
		lblAdminLogin.setBounds(74,245,309,63);
		imgPane3.add(lblAdminLogin);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\manager.png"));
		lblNewLabel_1.setBounds(149, 95, 134, 158);
		imgPane3.add(lblNewLabel_1);
		
		JLabel image3= new JLabel();
		image3.setIcon(new ImageIcon("E:\\Apps\\eclipse\\preferences\\ExamSystem\\resources\\images\\background.jpg"));
		image3.setBounds(0, 0, 450, 600);
		mainPaneladminLogin.add(image3);
		
		adminLoginPane = new JPanel();
		adminLoginPane.setBounds(450,0,450,600);
		adminLoginPane.setBackground(new Color(32,33, 35));
		adminLoginPane.setLayout(null);
		mainPaneladminLogin.add(adminLoginPane);
		
		adminLbl = new JLabel("Username:");
		adminLbl.setBounds(50,80,70,15);
		adminLbl.setForeground(new Color(57,113, 177));
		adminLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		adminLoginPane.add(adminLbl);
		
		adminTxtLogin = new JTextField();
		adminTxtLogin.setBounds(50,110,300,25);
		adminTxtLogin.setBorder(null);
		adminTxtLogin.setBackground(new Color(32,33, 35));
		adminTxtLogin.addFocusListener(this);
		adminTxtLogin.setForeground(new Color(57,113, 177));
		adminLoginPane.add(adminTxtLogin);
		
		adminUserSep = new JSeparator();
		adminUserSep.setBounds(50,137,300,2);
		adminLoginPane.add(adminUserSep);
		
		adminPswLbl = new JLabel("Password:");
		adminPswLbl.setBounds(50,155,70,15);
		adminPswLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		adminLoginPane.add(adminPswLbl);	
		
		adminLoginPsw = new JPasswordField();
		adminLoginPsw.setBounds(50,175,300,25);
		adminLoginPsw.setBorder(null);
		adminLoginPsw.setBackground(new Color(32,33, 35));
		adminLoginPsw.addFocusListener(this);
		adminLoginPsw.setForeground(new Color(57,113, 177));
		adminLoginPane.add(adminLoginPsw);
		
		adminPwdSep = new JSeparator();
		adminPwdSep.setBounds(50,202,300,2);
		adminLoginPane.add(adminPwdSep);
		
		adminLoginBtn = new JButton("Login");
		adminLoginBtn.setBounds(50,245,300,35);
		adminLoginBtn.addActionListener(this);
		btnDecoration(adminLoginBtn);
		adminLoginPane.add(adminLoginBtn);
		
		userSwitch = new JLabel("Switch to user");
		userSwitch.setBounds(150,300,90,15);
		userSwitch.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
		underliningLabels(userSwitch);
		userSwitch.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				switchingPanels(mainPanelLogin);
			}
		});
		adminLoginPane.add(userSwitch);
	//end of admin login pane
		
		
	//start of admin pane	
		
		adminTabPane = new JTabbedPane();
		genTokenPanel= new JPanel();
		//genTokenPanel.setSize(900,600);
		genTokenPanel.setLayout(null);
		adminTabPane.addTab("Examinees", genTokenPanel);
		rootLayer.add(adminTabPane);
		dispTable();
		
		tabLayers = new JLayeredPane();
		tabLayers.setBounds(0, 0, 900, 600);
		tabLayers.setLayout(new CardLayout());
		adminTabPane.addTab("Set questions",tabLayers);
		
		modulePanel = new JPanel();
		modulePanel.setLayout(null);
		tabLayers.add(modulePanel);
		
		JLabel moduleTitle = new JLabel("Select module to set question");
		moduleTitle.setBounds(285, 45, 250, 42);
		moduleTitle.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		modulePanel.add(moduleTitle);
		
		javaBtn = new JButton("JAVA");
		javaBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		javaBtn.setBounds(359, 103, 106, 42);
		javaBtn.addActionListener(this);
		modulePanel.add(javaBtn);
		
		cBtn = new JButton("C#");
		cBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		cBtn.setBounds(359, 155, 106, 42);
		cBtn.addActionListener(this);
		modulePanel.add(cBtn);
		
		pythonBtn = new JButton("Python");
		pythonBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		pythonBtn.setBounds(359, 207, 106, 42);
		pythonBtn.addActionListener(this);
		modulePanel.add(pythonBtn);
		
		javaScriptBtn = new JButton("Java Script");
		javaScriptBtn.setFont(new Font("Sans-Serif", Font.PLAIN, 18));
		javaScriptBtn.setBounds(359, 258, 106, 42);
		javaScriptBtn.addActionListener(this);
		modulePanel.add(javaScriptBtn);
		
		
		questionPanel = new JPanel();
		questionPanel.setLayout(null);
		
		
		JLabel addQuesLbl = new JLabel("Question");
		addQuesLbl.setBounds(81, 57, 61, 13);
		questionPanel.add(addQuesLbl);
		
		quesTextArea = new JTextArea();
		quesTextArea.setBounds(79, 80, 690, 100);
		questionPanel.add(quesTextArea);
		
		JLabel lblOption = new JLabel("Option");
		lblOption.setBounds(81, 207, 45, 13);
		questionPanel.add(lblOption);
		
		
		JLabel lblA = new JLabel("A.");
		lblA.setBounds(81, 230, 20, 13);
		questionPanel.add(lblA);
		
		optionAtxt = new JTextField();
		optionAtxt.setBounds(111, 227, 131, 19);
		
		questionPanel.add(optionAtxt);
		
		JLabel lblB = new JLabel("B.");
		lblB.setBounds(81, 253, 20, 13);
		questionPanel.add(lblB);
		
		optionBtxt = new JTextField();
		optionBtxt.setBounds(111, 250, 131, 19);
		questionPanel.add(optionBtxt);
		
		
		JLabel lblC = new JLabel("C.");
		lblC.setBounds(81, 276, 20, 13);
		questionPanel.add(lblC);
		
		optionCtxt = new JTextField();
		optionCtxt.setBounds(111, 273, 131, 19);
		questionPanel.add(optionCtxt);
		
		
		JLabel lblD = new JLabel("D.");
		lblD.setBounds(81, 299, 20, 13);
		questionPanel.add(lblD);
		
		optionDtxt = new JTextField();
		optionDtxt.setBounds(111, 296, 131, 19);
		questionPanel.add(optionDtxt);
		
		JLabel lblCorrectAnswer = new JLabel("Correct answer");
		lblCorrectAnswer.setBounds(81, 324, 95, 13);
		questionPanel.add(lblCorrectAnswer);
		correctAnsCombo = new JComboBox();
		correctAnsCombo.setBounds(81, 347, 161, 21);
		correctAnsCombo.addItem("");
		correctAnsCombo.addItem("");
		correctAnsCombo.addItem("");
		correctAnsCombo.addItem("");
		correctAnsCombo.addPopupMenuListener(new PopupMenuListener() {
			
			@Override
			public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
				correctAnsCombo.removeAllItems();
				correctAnsCombo.addItem(optionAtxt.getText());
				correctAnsCombo.addItem(optionBtxt.getText());
				correctAnsCombo.addItem(optionCtxt.getText());
				correctAnsCombo.addItem(optionDtxt.getText());
				
			}
			
			@Override
			public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {}
			
			@Override
			public void popupMenuCanceled(PopupMenuEvent e) {}
		});
		questionPanel.add(correctAnsCombo);
		
		createQbtnJava = new JButton("Save");
		createQbtnJava.setBounds(81, 408, 75, 30);
		questionPanel.add(createQbtnJava);
		createQbtnJava.addActionListener(this);
		createQbtnJava.setVisible(false);
		
		createQbtnC = new JButton("Save");
		createQbtnC.setBounds(81, 408, 75, 30);
		questionPanel.add(createQbtnC);
		createQbtnC.addActionListener(this);
		createQbtnC.setVisible(false);
		
		createQbtnPython = new JButton("Save");
		createQbtnPython.setBounds(81, 408, 75, 30);
		questionPanel.add(createQbtnPython);
		createQbtnPython.addActionListener(this);
		createQbtnPython.setVisible(false);
		
		createQbtnJs = new JButton("Save");
		createQbtnJs.setBounds(81, 408, 75, 30);
		questionPanel.add(createQbtnJs);
		createQbtnJs.addActionListener(this);
		createQbtnJs.setVisible(false);
		
		back2Module = new JLabel("Back");
		back2Module.setBounds(81,450,75,30);
		questionPanel.add(back2Module);
		back2Module.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				questCounterCs=0;
				questCounterPython = 0;
				questCounterJs = 0;
				questCounterJava = 0;
				quesInserted.setText("");
				createQbtnJava.setVisible(false);
				createQbtnC.setVisible(false);
				createQbtnPython.setVisible(false);
				createQbtnJs.setVisible(false);
				switchingTabbedPanels(modulePanel);
			}
		});
		
		//numOfquestion,quesInserted
		
		numOfquestion = new JLabel();
		numOfquestion.setBounds(500,10,450,20);
		questionPanel.add(numOfquestion);
		
		quesInserted = new JLabel();
		quesInserted.setBounds(500,30,450,20);
		questionPanel.add(quesInserted);
		//end of admin pane
		
		//module selection pane
		moduleSelection = new JPanel();
		moduleSelection.setLayout(null);
		
		JLabel titleLbl = new JLabel("Please select a module");
		titleLbl.setFont(new Font("Sans-Serif", Font.PLAIN, 16));
		titleLbl.setBounds(77, 102, 200, 13);
		moduleSelection.add(titleLbl);
		
		 btnGrp = new ButtonGroup();
		
		javaRadio = new JRadioButton("Java");
		javaRadio.setBounds(77,130,70,20);
		btnGrp.add(javaRadio);
		moduleSelection.add(javaRadio);
		
		cSharpRadio = new JRadioButton("cSharp");
		cSharpRadio.setBounds(77,150,70,20);
		btnGrp.add(cSharpRadio);
		moduleSelection.add(cSharpRadio);
		
		pythonRadio = new JRadioButton("python");
		pythonRadio.setBounds(77,170,70,20);
		btnGrp.add(pythonRadio);
		moduleSelection.add(pythonRadio);
		
		jsRadio = new JRadioButton("Javascript");
		jsRadio.setBounds(77,190,90,20);
		btnGrp.add(jsRadio);
		moduleSelection.add(jsRadio);
		
		startExam = new JButton("Start");
		startExam.setBounds(77,230,70,20);
		moduleSelection.add(startExam);
		startExam.addActionListener(this);
		
		examRootPanel = new JPanel();
		examRootPanel.setLayout(null);
		
		dynamicRootQuestionPane = new JPanel();
		dynamicRootQuestionPane = new JPanel();
		dynamicRootQuestionPane.setBounds(0, 0, 718, 491);
		dynamicRootQuestionPane.setLayout(null);
		examRootPanel.add(dynamicRootQuestionPane);
		
		
		btnPane = new JPanel();
		btnPane.setBounds(0, 495, 886, 68);
		btnPane.setBackground(Color.red);
		btnPane.setLayout(null);
		examRootPanel.add(btnPane);
		
		
		
		nextBtn = new JButton("Next");
		nextBtn.setBounds(768, 24, 85, 21);
		btnPane.add(nextBtn);
		nextBtn.addActionListener(this);
		//nextBtn.setVisible(false);
		
		prevBtn = new JButton("Back");
		prevBtn.setBounds(680, 24, 85, 21);
		prevBtn.addActionListener(this);
		btnPane.add(prevBtn);
		//prevBtn.setVisible(false);
		
		pythonRadio.setActionCommand("python");
		cSharpRadio.setActionCommand("cSharp");
		javaRadio.setActionCommand("Java");
		jsRadio.setActionCommand("Javascript");
		
		finishBtn = new JButton("Finish");
		finishBtn.setBounds(768, 24, 85, 21);
		finishBtn.addActionListener(this);
		finishBtn.setVisible(false);
		btnPane.add(finishBtn);
		
		resultPanel = new JPanel();
		resultPanel.setSize(900,600);
		resultPanel.setLayout(null);
		
		greetLabel = new JLabel("You have Scored...");
		greetLabel.setBounds(290, 147, 335, 61);
		greetLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		resultPanel.add(greetLabel);
		
		markLabel = new JLabel();
		markLabel.setBounds(390, 210, 63, 44);
		markLabel.setFont(new Font("Tahoma", Font.PLAIN, 36));
		resultPanel.add(markLabel);
		
		
}
	

public static void main(String[] args) {
		new examSystem().setVisible(true);

	}
	

	@Override
public void actionPerformed(ActionEvent e) {
		validation v = new validation();
		dbConnection dbc = new dbConnection();
		if (e.getSource().equals(regBtn)) 
		{
			Boolean result = v.regValidation(fnametxt.getText(), lnametxt.getText(), emailtxt.getText(), signupPsw.getText());
			if (result==true) {
				fnametxt.setText("");
				lnametxt.setText("");
				emailtxt.setText("");
				signupPsw.setText("");
			}
			else {
				JOptionPane.showMessageDialog(null, "Make sure to generate the password and to fill all the fields");
			}
			
		}
		if(e.getSource().equals(loginBtn)) {
				String pswd = new String(loginPsw.getPassword());
				
					try {
						
						Boolean result = v.loginValidation(emailTxtLogin.getText(),pswd);
						if (result==true) {
							switchingPanels(moduleSelection);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "invalid username or password");
						}
					} catch (HeadlessException | SQLException e1) {
						
					}
				
					
		}
		if (e.getSource().equals(genPasswordBtn)) {
			signupPsw.setText(tokenGenerator());
			JOptionPane.showMessageDialog(null, "Please note your password from password field before proceeding");
		}
		if (e.getSource().equals(adminLoginBtn)) {
			String pswd = new String(adminLoginPsw.getPassword());
			
			try {
				Boolean result=v.adminLogVal(adminTxtLogin.getText(), pswd);
				if (result==true) {
					
					switchingPanels(adminTabPane);
					
					//switchingPanels(panel);
				}
				else {
					JOptionPane.showMessageDialog(null, "invalid username or password");
				}
				
			} catch (HeadlessException | SQLException e1) {
				e1.printStackTrace();
			}
		
		}
		if (e.getSource().equals(javaBtn)) {
			switchingTabbedPanels(questionPanel);
			QuestionDat qd = new QuestionDat();
			try {
				QnAlist = qd.javaQuestionData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numOfquestion.setText("You currently have " + (QnAlist.size()) + " questions");
			
			createQbtnJava.setVisible(true);
		}
		if (e.getSource().equals(createQbtnJava)) {
			String ans = correctAnsCombo.getSelectedItem().toString();
			Boolean result = v.javaQuestionInsertion(quesTextArea.getText(), optionAtxt.getText(), 
					optionBtxt.getText(), optionCtxt.getText(), optionDtxt.getText(), ans);
			questCounterJava++;
			
			questionValidation(result, questCounterJava);
			
		}
		if (e.getSource().equals(cBtn)) {
			switchingTabbedPanels(questionPanel);
			QuestionDat qd = new QuestionDat();
			try {
				QnAlist = qd.cSharpQuestionData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numOfquestion.setText("You currently have " + (QnAlist.size()) + " questions");
			createQbtnC.setVisible(true);
			
		}
		if (e.getSource().equals(createQbtnC)) {
			String ans = correctAnsCombo.getSelectedItem().toString();
			Boolean result = v.cQuestionInsertion(quesTextArea.getText(), optionAtxt.getText(), 
					optionBtxt.getText(), optionCtxt.getText(), optionDtxt.getText(), ans);
			questCounterCs++;
			
			questionValidation(result, questCounterCs);
		}
		
		if (e.getSource().equals(pythonBtn)) {
			switchingTabbedPanels(questionPanel);
			QuestionDat qd = new QuestionDat();
			try {
				QnAlist = qd.pythonQuestionData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numOfquestion.setText("You currently have " + (QnAlist.size()) + " questions");
			createQbtnPython.setVisible(true);
			
		}
		if (e.getSource().equals(createQbtnPython)) {
			String ans = correctAnsCombo.getSelectedItem().toString();
			Boolean result = v.pythonQuestionInsertion(quesTextArea.getText(), optionAtxt.getText(), 
					optionBtxt.getText(), optionCtxt.getText(), optionDtxt.getText(), ans);
			questCounterPython++;
			
			questionValidation(result, questCounterPython);
			
		}
		if (e.getSource().equals(javaScriptBtn)) {
			switchingTabbedPanels(questionPanel);
			QuestionDat qd = new QuestionDat();
			try {
				QnAlist = qd.jsQuestionData();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			numOfquestion.setText("You currently have " + (QnAlist.size()) + " questions");
			createQbtnJs.setVisible(true);
			
		}
		if (e.getSource().equals(createQbtnJs)) {
			String ans = correctAnsCombo.getSelectedItem().toString();
			Boolean result = v.javascriptQuestionInsertion(quesTextArea.getText(), optionAtxt.getText(), 
					optionBtxt.getText(), optionCtxt.getText(), optionDtxt.getText(), ans);
			
			questCounterJs++;
			questionValidation(result,questCounterJs);
		}
		if(e.getSource().equals(startExam)) {
			if (btnGrp.getSelection().getActionCommand().equals("Java")) {
				QuestionDat qd = new QuestionDat();
				try {
					QnAlist= qd.javaQuestionData();
					Collections.shuffle(QnAlist);
					int size = QnAlist.size();
					userAns = new String[size];
					dynamicQpanels(size,QnAlist);
				} catch (SQLException e1) {
					
				}
				
			}
			else if (btnGrp.getSelection().getActionCommand().equals("cSharp")) {
				QuestionDat qd = new QuestionDat();
				
				try {
					QnAlist= qd.cSharpQuestionData();
					Collections.shuffle(QnAlist);
					int size = QnAlist.size();
					userAns = new String[size];
					dynamicQpanels(size,QnAlist);
				} catch (SQLException e1) {
					
				}
				
			}				
			else if (btnGrp.getSelection().getActionCommand().equals("python")) {
				QuestionDat qd = new QuestionDat();
				
				try {
					QnAlist= qd.pythonQuestionData();
					Collections.shuffle(QnAlist);
					int size = QnAlist.size();
					userAns = new String[size];
					dynamicQpanels(size,QnAlist);
				} catch (SQLException e1) {
					
				}
				
			}
			
			else if(btnGrp.getSelection().getActionCommand().equals("Javascript")){
				QuestionDat qd = new QuestionDat();
				
				try {
					QnAlist= qd.jsQuestionData();
					Collections.shuffle(QnAlist);
					int size = QnAlist.size();
					userAns = new String[size];
					dynamicQpanels(size,QnAlist);
				} catch (SQLException e1) {
					
				}
				
			}
		}
		if (e.getSource().equals(nextBtn)) {
			
			if (counter==QnAlist.size()-2) {
				finishBtn.setVisible(true);
				nextBtn.setVisible(false);
				
				
			}
			
			
		if (option1[counter].isSelected() || option2[counter].isSelected()||option3[counter].isSelected()||option4[counter].isSelected()) {
			
			userAns[counter]= dynamicBtnGrp[counter].getSelection().getActionCommand();
			
		}
		else {
			userAns[counter]=null;
		}
		switchingDynamicQpanels(counter);
		counter++;
			
			
				
		}
		if (e.getSource().equals(prevBtn)) {
		
				nextBtn.setVisible(true);
				finishBtn.setVisible(false);
			
			if (counter>=1) {
				counter= counter-1;
				prevDynamicPanels(counter);	
			}
		
			
		}
		
		if (e.getSource().equals(finishBtn)) {
			if (option1[counter].isSelected() || option2[counter].isSelected()||option3[counter].isSelected()||option4[counter].isSelected()) {
				
				userAns[counter]= dynamicBtnGrp[counter].getSelection().getActionCommand();
				
			}
			else {
				userAns[counter]=null;
			}
			switchingPanels(resultPanel);
			for (int i = 0; i < QnAlist.size(); i++) {
				if (QnAlist.get(i).getCorrectAns().equals(userAns[i])) {
					mark=mark+1;
				}
			}
			markLabel.setText(String.valueOf(mark));
		}
	}
public void switchingPanels(JPanel panel) {

		rootLayer.removeAll();
		rootLayer.add(panel);
		rootLayer.repaint();
		rootLayer.revalidate();
		
	}

public void switchingPanels(JTabbedPane panel) {
	rootLayer.removeAll();
	rootLayer.add(panel);
	rootLayer.repaint();
	rootLayer.revalidate();
	
}
public void switchingTabbedPanels(JPanel panel) {
	tabLayers.removeAll();
	tabLayers.add(panel);
	tabLayers.repaint();
	tabLayers.revalidate();
	
}
public void dispTable()
{
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10,10,860,500);
	genTokenPanel.add(scrollPane);
	String[] col = {"Firstname", "Lastname", "Email"};
	examineeData = new JTable();
	model = (DefaultTableModel) examineeData.getModel();
	model.setDataVector(null, col);
	scrollPane.setViewportView(examineeData);
	ExamineesDat ed = new ExamineesDat();
	Object[] columnDat = new Object[3];
		ArrayList<User> listOfUsers = null;
		try {
			listOfUsers = ed.tableData();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < listOfUsers.size(); i++) {
			columnDat[0] = listOfUsers.get(i).getFname();
			columnDat[1] = listOfUsers.get(i).getLastName();
			columnDat[2] = listOfUsers.get(i).getEmail();
			model.addRow(columnDat);
		}
		
}
public String tokenGenerator() {
	int n = 10;
	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+ "0123456789"+ "abcdefghijklmnopqrstuvxyz";  
	StringBuilder sb = new StringBuilder(n); 
	for (int i = 0; i < n; i++) { 
	int index = (int)(AlphaNumericString.length() * Math.random()); 
	sb.append(AlphaNumericString.charAt(index));
	}
	return sb.toString();
}
public void questionValidation(Boolean result , int questionCounts) {

	if (result == false) {
		JOptionPane.showMessageDialog(null, "fillup all the fields");
	}
	else {
		numOfquestion.setText("You now have " + (QnAlist.size()+questionCounts) + " questions");
		
		quesInserted.setText("You just inserted " + (questionCounts) +" questions");
		JOptionPane.showMessageDialog(null, "Question succesfully created");
		quesTextArea.setText("");
		optionAtxt.setText("");
		optionBtxt.setText("");
		optionCtxt.setText("");
		optionDtxt.setText("");
		correctAnsCombo.setSelectedItem(null);
	}
}
public void dynamicQpanels(int size, ArrayList<QandA> listOfQuestion) {
	
	dynamicQpane = new JPanel[size];
	dynamicQuestions = new JLabel[size];
	dynamicBtnGrp = new ButtonGroup[size];
	option1 = new JRadioButton[size];
	option2 = new JRadioButton[size];
	option3 = new JRadioButton[size];
	option4 = new JRadioButton[size];
	
	
	for (int i = 0; i < size; i++) {
		dynamicQpane[i] = new JPanel();
		dynamicQpane[i].setBounds(0, 0, 718, 491);
		dynamicQpane[i].setLayout(null);
		dynamicRootQuestionPane.add(dynamicQpane[0]);
		
		
		
		dynamicQuestions[i] = new JLabel("<html>Q"+(i+1)+".   "+listOfQuestion.get(i).getQuestion()+"</html>");
		dynamicQuestions[i].setFont(new Font("SansSerif", Font.PLAIN, 17));
		dynamicQuestions[i].setBounds(51, 80, 624, 50);
		dynamicQpane[i].add(dynamicQuestions[i]);
		
		dynamicBtnGrp[i]= new ButtonGroup();
		
		option1[i] = new JRadioButton(listOfQuestion.get(i).getOption1());
		option1[i].setBounds(51, 167, 450, 21);
		option1[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option1[i].setActionCommand(listOfQuestion.get(i).getOption1());
		dynamicBtnGrp[i].add(option1[i]);
		dynamicQpane[i].add(option1[i]);
		pythonRadio.setActionCommand("python");
		
		option2[i] = new JRadioButton(listOfQuestion.get(i).getOption2());
		option2[i].setBounds(51, 206, 450, 21);
		option2[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option2[i].setActionCommand(listOfQuestion.get(i).getOption2());
		dynamicBtnGrp[i].add(option2[i]);
		dynamicQpane[i].add(option2[i]);
		
		option3[i] = new JRadioButton(listOfQuestion.get(i).getOption3());
		option3[i].setBounds(51, 245, 450, 21);
		option3[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option3[i].setActionCommand(listOfQuestion.get(i).getOption3());
		dynamicBtnGrp[i].add(option3[i]);
		dynamicQpane[i].add(option3[i]);
		
		option4[i] = new JRadioButton(listOfQuestion.get(i).getOption4());
		option4[i].setBounds(51, 284, 450, 21);
		option4[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option4[i].setActionCommand(listOfQuestion.get(i).getOption4());
		dynamicBtnGrp[i].add(option4[i]);
		dynamicQpane[i].add(option4[i]);
		
	}
	
	switchingPanels(examRootPanel);
}
public void underliningLabels(JLabel hyperlinks) {
	hyperlinks.setFont(new Font("Sans-Serif", Font.PLAIN, 14));
	hyperlinks.setForeground(new Color(57,113,177));
	hyperlinks.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	Font font = hyperlinks.getFont();
	Map attributes = font.getAttributes();
	attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
	hyperlinks.setFont(font.deriveFont(attributes));
}
public void switchingDynamicQpanels(int counter) {
	
	dynamicRootQuestionPane.removeAll();
	dynamicRootQuestionPane.add(dynamicQpane[counter+1]);
	dynamicRootQuestionPane.repaint();
	dynamicRootQuestionPane.revalidate();
}
public void prevDynamicPanels(int counter) {
	dynamicRootQuestionPane.removeAll();
	dynamicRootQuestionPane.add(dynamicQpane[counter]);
	dynamicRootQuestionPane.repaint();
	dynamicRootQuestionPane.revalidate();
}




@Override
public void focusGained(FocusEvent e) {
	if (e.getSource().equals(loginPsw)) {
		
		pswLbl.setForeground(new Color(57,113,177));
		userLbl.setForeground(new Color(51,52,54));
		
	}
	
	if (e.getSource().equals(emailTxtLogin)) {
		
		pswLbl.setForeground(new Color(51,52,54));
		userLbl.setForeground(new Color(57,113,177));
		
	}
	if (e.getSource().equals(adminLoginPsw)) {
	
	adminPswLbl.setForeground(new Color(57,113,177));
	adminLbl.setForeground(new Color(51,52,54));
	
}

	if (e.getSource().equals(adminTxtLogin)) {
	adminPswLbl.setForeground(new Color(51,52,54));
	adminLbl.setForeground(new Color(57,113,177));
	
}
	if (e.getSource().equals(fnametxt)) {
		fname.setForeground(new Color(57,113,177));
		lname.setForeground(new Color(51,52,54));
		email.setForeground(new Color(51,52,54));
		password.setForeground(new Color(51,52,54));
	}
	if (e.getSource().equals(lnametxt)) {
		fname.setForeground(new Color(51,52,54));
		lname.setForeground(new Color(57,113,177));
		email.setForeground(new Color(51,52,54));
		password.setForeground(new Color(51,52,54));
	}
	if (e.getSource().equals(emailtxt)) {
		fname.setForeground(new Color(51,52,54));
		lname.setForeground(new Color(51,52,54));
		email.setForeground(new Color(57,113,177));
		password.setForeground(new Color(51,52,54));
	}
	if (e.getSource().equals(signupPsw)) {
		fname.setForeground(new Color(51,52,54));
		lname.setForeground(new Color(51,52,54));
		email.setForeground(new Color(51,52,54));
		password.setForeground(new Color(57,113,177));
		
	}
	
	
}




@Override
public void focusLost(FocusEvent e) {
	// TODO Auto-generated method stub
	
}
private void btnDecoration(JButton buttons) {
	buttons.setBackground(new Color(126,87,194));
	buttons.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	buttons.setFont(new Font("Sans-Serif", Font.PLAIN, 15));
	buttons.setBorder(null);
		
	}

}
