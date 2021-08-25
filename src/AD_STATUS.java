import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AD_STATUS {
	
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	Connection con;
	PreparedStatement p;
	ResultSet r;

	public JFrame frmAdmissionStatus;
	private JTextField puc;
	private JLabel lblGotAdmission;
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
					AD_STATUS window = new AD_STATUS();
					window.frmAdmissionStatus.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AD_STATUS() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmissionStatus = new JFrame();
		frmAdmissionStatus.setTitle("Admission Status |4JN18IS065-PUNEETH K S");
		frmAdmissionStatus.setBounds(100, 100, 892, 497);
		frmAdmissionStatus.setLocationRelativeTo(null);
		frmAdmissionStatus.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmissionStatus.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admission Status Update");
		lblNewLabel.setBounds(180, 6, 577, 52);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 40));
		frmAdmissionStatus.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPucRegno = new JLabel("Enter PUC Reg.no :");
		lblEnterPucRegno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblEnterPucRegno.setBounds(85, 139, 349, 61);
		frmAdmissionStatus.getContentPane().add(lblEnterPucRegno);
		
		puc = new JTextField();
		puc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		puc.setColumns(10);
		puc.setBounds(446, 139, 255, 61);
		frmAdmissionStatus.getContentPane().add(puc);
		
		lblGotAdmission = new JLabel("Got Admission :");
		lblGotAdmission.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblGotAdmission.setBounds(85, 258, 242, 61);
		frmAdmissionStatus.getContentPane().add(lblGotAdmission);
		
		got = new JComboBox();
		got.setModel(new DefaultComboBoxModel(new String[] {"YES", "NO"}));
		got.setFont(new Font("SansSerif", Font.PLAIN, 26));
		got.setBounds(446, 258, 255, 66);
		frmAdmissionStatus.getContentPane().add(got);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update(e);
			}
		});
		btnUpdate.setForeground(Color.BLUE);
		btnUpdate.setFont(new Font("SansSerif", Font.BOLD, 37));
		btnUpdate.setBackground(new Color(0, 204, 51));
		btnUpdate.setBounds(326, 378, 232, 61);
		frmAdmissionStatus.getContentPane().add(btnUpdate);
	}
	public void update(ActionEvent e)
	{
		String reg=puc.getText();
		String GOT=(String)got.getSelectedItem().toString();
		
		try
		{			
			con=Student.Connect();
			
			String update="update `register` set GOT_ADMISSION=? where PUC=?";
			p=con.prepareStatement(update);
			p.setString(1,GOT);
			p.setString(2,reg);
			
			p.executeUpdate();
			JOptionPane.showMessageDialog(null, "Updated Succesfully\n");
			
			frmAdmissionStatus.dispose();
    		frontpage window = new frontpage();
    		window.frmWelcome.setVisible(true);
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
}
