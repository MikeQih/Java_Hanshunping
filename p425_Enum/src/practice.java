public class practice {
    public static void main(String[] args) {
        xingQi[] xingqi = xingQi.values();
        System.out.println("===所有的星期信息如下===");
        for(xingQi xq: xingqi){
            System.out.println(xq);
        }
    }
}
enum xingQi{
    MONDAY("星期一"),TUESDAY("星期二"),WEDNESDAY("星期三"),
    THURSAY("星期四"),FRIDAY("星期五"), 
    SATURDAY("星期六"),SUNDAY("星期天");
    private String xingqi_chinese;

    private xingQi(String xingqi_chinese) {
        this.xingqi_chinese = xingqi_chinese;
    }

    public String toString(){
        return xingqi_chinese;
    }



}
