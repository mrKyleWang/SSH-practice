package top.kylewang.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:37
 */
@Entity
@Table(name = "t_order")
@Getter@Setter
public class Order {

    @Id
    @GenericGenerator(name = "myUuid",strategy = "uuid")
    @GeneratedValue(generator = "myUuid")
    private String orderNum;
    private String receiverInfo;
    @Column(precision = 23,scale = 2)   //小数点后保留两位,长度23
    private BigDecimal price;

    //订单关联客户
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name="customer_id") //外键名称
    private Customer customer;
}
