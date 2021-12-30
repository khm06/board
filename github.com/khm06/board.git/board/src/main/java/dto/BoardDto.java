package dto;

import java.time.LocalDateTime;

import domain.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
	private Long id;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createDate;
	private LocalDateTime modifiedDate;
	
	public Board toEntity() {
		Board build = Board.builder()
				.id(id)
				.writer(writer)
				.title(title)
				.content(content)
				.build();
		return build;
	}
	
	@Builder
	public BoardDto(Long id, String title, String content, String writer, LocalDateTime createdDate, LocalDateTime modifiedDate) {
		this.id = id;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createDate = createDate;
		this.modifiedDate = modifiedDate;
	}
	

}
