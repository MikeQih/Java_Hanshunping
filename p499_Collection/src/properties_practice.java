import java.util.Hashtable;
import java.util.Properties;

public class properties_practice {
    public static void main(String[] args) {
        //1.Properties继承Hashtable
        //2.可以通过k-v存放数据，key和value不能为null
        Properties properties = new Properties();
        // properties.put(null, "a"); //抛出空指针异常
        // properties.put("a", null); //也会抛出空指针异常
        properties.put("mike", 100);
        properties.put("wang", "UoM");
        properties.put("lucas", 95);
        properties.put("david", 90);
        properties.put("xiaowang", 80);

        //修改
        properties.put("lucas", 94); //相同的key，value会被替换
        System.out.println("properties: "+properties); //无序的

        //查找
        System.out.println(properties.get("mike"));
        System.out.println(properties.getProperty("wang")); //只有value是String时，才能返回对应的String值，其他类型都返回null。

        //删除
        properties.remove("david");
        System.out.println("new properties: "+properties);

        
    }
}
