
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class View {
	private JFrame frame;
	private JPanel firstPanel, secondPanel;

	// Attributes for the first panel
	private JLabel firstPanelTitle, nbPalletsLabel, nbBigBoxesLabel, nbAssociatesLabel;
	private JTextField nbPalletsTextfield, nbBigBoxesTextfield, nbAssociatesTruckTextfield;
	private JButton palletsButton, bigBoxesButton, associatesTruckButton, hello;

	final JLabel timeLabel, dateLabel;

	// Attributes for the second panel
	private JLabel secondPanelTitle, nbBoxesStackedLabel, nbAssoProcessingLabel, totalBreakTimeLabel;
	private JTextField nbBoxesStackedTextfield, nbAssoProcessingTextfield, totalBreakTimeTextfield;
	private JButton nbBoxesStackedButton, nbAssoProcessingButton, totalBreakTimeButton, byeBye, generateReportButton;

	public View(String title) {

		// JFrame settings
		frame = new JFrame(title);
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(500, 280));
		// frame.setSize(500, 150); //120 og
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		// Create UI elements for the first panel
		nbPalletsLabel = new JLabel("Number of pallets (8 ft.) :");
		nbBigBoxesLabel = new JLabel("Number of big boxes :");
		nbAssociatesLabel = new JLabel("Number of associates : ");

		nbPalletsTextfield = new JTextField();
		nbPalletsTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbPalletsTextfield.setText("");
			}
		});

		nbBigBoxesTextfield = new JTextField();
		nbBigBoxesTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbBigBoxesTextfield.setText("");
			}
		});

		nbAssociatesTruckTextfield = new JTextField();
		nbAssociatesTruckTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbAssociatesTruckTextfield.setText("");
			}
		});

		palletsButton = new JButton("Save");
		bigBoxesButton = new JButton("Save");
		associatesTruckButton = new JButton("Save");
		hello = new JButton("Calculate");
		firstPanelTitle = new JLabel("Delivery & Unloading ");

		// show time and date
		dateLabel = new JLabel(); // time zone and offset label
		timeLabel = new JLabel();

		final DateFormat timeFormat = new SimpleDateFormat("hh:mm a Z");
		final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-d");
		ActionListener timerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				/*
				 * Calendar date = Calendar.getInstance(); long t= date.getTimeInMillis();
				 * 
				 * 
				 * Date newDate = new Date(t + (10 * ONE_MINUTE_IN_MILLIS));
				 */
				Date date = new Date();
				String time = timeFormat.format(date);
				timeLabel.setText(time);

				// repeat
				Date date1 = new Date();
				String time1 = dateFormat.format(date1);
				dateLabel.setText(time1);

			}
		};
		Timer timer = new Timer(1000, timerListener);
		// to make sure it doesn't wait one second at the start
		timer.setInitialDelay(0);
		timer.start();

		firstPanel = new JPanel(new FlowLayout());
		// panel.setBackground(Color.RED);

		// Add UI elements to the first panel
		GroupLayout layout = new GroupLayout(firstPanel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);

		layout.setHorizontalGroup(layout.createSequentialGroup()
				// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				// .addComponent(titleMain))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(firstPanelTitle)
						// .addGap(30, 50, 80)
						.addComponent(nbPalletsLabel).addComponent(nbBigBoxesLabel).addComponent(nbAssociatesLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(nbPalletsTextfield)
						.addComponent(nbBigBoxesTextfield).addComponent(nbAssociatesTruckTextfield))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(palletsButton)
						.addComponent(bigBoxesButton).addComponent(associatesTruckButton).addComponent(dateLabel))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(hello)
						.addComponent(timeLabel)));
		layout.setVerticalGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(firstPanelTitle)
						.addGap(25, 25, 25)) // gap entre le titre et palletsLabel
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nbPalletsLabel)
						.addComponent(nbPalletsTextfield).addComponent(palletsButton))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nbBigBoxesLabel)
						.addComponent(nbBigBoxesTextfield).addComponent(bigBoxesButton).addComponent(hello))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(nbAssociatesLabel)
						.addComponent(nbAssociatesTruckTextfield).addComponent(associatesTruckButton)
						.addGap(80, 80, 80)) // gap entre le last label et timer))
				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(dateLabel)
						.addComponent(timeLabel)));
		firstPanel.setLayout(layout);
		// frame.getContentPane().setLayout(layout);

		/*
		 * *****************************************************************************
		 * *****************************************************************************
		 * *****************************************************************************
		 */

		// Create UI elements for the second panel
		nbBoxesStackedLabel = new JLabel("Number of boxes (sorted) :");
		nbAssoProcessingLabel = new JLabel("Number of associates :");
		totalBreakTimeLabel = new JLabel("Total duration of breaks : ");

		nbBoxesStackedTextfield = new JTextField();
		nbBoxesStackedTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbBoxesStackedTextfield.setText("");
			}
		});

		nbAssoProcessingTextfield = new JTextField();
		nbAssoProcessingTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nbAssoProcessingTextfield.setText("");
			}
		});

		totalBreakTimeTextfield = new JTextField();
		totalBreakTimeTextfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				totalBreakTimeTextfield.setText("");
			}
		});

		nbBoxesStackedButton = new JButton("Save");
		nbAssoProcessingButton = new JButton("Save");
		totalBreakTimeButton = new JButton("Save");
		byeBye = new JButton("Calculate");
		secondPanelTitle = new JLabel("Clothing Processing");
		generateReportButton = new JButton("Generate Report");

		secondPanel = new JPanel(); // should be FlowLayout by default

		// Add UI element to the second panel
		GroupLayout secondLayout = new GroupLayout(secondPanel);
		secondLayout.setAutoCreateGaps(true);
		secondLayout.setAutoCreateContainerGaps(true);

		secondLayout.setHorizontalGroup(secondLayout.createSequentialGroup()
				// .addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
				// .addComponent(titleMain))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(secondPanelTitle)
						// .addGap(30, 50, 80)
						.addComponent(nbBoxesStackedLabel).addComponent(nbAssoProcessingLabel)
						.addComponent(totalBreakTimeLabel))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(nbBoxesStackedTextfield).addComponent(nbAssoProcessingTextfield)
						.addComponent(totalBreakTimeTextfield).addComponent(generateReportButton))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
						.addComponent(nbBoxesStackedButton).addComponent(nbAssoProcessingButton)
						.addComponent(totalBreakTimeButton))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(byeBye)));
		secondLayout.setVerticalGroup(secondLayout.createSequentialGroup()
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(secondPanelTitle).addGap(25, 25, 25)) // gap entre le titre et palletsLabel
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(nbBoxesStackedLabel).addComponent(nbBoxesStackedTextfield)
						.addComponent(nbBoxesStackedButton))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(nbAssoProcessingLabel).addComponent(nbAssoProcessingTextfield)
						.addComponent(nbAssoProcessingButton).addComponent(byeBye))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(totalBreakTimeLabel).addComponent(totalBreakTimeTextfield)
						.addComponent(totalBreakTimeButton).addGap(50, 50, 50))
				.addGroup(secondLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
						.addComponent(generateReportButton)));
		secondPanel.setLayout(secondLayout);

		/*
		 * *****************************************************************************
		 * *****************************************************************************
		 * *****************************************************************************
		 */

		// panel2.add(new Label("This is my second panel!"));
		JPanel thirdPanel = new JPanel();
		thirdPanel.setLayout(new BorderLayout());
		// panel3.add(new Label("This is my third panel!"));
		// panel3.add(new Label("\nCopyright (C) 2020 Willy Kao - All Rights
		// Reserved."));
		JLabel author = new JLabel(
				"<html>Copyright \u00A9 2020 Willy Kao. All rights reserved.<br/>"
						+ "E-mail: willy.kao.1@ens.etsmtl.ca<br/>" + "Last modified: December 21st, 2020</html>",
				SwingConstants.CENTER);
		JLabel textPanel3 = new JLabel("This is my third panel!", SwingConstants.CENTER);
		thirdPanel.add(textPanel3, BorderLayout.NORTH);
		thirdPanel.add(author, BorderLayout.CENTER);

		// Creating my tabs
		JTabbedPane tp = new JTabbedPane();

		tp.add("Unloading", firstPanel);
		tp.add("Processing", secondPanel);
		tp.add("About", thirdPanel);

		// frame.add(panel);
		frame.add(tp);
		frame.pack();

	}

	public JTextField getNbPalletsTextfield() {
		return nbPalletsTextfield;
	}

	public void setNbPalletsTextfield(JTextField nbPalletsTextfield) {
		this.nbPalletsTextfield = nbPalletsTextfield;
	}

	public JTextField getNbBigBoxesTextfield() {
		return nbBigBoxesTextfield;
	}

	public void setNbBigBoxesTextfield(JTextField nbBigBoxesTextfield) {
		this.nbBigBoxesTextfield = nbBigBoxesTextfield;
	}

	public JTextField getNbAssociatesTruckTextfield() {
		return nbAssociatesTruckTextfield;
	}

	public void setNbAssociatesTruckTextfield(JTextField nbAssociatesTextfield) {
		this.nbAssociatesTruckTextfield = nbAssociatesTextfield;
	}

	public JButton getPalletsButton() {
		return palletsButton;
	}

	public void setPalletsButton(JButton palletsButton) {
		this.palletsButton = palletsButton;
	}

	public JButton getBigBoxesButton() {
		return bigBoxesButton;
	}

	public void setBigBoxesButton(JButton bigBoxesButton) {
		this.bigBoxesButton = bigBoxesButton;
	}

	public JButton getAssociatesTruckButton() {
		return associatesTruckButton;
	}

	public void setAssociatesTruckButton(JButton associatesTruckButton) {
		this.associatesTruckButton = associatesTruckButton;
	}

	public JButton getHello() {
		return hello;
	}

	public void setHello(JButton hello) {
		this.hello = hello;
	}

	/*
	 * *****************************************************************************
	 * *****************************************************************************
	 * *****************************************************************************
	 */

	public JTextField getNbBoxesStackedTextfield() {
		return nbBoxesStackedTextfield;
	}

	public void setNbBoxesStackedTextfield(JTextField nbBoxesStackedTextfield) {
		this.nbBoxesStackedTextfield = nbBoxesStackedTextfield;
	}

	public JTextField getNbAssoProcessingTextfield() {
		return nbAssoProcessingTextfield;
	}

	public void setNbAssoProcessingTextfield(JTextField nbAssoProcessingTextfield) {
		this.nbAssoProcessingTextfield = nbAssoProcessingTextfield;
	}

	public JTextField getTotalBreakTimeTextfield() {
		return totalBreakTimeTextfield;
	}

	public void setTotalBreakTimeTextfield(JTextField totalBreakTimeTextfield) {
		this.totalBreakTimeTextfield = totalBreakTimeTextfield;
	}

	public JButton getNbBoxesStackedButton() {
		return nbBoxesStackedButton;
	}

	public void setNbBoxesStackedButton(JButton nbBoxesStackedButton) {
		this.nbBoxesStackedButton = nbBoxesStackedButton;
	}

	public JButton getNbAssoProcessingButton() {
		return nbAssoProcessingButton;
	}

	public void setNbAssoProcessingButton(JButton nbAssoProcessingButton) {
		this.nbAssoProcessingButton = nbAssoProcessingButton;
	}

	public JButton getTotalBreakTimeButton() {
		return totalBreakTimeButton;
	}

	public void setTotalBreakTimeButton(JButton totalBreakTimeButton) {
		this.totalBreakTimeButton = totalBreakTimeButton;
	}

	public JButton getByeBye() {
		return byeBye;
	}

	public void setByeBye(JButton byeBye) {
		this.byeBye = byeBye;
	}
}
