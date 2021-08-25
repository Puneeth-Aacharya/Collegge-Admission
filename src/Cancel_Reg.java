import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import javax.swing.JButton;
import java.awt.Color;
import java.sql.*;
import java.awt.event.ActionListener;
public class Cancel_Reg {
	
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	Connection con;
	PreparedStatement p;

	public JFrame cancelfrmjnispuneethKS;
	private JTextField puc;

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
					Cancel_Reg window = new Cancel_Reg();
					window.cancelfrmjnispuneethKS.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cancel_Reg() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		cancelfrmjnispuneethKS = new JFrame();
		cancelfrmjnispuneethKS.setTitle("cancel | 4JN18IS065-PUNEETH K S");
		cancelfrmjnispuneethKS.setBounds(100, 100, 929, 475);
		cancelfrmjnispuneethKS.setLocationRelativeTo(null);
		cancelfrmjnispuneethKS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cancelfrmjnispuneethKS.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CANCEL RAGISTRATION");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 45));
		lblNewLabel.setBounds(205, 10, 615, 66);
		cancelfrmjnispuneethKS.getContentPane().add(lblNewLabel);
		
		JLabel lblEnterPucRegno = new JLabel("Enter PUC Reg.no :");
		lblEnterPucRegno.setFont(new Font("SansSerif", Font.PLAIN, 30));
		lblEnterPucRegno.setBounds(162, 171, 349, 61);
		cancelfrmjnispuneethKS.getContentPane().add(lblEnterPucRegno);
		
		puc = new JTextField();
		puc.setFont(new Font("SansSerif", Font.PLAIN, 30));
		puc.setColumns(10);
		puc.setBounds(521, 171, 255, 61);
		cancelfrmjnispuneethKS.getContentPane().add(puc);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Delete(e);
			}
		});
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 40));
		btnDelete.setBackground(new Color(255, 0, 51));
		btnDelete.setBounds(343, 321, 239, 61);
		cancelfrmjnispuneethKS.getContentPane().add(btnDelete);
	}
	public void Delete(ActionEvent e)
	{
		String reg=puc.getText();		
		try
		{			
			con=Student.Connect();
			
			String delete="DELETE FROM `register` WHERE PUC=?";
			p=con.prepareStatement(delete);
			p.setString(1,reg);
			
			p.execute();
			JOptionPane.showConfirmDialog(null, "Do you really want to Delete\n");
			JOptionPane.showMessageDialog(null, "Deleted Succesfully\n");
			
			cancelfrmjnispuneethKS.dispose();
    		frontpage window = new frontpage();
    		window.frmWelcome.setVisible(true);
			
		}
		catch(Exception c)
		{
			JOptionPane.showMessageDialog(null, c);
		}
	}
}
