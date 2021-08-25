import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;

public class PUC_update {
	/**
	 * @author 4JN18IS065-PUNEETH KS 
	 * 
	 */
	
	Connection con;
	PreparedStatement p;

	public JFrame frmPUCupdate;
	private JTextField t1;
	private JTextField tPhy;
	private JTextField tChem;
	private JTextField tmath;
	private JTextField tBio;
	private JTextField tCs;
	private JTextField tk;
	private JTextField te;
	private JTextField th;
	private JTextField ts;
	private JTextField total;
	private JTextField t2;

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
					PUC window = new PUC();
					window.frmPucMarks.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public PUC_update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPUCupdate = new JFrame();
		frmPUCupdate.setTitle("Update PUC marks  | 4JN18IS065-PUNEETH K S");
		frmPUCupdate.setBounds(100, 100, 1201, 766);
		frmPUCupdate.setLocationRelativeTo(null);
		frmPUCupdate.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPUCupdate.getContentPane().setLayout(null);
		
		JLabel lblEnterPucDetails = new JLabel("Enter PUC details");
		lblEnterPucDetails.setFont(new Font("SansSerif", Font.BOLD, 45));
		lblEnterPucDetails.setBounds(414, 6, 458, 58);
		frmPUCupdate.getContentPane().add(lblEnterPucDetails);
		
		JLabel lblRegisterNo = new JLabel("New Register No. :");
		lblRegisterNo.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblRegisterNo.setBounds(23, 130, 276, 44);
		frmPUCupdate.getContentPane().add(lblRegisterNo);
		
		t1 = new JTextField();
		t1.setForeground(Color.BLUE);
		t1.setFont(new Font("SansSerif", Font.PLAIN, 35));
		t1.setEditable(false);
		t1.setBounds(296, 122, 220, 58);
		frmPUCupdate.getContentPane().add(t1);
		t1.setColumns(10);
		
		JLabel lblEnterNaFor = new JLabel("Enter  0  for  the subjects that you don't have");
		lblEnterNaFor.setForeground(Color.RED);
		lblEnterNaFor.setFont(new Font("SansSerif", Font.BOLD, 19));
		lblEnterNaFor.setBounds(23, 210, 509, 31);
		frmPUCupdate.getContentPane().add(lblEnterNaFor);
		
		JLabel lblPhysics = new JLabel("Physics :");
		lblPhysics.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblPhysics.setBounds(34, 287, 202, 51);
		frmPUCupdate.getContentPane().add(lblPhysics);
		
		JLabel lblChemistry = new JLabel("Chemistry :");
		lblChemistry.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblChemistry.setBounds(34, 357, 202, 51);
		frmPUCupdate.getContentPane().add(lblChemistry);
		
		JLabel lblMathematics = new JLabel("Mathematics :");
		lblMathematics.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblMathematics.setBounds(34, 432, 243, 58);
		frmPUCupdate.getContentPane().add(lblMathematics);
		
		JLabel lblBiology = new JLabel("Biology :");
		lblBiology.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblBiology.setBounds(34, 508, 202, 51);
		frmPUCupdate.getContentPane().add(lblBiology);
		
		JLabel lblComputerScience = new JLabel("Computer Science :");
		lblComputerScience.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblComputerScience.setBounds(34, 571, 294, 58);
		frmPUCupdate.getContentPane().add(lblComputerScience);
		
		tPhy = new JTextField();
		tPhy.setForeground(Color.BLUE);
		tPhy.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tPhy.setColumns(10);
		tPhy.setBounds(332, 287, 176, 58);
		frmPUCupdate.getContentPane().add(tPhy);
		
		tChem = new JTextField();
		tChem.setForeground(Color.BLUE);
		tChem.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tChem.setColumns(10);
		tChem.setBounds(332, 357, 176, 58);
		frmPUCupdate.getContentPane().add(tChem);
		
		tmath = new JTextField();
		tmath.setForeground(Color.BLUE);
		tmath.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tmath.setColumns(10);
		tmath.setBounds(332, 432, 176, 58);
		frmPUCupdate.getContentPane().add(tmath);
		
		tBio = new JTextField();
		tBio.setForeground(Color.BLUE);
		tBio.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tBio.setColumns(10);
		tBio.setBounds(332, 501, 176, 58);
		frmPUCupdate.getContentPane().add(tBio);
		
		tCs = new JTextField();
		tCs.setForeground(Color.BLUE);
		tCs.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tCs.setColumns(10);
		tCs.setBounds(332, 571, 176, 58);
		frmPUCupdate.getContentPane().add(tCs);
		
		tk = new JTextField();
		tk.setForeground(Color.BLUE);
		tk.setFont(new Font("SansSerif", Font.PLAIN, 35));
		tk.setColumns(10);
		tk.setBounds(893, 280, 176, 58);
		frmPUCupdate.getContentPane().add(tk);
		
