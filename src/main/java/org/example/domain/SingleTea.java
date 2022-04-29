package org.example.domain;

public class SingleTea {
    //==奶茶表属性==
    private int teaId;//奶茶编号
    private String name;//奶茶名称
    private double price;//奶茶价格
    private String type;//奶茶类型
    private int isSale;//1表示可销售，0表示不销售，默认为1
    private String remark;//对奶茶的备注信息

    public SingleTea() {
    }

    public SingleTea(String name, double price, String type, int isSale, String remark) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.isSale = isSale;
        this.remark = remark;
    }

    public SingleTea(int teaId, String name, double price, String type, int isSale, String remark) {
        this.teaId = teaId;
        this.name = name;
        this.price = price;
        this.type = type;
        this.isSale = isSale;
        this.remark = remark;
    }

    public int getTeaId() {
        return teaId;
    }

    public void setTeaId(int teaId) {
        this.teaId = teaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIsSale() {
        return isSale;
    }

    public void setIsSale(int isSale) {
        this.isSale = isSale;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "SingleTea{" +
                "teaId=" + teaId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isSale=" + isSale +
                ", remark='" + remark + '\'' +
                '}';
    }
}
