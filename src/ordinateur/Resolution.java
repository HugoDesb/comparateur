package ordinateur;

public enum Resolution {
	SD("sd", 6), HD("hd",5), FULL_HD("fullhd",4), QUAD_HD("quadhd",3),ULTRA_HD("ultrahd",2), FOUR_K("4k",1);
	
	private String s;
	private int classement;
	
	Resolution(String s, int n) {	
		this.classement = n;
		this.s = s;
	}
	
	public static Resolution parseResolution(String s) {
		switch(s.toLowerCase()) {
		case "sd" : return Resolution.SD;
		case "hd" : return Resolution.HD;
		case "fullhd" : return Resolution.FULL_HD;
		case "quadhd" : return Resolution.QUAD_HD;
		case "ultrahd" : return Resolution.ULTRA_HD;
		case "4k" : return Resolution.FOUR_K;
		default : return null;
		}
	}
	
	public String toString() {
		return s;
	}
	
	public int getRank() {
		return classement;
	}
}
