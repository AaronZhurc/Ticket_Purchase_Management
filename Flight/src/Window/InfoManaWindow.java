package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.User;
import dao.DAOFactory;
import dao.IPassDAO;
import dao.PassDAOProxy;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InfoManaWindow extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPass;
	private JTextField textFieldName;
	private JTextField textFieldSex;
	private JTextField textFieldContact;
	IPassDAO dao;
	private JFrame jf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfoManaWindow frame = new InfoManaWindow();
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
	public InfoManaWindow() throws Exception {
		dao=DAOFactory.getIPassDAOInstance();
		setTitle("账户管理");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7");
		lblNewLabel.setBounds(15, 15, 61, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(15, 59, 43, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8BC1\u4EF6\u53F7");
		lblNewLabel_2.setBounds(15, 106, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BC1\u4EF6\u7C7B\u578B");
		lblNewLabel_3.setBounds(15, 152, 81, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u59D3\u540D");
		lblNewLabel_4.setBounds(216, 15, 81, 21);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6027\u522B");
		lblNewLabel_5.setBounds(216, 59, 81, 21);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("\u8054\u7CFB\u65B9\u5F0F");
		lblNewLabel_6.setBounds(216, 106, 81, 21);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("\u6301\u6709\u673A\u7968\u6570");
		lblNewLabel_7.setBounds(216, 152, 103, 21);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblAcc = new JLabel(User.getUser().getUserAccount());
		lblAcc.setBounds(98, 15, 81, 21);
		contentPane.add(lblAcc);
		
		JLabel lblIdNum = new JLabel(User.getUser().getIDnum());
		lblIdNum.setBounds(98, 106, 81, 21);
		contentPane.add(lblIdNum);
		
		JLabel lblIdType = new JLabel(User.getUser().getIDtype());
		lblIdType.setBounds(98, 152, 81, 21);
		contentPane.add(lblIdType);
		
		textFieldPass = new JTextField();
		textFieldPass.setText(User.getUser().getUserPassword());
		textFieldPass.setBounds(98, 56, 96, 27);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldName = new JTextField();
		textFieldName.setText(User.getUser().getUserName());
		textFieldName.setBounds(317, 12, 96, 27);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldSex = new JTextField();
		textFieldSex.setText(User.getUser().getSex());
		textFieldSex.setBounds(317, 56, 96, 27);
		contentPane.add(textFieldSex);
		textFieldSex.setColumns(10);
		
		textFieldContact = new JTextField();
		textFieldContact.setText(User.getUser().getContact());
		textFieldContact.setBounds(317, 103, 96, 27);
		contentPane.add(textFieldContact);
		textFieldContact.setColumns(10);
		
		JLabel lblTicket = new JLabel(String.valueOf(User.getUser().getTicketHold()));
		lblTicket.setBounds(317, 152, 81, 21);
		contentPane.add(lblTicket);
		
		JButton btnConfirm = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User.getUser().setUserName(textFieldName.getText());
				User.getUser().setContact(textFieldContact.getText());
				User.getUser().setUserPassword(textFieldPass.getText());
				User.getUser().setSex(textFieldSex.getText());
				try {
					if(dao.doMod(User.getUser())==true) {
						JOptionPane.showMessageDialog(null, "修改成功", "修改",JOptionPane.INFORMATION_MESSAGE);
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "修改失败", "修改",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "修改失败", "修改",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirm.setBounds(58, 200, 123, 29);
		contentPane.add(btnConfirm);
		
		JButton btnCancel = new JButton("\u6CE8\u9500\u8D26\u53F7");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(User.getUser().getTicketHold()==0) {
						if(dao.doDel(User.getUser())==true) {
							JOptionPane.showMessageDialog(null, "注销成功", "注销",JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);
						} else {
							JOptionPane.showMessageDialog(null, "注销失败", "注销",JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "无法在还持有机票的情况下注销", "注销",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "注销失败", "注销",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCancel.setBounds(230, 200, 123, 29);
		contentPane.add(btnCancel);
	}
	public void getCtrlWindow(JFrame jf) {
		this.jf=jf;
	}
}
