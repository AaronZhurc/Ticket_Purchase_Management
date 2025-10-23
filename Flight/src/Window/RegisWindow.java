package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import dao.DAOFactory;
import dao.IPassDAO;
import dao.PassDAOProxy;
import controller.User;
import vo.Passenger;

public class RegisWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAcc;
	private JTextField textFieldPass;
	private JTextField textFieldId;
	private JTextField textFieldIdtype;
	private JTextField textFieldName;
	private JTextField textFieldCon;
	private JTextField textFieldSex;
	IPassDAO dao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisWindow frame = new RegisWindow();
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
	public RegisWindow() throws Exception {
		setTitle("×¢²á");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(15, 26, 61, 21);
		contentPane.add(lblNewLabel);
		
		textFieldAcc = new JTextField();
		textFieldAcc.setBounds(73, 23, 96, 27);
		contentPane.add(textFieldAcc);
		textFieldAcc.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(15, 69, 43, 21);
		contentPane.add(lblNewLabel_1);
		
		textFieldPass = new JTextField();
		textFieldPass.setText("");
		textFieldPass.setBounds(73, 66, 96, 27);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BC1\u4EF6\u53F7");
		lblNewLabel_2.setBounds(213, 26, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BC1\u4EF6\u7C7B\u578B");
		lblNewLabel_3.setBounds(213, 69, 81, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D");
		lblNewLabel_4.setBounds(213, 115, 81, 21);
		contentPane.add(lblNewLabel_4);
		
		textFieldId = new JTextField();
		textFieldId.setBounds(290, 23, 96, 27);
		contentPane.add(textFieldId);
		textFieldId.setColumns(10);
		
		textFieldIdtype = new JTextField();
		textFieldIdtype.setBounds(290, 66, 96, 27);
		contentPane.add(textFieldIdtype);
		textFieldIdtype.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(290, 112, 96, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B");
		lblNewLabel_5.setBounds(435, 26, 81, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_6.setBounds(435, 69, 81, 21);
		contentPane.add(lblNewLabel_6);
		
		textFieldCon = new JTextField();
		textFieldCon.setBounds(525, 66, 96, 27);
		contentPane.add(textFieldCon);
		textFieldCon.setColumns(10);
		
		textFieldSex = new JTextField();
		textFieldSex.setBounds(525, 23, 96, 27);
		contentPane.add(textFieldSex);
		textFieldSex.setColumns(10);
		
		JButton btnRegist = new JButton("\u6CE8\u518C");
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Passenger pass=new Passenger();
				pass.setUserAccount(textFieldAcc.getText());
				pass.setUserPassword(textFieldPass.getText());
				pass.setIDnum(textFieldId.getText());
				pass.setIDtype(textFieldIdtype.getText());
				pass.setUserName(textFieldName.getText());
				pass.setContact(textFieldCon.getText());
				pass.setSex(textFieldSex.getText());
				try {
					dao=DAOFactory.getIPassDAOInstance();
					if(dao.findUser(pass)==true) {
						dao=DAOFactory.getIPassDAOInstance();
						if(dao.doRegis(pass)==true) {
							JOptionPane.showMessageDialog(null, "×¢²á³É¹¦", "×¢²á",JOptionPane.INFORMATION_MESSAGE);
							User.setUser(pass.getUserAccount());
							CtrlWindow cw=new CtrlWindow();
							cw.setVisible(true);
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü", "×¢²á",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "¸ÃÓÃ»§ÒÑ±»×¢²á¹ý", "×¢²á",JOptionPane.ERROR_MESSAGE);
					}
				} catch (HeadlessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "×¢²áÊ§°Ü", "×¢²á",JOptionPane.ERROR_MESSAGE);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnRegist.setBounds(182, 174, 123, 29);
		contentPane.add(btnRegist);
		
		JButton btnCancel = new JButton("\u53D6\u6D88");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginWindow lw;
				try {
					lw = new LoginWindow();
					lw.setVisible(true);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
				dispose();
			}
		});
		btnCancel.setBounds(351, 174, 123, 29);
		contentPane.add(btnCancel);
	}
}
