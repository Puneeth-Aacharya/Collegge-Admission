import java.awt.EventQueue;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register {
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	
	Connection con;
	PreparedStatement p;
	ResultSet r; 

	public JFrame frmApplicationForm;
	private JTextField sName;
	private JTextField fname;
	private JTextField mname;
	private JTextField m_no;
	private JTextField addr;
	private JTextField village;
	private JTextField city;
	private JTextField puc;
	private JComboBox taluk;
	private JComboBox dist;
	private JComboBox branch;
	private JComboBox got;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			  UIManager.setLookAndFeel(new NimbusLookAndFeel());
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register window = new Register();
					window.frmApplicationForm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Register() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmApplicationForm = new JFrame();
		frmApplicationForm.setTitle("Application Form\r\n | 4JN18IS065-PUNEETH K S");
		frmApplicationForm.setBounds(100, 100, 1293, 801);
		frmApplicationForm.setLocationRelativeTo(null);
		frmApplicationForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmApplicationForm.getContentPane().setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("STUDENT REGISTRATION");
		lblStudentRegistration.setFont(new Font("SansSerif", Font.BOLD, 46));
		lblStudentRegistration.setBounds(340, 6, 604, 70);
		frmApplicationForm.getContentPane().add(lblStudentRegistration);
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblStudentName.setBounds(58, 149, 217, 61);
		frmApplicationForm.getContentPane().add(lblStudentName);
		
		sName = new JTextField();
		sName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		sName.setBounds(317, 149, 255, 61);
		frmApplicationForm.getContentPane().add(sName);
		sName.setColumns(10);
		
		JLabel lblFatherName = new JLabel("Father Name   :");
		lblFatherName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblFatherName.setBounds(58, 236, 217, 57);
		frmApplicationForm.getContentPane().add(lblFatherName);
		
		JLabel lblMotherName = new JLabel("Mother Name  :");
		lblMotherName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblMotherName.setBounds(58, 319, 217, 61);
		frmApplicationForm.getContentPane().add(lblMotherName);
		
		JLabel lblParentsPhno = new JLabel("Mobile No. :");
		lblParentsPhno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblParentsPhno.setBounds(58, 409, 217, 61);
		frmApplicationForm.getContentPane().add(lblParentsPhno);
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblAddress.setBounds(58, 506, 217, 57);
		frmApplicationForm.getContentPane().add(lblAddress);
		
		JLabel lblVillage = new JLabel("Village  :");
		lblVillage.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblVillage.setBounds(674, 149, 179, 61);
		frmApplicationForm.getContentPane().add(lblVillage);
		
		JLabel lblCity = new JLabel("City  :");
		lblCity.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblCity.setBounds(674, 236, 179, 56);
		frmApplicationForm.getContentPane().add(lblCity);
		
		JLabel lblTaluq = new JLabel("Taluk  :");
		lblTaluq.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblTaluq.setBounds(674, 321, 179, 57);
		frmApplicationForm.getContentPane().add(lblTaluq);
		
		JLabel lblDistrict = new JLabel("District :");
		lblDistrict.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblDistrict.setBounds(674, 411, 179, 57);
		frmApplicationForm.getContentPane().add(lblDistrict);
		
		taluk = new JComboBox();
		taluk.setFont(new Font("SansSerif", Font.PLAIN, 27));
		taluk.setModel(new DefaultComboBoxModel(new String[] {"Shivamogga", "Thirthahalli", "Sagara", "Soraba", "Shikaripura", "Hosanagra", "Bhadravathi"}));
		taluk.setBounds(933, 323, 255, 56);
		frmApplicationForm.getContentPane().add(taluk);
		
		dist = new JComboBox();
		dist.setModel(new DefaultComboBoxModel(new String[] {"Shivamogga", "Udupi", "Uttar kannada", "Mysore", "Dakshin Kannada"}));
		dist.setFont(new Font("SansSerif", Font.PLAIN, 26));
		dist.setBounds(933, 408, 255, 66);
		frmApplicationForm.getContentPane().add(dist);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save(e);
			}
		});
		btnNewButton.setBackground(new Color(72, 209, 204));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 37));
		btnNewButton.setBounds(563, 697, 232, 61);
		frmApplicationForm.getContentPane().add(btnNewButton);
		
		JLabel lblPucRegno = new JLabel("PUC Reg.no :");
		lblPucRegno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblPucRegno.setBounds(675, 506, 227, 57);
		frmApplicationForm.getContentPane().add(lblPucRegno);
		
		fname = new JTextField();
		fname.setFont(new Font("SansSerif", Font.PLAIN, 30));
		fname.setColumns(10);
		fname.setBounds(317, 232, 255, 61);
		frmApplicationForm.getContentPane().add(fname);
		
		mname = new JTextField();
		mname.setFont(new Font("SansSerif", Font.PLAIN, 30));
		mname.setColumns(10);
		mname.setBounds(317, 319, 255, 61);
		frmApplicationForm.getContentPane().add(mname);
		
		m_no = new JTextField();
		m_no.setFont(new Font("SansSerif", Font.PLAIN, 30));
		m_no.setColumns(10);
		m_no.setBounds(317, 409, 255, 61);
		frmApplicationForm.getContentPane().add(m_no);
		
		addr = new JTextField();
		addr.setFont(new Font("SansSerif", Font.PLAIN, 30));
		addr.setColumns(10);
		addr.setBounds(317, 502, 255, 61);
		frmApplicationForm.getContentPane().add(addr);
		
		village = new JTextField();
		village.setFont(new Font("SansSerif", Font.PLAIN, 30));
		village.setColumns(10);
		village.setBounds(933, 149, 255, 61);
		frmApplicationForm.getContentPane().add(village);
		
		city = new JTextField();
		city.setFont(new Font("SansSerif", Font.PLAIN, 30));
		city.setColumns(10);
		city.setBounds(933, 232, 255, 61);
		frmApplicationForm.getContentPane().add(city);
		
		puc = new JTextField();
		puc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		puc.setColumns(10);
		puc.setBounds(933, 502, 255, 61);
		frmApplicationForm.getContentPane().add(puc);
		
		JLabel lblSelectBranch = new JLabel("Select Branch :");
		lblSelectBranch.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblSelectBranch.setBounds(58, 600, 217, 57);
		frmApplicationForm.getContentPane().add(lblSelectBranch);
		
		branch = new JComboBox();
		branch.setModel(new DefaultComboBoxModel(new String[] {"Mechanical ", "Civil", "CSE", "ISE", "TCE", "EEE", "ECE"}));
		branch.setFont(new Font("SansSerif", Font.PLAIN, 26));
		branch.setBounds(317, 591, 255, 66);
		frmApplicationForm.getContentPane().add(branch);
		
		got = new JComboBox();
		got.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		got.setFont(new Font("SansSerif", Font.PLAIN, 26));
		got.setBounds(933, 591, 255, 66);
		frmApplicationForm.getContentPane().add(got);
		
		JLabel lblGotAdmission = new JLabel("Got Admission :");
		lblGotAdmission.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblGotAdmission.setBounds(649, 600, 242, 61);
		frmApplicationForm.getContentPane().add(lblGotAdmission);
	}
	public void save(ActionEvent evt)
	{
		String str=puc.getText();
		PUC obj=new PUC();
		obj.my_update(str);
		obj.frmPucMarks.setVisible(true);
		frmApplicationForm.dispose();
		
		String name=sName.getText();
		String F_name=fname.getText();
		String M_name=mname.getText();
		String Ph_no=m_no.getText();
		String Addr=addr.getText();
		String Vill=village.getText();
		String City=city.getText();
		String TQ=(String)taluk.getSelectedItem().toString();
		String DIST=(String)dist.getSelectedItem().toString();
		String Branch=(String)branch.getSelectedItem().toString();
		String Got=(String)got.getSelectedItem().toString();
		
		String PUC=puc.getText();
		
		java.util.Date date=new java.util.Date();
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		String s=sdf.format(date);
		
		try
		{			
			con=Student.Connect();
			
			String insert="INSERT INTO `register` (`NAME`, `FNAME`, `MNAME`,`MOBILE`,`ADDR`,`VILLAGE`,`CITY`,`TALUK`,`DIST`,`PUC`,`BRANCH`,`GOT_ADMISSION`,`DATE`,`TIME`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			p=con.prepareStatement(insert);
			p.setString(1,name);
			p.setString(2, F_name);
			p.setString(3, M_name);
			p.setString(4, Ph_no);
			p.setString(5, Addr);
			p.setString(6, Vill);
			p.setString(7, City);
			p.setString(8, TQ);
			p.setString(9, DIST);
			p.setString(10, PUC);
			p.setString(11, Branch);
			p.setString(12, Got);
			p.setDate(13, sqldate);
			p.setString(14, s);
			
			p.execute();
			JOptionPane.showMessageDialog(null, "Saved Succesfully......\nEnter your PUC marks");
			
			frmApplicationForm.dispose();
    		frontpage window = new frontpage();
    		window.frmWelcome.setVisible(true);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
