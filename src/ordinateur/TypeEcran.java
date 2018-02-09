package ordinateur;

public enum TypeEcran {
	LCD("lcd"), OLED("oled");
	
	String s;
	
	TypeEcran(String s){
		this.s = s;
	}
	
	public static TypeEcran parseTypeEcran(String s) {
		switch(s.toLowerCase()) {
		case "lcd": return TypeEcran.LCD;
		case "oled": return TypeEcran.OLED;
		default : return null;
		}
	}
	
	public String toString() {
		return s;
	}
}
