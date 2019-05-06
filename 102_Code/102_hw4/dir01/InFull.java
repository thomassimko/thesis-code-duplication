import java.io.PrintWriter;
import java.util.Calendar;


public class InFull implements Payment {
	private Integer paid[];
	private Calendar date;
	private String payee;
	private String catagory;
	public InFull(Calendar date,Integer paid[], String payee,String catagory)
	{
		this.date = date;
		this.paid = paid;
		this.payee = payee;
		this.catagory = catagory;
	}
	@Override
	public void display() {
		String str;
		Double payment = (this.paid[0]+this.paid[1]/100.0);
		str = String.format("%1$2tm/%<2td/%<tY",this.date.getTime())+String.format(" %-15.15s %.2f [%s]",
				this.payee,payment,this.catagory);
		
		/*str = String.format("%1$2tm/%<2td/%<tY",this.date.getTime())+String.format(" %-15.15s %s [%s]",
				this.payee,this.paid[0].toString()+'.'+this.paid[1].toString(),this.catagory);*/
		System.out.println(str);

	}

	public void save(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println("in-full");
		out.println(String.format("%1$2tm/%<2td/%<tY", this.date.getTime()));
		out.println(this.catagory);
		out.println(this.payee);
		out.println(this.paid[0].toString()+'.'+this.paid[1].toString());
		out.println("0.00");
	}
	@Override
	public boolean after(Payment p) {
		// TODO Auto-generated method stub
		return this.date.after(p.date());
	}
	@Override
	public boolean before(Payment p) {
		// TODO Auto-generated method stub
		return this.date.before(p.date());
	}
	@Override
	public int amount() {
		// TODO Auto-generated method stub
		return this.paid[0]*100+this.paid[1];
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return this.payee;
	}
	@Override
	public String Catagory() {
		// TODO Auto-generated method stub
		return this.catagory;
	}
	@Override
	public Calendar date() {
		// TODO Auto-generated method stub
		return this.date;
	}

}
