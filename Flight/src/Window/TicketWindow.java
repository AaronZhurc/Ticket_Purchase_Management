package Window;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import vo.Flight;
import vo.Seat;
import vo.Ticket;

import controller.User;
import dao.DAOFactory;
import dao.IFlightDAO;
import dao.ISeatDAO;
import dao.ITicketDAO;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TicketWindow extends JFrame {

	private JPanel contentPane;
	private JTable table;
	ITicketDAO daoT;
	ISeatDAO daoS;
	IFlightDAO daoF;
	Vector columnNames;
	Vector Ticket;
	Vector rowData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicketWindow frame = new TicketWindow();
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
	public TicketWindow() throws Exception {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		columnNames=new Vector();
		columnNames.add("机票号");
		columnNames.add("航班号");
		columnNames.add("价格");
		columnNames.add("起飞地");
		columnNames.add("降落地");
		columnNames.add("起飞时间");
		columnNames.add("降落时间");
		columnNames.add("登机口");
		columnNames.add("座位号");
		

		rowData=new Vector();
		daoT=DAOFactory.getITicketDAOInstance();
		for(Object t:daoT.findAll(User.getUser().getIDnum())) {
			daoS=DAOFactory.getISeatDAOInstance();
			daoF=DAOFactory.getIFlightDAOInstance();
			Vector row=new Vector();
			Ticket ti=(Ticket)t;
			Flight fli=daoF.findFlight(ti.getFlightNum());
			Seat s=daoS.findSeat(ti.getSeatNum());
			row.add(ti.getTicketNum());
			row.add(ti.getFlightNum());
			row.add(s.getPrice());
			row.add(fli.getDeparture());
			row.add(fli.getLanding());
			row.add(fli.getDepartTime());
			row.add(fli.getLandTime());
			row.add(fli.getBoarding());
			row.add(s.getSeatLocat());
			rowData.add(row);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 15, 626, 384);
		contentPane.add(scrollPane);
		
		table = new JTable(rowData,columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("\u9000\u7968");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					daoT=DAOFactory.getITicketDAOInstance();
					if(daoT.doRefund(table.getValueAt(table.getSelectedRow(),((DefaultTableModel)table.getModel()).findColumn("机票号")).toString())==true){
						JOptionPane.showMessageDialog(null, "退票成功", "退票",JOptionPane.INFORMATION_MESSAGE);
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);	
						rowData.clear();
						daoT=DAOFactory.getITicketDAOInstance();
						for(Object t:daoT.findAll(User.getUser().getIDnum())) {
							daoS=DAOFactory.getISeatDAOInstance();
							daoF=DAOFactory.getIFlightDAOInstance();
							Vector row=new Vector();
							Ticket ti=(Ticket)t;
							Flight fli=daoF.findFlight(ti.getFlightNum());
							Seat s=daoS.findSeat(ti.getSeatNum());
							row.add(ti.getTicketNum());
							row.add(ti.getFlightNum());
							row.add(s.getPrice());
							row.add(fli.getDeparture());
							row.add(fli.getLanding());
							row.add(fli.getDepartTime());
							row.add(fli.getLandTime());
							row.add(fli.getBoarding());
							row.add(s.getSeatLocat());
							rowData.add(row);
						}
						DefaultTableModel modeln=new DefaultTableModel(rowData,columnNames);
						table.setModel(modeln);
						User.getUser().refund();
					} else {
						JOptionPane.showMessageDialog(null, "退票失败", "退票",JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBounds(270, 434, 123, 29);
		contentPane.add(btnNewButton);
	}

}
