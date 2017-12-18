package com.itheima.domain;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_book")
public class Book {
	@Id
	@GenericGenerator(name = "myUuid",strategy = "uuid")
	@GeneratedValue(generator = "myUuid")
	private String id;

	@Column(name = "c_name",length = 30,nullable = false)
	private String name;

	@Temporal(TemporalType.TIMESTAMP)
	private Date publicationDate;

	private Double price;

	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
}
