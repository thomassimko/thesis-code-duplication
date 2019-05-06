import java.util.Calendar;

public class Item implements RSSItem {

	private String title;
	private String date;
	private String link;
	private Calendar datez;

	public Item(String title, String link, String date) throws BadItemException {
		this.title = title;
		this.date = date;
		this.date = this.date.substring(5, 25);
		this.link = link;
		this.datez = this.getDatez();
		if (this.datez == null)
			throw new BadItemException();

	}

	@Override
	public String getTitle() {
		return title;
	}


	private Calendar getDatez() {
		try{
		int year = Integer.parseInt(this.date.substring(7, 11));
		String m = this.date.substring(3, 6);
		int month;
		if (m.equals("Jan"))
			month = 0;
		else if (m.equals("Mar"))
			month = 2;
		else if (m.equals("May"))
			month = 4;
		else if (m.equals("Jul"))
			month = 6;
		else if (m.equals("Sept"))
			month = 8;
		else if (m.equals("Nov"))
			month = 10;
		else if (m.equals("Feb"))
			month = 1;
		else if (m.equals("Apr"))
			month = 3;
		else if (m.equals("Jun"))
			month = 5;
		else if (m.equals("Aug"))
			month = 7;
		else if (m.equals("Oct"))
			month = 9;
		else if (m.equals("Dec"))
			month = 11;
		else {
			return null;
		}
		int date = Integer.parseInt(this.date.substring(0, 2));
		int hourOfDay = Integer.parseInt(this.date.substring(12, 14));
		int minute = Integer.parseInt(this.date.substring(15, 17));
		int second = Integer.parseInt(this.date.substring(18, 20));

		Calendar day = Calendar.getInstance();
		day.set(year, month, date, hourOfDay, minute, second);

		return day;
		}
		catch (Exception e)
		{
			return null;
		}
	}

	@Override
	public String getLink() {
		return link;
	}

	@Override
	public Calendar getDate() {
		// TODO Auto-generated method stub
		return this.datez;
	}
}
