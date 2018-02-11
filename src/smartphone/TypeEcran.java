package ordinateur;

public enum TypeEcran {
	LCD("lcd",2), OLED("oled",1);
	
	String s;
	int rank;
	
	TypeEcran(String s,int rank){
		this.rank = rank;
		this.s = s;
	}
	
	public static TypeEcran parseTypeEcran(String s) {
		switch(s.toLowerCase()) {
		case "lcd": return TypeEcran.LCD;
		case "oled": return TypeEcran.OLED;
		default : return null;
		}
	}
	
	public int getRank() {
		return rank;
	}
	
	public String toString() {
		return s;
	}
}
