/**
 * 
 */
package com.technicaltest.restusercontrol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 *
 */
@Component
@Entity(name="users")
@Data @AllArgsConstructor @NoArgsConstructor
public class User {
	@Column(name = "name")
	private String  name;
	@Column(name = "username")
	private String  userName;
	@Id
    @Column(name = "email")
	private String  email;
	@Column(name = "phone")
	private Integer phone;
}
