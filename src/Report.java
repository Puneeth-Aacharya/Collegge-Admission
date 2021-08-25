import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Report {
	
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	Connection con;
	PreparedStatement p;
	ResultSet r;

	public JFrame frmjnispuneethKS;
	private JComboBox branch;
	private JComboBox place;
	private JTable table;

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
					Report window = new Report();
					window.frmjnispuneethKS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Report() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmjnispuneethKS = new JFrame();
		frmjnispuneethKS.setTitle("4JN18IS065-PUNEETH K S");
		frmjnispuneethKS.setBounds(100, 100, 1344, 747);
		frmjnispuneethKS.setLocationRelativeTo(null);
		frmjnispuneethKS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmjnispuneethKS.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION DETAILS");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 45));
		lblNewLabel.setBounds(316, 10, 895, 58);
		frmjnispuneethKS.getContentPane().add(lblNewLabel);
		
		JLabel lblSelectBranch = new JLabel("Select Branch :");
		lblSelectBranch.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblSelectBranch.setBounds(107, 134, 217, 57);
		frmjnispuneethKS.getContentPane().add(lblSelectBranch);
		
		JLabel lblSelectPlace = new JLabel("Select Place :");
		lblSelectPlace.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblSelectPlace.setBounds(696, 134, 217, 57);
		frmjnispuneethKS.getContentPane().add(lblSelectPlace);
		
		branch = new JComboBox();
		branch.setModel(new DefaultComboBoxModel(new String[] {"Mechanical ", "Civil", "CSE", "ISE", "TCE", "EEE", "ECE"}));
		branch.setFont(new Font("SansSerif", Font.PLAIN, 26));
		branch.setBounds(370, 134, 255, 50);
		frmjnispuneethKS.getContentPane().add(branch);
		
		place = new JComboBox();
		place.setModel(new DefaultComboBoxModel(new String[] {"Shivamogga", "Thirthahalli", "Sagara", "Soraba", "Shikaripura", "Hosanagra", "Bhadravathi"}));
		place.setFont(new Font("SansSerif", Font.PLAIN, 26));
		place.setBounds(941, 134, 255, 50);
		frmjnispuneethKS.getContentPane().add(place);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 323, 1310, 377);
		frmjnispuneethKS.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnBranchWiseList = new JButton("Branch wise Registered list ");
		btnBranchWiseList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchwiseRlist(e);
			}
		});
		btnBranchWiseList.setForeground(Color.BLACK);
		btnBranchWiseList.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnBranchWiseList.setBackground(new Color(0, 153, 0));
		btnBranchWiseList.setBounds(10, 228, 314, 50);
		frmjnispuneethKS.getContentPane().add(btnBranchWiseList);
		
		JButton btnPalceAndBranch = new JButton("Palce and Branch wise Registered list ");
		btnPalceAndBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeandbranchwiseRlist(e);
			}
		});
		btnPalceAndBranch.setForeground(Color.BLACK);
		btnPalceAndBranch.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPalceAndBranch.setBackground(new Color(0, 153, 0));
		btnPalceAndBranch.setBounds(338, 228, 398, 50);
		frmjnispuneethKS.getContentPane().add(btnPalceAndBranch);
		
		JButton btnBranchWiseAdmitted = new JButton("Branch wise Admitted list");
		btnBranchWiseAdmitted.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				branchwiseAlist(e);
			}
		});
		btnBranchWiseAdmitted.setForeground(Color.BLACK);
		btnBranchWiseAdmitted.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnBranchWiseAdmitted.setBackground(new Color(0, 153, 0));
		btnBranchWiseAdmitted.setBounds(746, 228, 275, 50);
		frmjnispuneethKS.getContentPane().add(btnBranchWiseAdmitted);
		
		JButton btnPlaceAndBranch = new JButton("Place and Branch wise list ");
		btnPlaceAndBranch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				placeandbranchlist(e);
			}
		});
		btnPlaceAndBranch.setForeground(Color.BLACK);
		btnPlaceAndBranch.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnPlaceAndBranch.setBackground(new Color(0, 153, 0));
		btnPlaceAndBranch.setBounds(1031, 228, 289, 50);
		frmjnispuneethKS.getContentPane().add(btnPlaceAndBranch);
	}
	public void branchwiseRlist(ActionEvent evt)
	{
		String Branch=(String)branch.getSelectedItem().toString();
		
		try
		{			
			con=Student.Connect();
			
			String get="SELECT * FROM `register` WHERE `BRANCH`=? AND `GOT_ADMISSION`='No'";
			p=con.prepareStatement(get);
			p.setString(1,Branch);
			
			r=p.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
	public void placeandbranchwiseRlist(ActionEvent evt2)
	{
		String Branch=(String)branch.getSelectedItem().toString();
		String Place=(String)place.getSelectedItem().toString();
		
		try
		{			
			con=Student.Connect();
			
			String get="SELECT * FROM `register` WHERE `BRANCH`=? AND `DIST`=?";
			p=con.prepareStatement(get);
			p.setString(1,Branch);
			p.setString(2,Place);
			
			r=p.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
	public void branchwiseAlist(ActionEvent evt2)
	{
		String Branch=(String)branch.getSelectedItem().toString();
		String Place=(String)place.getSelectedItem().toString();
		
		try
		{			
			con=Student.Connect();
			
			String get="SELECT * FROM `register` WHERE `BRANCH`=? AND `GOT_ADMISSION`='Yes'";
			p=con.prepareStatement(get);
			p.setString(1,Branch);
			
			
			r=p.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
	
	public void placeandbranchlist(ActionEvent evt2)
	{
		String Branch=(String)branch.getSelectedItem().toString();
		String Place=(String)place.getSelectedItem().toString();
		
		try
		{			
			con=Student.Connect();
			
			String get="SELECT * FROM `register` WHERE `BRANCH`=? AND `TALUK`=?";
			p=con.prepareStatement(get);
			p.setString(1,Branch);
			p.setString(2,Place);
			
			r=p.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(r));
			
			
			
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
}
