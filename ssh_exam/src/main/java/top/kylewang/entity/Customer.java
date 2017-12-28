package top.kylewang.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Kyle.Wang
 * 2017/12/27 0027 9:37
 */
@Entity
@Table(name = "t_customer")
@Getter@Setter
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cusName;
    private String cusPhone;
    private String cusImgSrc;

    //客户关联订单
    @OneToMany(targetEntity = Order.class,mappedBy = "customer")
    @Cascade(CascadeType.DELETE)
    private Set<Order> orders;

}
