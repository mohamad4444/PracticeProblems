package AfterAcademy;
import java.util.HashMap;

public class romanToInteger {
	public static int romanToInt(String s) {
		HashMap<String, Integer> romanValues = new HashMap<>();
		romanValues.put("I", 1);
		romanValues.put("V", 5);
		romanValues.put("X", 10);
		romanValues.put("L", 50);
		romanValues.put("C", 100);
		romanValues.put("D", 500);
		romanValues.put("M", 1000);
		char[] charArr = s.toCharArray();
		if (charArr.length == 1) {
			return romanValues.get("" + charArr[0]);
		}
		int sum = 0;
		for (int i = 0; i < charArr.length - 1; i++) {
			int d1 = romanValues.get("" + charArr[i]);
			int d2 = romanValues.get("" + charArr[i + 1]);
			if (d1 >= d2) {
				sum = sum + d1;
			} else {
				sum = sum - d1;
			}

		}
		sum = sum + romanValues.get("" + charArr[charArr.length - 1]);
		return sum;
	}

	public static void main(String[] args) {
		romanToInt("XVV");
	}
}
