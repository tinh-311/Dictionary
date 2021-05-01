package dictionary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public class insert extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_tu;
	private JTextField textField_nghia;
	private JLabel lb_tu = new JLabel("");
	private JLabel lb_nghia = new JLabel("");
	private JLabel lb_tc = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insert frame = new insert();
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
	public insert() {
		setTitle("Insert");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 267);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Tahoma", Font.ITALIC, 11));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TH\u00CAM T\u1EEA");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(252, 0, 110, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nh\u1EADp t\u1EEB c\u1EA7n th\u00EAm: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(37, 60, 167, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nh\u1EADp ngh\u0129a: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(37, 109, 145, 30);
		contentPane.add(lblNewLabel_2);
		
		textField_tu = new JTextField();
		textField_tu.setBounds(192, 63, 277, 19);
		contentPane.add(textField_tu);
		textField_tu.setColumns(10);
		
		textField_nghia = new JTextField();
		textField_nghia.setBounds(192, 117, 277, 19);
		contentPane.add(textField_nghia);
		textField_nghia.setColumns(10);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.setMnemonic(KeyEvent.VK_ENTER);
		btnNewButton.setToolTipText("Left_Alt + Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tu = null;
				String nghia = null;
				word x = new word();
				try {
					tu = (String) textField_tu.getText();
					nghia = (String) textField_nghia.getText();
					
					if(tu != "" && nghia != "") {
						x.setTuTA(tu);
						x.nghia.add(nghia);
						int k = hashTable.hash(tu.charAt(0));
						mainFrom.t.list[k].insertLast(x);
						lb_tc.setText("Thêm thành công !");
					}
				} catch (Exception e2) {
					// TODO: handle exception
					lb_tu.setText("Vui lòng điền vào !");
					lb_nghia.setText("Vui lòng điền vào !");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(252, 185, 110, 31);
		contentPane.add(btnNewButton);
		
		
		lb_tu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_tu.setForeground(Color.RED);
		lb_tu.setBounds(481, 56, 110, 30);
		contentPane.add(lb_tu);
		
		lb_nghia.setForeground(Color.RED);
		lb_nghia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lb_nghia.setBounds(481, 109, 110, 30);
		contentPane.add(lb_nghia);
		
		lb_tc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lb_tc.setForeground(Color.BLUE);
		lb_tc.setBounds(252, 146, 110, 26);
		contentPane.add(lb_tc);
	}

}
