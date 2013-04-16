package org.akceptor.ijournal.service;

import org.akceptor.ijournal.dao.DateDAO;
import org.akceptor.ijournal.domain.MyDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

@Service
public class DateService {
	
	@Autowired 
	DateDAO dateDAO;

	public void generateCalendar(int year, boolean toDB) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		int month, mth;
		month = 8;
		for (mth = 1; mth < 10; mth++) {
			month++;
			if (month > 12) {
				month = 1;
				year++;
			}
			Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime(format.parse("01/"
						+ (month < 10 ? "0" + month : month) + "/" + year));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int i, j, k = 1, n = 6, m = 7;
			int[][] monthCalendar = new int[n][m];
			for (i = 0; i < n
					&& k <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); ++i)
				for (j = 0; j < m
						&& k <= calendar
								.getActualMaximum(Calendar.DAY_OF_MONTH); ++j)
					if ((i == 0 && j >= calendar.get(Calendar.DAY_OF_WEEK) - 2)
							|| i != 0) {
						monthCalendar[i][j] = k++;
						if (toDB) {
							MyDate date = new MyDate();
							try {
								date.setDate(format.parse((k-1)+"/"+(month < 10 ? "0" + month : month)+"/"+year));
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
//							System.err.println(date.getDate());
//							System.exit(0);
							dateDAO.addDate(date);
							
						}
					}

			if (!toDB) {
				// Calendar Printing
				System.out.println("\n___________________________\n\n   "
						+ calendar.getDisplayName(Calendar.MONTH,
								Calendar.LONG, Locale.ENGLISH) + "   " + year);
				System.out.println("Ïí Âò Ñð ×ò Ïò Ñá Íä");

				for (i = 0; i < n; ++i, System.out.println())
					for (j = 0; j < m; ++j) {

						if (monthCalendar[i][j] != 0)
							System.out.printf("%2d ", monthCalendar[i][j]);
						else
							System.out.print("   ");
					}
			}
		}

	}
}
