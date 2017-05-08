package jdk8;

import java.math.BigDecimal;

public class Developer {
	
	String name;
	BigDecimal salary;
	Integer  age;
	
	
	Developer(String name,BigDecimal salary, Integer age){
		this.name=name;
		this.salary=salary;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public BigDecimal getSalary() {
		return salary;
	}


	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Developer [name=" + name + ", salary=" + salary + ", age="
				+ age + "]";
	}
	
	

}
