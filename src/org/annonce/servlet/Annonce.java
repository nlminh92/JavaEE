package org.annonce.servlet;
import java.sql.Date;


public class Annonce {
	private Integer id;
	private String title;
	private String description;
	private String adress;
	private Date date;
	private String mail;
	
	public Annonce() {
		
		
	}
	
	public Annonce(Integer id, Date date,String title, String description, String adress,String mail) {
		this.id = id;
		this.title = title; 
		this.description=description;
		this.adress=adress;
		this.date=date;
		this.mail=mail;
		
	}

	

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
