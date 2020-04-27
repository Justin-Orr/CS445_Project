package util;

public class JsonStringGenerator {
	
	private String json;
	
	public void initialize() {
		json = "{";
	}
	
	public String getJson() {
		return json;
	}
	
	public void close() {
		json += "\n}";
	}
	
	public void add(String name, int value) {
		json += "\n\t\"" + name + "\": " +  String.valueOf(value);
	}
	
	public void add(String name, boolean value) {
		json += "\n\t\"" + name + "\": " +  String.valueOf(value);
	}
	
	public void add(String name, String value) {
		json += "\n\t\"" + name + "\": " + value ;
	}

}
