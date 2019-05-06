import java.io.PrintWriter;
import java.util.Calendar;


public class Partial implements Payment {

	private Calendar date;
	private String payee;
	private Integer paid[];
	private Integer remaining[];
	private String category;
	
	public Partial(Calendar date,String payee,Integer paid [],Integer remaining [],String catagory)
	{
		this.date = date;
		this.payee = payee;
		this.paid = paid;
		this.remaining = remaining;
		this.category = catagory;
	}
	@Override
	public void display() {
		String str = String.format("%1$2tm/%<2td/%<tY",this.date.getTime())+String.format(" %-15.15s %s (%s) [%s]",
				this.payee,this.paid[0].toString()+'.'+this.paid[1].toString(),this.remaining[0].toString()+'.'+this.remaining[1].toString(),this.category);
		System.out.println(str);
	}

	@Override
	public void save(PrintWriter out) {
		// TODO Auto-generated method stub
		out.println("partial");
		out.println(String.format("%1$2tm/%<2td/%<tY", this.date.getTime()));
		out.println(this.category);
		out.println(this.payee);
		out.println(this.paid[0].toString()+'.'+this.paid[1].toString());
		out.println(this.remaining[0].toString()+'.'+this.remaining[1].toString());
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
		return this.category;
	}
	@Override
	public Calendar date() {
		// TODO Auto-generated method stub
		return this.date;
	}

}
