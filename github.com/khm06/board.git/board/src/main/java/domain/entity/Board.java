package domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends TimeEntity{
	
	@Id @Generated
	private Long id;
	
	@Column(length = 10, nullable = false)
	private String writer;
	
	@Column(length = 100, nullable = false)
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false)
	private String content;

	private LocalDateTime createdDate;
	
	@Builder
	public Board(Long id, String title, String content, String writer, LocalDateTime createdDate) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.createdDate = createdDate;
	}
	public Long getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getWriter() {
		return writer;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
	}
	

}
