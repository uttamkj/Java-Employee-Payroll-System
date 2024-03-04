import java.util.ArrayList;
import java.util.*;


abstract class Employee{
    private String name;
    private  int id;

    public Employee(String name,int id){
        this.name= name;
        this.id =id;
    }
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }

    public abstract double calculateSalary();

    public  String toString(){
        return "Employee[name = "+name+" id= "+id+ " salary="+calculateSalary()+"]";
    }
}

class FulltimeEmployee extends Employee{

    private double monthlySalary;
    public FulltimeEmployee(String name,int id,double monthlySalary){
        super(name,id);
        this.monthlySalary= monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}
class parttimeEmployrr extends Employee{
    private int hoursWorked;
    private double hourlyrate;
    private double paritimeSalary;

    parttimeEmployrr(String name,int id,int hoursWorked,double hourlyrate){
        super(name,id);
        this.hourlyrate =hourlyrate;
        this.hoursWorked =hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyrate;
    }
}

class payrollSystem{
    private ArrayList<Employee> employeelist;
    public payrollSystem(){
        employeelist = new ArrayList<>();
    }
    public void  addEmployee(Employee employee){
        employeelist.add(employee);
    }
    public void removeEmployee(int id){
        Employee employeeToremove = null;
        for(Employee employee : employeelist){

            if(employee.getId() == id){
                employeeToremove = employee;
                break;
            }
        }
        if(employeeToremove != null)
            employeelist.remove(employeeToremove);
        else
            System.out.println("Emp not present");
    }
    public void displayEmpolyee(){
        for (Employee employee : employeelist){
            System.out.println(employee);
        }
    }
}

public class Main {
    public static void main(String[] args) {
    payrollSystem payrollSystem =new payrollSystem();
    FulltimeEmployee emp1 = new FulltimeEmployee("deepak",1,70000);
    parttimeEmployrr emp2 = new parttimeEmployrr("manas",2,40,100);

    payrollSystem.addEmployee(emp1);
    payrollSystem.addEmployee(emp2);
        System.out.println("Initial employee details.");
        payrollSystem.displayEmpolyee();

        System.out.println("Remove Employee");
        payrollSystem.removeEmployee(1);

        System.out.println("After removing");
        payrollSystem.displayEmpolyee();
    }
}