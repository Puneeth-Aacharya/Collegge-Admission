import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class frontpage {

	public JFrame frmWelcome;
	
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */

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
					frontpage window = new frontpage();
					window.frmWelcome.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frontpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWelcome = new JFrame();
		frmWelcome.setTitle("4JN18IS065-PUNEETH K S");
		frmWelcome.getContentPane().setBackground(SystemColor.activeCaption);
		frmWelcome.setBounds(100, 100, 1189, 691);
		frmWelcome.setLocationRelativeTo(null);
		frmWelcome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcome.getContentPane().setLayout(null);
		
		JLabel lblhead = new JLabel("COLLEGE ADMISSION");
		lblhead.setForeground(SystemColor.textHighlightText);
		lblhead.setFont(new Font("SansSerif", Font.BOLD, 50));
		lblhead.setBounds(328, 29, 545, 44);
		frmWelcome.getContentPane().add(lblhead);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(102, 204, 255), new Color(255, 255, 0), new Color(153, 204, 204)));
		panel.setBounds(74, 189, 451, 418);
		frmWelcome.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBackground(new Color(175, 238, 238));
		btnRegister.setBounds(117, 108, 212, 53);
		panel.add(btnRegister);
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Register window = new Register();
				window.frmApplicationForm.setVisible(true);
			}
		});
		btnRegister.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 26));
		
		JButton btnCancelRegister = new JButton("Cancel Registration");
		btnCancelRegister.setBackground(new Color(255, 99, 71));
		btnCancelRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Cancel_Reg window = new Cancel_Reg();
				window.cancelfrmjnispuneethKS.setVisible(true);
			}
		});
		btnCancelRegister.setBounds(59, 336, 335, 61);
		panel.add(btnCancelRegister);
		btnCancelRegister.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 26));
		
		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblStudent.setBounds(133, 6, 184, 61);
		panel.add(lblStudent);
		
		JButton btnAdmitssion = new JButton("Admission");
		btnAdmitssion.setBackground(new Color(173, 255, 47));
		btnAdmitssion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				AD_STATUS window = new AD_STATUS();
				window.frmAdmissionStatus.setVisible(true);
			}
		});
		btnAdmitssion.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 26));
		btnAdmitssion.setBounds(117, 191, 212, 53);
		panel.add(btnAdmitssion);
		
		JButton btnEditApplication = new JButton("Edit Application");
		btnEditApplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Edit window = new Edit();
				window.frmEditAppication.setVisible(true);
			}
		});
		btnEditApplication.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 26));
		btnEditApplication.setBackground(new Color(255, 215, 0));
		btnEditApplication.setBounds(59, 271, 335, 53);
		panel.add(btnEditApplication);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 255, 0), new Color(102, 204, 255), new Color(255, 255, 0), new Color(153, 204, 204)));
		panel_1.setBounds(682, 189, 398, 364);
		frmWelcome.getContentPane().add(panel_1);
		
		JButton btnAdminLogin = new JButton("Admin Login");
		btnAdminLogin.setBackground(new Color(100, 149, 237));
		btnAdminLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmWelcome.dispose();
				Admin_LOGIN window = new Admin_LOGIN();
				window.frmjnispuneethKS.setVisible(true);
				
			}
		});
		btnAdminLogin.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 35));
		btnAdminLogin.setBounds(58, 170, 297, 60);
		panel_1.add(btnAdminLogin);
		
		JLabel lblCollege = new JLabel("COLLEGE");
		lblCollege.setFont(new Font("SansSerif", Font.BOLD, 35));
		lblCollege.setBounds(115, 23, 184, 61);
		panel_1.add(lblCollege);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\Bluetooth\\1602676505898.png"));
		lblNewLabel.setBounds(0, 0, 1175, 654);
		frmWelcome.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(383, 123, 4, -6);
		frmWelcome.getContentPane().add(lblNewLabel_1);
	}
}
