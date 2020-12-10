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
		view.getNbPaletsTextfield().setText("Please enter an integer.");
		view.getNbBigBoxesTextfield().setText("Please enter an integer.");
		view.getNbAssociatesTextfield().setText("Please enter an integer.");
		
		view.getNbBoxesStackedTextfield().setText("Only integers, please!");
		view.getNbAssoProcessingTextfield().setText("... here also!");
		view.getTotalBreakTimeTextfield().setText("... you're almost done!");
	}

	public void initController() {
		view.getPaletsButton().addActionListener(e -> saveFirstname());
		view.getBigBoxesButton().addActionListener(e -> saveLastname());
		view.getAssociatesButton().addActionListener(e -> saveMiddlename());
		view.getHello().addActionListener(e -> sayHello());
		
		view.getNbBoxesStackedButton().addActionListener(e -> saveOnename());
		view.getNbAssoProcessingButton().addActionListener(e -> saveTwoname());
		view.getTotalBreakTimeButton().addActionListener(e -> saveThreename());
		view.getByeBye().addActionListener(e -> saveFinalname());
	}

	private void saveFirstname() {
		model.setNumberOfPalets(view.getNbPaletsTextfield().getText());

		try {// if is number
			Integer.parseInt(model.getNumberOfPalets());
			JOptionPane.showMessageDialog(null, "# of pallets saved : " + model.getNumberOfPalets(), "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("1st field is not a number!");
		}

	}
	
	private void saveLastname() {
		model.setNumberOfBigBoxes(view.getNbBigBoxesTextfield().getText());

		try {// if is number
			Integer.parseInt(model.getNumberOfBigBoxes());
			JOptionPane.showMessageDialog(null, "# of big boxes saved : " + model.getNumberOfBigBoxes(), "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("2nd field is not a number!");
		}

	}
	
	private void saveMiddlename() {
		model.setNbAssociates(view.getNbAssociatesTextfield().getText()); //string type

		try {// if is number
			//if Integer.parseInt is possible AND if it is less than 0...
			if(Integer.parseInt(model.getNbAssociates()) < 0) {
				throw new IllegalArgumentException("Only positive numbers allowed!");
				
			}
			//Integer.parseInt(model.getNbAssociates()); //convert string to int
			JOptionPane.showMessageDialog(null, "# of associates saved : " + model.getNbAssociates(), "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("3rd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("# of associates cannot be less than 0!");
		}

	}
	
	
	private void sayHello() {
		
		try {// if is number
			model.setNumberOfBoxes(model.calculateNumberOfBoxes(Integer.parseInt(model.getNumberOfPalets()), Integer.parseInt(model.getNumberOfBigBoxes())));
			model.setEstimatedUnloadingTime(model.calculateEstimatedUnloadingTime(Integer.parseInt(model.getNbAssociates())));
			
			JOptionPane.showMessageDialog(null, "# of pallets : " + model.getNumberOfPalets() + "\n" 
			+ "# of big boxes : " + model.getNumberOfBigBoxes() + "\n" 
			+ "Total : " + model.getNumberOfBoxes() + " boxes" + "\n" 
			+ "# of associates : " + model.getNbAssociates() + "\n\n"
			+ "            ETA : " + model.getEstimatedUnloadingTime(), "Results", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("Invalid inputs!");
		}
	}
	
	private void saveOnename() {
		//model.setNbBoxesSorted(view.getNbBoxesStackedTextfield().getText());
		//Integer.parseInt(model.getNbBoxesStacked());
		
		try {
			model.setNbBoxesSorted(Integer.parseInt(view.getNbBoxesStackedTextfield().getText()));
			//view.getNbBoxesStackedTextfield().setText(Integer.toString(model.getNumberOfBoxes()));
			JOptionPane.showMessageDialog(null, "# of sorted boxes saved : " + model.getNbBoxesSorted(), "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("1st field is not a number!");
		}
		
	}

	private void saveTwoname() {
		
		model.setNumberOfAssoProcess(view.getNbAssoProcessingTextfield().getText()); //string type

		try {// if is number
			//if Integer.parseInt is possible AND if it is less than 0...
			if(Integer.parseInt(model.getNumberOfAssoProcess()) < 0) {
				throw new IllegalArgumentException("Only positive numbers allowed!");
				
			}
			//Integer.parseInt(model.getNbAssociates()); //convert string to int
			JOptionPane.showMessageDialog(null, "# of processing associates saved: " + model.getNumberOfAssoProcess(), "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("2nd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("# of associates cannot be less than 0!");
		}
	}
	
	private void saveThreename() {
		model.setTotalDurationBreaks(view.getTotalBreakTimeTextfield().getText());
		
		try {
			if(Integer.parseInt(model.getTotalDurationBreaks()) < 0) {
				throw new IllegalArgumentException("Only positive amount of time allowed!");
			}
			JOptionPane.showMessageDialog(null, "Total duration of breaks saved: " + model.getTotalDurationBreaks() + " min.", "Info", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e){
			e.printStackTrace();
			System.out.println("3rd field is not a number!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			System.out.println("Amount of time cannot be less than 0!");
		}
	}
	
	private void saveFinalname() {
		model.setEstimatedProcessingTime(model.calculateEstimatedProcessingTime(Integer.parseInt(model.getNumberOfAssoProcess())));
		JOptionPane.showMessageDialog(null, "ETA!" + model.getEstimatedProcessingTime(), "Info", JOptionPane.INFORMATION_MESSAGE);
	}


}
