package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;

public class FrmIgraci extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroup = new ButtonGroup();
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	JList listIgraci = new JList();
	private JTextField txtUnosIgraca;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgraci frame = new FrmIgraci();
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
	public FrmIgraci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 865, 460);
		setTitle("Evidencija igraca");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JLabel lblAleksandarKolarov = new JLabel("Aleksandar Kolarov");
		
		JLabel lblDusanTadic = new JLabel("Dusan Tadic");
		
		JLabel lblNemanjaGudelj = new JLabel("Nemanja Gudelj");
		
		JToggleButton tglbtnKolarov = new JToggleButton("Kolarov");
		tglbtnKolarov.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnKolarov.isSelected()) {
					dlm.addElement(lblAleksandarKolarov.getText());
				}
			}
		});
		
		JToggleButton tglbtnTadic = new JToggleButton("Tadic");
		tglbtnTadic.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnTadic.isSelected()) {
					dlm.addElement(lblDusanTadic.getText());
				}
			}
		});
		
		JToggleButton tglbtnGudelj = new JToggleButton("Gudelj");
		tglbtnGudelj.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(tglbtnGudelj.isSelected()) {
					dlm.addElement(lblNemanjaGudelj.getText());
				}
			}
		});
		
		btnGroup.add(tglbtnKolarov);
		btnGroup.add(tglbtnTadic);
		btnGroup.add(tglbtnGudelj);
		
		
		JScrollPane scrlPaneIgraci = new JScrollPane();
		
		JLabel lblUnesiIgraca = new JLabel("Unesi igraca:");
		
		txtUnosIgraca = new JTextField();
		txtUnosIgraca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnosIgraca.getText());
				}
			}
		});
		txtUnosIgraca.setColumns(10);
		
		JLabel lblOdaberiIgraca = new JLabel("Odaberi igraca:");
		
		JComboBox cbxIgraci = new JComboBox();
		cbxIgraci.addItem("Nemanja Matic");
		cbxIgraci.addItem("Luka Jovic");
		cbxIgraci.addItem("Nikola Milenkovic");
		
		JButton btnDodajIgraca = new JButton("Dodaj igraca");
		btnDodajIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement((String) cbxIgraci.getSelectedItem());
			}
		});
		
		JButton btnUkloniIgraca = new JButton("Ukloni igraca");
		btnUkloniIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!listIgraci.isSelectionEmpty()) {
					dlm.removeElement(listIgraci.getSelectedValue());
				} else {
					JOptionPane.showMessageDialog(null, "Nije selektovan nijedan igrac iz liste!");
				}
			}
		});
		
		JButton btnDodajIgraca_1 = new JButton("Dodaj igraca");
		btnDodajIgraca_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgIgrac dlg = new DlgIgrac();
				dlg.setVisible(true);
				if (dlg.isOk) {
					dlm.addElement(dlg.getTxtIme().getText() + " " + dlg.getTxtPrezime().getText());
				}
			}
		});
		
		JButton btnModifikacijaIgraca = new JButton("Modifikacija igraca");
		btnModifikacijaIgraca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listIgraci.isSelectionEmpty()) {
					JOptionPane.showMessageDialog(null, "Nije selektovan nijedan igrac iz liste!");
				} else {
					DlgIgrac dlgModifikacija = new DlgIgrac();
					int index = listIgraci.getSelectedIndex();
					String[] split = dlm.getElementAt(index).toString().split(" ");
					dlgModifikacija.getTxtIme().setText(split[0]);
					dlgModifikacija.getTxtPrezime().setText(split[1]);
					dlgModifikacija.setVisible(true);
					if(dlgModifikacija.isOk) {
						dlm.removeElementAt(index);
						dlm.add(index, dlgModifikacija.getTxtIme().getText() + " " +
								dlgModifikacija.getTxtPrezime().getText());
					}
				}
			}
		});
		
		
		
		GroupLayout gl_pnlCenter = new GroupLayout(pnlCenter);
		gl_pnlCenter.setHorizontalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUnesiIgraca)
								.addComponent(lblOdaberiIgraca))
							.addGap(41)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
								.addComponent(cbxIgraci, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txtUnosIgraca))
							.addGap(33)
							.addComponent(btnDodajIgraca)
							.addGap(149)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addComponent(btnModifikacijaIgraca)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnDodajIgraca_1)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnUkloniIgraca)
								.addGroup(gl_pnlCenter.createSequentialGroup()
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tglbtnGudelj, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tglbtnTadic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(tglbtnKolarov, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
									.addGap(18)
									.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING, false)
											.addComponent(lblDusanTadic, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblAleksandarKolarov, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
										.addComponent(lblNemanjaGudelj))
									.addPreferredGap(ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
									.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 306, GroupLayout.PREFERRED_SIZE)))))
					.addGap(36))
		);
		gl_pnlCenter.setVerticalGroup(
			gl_pnlCenter.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCenter.createSequentialGroup()
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnKolarov)
								.addComponent(lblAleksandarKolarov))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnTadic)
								.addComponent(lblDusanTadic))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
								.addComponent(tglbtnGudelj)
								.addComponent(lblNemanjaGudelj)))
						.addGroup(gl_pnlCenter.createSequentialGroup()
							.addGap(24)
							.addComponent(scrlPaneIgraci, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnUkloniIgraca)
					.addGap(25)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnesiIgraca)
						.addComponent(txtUnosIgraca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnDodajIgraca_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnlCenter.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOdaberiIgraca)
						.addGroup(gl_pnlCenter.createParallelGroup(Alignment.BASELINE)
							.addComponent(cbxIgraci, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(btnDodajIgraca)
							.addComponent(btnModifikacijaIgraca)))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		
		scrlPaneIgraci.setViewportView(listIgraci);
		pnlCenter.setLayout(gl_pnlCenter);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnIspis = new JButton("Ispis");
		btnIspis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Test Button");
			}
		});
		pnlSouth.add(btnIspis);
		
		listIgraci.setModel(dlm); // bindovanje modela (dlm) na JList-u (listIgraci)
		
	}

}
