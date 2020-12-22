package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Model {
	public static final int PALLET_BOXES = 28;
	public static final int BIG_BOX_BOXES = 24;
	public static final double UNLOADING_FACTOR = 1.5;
	public static final int PROCESSING_FACTOR = 14;
	static final long ONE_MINUTE_IN_MILLIS = 60000; // millisecs

	private int nbBoxes;
	private String nbOfPallets;
	private String nbOfBigBoxes;
	private String nbOfAssociatesTruck;
	private String EstimatedUnloadingTime;

	private int nbBoxesSorted;
	private String nbOfAssociatesProcessing;
	private String totalDurationBreaks;
	private String EstimatedProcessingTime;

	public Model() {
	}

	public Model(String nbOfPallets, String nbOfBigBoxes, String nbOfAssociatesTruck) {
		this.nbOfBigBoxes = nbOfBigBoxes;
		this.nbOfPallets = nbOfPallets;
		this.nbOfAssociatesTruck = nbOfAssociatesTruck;
	}

	public int calculateNumberOfBoxes(int nbOfPallets, int nbOfBigBoxes) {
		nbBoxes = nbOfPallets * PALLET_BOXES + nbOfBigBoxes * BIG_BOX_BOXES;
		return nbBoxes;
	}

	final DateFormat timeFormat = new SimpleDateFormat("hh:mm a");

	public String calculateEstimatedUnloadingTime(int nbOfAssociatesTruck) {

		int minutesNeeded = (int) ((UNLOADING_FACTOR * nbBoxes) / nbOfAssociatesTruck);

		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
		EstimatedUnloadingTime = timeFormat.format(newTime);
		
		/*
		 * ActionListener timerListener = new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent arg0) {
		 * 
		 * Calendar date = Calendar.getInstance(); long t= date.getTimeInMillis();
		 * 
		 * Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
		 * EstimatedUnloadingTime = timeFormat.format(newTime); } }; Timer timer = new
		 * Timer(1000, timerListener); // to make sure it doesn't wait one second at the
		 * start timer.setInitialDelay(0); timer.start();
		 */
		
		return EstimatedUnloadingTime;

	}

	public String calculateEstimatedProcessingTime(int nbOfAssociatesTruck) {

		int minutesNeeded = (PROCESSING_FACTOR * nbBoxesSorted)
				+ (Integer.parseInt(totalDurationBreaks) / nbOfAssociatesTruck);

		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
		EstimatedProcessingTime = timeFormat.format(newTime);

		return EstimatedProcessingTime;

	}

	public int getNumberOfBoxes() {
		return nbBoxes;
	}

	public void setNumberOfBoxes(int nbBoxes) {
		this.nbBoxes = nbBoxes;
	}

	public String getNbOfBigBoxes() {
		return nbOfBigBoxes;
	}

	public void setNbOfBigBoxes(String nbOfBigBoxes) {
		this.nbOfBigBoxes = nbOfBigBoxes;
	}

	public String getNbOfPallets() {
		return nbOfPallets;
	}

	public void setNbOfPallets(String nbOfPallets) {
		this.nbOfPallets = nbOfPallets;
	}

	public String getNbOfAssociatesTruck() {
		return nbOfAssociatesTruck;
	}

	public void setNbOfAssociatesTruck(String nbOfAssociatesTruck) {
		this.nbOfAssociatesTruck = nbOfAssociatesTruck;
	}

	public String getEstimatedUnloadingTime() {
		return EstimatedUnloadingTime;
	}

	public void setEstimatedUnloadingTime(String estimatedUnloadingTime) {
		EstimatedUnloadingTime = estimatedUnloadingTime;
	}

	public int getNbBoxesSorted() {
		return nbBoxesSorted;
	}

	public void setNbBoxesSorted(int nbBoxesSorted) {
		this.nbBoxesSorted = nbBoxesSorted;
	}

	public String getNbOfAssociatesProcessing() {
		return nbOfAssociatesProcessing;
	}

	public void setNbOfAssociatesProcessing(String nbOfAssociatesProcessing) {
		this.nbOfAssociatesProcessing = nbOfAssociatesProcessing;
	}

	public String getTotalDurationBreaks() {
		return totalDurationBreaks;
	}

	public void setTotalDurationBreaks(String totalDurationBreaks) {
		this.totalDurationBreaks = totalDurationBreaks;
	}

	public String getEstimatedProcessingTime() {
		return EstimatedProcessingTime;
	}

	public void setEstimatedProcessingTime(String estimatedProcessingTime) {
		EstimatedProcessingTime = estimatedProcessingTime;
	}

}
