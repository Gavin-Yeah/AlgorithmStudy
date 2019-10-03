package ChallengeSet.Drawbridge;

public class ValidLongitudeAndLatitude {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static boolean isValid(String s) {
		if(s.startsWith("(")&&s.endsWith(")")){
			s=s.substring(1, s.length()-2);
			if(!s.startsWith(" ")&&!s.endsWith(" ")) {
				String[] sub= s.split(",");
				String longitude=sub[0];
				String latitude=sub[1];
				if(latitude.startsWith(" ")&&latitude.substring(1).equals(latitude.strip())) {
					latitude=latitude.strip();
					if(longitude.startsWith("+")||longitude.startsWith("-")) {
						longitude=longitude.substring(1);
					}
					if(latitude.startsWith("+")||latitude.startsWith("-")) {
						latitude=latitude.substring(1);
					}
					if(longitude.contains(".")) {
						S
					}
					
				}
				
			}
		}
		return false;
	}
}
