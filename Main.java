package OOPS_Project2;
import java.util.*;
abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name=name;
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public abstract double calculateSalary();

    @Override
    public String toString(){
        return "Employee [name="+name+",id="+id+" , salary="+calculateSalary()+"]";
    }
}
class fullTimeEmployee extends Employee{
    private double monthlySalary;

    public  fullTimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary=monthlySalary;
    }
    @Override
    public double calculateSalary(){
        return monthlySalary;
    }
}
class partTimeEmployee extends Employee{
    private int hoursWorked;
    private double hourlyRate;

    partTimeEmployee(String name, int id,int hoursWorked,double hourlyRate){
        super(name,id);
        this.hourlyRate=hourlyRate;
        this.hoursWorked=hoursWorked;
    }
    @Override
    public double calculateSalary(){
        return hourlyRate*hoursWorked;
    }
}
class PayrollSystem{
    private ArrayList<Employee>employeeList;

    PayrollSystem(){
        employeeList=new ArrayList<Employee>();
    }
    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToRemove=null;
        for(Employee employee:employeeList){
            if(employee.getId()==id){
                employeeToRemove=employee;
                break;
            }
        }
        if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
        }
    }
    public void displayEmployees(){
       for(Employee employee:employeeList){
           System.out.println(employee);
       }
    }
}
public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem=new PayrollSystem();
        fullTimeEmployee emp1=new fullTimeEmployee("Md Modassir Raza",1,45000);
        partTimeEmployee part1=new partTimeEmployee("Maruf Adil",2,8,2000);
        
        payrollSystem.addEmployee(emp1);
        payrollSystem.addEmployee(part1);
        System.out.println("Initial employee detail");
        payrollSystem.displayEmployees();
        payrollSystem.removeEmployee(2);
        System.out.println("After Delete");
        payrollSystem.displayEmployees();
    }
}
