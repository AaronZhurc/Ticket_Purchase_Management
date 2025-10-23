package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.DAOFactory;
import dao.IPassDAO;
import dao.PassDAOProxy;
import controller.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class LoginWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	IPassDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public LoginWindow() throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("µÇÂ¼");
		setBounds(100, 100, 424, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(38, 51, 41, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(38, 118, 41, 21);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(94, 48, 96, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(94, 115, 96, 27);
		contentPane.add(passwordField);
		
		JButton btnLogin = new JButton("\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					dao=DAOFactory.getIPassDAOInstance();
					if(dao.findLogin(textField.getText(), passwordField.getText())==true) {
						JOptionPane.showMessageDialog(null, "ÒÑµÇÂ¼ÉÏ", "µÇÂ¼",JOptionPane.INFORMATION_MESSAGE);
						User.setUser(textField.getText());
						CtrlWindow cw=new CtrlWindow();
						cw.setVisible(true);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü", "µÇÂ¼",JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "µÇÂ¼Ê§°Ü", "µÇÂ¼",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnLogin.setBounds(242, 47, 123, 29);
		contentPane.add(btnLogin);
		
		JButton btnRegis = new JButton("\u6CE8\u518C");
		btnRegis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				RegisWindow rw;
				try {
					rw = new RegisWindow();
					rw.setVisible(true);
					dispose();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				dispose();
			}
		});
		btnRegis.setBounds(242, 114, 123, 29);
		contentPane.add(btnRegis);
		
	}
}
