package com.kan.shoppingcart.domain;
import java.sql.Date;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component   //will create instance of User class --- user
@Table 
public class Category {
private String name;
private String description;
private Date added_date;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getAdded_date() {
	return added_date;
}
public void setAdded_date(Date added_date) {
	this.added_date = added_date;
}
}