package dictionary;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class delete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_xoa;
	private JLabel lb_tb = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					delete frame = new delete();
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
	public delete() {
		setTitle("DELETE");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 525, 184);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("X\u00D3A T\u1EEA");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(lblNewLabel.getFont().deriveFont(lblNewLabel.getFont().getSize() + 8f));
		lblNewLabel.setBounds(215, 10, 78, 26);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp t\u1EEB c\u1EA7n x\u00F3a: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(28, 52, 167, 20);
		contentPane.add(lblNewLabel_1);
		
		textField_xoa = new JTextField();
		textField_xoa.setColumns(10);
		textField_xoa.setBounds(168, 55, 200, 19);
		contentPane.add(textField_xoa);
		
		JButton bt_xoa = new JButton("X\u00F3a");
		bt_xoa.setMnemonic(KeyEvent.VK_ENTER);
		bt_xoa.setToolTipText("Left_Alt + Enter");
		bt_xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String s = (String) textField_xoa.getText();
					int k = hashTable.hash(s.charAt(0));
					Boolean kt = mainFrom.t.list[k].xoa(s);
					if(kt== true) {
						lb_tb.setText("Đã xóa !");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					lb_tb.setText("Từ không tồn tại!");
				}
	
			}
		});
		bt_xoa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		bt_xoa.setBounds(194, 104, 110, 31);
		contentPane.add(bt_xoa);
		
		lb_tb.setForeground(Color.BLUE);
		lb_tb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_tb.setBounds(377, 52, 110, 26);
		contentPane.add(lb_tb);
	}

}
