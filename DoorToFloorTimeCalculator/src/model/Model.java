package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Timer;

public class Model {
	public static final int PALET_BOXES = 28;
	public static final int BIG_BOX_BOXES = 24;
	public static final double UNLOADING_FACTOR = 1.5;
	public static final int PROCESSING_FACTOR = 14;
	static final long ONE_MINUTE_IN_MILLIS = 60000;//millisecs
	
	private int nbBoxes;
	private String numberOfPalets;
	private String numberOfBigBoxes;
	private String nbAssociates;
	private String EstimatedUnloadingTime;
	
	private int nbBoxesSorted;
	private String numberOfAssoProcess;
	private String totalDurationBreaks;
	private String EstimatedProcessingTime;
	
	public Model() {}
	
	public Model(String numberOfPalets, String numberOfBigBoxes, String nbAssociates) {
		this.numberOfBigBoxes = numberOfBigBoxes;
		this.numberOfPalets = numberOfPalets;
		this.nbAssociates = nbAssociates;
	}
	
	public int calculateNumberOfBoxes(int numberOfPalets, int numberOfBigBoxes) {
		nbBoxes = numberOfPalets * PALET_BOXES + numberOfBigBoxes * BIG_BOX_BOXES;
		return nbBoxes;
	}
	
	final DateFormat timeFormat = new SimpleDateFormat("hh:mm a");
	public String calculateEstimatedUnloadingTime(int nbAssociates) {
		
		int minutesNeeded = (int) ((UNLOADING_FACTOR * nbBoxes)/nbAssociates);
		
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
		EstimatedUnloadingTime = timeFormat.format(newTime);
		/*
        ActionListener timerListener = new ActionListener()
        {
			@Override
			public void actionPerformed(ActionEvent arg0) {
               
				Calendar date = Calendar.getInstance();
				long t= date.getTimeInMillis();
				
				Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
                EstimatedUnloadingTime = timeFormat.format(newTime);	
			}
        };
        Timer timer = new Timer(1000, timerListener);
        // to make sure it doesn't wait one second at the start
        timer.setInitialDelay(0);
        timer.start();
		*/
		return EstimatedUnloadingTime;
		
	}
	
	public String calculateEstimatedProcessingTime(int nbAssociates) {
		
		int minutesNeeded = (PROCESSING_FACTOR * nbBoxesSorted) + (Integer.parseInt(totalDurationBreaks) / nbAssociates);
		
		Calendar date = Calendar.getInstance();
		long t = date.getTimeInMillis();
		Date newTime = new Date(t + (minutesNeeded * ONE_MINUTE_IN_MILLIS));
		EstimatedProcessingTime = timeFormat.format(newTime);

		return EstimatedProcessingTime;
		
	}
	
	public int getNumberOfBoxes()  {
		return nbBoxes;
	}
	
	public void setNumberOfBoxes(int nbBoxes) {
		this.nbBoxes = nbBoxes;
	}

	public String getNumberOfBigBoxes() {
		return numberOfBigBoxes;
	}

	public void setNumberOfBigBoxes(String numberOfBigBoxes) {
		this.numberOfBigBoxes = numberOfBigBoxes;
	}

	public String getNumberOfPalets() {
		return numberOfPalets;
	}

	public void setNumberOfPalets(String numberOfPalets) {
		this.numberOfPalets = numberOfPalets;
	}

	public String getNbAssociates() {
		return nbAssociates;
	}

	public void setNbAssociates(String nbAssociates) {
		this.nbAssociates = nbAssociates;
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

	public String getNumberOfAssoProcess() {
		return numberOfAssoProcess;
	}

	public void setNumberOfAssoProcess(String numberOfAssoProcess) {
		this.numberOfAssoProcess = numberOfAssoProcess;
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
