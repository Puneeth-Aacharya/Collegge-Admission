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

public class Edit {
	
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	Connection con;
	PreparedStatement p;
	ResultSet r; 

	public JFrame frmEditAppication;
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
	private JTextField puc_fetch;

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
					Edit window = new Edit();
					window.frmEditAppication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Edit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEditAppication = new JFrame();
		frmEditAppication.setTitle("Application Form\r\n | 4JN18IS065-PUNEETH K S");
		frmEditAppication.setBounds(100, 100, 1293, 801);
		frmEditAppication.setLocationRelativeTo(null);
		frmEditAppication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEditAppication.getContentPane().setLayout(null);
		
		JLabel lblStudentRegistration = new JLabel("STUDENT REGISTRATION");
		lblStudentRegistration.setFont(new Font("SansSerif", Font.BOLD, 46));
		lblStudentRegistration.setBounds(334, 0, 604, 70);
		frmEditAppication.getContentPane().add(lblStudentRegistration);
		
		JLabel lblStudentName = new JLabel("Student Name :");
		lblStudentName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblStudentName.setBounds(58, 149, 217, 61);
		frmEditAppication.getContentPane().add(lblStudentName);
		
		sName = new JTextField();
		sName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		sName.setBounds(317, 149, 255, 61);
		frmEditAppication.getContentPane().add(sName);
		sName.setColumns(10);
		
		JLabel lblFatherName = new JLabel("Father Name   :");
		lblFatherName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblFatherName.setBounds(58, 236, 217, 57);
		frmEditAppication.getContentPane().add(lblFatherName);
		
		JLabel lblMotherName = new JLabel("Mother Name  :");
		lblMotherName.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblMotherName.setBounds(58, 319, 217, 61);
		frmEditAppication.getContentPane().add(lblMotherName);
		
		JLabel lblParentsPhno = new JLabel("Mobile No. :");
		lblParentsPhno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblParentsPhno.setBounds(58, 409, 217, 61);
		frmEditAppication.getContentPane().add(lblParentsPhno);
		
		JLabel lblAddress = new JLabel("Address  :");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblAddress.setBounds(58, 506, 217, 57);
		frmEditAppication.getContentPane().add(lblAddress);
		
		JLabel lblVillage = new JLabel("Village  :");
		lblVillage.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblVillage.setBounds(674, 149, 179, 61);
		frmEditAppication.getContentPane().add(lblVillage);
		
		JLabel lblCity = new JLabel("City  :");
		lblCity.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblCity.setBounds(674, 236, 179, 56);
		frmEditAppication.getContentPane().add(lblCity);
		
		JLabel lblTaluq = new JLabel("Taluk  :");
		lblTaluq.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblTaluq.setBounds(674, 321, 179, 57);
		frmEditAppication.getContentPane().add(lblTaluq);
		
		JLabel lblDistrict = new JLabel("District :");
		lblDistrict.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblDistrict.setBounds(674, 411, 179, 57);
		frmEditAppication.getContentPane().add(lblDistrict);
		
		taluk = new JComboBox();
		taluk.setFont(new Font("SansSerif", Font.PLAIN, 27));
		taluk.setModel(new DefaultComboBoxModel(new String[] {"Shivamogga", "Thirthahalli", "Sagara", "Soraba", "Shikaripura", "Hosanagra", "Bhadravathi"}));
		taluk.setBounds(933, 323, 255, 56);
		frmEditAppication.getContentPane().add(taluk);
		
