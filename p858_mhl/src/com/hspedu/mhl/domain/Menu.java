package com.hspedu.mhl.domain;

public class Menu {
    private Integer id;
    private String name;
    private String type;
    private Double price;

    public Menu() {

    }

    public Menu(Integer id, String name, String type, Double price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    @Override
    public String toString() {
        if(id==3 || id==4){
            return id+"\t\t\t"+name+"\t"+type+"\t\t"+price; //给宫保鸡丁和山药拨鱼 四个字的菜 做的调整？不然对不齐？没别的办法了吧
        }
        return id+"\t\t\t"+name+"\t\t"+type+"\t\t"+price;
    }
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
    
}