		te = new JTextField();
		te.setForeground(Color.BLUE);
		te.setFont(new Font("SansSerif", Font.PLAIN, 35));
		te.setColumns(10);
		te.setBounds(893, 357, 176, 58);
		frmPUCupdate.getContentPane().add(te);
		
		th = new JTextField();
		th.setForeground(Color.BLUE);
		th.setFont(new Font("SansSerif", Font.PLAIN, 35));
		th.setColumns(10);
		th.setBounds(893, 432, 176, 58);
		frmPUCupdate.getContentPane().add(th);
		
		ts = new JTextField();
		ts.setForeground(Color.BLUE);
		ts.setFont(new Font("SansSerif", Font.PLAIN, 35));
		ts.setColumns(10);
		ts.setBounds(893, 501, 176, 58);
		frmPUCupdate.getContentPane().add(ts);
		
		JLabel lblKannada = new JLabel("Kannada :");
		lblKannada.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblKannada.setBounds(608, 280, 202, 51);
		frmPUCupdate.getContentPane().add(lblKannada);
		
		JLabel lblEnglish = new JLabel("English :");
		lblEnglish.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblEnglish.setBounds(608, 357, 202, 51);
		frmPUCupdate.getContentPane().add(lblEnglish);
		
		JLabel lblHindi = new JLabel("Hindi :");
		lblHindi.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblHindi.setBounds(608, 432, 202, 51);
		frmPUCupdate.getContentPane().add(lblHindi);
		
		JLabel lblSanskrit = new JLabel("Sanskrit :");
		lblSanskrit.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblSanskrit.setBounds(608, 497, 202, 51);
		frmPUCupdate.getContentPane().add(lblSanskrit);
		
		JButton btnRegister = new JButton("Update");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register(e);
			}
		});
		btnRegister.setBackground(new Color(255, 51, 0));
		btnRegister.setFont(new Font("SansSerif", Font.BOLD, 40));
		btnRegister.setBounds(496, 664, 265, 59);
		frmPUCupdate.getContentPane().add(btnRegister);
		
		JLabel lblTotal = new JLabel("TOTAL");
		lblTotal.setForeground(new Color(204, 51, 102));
		lblTotal.setFont(new Font("SansSerif", Font.BOLD, 40));
		lblTotal.setBounds(608, 578, 202, 51);
		frmPUCupdate.getContentPane().add(lblTotal);
		
		total = new JTextField();
		total.setForeground(Color.BLUE);
		total.setFont(new Font("SansSerif", Font.PLAIN, 35));
		total.setColumns(10);
		total.setBounds(893, 571, 176, 58);
		frmPUCupdate.getContentPane().add(total);
		
		JLabel lblOldRegisterNo = new JLabel("Old Register No. :");
		lblOldRegisterNo.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblOldRegisterNo.setBounds(596, 130, 276, 44);
		frmPUCupdate.getContentPane().add(lblOldRegisterNo);
		
		t2 = new JTextField();
		t2.setForeground(Color.BLUE);
		t2.setFont(new Font("SansSerif", Font.PLAIN, 35));
		t2.setEditable(false);
		t2.setColumns(10);
		t2.setBounds(867, 122, 220, 58);
		frmPUCupdate.getContentPane().add(t2);
	}
	public void my_update(String str)
	{
		t1.setText(str);
		
	}
	public void puReg(String PUC)
	{
		t2.setText(PUC);
	}
	public void Register(ActionEvent evt)
	{
		
		String phy=tPhy.getText();
		String chem=tChem.getText();
		String math=tmath.getText();
		String bio=tBio.getText();
		String cs=tCs.getText();
		String kan=tk.getText();
		String eng=te.getText();
		String hin=th.getText();
		String san=ts.getText();
		String Reg=t1.getText();
		String T=total.getText();
		String puc_old=t2.getText();
		
		try
		{			
			con=Student.Connect();
			
			String insert="update `marks` set REG_NO=?,PHY=?, CHEM=?, MATH=?,BIO=?,CSE=?,KANNADA=?,ENGLISH=?,HINDI=?,SANSKRIT=?,TOTAL=? where REG_NO=?";
			p=con.prepareStatement(insert);
			p.setString(1, Reg);
			p.setString(2, phy);
			p.setString(3, chem);
			p.setString(4, math);
			p.setString(5, bio);
			p.setString(6, cs);
			p.setString(7, kan);
			p.setString(8, eng);
			p.setString(9, hin);
			p.setString(10, san);
			p.setString(11, T);
			p.setString(12, puc_old);
			
			p.execute();
			JOptionPane.showMessageDialog(null, "Updated Successfully :)");
			
			frmPUCupdate.dispose();
    		frontpage window = new frontpage();
    		window.frmWelcome.setVisible(true);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,e);
		}
	}
}
