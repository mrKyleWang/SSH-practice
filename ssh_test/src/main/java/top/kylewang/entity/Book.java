package top.kylewang.entity;

import javax.persistence.*;

/**
 * @author Kyle.Wang
 * 2017/12/28 0028 20:27
 */
@Entity
@Table(name="t_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 书名
     */
    private String bookname;
    /**
     * 数量
     */
    private String num;
    /**
     * 价格
     */
    private Double prices;
    /**
     * 作者
     */
    private String vender;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Double getPrices() {
        return prices;
    }

    public void setPrices(Double prices) {
        this.prices = prices;
    }

    public String getVender() {
        return vender;
    }

    public void setVender(String vender) {
        this.vender = vender;
    }
}
