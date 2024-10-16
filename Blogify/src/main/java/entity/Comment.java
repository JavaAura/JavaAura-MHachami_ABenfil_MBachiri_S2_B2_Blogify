package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import enums.CommentStatus;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "content", nullable = false)
	private String content;

	@Column(name = "creation_date")
	private LocalDate creationDate;

	@Enumerated(EnumType.STRING) // Maps enum as a string to the database.
	@Column(name = "comment_status")
	private CommentStatus commentStatus = CommentStatus.PENDING;

	@ManyToOne(fetch = FetchType.LAZY) // Specifies a many-to-one relationship with the Article entity.
	@JoinColumn(name = "article") // Column name in the comments table that refers to the article.
	private Article article;

	@ManyToOne(fetch = FetchType.LAZY) // Specifies a many-to-one relationship with the User entity.
	@JoinColumn(name = "user_id") // Column name in the comments table that refers to the user
	private User user;

	public Comment(String content, LocalDate creationDate, Article article, User user) {
		setContent(content);
		setCreationDate(creationDate);
		setArticle(article);
		setUser(user);
	}

	public Comment(int id, String content, LocalDate creationDate, Article article, User user) {
		setContent(content);
		setCreationDate(creationDate);
		setArticle(article);
		setUser(user);
		setId(id);
	}

	public Comment() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CommentStatus getCommentStatus() {
		return commentStatus;
	}

	public void setCommentStatus(CommentStatus commentStatus) {
		this.commentStatus = commentStatus;
	}

	public String getFormattedCreationDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return this.creationDate.format(formatter);
	}

	public String getStatus() {
		return commentStatus.toString();
	}
}