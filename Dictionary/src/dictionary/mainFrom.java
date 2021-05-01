package dictionary;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.BevelBorder;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.SystemColor;
import java.awt.Cursor;

public class mainFrom extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static hashTable t = new hashTable();
	private JPanel contentPane;
	private JTextField textField;
	private TextArea textArea = new TextArea();
	private JButton bt;
	private JLabel lb_date = new JLabel("");
	private JLabel lb_hour = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainFrom frame = new mainFrom();
					frame.setVisible(true);	
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	          /**
	 * Create the frame.
	 */
	public mainFrom() {
		for(int i = 0; i< 28; i++) {
			t.list[i] = new LINKEDLIST();
		}
		clock();
		setResizable(false);
		t.docFile();
		setTitle("Dictionary - Nguy\u1EC5n Trung T\u00EDnh");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1003, 721);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setFont(new Font("Tahoma", Font.PLAIN, 15));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(39, 70, 904, 543);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lb_NhapTu_1 = new JLabel("Nhập từ: ");
		lb_NhapTu_1.setFont(lb_NhapTu_1.getFont().deriveFont(lb_NhapTu_1.getFont().getSize() + 7f));
		lb_NhapTu_1.setBounds(32, 27, 92, 34);
		panel.add(lb_NhapTu_1);
		
		textField = new JTextField();
		textField.setBackground(new Color(245, 245, 245));
		textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField.setBounds(140, 27, 390, 34);
		panel.add(textField);
		textField.setColumns(10);
		
		bt = new JButton("T\u00ECm");
		bt.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		bt.setBackground(SystemColor.activeCaption);
		bt.setMnemonic(KeyEvent.VK_F);
		bt.setToolTipText("Left_Alt + F");
		
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String s = null;
				int temp = 0;
				try {
					 s = (String) textField.getText();
					 temp = hashTable.hash(s.charAt(0));
					 Boolean kt = false;
						for(Node i = t.list[temp].first; i != null; i = i.link) {
							String k = hashTable.xuLyTen(i.data.getTuTA());
							if(s.equalsIgnoreCase(k)) {
								textArea.setText(textArea.getText() + "\n" + "------------ " + i.data.getTuTA() + " ------------");
								for(int j = 0; j < i.data.nghia.size(); j++) {
									textArea.setText(textArea.getText() + "\n" + i.data.nghia.get(j));
								}
								textArea.setText(textArea.getText() + "\n");
								kt = true;
							}
						}
						
						if(kt == false)
							textArea.setText("Không tìm thấy !");
				} catch (Exception e2) {
					// TODO: handle exception
					textArea.setText("Vui lòng nhập từ cần tìm !");
				}
			}
		});
		bt.setFont(bt.getFont().deriveFont(bt.getFont().getSize() + 1f));
		bt.setBounds(548, 27, 72, 34);
		panel.add(bt);
		textArea.setBackground(new Color(245, 245, 245));
		textArea.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		
		textArea.setBounds(32, 84, 837, 433);
		panel.add(textArea);
		
		JButton btnNewButton = new JButton("Thêm");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setMnemonic(KeyEvent.VK_A);
		btnNewButton.setToolTipText("Left_Alt + A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert s = new insert();
				s.setVisible(true);
			}
		});
		btnNewButton.setBounds(630, 27, 72, 34);
		panel.add(btnNewButton);
		btnNewButton.setFont(btnNewButton.getFont().deriveFont(btnNewButton.getFont().getSize() + 1f));
		
		JButton btnNewButton_1 = new JButton("Lưu");
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setMnemonic(KeyEvent.VK_S);
		btnNewButton_1.setToolTipText("Left_Alt + S");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.ghiFile();
				textArea.setText("Đã Lưu !");
			}
		});
		btnNewButton_1.setFont(btnNewButton_1.getFont().deriveFont(btnNewButton_1.getFont().getSize() + 3f));
		btnNewButton_1.setBounds(783, 28, 72, 33);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Xóa");
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setMnemonic(KeyEvent.VK_D);
		btnNewButton_2.setToolTipText("Left_Alt + D");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete d = new delete();
				d.setVisible(true);
			}
		});
		btnNewButton_2.setFont(btnNewButton_2.getFont().deriveFont(btnNewButton_2.getFont().getSize() + 1f));
		btnNewButton_2.setBounds(712, 28, 61, 33);
		panel.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("T\u1EEA \u0110I\u1EC2N ANH VI\u1EC6T");
		lblNewLabel.setForeground(new Color(0, 102, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
		lblNewLabel.setBounds(353, 10, 307, 50);
		contentPane.add(lblNewLabel);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(SystemColor.activeCaption);
		btnReset.setMnemonic(KeyEvent.VK_R);
		btnReset.setToolTipText("Left_Alt + R");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				textField.setText("");
			}
		});
		btnReset.setFont(new Font("Arial", Font.PLAIN, 15));
		btnReset.setBounds(429, 633, 86, 36);
		contentPane.add(btnReset);
		lb_date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		
		lb_date.setBounds(39, 43, 240, 28);
		contentPane.add(lb_date);
		
		lb_hour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_hour.setBounds(895, 48, 55, 23);
		contentPane.add(lb_hour);
	}
	
	public void clock() {
	    Thread clock = new Thread() {
	        public void run() {
	        	try {	
        			while(true) {
        				Calendar cal = new GregorianCalendar();
        				int second = cal.get(Calendar.SECOND);
        				int minute = cal.get(Calendar.MINUTE);
        				int hour = cal.get(Calendar.HOUR);
        				
        				String thu;
        				int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        				if(dayofweek == 1) {
        					thu = "Chủ nhật";
        				}
        				else {
        					thu = "Thứ " + Integer.toString(dayofweek);
        				}
        				
        				int dayofmonth = cal.get(Calendar.DAY_OF_MONTH);
        				int month = cal.get(Calendar.MONTH);
        				int year = cal.get(Calendar.YEAR);
        				
        				lb_date.setText(thu + " Ngày " + dayofmonth + " Tháng " + (month +1) + " Năm " + year);
        				lb_hour.setText(hour + ":" + minute + ":" + second);
        				//sleep(1000);
        			}	
        		} catch (Exception e2) {
        			// TODO: handle exception
        		}
	        }
	    };
	    clock.start();
	}
}
