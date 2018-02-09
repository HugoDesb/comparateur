package ordinateur;

public enum Type {
	LCD("lcd"), OLED("oled");
	
	String s;
	
	Type(String s){
		this.s = s;
	}
	
	public static Type parseType(String s) {
		switch(s.toLowerCase()) {
		case "lcd": return Type.LCD;
		case "oled": return Type.OLED;
		default : return null;
		}
	}
	
	public String toString() {
		return s;
	}
}
