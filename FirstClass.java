package calendar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.*;
import java.time.format.TextStyle;
import java.util.Locale;

public class FirstClass {

	public static int MLength;
	public static int MNumber;

	public static int[] week6 = new int[7];
	public static int[] week5 = new int[7];
	public static int[] week4 = new int[7];
	public static int[] week3 = new int[7];
	public static int[] week2 = new int[7];
	public static int[] week1 = new int[7];

	public static void start() throws IOException {

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("������� �������� ������");
		int today=0; // ��������� � ��� � �� ���� ������� ������� ����� � �������,
					// �� � ����������� ����� � ������ ��������
		String month = bf.readLine();
		LocalDate ld;

		if (month.isEmpty()) {
			ld = LocalDate.now();
			MNumber = ld.getMonthValue();
			today = ld.getDayOfMonth();

		} else {
			MNumber = MonthNumberMap.MonthNumber(month);
			ld = LocalDate.of(2016, MonthNumberMap.MonthNumber(month), 01);
		}

		MLength = ld.lengthOfMonth();

		AddingToArray(week1);
		AddingToArray(week2);
		AddingToArray(week3);
		AddingToArray(week4);
		AddingToArray(week5);
		AddingToArray(week6);
		
		if(today != 0 ){
			System.out.println("������� "+today+"-e �����.");
		}
		
		Month monthInRussian = ld.getMonth();
		String output = monthInRussian.getDisplayName(TextStyle.FULL_STANDALONE, new Locale("ru"));

		System.out.println(output);
		System.out.println();
		dayNameArray();
		print(week6);
		print(week5);
		print(week4);
		print(week3);
		print(week2);
		print(week1);

	}

	private static void AddingToArray(int[] mas) {

		for (int i = 0; i < 7; i++) {
			if (MLength > 0) {
				LocalDate day = LocalDate.of(2016, MNumber, MLength);
				DayOfWeek dow = day.getDayOfWeek();
				mas[dow.getValue() - 1] = MLength;
				MLength--;
				if (mas[0] != 0)
					break;
			}

		}

	}

	private static void print(int[] mas) {
		System.out.println();
		if (mas.length > 0) {
			for (int a : mas) {
				if (a == 0) {
					System.out.print("    ");
				} else if (a < 10) {
					System.out.print(a + "   ");
				} else {
					System.out.print(a + "  ");
				}
			}
		}

	}

	private static void dayNameArray() {
		String[] daysInWeek = new String[7];
		daysInWeek[0] = "��";
		daysInWeek[1] = "��";
		daysInWeek[2] = "��";
		daysInWeek[3] = "��";
		daysInWeek[4] = "��";
		daysInWeek[5] = "��";
		daysInWeek[6] = "��";

		for (String a : daysInWeek) {
			System.out.print(a + "  ");
		}
	}
}