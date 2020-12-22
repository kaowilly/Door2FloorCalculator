package controller;

import javax.swing.JOptionPane;

import model.Model;
import view.View;

public class Controller {
	private Model model;
	private View view;

	public Controller(Model m, View v) {
		model = m;
		view = v;
		initView();
	}

	public void initView() {
		view.getNbPalletsTextfield().setText("Please enter an integer.");
		view.getNbBigBoxesTextfield().setText("Please enter an integer.");
		view.getNbAssociatesTruckTextfield().setText("Please enter an integer.");

		view.getNbBoxesStackedTextfield().setText("Only integers, please!");
		view.getNbAssoProcessingTextfield().setText("... here also!");
		view.getTotalBreakTimeTextfield().setText("... you're almost done!");
	}

	public void initController() {
		view.getPalletsButton().addActionListener(e -> saveNumberOfPallets());
		view.getBigBoxesButton().addActionListener(e -> saveNumberOfBigBoxes());
		view.getAssociatesTruckButton().addActionListener(e -> saveNbOfAssociatesTruck());
		view.getHello().addActionListener(e -> showDeliveryETA());

		view.getNbBoxesStackedButton().addActionListener(e -> saveNbOfSortedBoxes());
		view.getNbAssoProcessingButton().addActionListener(e -> saveNbOfAssociatesProcessing());
		view.getTotalBreakTimeButton().addActionListener(e -> saveTotalBreakTime());
		view.getByeBye().addActionListener(e -> showProcessingETA());
	}

	private void saveNumberOfPallets() {
		model.setNbOfPallets(view.getNbPalletsTextfield().getText());

		try {// if is number
			Integer.parseInt(model.getNbOfPallets());
			JOptionPane.showMessageDialog(null, "# of pallets saved : " + model.getNbOfPallets(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("1st field is not a number!");
		}

	}

	private void saveNumberOfBigBoxes() {
		model.setNbOfBigBoxes(view.getNbBigBoxesTextfield().getText());

		try {// if is number
			Integer.parseInt(model.getNbOfBigBoxes());
			JOptionPane.showMessageDialog(null, "# of big boxes saved : " + model.getNbOfBigBoxes(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("2nd field is not a number!");
		}

	}

	private void saveNbOfAssociatesTruck() {
		model.setNbOfAssociatesTruck(view.getNbAssociatesTruckTextfield().getText()); // string type

		try {// if is number
				// if Integer.parseInt is possible AND if it is less than 0...
			if (Integer.parseInt(model.getNbOfAssociatesTruck()) < 0) {
				throw new IllegalArgumentException("Only positive numbers allowed!");

			}
			// Integer.parseInt(model.getNbAssociates()); //convert string to int
			JOptionPane.showMessageDialog(null, "# of associates saved : " + model.getNbOfAssociatesTruck(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("3rd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("# of associates cannot be less than 0!");
		}

	}

	private void showDeliveryETA() {

		try {// if is number
			model.setNumberOfBoxes(model.calculateNumberOfBoxes(Integer.parseInt(model.getNbOfPallets()),
					Integer.parseInt(model.getNbOfBigBoxes())));
			model.setEstimatedUnloadingTime(
					model.calculateEstimatedUnloadingTime(Integer.parseInt(model.getNbOfAssociatesTruck())));

			JOptionPane.showMessageDialog(null,
					"# of pallets : " + model.getNbOfPallets() + "\n" + "# of big boxes : "
							+ model.getNbOfBigBoxes() + "\n" + "Total : " + model.getNumberOfBoxes() + " boxes"
							+ "\n" + "# of associates : " + model.getNbOfAssociatesTruck() + "\n\n" + "            ETA : "
							+ model.getEstimatedUnloadingTime(),
					"Results", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Invalid inputs!");
		}
	}

	private void saveNbOfSortedBoxes() {
		// model.setNbBoxesSorted(view.getNbBoxesStackedTextfield().getText());
		// Integer.parseInt(model.getNbBoxesStacked());

		try {
			model.setNbBoxesSorted(Integer.parseInt(view.getNbBoxesStackedTextfield().getText()));
			// view.getNbBoxesStackedTextfield().setText(Integer.toString(model.getNumberOfBoxes()));
			JOptionPane.showMessageDialog(null, "# of sorted boxes saved : " + model.getNbBoxesSorted(), "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("1st field is not a number!");
		}

	}

	private void saveNbOfAssociatesProcessing() {

		model.setNbOfAssociatesProcessing(view.getNbAssoProcessingTextfield().getText()); // string type

		try {// if is number
				// if Integer.parseInt is possible AND if it is less than 0...
			if (Integer.parseInt(model.getNbOfAssociatesProcessing()) < 0) {
				throw new IllegalArgumentException("Only positive numbers allowed!");

			}
			// Integer.parseInt(model.getNbAssociates()); //convert string to int
			JOptionPane.showMessageDialog(null, "# of processing associates saved : " + model.getNbOfAssociatesProcessing(),
					"Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("2nd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("# of associates cannot be less than 0!");
		}
	}

	private void saveTotalBreakTime() {
		model.setTotalDurationBreaks(view.getTotalBreakTimeTextfield().getText());

		try {
			if (Integer.parseInt(model.getTotalDurationBreaks()) < 0) {
				throw new IllegalArgumentException("Only positive amount of time allowed!");
			}
			JOptionPane.showMessageDialog(null,
					"Total duration of breaks saved : " + model.getTotalDurationBreaks() + " min.", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("3rd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Amount of time cannot be less than 0!");
		}
	}

	private void showProcessingETA() {
		model.setEstimatedProcessingTime(
				model.calculateEstimatedProcessingTime(Integer.parseInt(model.getNbOfAssociatesProcessing())));
		JOptionPane.showMessageDialog(null, 
				"# of boxes sorted : " + model.getNbBoxesSorted() + "\n" +
				"# of processing associates : " + model.getNbOfAssociatesProcessing() + "\n" +
				"Total duration of breaks : " + model.getTotalDurationBreaks() + " min." + "\n\n" + 
				"            ETA : " + model.getEstimatedProcessingTime(), "Info",
				JOptionPane.INFORMATION_MESSAGE);
	}

}