		dist = new JComboBox();
		dist.setModel(new DefaultComboBoxModel(new String[] {"Shivamogga", "Udupi", "Uttar kannada", "Mysore", "Dakshin Kannada"}));
		dist.setFont(new Font("SansSerif", Font.PLAIN, 26));
		dist.setBounds(933, 408, 255, 66);
		frmEditAppication.getContentPane().add(dist);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(e);
			}
		});
		update.setBackground(new Color(72, 209, 204));
		update.setForeground(Color.BLUE);
		update.setFont(new Font("SansSerif", Font.BOLD, 37));
		update.setBounds(535, 697, 232, 61);
		frmEditAppication.getContentPane().add(update);
		
		JLabel lblPucRegno = new JLabel("PUC Reg.no :");
		lblPucRegno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblPucRegno.setBounds(675, 506, 227, 57);
		frmEditAppication.getContentPane().add(lblPucRegno);
		
		fname = new JTextField();
		fname.setFont(new Font("SansSerif", Font.PLAIN, 30));
		fname.setColumns(10);
		fname.setBounds(317, 232, 255, 61);
		frmEditAppication.getContentPane().add(fname);
		
		mname = new JTextField();
		mname.setFont(new Font("SansSerif", Font.PLAIN, 30));
		mname.setColumns(10);
		mname.setBounds(317, 319, 255, 61);
		frmEditAppication.getContentPane().add(mname);
		
		m_no = new JTextField();
		m_no.setFont(new Font("SansSerif", Font.PLAIN, 30));
		m_no.setColumns(10);
		m_no.setBounds(317, 409, 255, 61);
		frmEditAppication.getContentPane().add(m_no);
		
		addr = new JTextField();
		addr.setFont(new Font("SansSerif", Font.PLAIN, 30));
		addr.setColumns(10);
		addr.setBounds(317, 502, 255, 61);
		frmEditAppication.getContentPane().add(addr);
		
		village = new JTextField();
		village.setFont(new Font("SansSerif", Font.PLAIN, 30));
		village.setColumns(10);
		village.setBounds(933, 149, 255, 61);
		frmEditAppication.getContentPane().add(village);
		
		city = new JTextField();
		city.setFont(new Font("SansSerif", Font.PLAIN, 30));
		city.setColumns(10);
		city.setBounds(933, 232, 255, 61);
		frmEditAppication.getContentPane().add(city);
		
		puc = new JTextField();
		puc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		puc.setColumns(10);
		puc.setBounds(933, 502, 255, 61);
		frmEditAppication.getContentPane().add(puc);
		
		JLabel lblSelectBranch = new JLabel("Select Branch :");
		lblSelectBranch.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblSelectBranch.setBounds(58, 600, 217, 57);
		frmEditAppication.getContentPane().add(lblSelectBranch);
		
		branch = new JComboBox();
		branch.setModel(new DefaultComboBoxModel(new String[] {"Mechanical ", "Civil", "CSE", "ISE", "TCE", "EEE", "ECE"}));
		branch.setFont(new Font("SansSerif", Font.PLAIN, 26));
		branch.setBounds(317, 591, 255, 66);
		frmEditAppication.getContentPane().add(branch);
		
		got = new JComboBox();
		got.setModel(new DefaultComboBoxModel(new String[] {"Yes", "No"}));
		got.setFont(new Font("SansSerif", Font.PLAIN, 26));
		got.setBounds(933, 591, 255, 66);
		frmEditAppication.getContentPane().add(got);
		
		JLabel lblGotAdmission = new JLabel("Got Admission :");
		lblGotAdmission.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblGotAdmission.setBounds(649, 600, 242, 61);
		frmEditAppication.getContentPane().add(lblGotAdmission);
		
		puc_fetch = new JTextField();
		puc_fetch.setFont(new Font("SansSerif", Font.PLAIN, 30));
		puc_fetch.setColumns(10);
		puc_fetch.setBounds(579, 64, 255, 61);
		frmEditAppication.getContentPane().add(puc_fetch);
		
		JLabel lblPucRegno_1 = new JLabel("PUC Reg.no :");
		lblPucRegno_1.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblPucRegno_1.setBounds(306, 66, 227, 57);
		frmEditAppication.getContentPane().add(lblPucRegno_1);
		
		JButton fetch = new JButton("Fetch");
		fetch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Fetch(e);
			}
		});
		fetch.setForeground(Color.BLUE);
		fetch.setFont(new Font("SansSerif", Font.BOLD, 37));
		fetch.setBackground(new Color(72, 209, 204));
		fetch.setBounds(869, 64, 232, 61);
		frmEditAppication.getContentPane().add(fetch);
	}
	public void Fetch(ActionEvent evt)
	{	
		String PUC_REG=puc_fetch.getText();
		String PUC=puc.getText();
		try
		{			
			con=Student.Connect();
			p=con.prepareStatement("select * from `register` where PUC=?");
			p.setString(1, PUC_REG);
			r=p.executeQuery();
			if(r.next())
			{
				String name=r.getString("NAME");
				sName.setText(name);
				String F_name=r.getString("FNAME");
				fname.setText(F_name);
				String M_name=r.getString("MNAME");
				mname.setText(M_name);
				String Ph_no=r.getString("MOBILE");
				m_no.setText(Ph_no);
				String Addr=r.getString("ADDR");
				addr.setText(Addr);
				String Vill=r.getString("VILLAGE");
				village.setText(Vill);
				String City=r.getString("CITY");
				city.setText(City);
				String Puc=r.getString("PUC");
				puc.setText(Puc);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Enter valid Register number");
		}
	}
	
	public void update(ActionEvent evt)
	{
		String str=puc.getText();
		String PUC_REG=puc_fetch.getText();
		PUC_update obj=new PUC_update();
		obj.my_update(str);
		obj.puReg(PUC_REG);
		obj.frmPUCupdate.setVisible(true);
		frmEditAppication.dispose();
		
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
	//	String PUC_REG=puc_fetch.getText();
		
		java.util.Date date=new java.util.Date();
		
		java.sql.Date sqldate=new java.sql.Date(date.getTime());
		
		SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
		String s=sdf.format(date);
		
		try
		{			
			con=Student.Connect();
			
			String update="update `register` set NAME=?,FNAME=?,MNAME=?,MOBILE=?,ADDR=?,VILLAGE=?,CITY=?,TALUK=?,DIST=?,PUC=?,BRANCH=?,GOT_ADMISSION=?,DATE=?,TIME=? where PUC=?";
			p=con.prepareStatement(update);
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
			p.setString(15, PUC_REG);
			
			p.executeUpdate();
			JOptionPane.showMessageDialog(null, "Updated Succesfully......\nEnter your PUC marks");
			
			frmEditAppication.dispose();
    		frontpage window = new frontpage();
    		window.frmWelcome.setVisible(true);
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
