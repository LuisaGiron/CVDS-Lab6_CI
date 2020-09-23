package edu.eci.cvds.servlet.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean(name="calculadoraBean")
@SessionScoped
public class CalculadoraBean {
	
	
	private List<Double> numeros;
	private List<String> pastList;


	private double mean;
	private double mode;
	private double median;
	private double variance;
	private double stdDev;
	
	private String numberList;
	
	
	public CalculadoraBean() {
		numeros = new ArrayList<Double>();
		pastList = new ArrayList<String>();
	}
	
	
	public double calculateMean(String n) {
		stringToList(n);
		double result = 0;
		for (double d: numeros) result += d/numeros.size();
		
		setMean(result);
		
		return result;
	}
	
	
	public double calculateVariance(String n) {
		double m = calculateMean(n);
		double result = 0;
		for (double d: numeros) result += Math.pow((m-d), 2)/numeros.size();
		
		setVariance(result);
		
		return result;
	}


	public double calculateMode(String n) {
		stringToList(n);
		double result = 0;
		double repsMax= 0;
		Map<Double, Integer> h = new HashMap<Double, Integer>();
		for (double d: numeros) {
			if (h.containsKey(d)) h.replace(d, h.get(d)+1);
			else h.put(d, 1);
			
			if (repsMax < h.get(d)) {
				result = d;
				repsMax = h.get(d);
			}
			
		}
		
		setMode(result);
		
		return result;
	}
	
	
	public double calculateStandardDeviation(String n) {
		double result = Math.sqrt(calculateVariance(n));
		
		setStdDev(result);
		
		return result;
		
	}
	
	
	public double calculateMedian(String n) {
		stringToList(n);
		double result = 0;
		Collections.sort(numeros);
		result = (numeros.size() % 2 != 0) ? numeros.get((numeros.size()-1)/2): (numeros.get(numeros.size()/2 -1) + numeros.get(numeros.size()/2))/2;
		
		setMedian(result);
		
		return result;
	}
	
	
	public void restart() {
		mean = 0;
		mode = 0;
		median = 0;
		variance = 0;
		stdDev = 0;
		numeros.clear();
		pastList.clear();
	}
	
	
	private void stringToList(String str) {
		numeros.clear();
		if (pastList.isEmpty() || !str.equals(pastList.get(pastList.size()-1))) pastList.add(str);
		for (String s: str.split(";")) numeros.add(Double.parseDouble(s));
	}


	public double getMean() {
		return mean;
	}


	public double getMode() {
		return mode;
	}


	public double getMedian() {
		return median;
	}


	public double getVariance() {
		return variance;
	}


	public double getStdDev() {
		return stdDev;
	}
	
	
	public String getNumberList() {
		return numberList;
	}
	
	public void setNumberList(String numberList) {
		this.numberList = numberList;
	}


	public void setMean(double mean) {
		this.mean = mean;
	}


	public void setVariance(double variance) {
		this.variance = variance;
	}


	public void setMode(double mode) {
		this.mode = mode;
	}


	public void setMedian(double median) {
		this.median = median;
	}


	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}
	
	public List<String> getPastList() {
		return pastList;
	}


	public void setPastList(List<String> pastList) {
		this.pastList = pastList;
	}
	
	
}
