package com.itheima.manyToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "t_student")
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(targetEntity =Teacher.class)
	@JoinTable(name = "s_t",
			joinColumns = {@JoinColumn(name = "c_student_id",referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "c_teacher_id")})
	@Cascade(CascadeType.SAVE_UPDATE)
	private Set<Teacher> teachers = new HashSet<Teacher>();

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
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
		this.teachers = teachers;
	}
}
