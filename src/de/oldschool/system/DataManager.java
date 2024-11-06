package de.oldschool.system;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

//Lennox
public class DataManager {
	
	private Map<String, Map<String, Integer>> data;
	private Map<String, Integer> keyValues;
	
	public DataManager() {
		this.data = new HashMap<>();
		this.keyValues = new HashMap<>();
	}
	
	public Map<String, Map<String, Integer>> getData() {
		return data;
	}
	
	public int getValue(String name, String key) {
		if(!data.containsKey(name)) {
			System.out.println("Dieser Name existiert nicht!");
		}
		
		return data.get(name).get(key);
	}
	
	public void setStats(String name, int timeValue, int goalValue) {
		keyValues.put("time", timeValue);
		keyValues.put("goals", goalValue);
		data.put(name, keyValues);
	}
	
	@SuppressWarnings("unchecked")
	public void loadData(File file) {
		
		if(!file.exists()) {
			return;
		}
		
		try {
			InputStream inputStream = new FileInputStream(file);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			
			this.data = (Map<String, Map<String, Integer>>) objectInputStream.readObject();  
			
			objectInputStream.close();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void storeData(File file) {
		
		if(!file.exists()) {
			return;
		}
		
		try {
			OutputStream outputStream = new FileOutputStream(file);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			
			objectOutputStream.writeObject(data);
			
			objectOutputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
