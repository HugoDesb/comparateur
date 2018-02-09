package ordinateur;

public enum Resolution {
	SD("sd"), HD("hd"), FULL_HD("fullhd"), QUAD_HD("quadhd"),ULTRA_HD("ultrahd"), FOUR_K("4k");
	
	private String s;
	Resolution(String s) {	
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
}
