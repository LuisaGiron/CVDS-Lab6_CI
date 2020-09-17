package edu.eci.cvds.servlet.bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@ManagedBean(name="calculadoraBean")
@ApplicationScoped
public class CalculadoraBean {
	
	private double mean;
	private double mode;
	private double median;
	private double stdDev;
	private double variance;
	private List<Double> numeros;
	
	private String listaNumeros;
	
	public CalculadoraBean() {
		numeros = new ArrayList<Double>();
		restart();
	}
	
	
	public double calculateMean(String n) {
		stringToList(n);
		mean = 0;
		for (Double d: numeros) mean += d;
		mean /= numeros.size();
		
		return getMean();
	}
	
	public double calculateMode(String n) {
		stringToList(n);
		int reps = 0;
		HashMap<Double, Integer> map = new HashMap<Double, Integer>();
		for (Double d: numeros) {
			if (!map.containsKey(d)) map.put(d, 1); 
			else map.put(d, map.get(d)+1);
			
			if (map.get(d) > reps) {
				reps = map.get(d);
				mode = d;
			}
		}
		
		return getMode();
	}
	
	public double calculateMedian(String n) {
		stringToList(n);
		Collections.sort(numeros);
		int size = numeros.size();
		median = (size % 2 == 0) ? (numeros.get(size/2-1)+numeros.get(size/2))/2: numeros.get((size-1)/2);
		
		return getMedian();
	}
	
	
	public double calculateVariance(String n) {
		calculateMean(n);
		variance = 0;
		for (Double d: numeros) variance += Math.pow((mean-d), 2)/numeros.size();
		
		return getVariance();
	}
	
	
	public double calculateStandardDeviation(String n) {
		calculateVariance(n);
		stdDev = Math.sqrt(variance);
		
		return getStdDev();
	}
	
	
	public void restart() {
		mean = 0;
		mode = 0;
		median = 0;
		variance = 0;
		stdDev = 0;
		numeros.clear();
		listaNumeros = "";
	}
	
	
	private void stringToList(String n) {
		String[] strs = n.split("; ");
		for (String s: strs) numeros.add(Double.parseDouble(s));
	}


	public double getMean() {
		return mean;
	}


	public void setMean(double mean) {
		this.mean = mean;
	}


	public double getMode() {
		return mode;
	}


	public void setMode(double mode) {
		this.mode = mode;
	}


	public double getMedian() {
		return median;
	}


	public void setMedian(double median) {
		this.median = median;
	}


	public double getStdDev() {
		return stdDev;
	}


	public void setStdDev(double stdDev) {
		this.stdDev = stdDev;
	}


	public double getVariance() {
		return variance;
	}


	public void setVariance(double variance) {
		this.variance = variance;
	}


	public String getListaNumeros() {
		return listaNumeros;
	}


	public void setListaNumeros(String listaNumeros) {
		this.listaNumeros = listaNumeros;
	}
	
	
}
