package calendar;

import java.util.HashMap;
import java.util.Map;

public class MonthNumberMap {

	public static int MonthNumber(String month) {
		Map<String, Integer> map = new HashMap<>();
		map.put("������", 1);
		map.put("�������", 2);
		map.put("����", 3);
		map.put("������", 4);
		map.put("���", 5);
		map.put("����", 6);
		map.put("����", 7);
		map.put("������", 8);
		map.put("��������", 9);
		map.put("�������", 10);
		map.put("������", 11);
		map.put("�������", 12);

		month = month.toLowerCase();
		int a = 0;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {

			if (month.equals(entry.getKey())) {
				a = entry.getValue();

			}
		}
		return a;

	}
}
