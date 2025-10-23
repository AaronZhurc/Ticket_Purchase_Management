package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.User;
import dao.DAOFactory;
import dao.IFlightDAO;
import dao.ISeatDAO;
import dao.ITicketDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AirlineWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	IFlightDAO daoF;
	ISeatDAO daoS;
	ITicketDAO daoT;
	Vector columnNames;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AirlineWindow frame = new AirlineWindow();
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
	public AirlineWindow() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 676, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		columnNames=new Vector();
		columnNames.add("航班号");
		columnNames.add("执飞航司");
		columnNames.add("机型");
		columnNames.add("起飞机场");
		columnNames.add("降落机场");
		columnNames.add("登机口");
		columnNames.add("起飞时间");
		columnNames.add("降落时间");
		columnNames.add("座位数");
		columnNames.add("乘客数");
		
		JLabel lblNewLabel = new JLabel("\u51FA\u53D1\u5730");
		lblNewLabel.setBounds(40, 31, 59, 21);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 67, 567, 347);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("\u964D\u843D\u5730");
		lblNewLabel_1.setBounds(260, 31, 81, 21);
		contentPane.add(lblNewLabel_1);
		
		JComboBox comboBoxDepart = new JComboBox();
		comboBoxDepart.setBounds(115, 28, 107, 27);
		contentPane.add(comboBoxDepart);
		daoF=DAOFactory.getIFlightDAOInstance();
		for(Object depart:daoF.findDepart()) {
			comboBoxDepart.addItem(depart.toString());
		}
		
		JComboBox comboBoxLand = new JComboBox();
		comboBoxLand.setBounds(330, 28, 107, 27);
		contentPane.add(comboBoxLand);
		daoF=DAOFactory.getIFlightDAOInstance();
		for(Object land:daoF.findLand()) {
			comboBoxLand.addItem(land.toString());
		}
		
		JButton btnQueryF = new JButton("\u67E5\u8BE2\u822A\u73ED");
		btnQueryF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					daoF=DAOFactory.getIFlightDAOInstance();
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					Vector rowData=new Vector();
					for(Object fli:daoF.findFlight(comboBoxDepart.getSelectedItem().toString(), comboBoxLand.getSelectedItem().toString())) {
						rowData.add(fli);
					}
					DefaultTableModel modeln=new DefaultTableModel(rowData,columnNames);
					table.setModel(modeln);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnQueryF.setBounds(484, 27, 123, 29);
		contentPane.add(btnQueryF);
		
		JLabel lblNewLabel_2 = new JLabel("\u91D1\u989D");
		lblNewLabel_2.setBounds(327, 433, 131, 21);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBoxSeat = new JComboBox();
		comboBoxSeat.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				float price=0;
				String FlightNum=table.getValueAt(table.getSelectedRow(),((DefaultTableModel)table.getModel()).findColumn("航班号")).toString();
				String SeatLocat=comboBoxSeat.getSelectedItem().toString();
				String SeatNum=FlightNum+SeatLocat;
				try {
					daoS=DAOFactory.getISeatDAOInstance();
					price=daoS.findPrice(SeatNum);
					lblNewLabel_2.setText(new String().format("金额：CN￥%.2f", price));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		comboBoxSeat.setBounds(178, 430, 114, 27);
		contentPane.add(comboBoxSeat);
		
		JButton btnQueryS = new JButton("\u67E5\u8BE2\u5EA7\u4F4D");
		btnQueryS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				try {
					comboBoxSeat.removeAllItems();
					daoS=DAOFactory.getISeatDAOInstance();
					for(Object emp:daoS.findEmpty(table.getValueAt(table.getSelectedRow(),((DefaultTableModel)table.getModel()).findColumn("航班号")).toString())) {
						comboBoxSeat.addItem(emp.toString());
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "您还没有选中", "购票",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnQueryS.setBounds(40, 429, 123, 29);
		contentPane.add(btnQueryS);		
		
		JButton btnBuy = new JButton("\u8D2D\u7968");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					daoT=DAOFactory.getITicketDAOInstance();
					String FlightNum=table.getValueAt(table.getSelectedRow(),((DefaultTableModel)table.getModel()).findColumn("航班号")).toString();
					String SeatLocat=comboBoxSeat.getSelectedItem().toString();
					if(daoT.doBuy(User.getUser().getIDnum(), FlightNum, SeatLocat)==true) {
						JOptionPane.showMessageDialog(null, "购票成功", "购票",JOptionPane.INFORMATION_MESSAGE);
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
						Vector rowData=new Vector();
						daoF=DAOFactory.getIFlightDAOInstance();
						for(Object fli:daoF.findFlight(comboBoxDepart.getSelectedItem().toString(), comboBoxLand.getSelectedItem().toString())) {
							rowData.add(fli);
						}
						DefaultTableModel modeln=new DefaultTableModel(rowData,columnNames);
						table.setModel(modeln);
						User.getUser().Buy();
					} else {
						JOptionPane.showMessageDialog(null, "购票失败", "购票",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnBuy.setBounds(484, 429, 123, 29);
		contentPane.add(btnBuy);
		
	}
}
