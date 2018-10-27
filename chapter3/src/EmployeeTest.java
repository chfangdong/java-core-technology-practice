import java.util.Date;
import java.util.GregorianCalendar;

import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;


class Employee
{
	private final String name;
	private double salary;
	private Date hireDay;

	public Employee(String n, double s, int year, int month, int day, String address) {
		name = n;
		salary = s;
		GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month, -1, -1, day);
		hireDay = gregorianCalendar.getTime();

	}
	
	public String getName()
	{
		return this.name;
	}
	
	
	public double getSalary()
	{
		return salary;
	}
	
	public Date getHireDay()
	{
		return hireDay;
	}
	
	public void raiseSalary(double byPercent)
	{
		double raise = this.salary * byPercent/100;
		this.salary += raise; 
	}
}

class Manager extends Employee{
	private double bonus;
	
	@Override
	public String toString() {
		return "I am manager class";
	}
	
	public Manager(String n, double s, int year, int month, int day, String address, double b) {
		super(n, s, year, month, day, address);
		bonus = b;
	}
	
	public void setBonus(double b) {
		bonus = b; 
	}
	
	public double getSalary()
	{
		return super.getSalary()+bonus;
	}

}