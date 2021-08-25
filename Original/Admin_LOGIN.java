import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin_LOGIN {
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */

	public JFrame frmjnispuneethKS;
	private JTextField usr;
	private JPasswordField passfield;

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
					Admin_LOGIN window = new Admin_LOGIN();
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
	public Admin_LOGIN() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmjnispuneethKS = new JFrame();
		frmjnispuneethKS.setTitle("4JN18IS065-PUNEETH K S");
		frmjnispuneethKS.setBounds(100, 100, 826, 428);
		frmjnispuneethKS.setLocationRelativeTo(null);
		frmjnispuneethKS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmjnispuneethKS.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(338, 10, 285, 49);
		frmjnispuneethKS.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("UserName :");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblUsername.setBounds(154, 124, 258, 49);
		frmjnispuneethKS.getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblPassword.setBounds(154, 213, 231, 49);
		frmjnispuneethKS.getContentPane().add(lblPassword);
		
		usr = new JTextField();
		usr.setFont(new Font("Tahoma", Font.PLAIN, 30));
		usr.setBounds(390, 124, 258, 49);
		frmjnispuneethKS.getContentPane().add(usr);
		usr.setColumns(10);
		
		passfield = new JPasswordField();
		passfield.setBounds(390, 218, 263, 49);
		frmjnispuneethKS.getContentPane().add(passfield);
		
		JButton btnNewButton = new JButton("SignIn");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signin(e);
				
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(338, 311, 173, 49);
		frmjnispuneethKS.getContentPane().add(btnNewButton);
	}
	public void signin(ActionEvent e)
	{
		String user=usr.getText();
		String pass=new String(passfield.getPassword());				
		String USER="root";
		String PASS="jnnce";
		
		if(user.equals(USER) && pass.equals(PASS)) {
			JOptionPane.showMessageDialog(null, "Logged In Succesfully\n");
			
			frmjnispuneethKS.dispose();
			Report window = new Report();
			window.frmjnispuneethKS.setVisible(true);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Credentials !!!!",null, JOptionPane.ERROR_MESSAGE);
		}
	}
}
