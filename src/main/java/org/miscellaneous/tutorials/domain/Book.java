package org.miscellaneous.tutorials.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	
	@Column(name="title")
	String title;
	
	@Column(name="total_pages")
	int totalPages;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="author_id", nullable=false)
	Author author;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book with id: " + id + "title: " + title + " totalpages: " + totalPages;
	}

}
