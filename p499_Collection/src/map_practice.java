import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class map_practice {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Employee mike = new Employee("mike", 50000, 01);
        Employee lucas = new Employee("lucas", 30000, 02);
        Employee david = new Employee("david", 10000, 03);
        Map hashMap = new HashMap();
        hashMap.put(mike.getId(),mike);
        hashMap.put(lucas.getId(),lucas);
        hashMap.put(david.getId(),david);
        
        Set keyset = hashMap.keySet();
        //m1 显示工资>18000的员工
        for(Object key: keyset){
            Employee obj = (Employee)hashMap.get(key);// obj是emplyee类型
            if(obj.getSal()>18000){
                System.out.println(obj);
            }
        }
        //m2
        System.out.println();
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry next = (Map.Entry)iterator.next();
            Employee emp = (Employee) next.getValue();
            if(emp.getSal()>18000){
                System.out.println(emp);
            }
        }
    }
}
class Employee{
    private String name;
    private double sal;
    private int id;
    public Employee(String name, int sal, int id) {
        this.name = name;
        this.sal = sal;
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getSal() {
        return sal;
    }
    public void setSal(double sal) {
        this.sal = sal;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Employee [name=" + name + ", sal=" + sal + ", id=" + id + "]";
    }
    
    
    
    

}
