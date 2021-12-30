package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import domain.entity.Board;
import domain.repository.BoardRepository;
import dto.BoardDto;

@Service
public class BoardService {

	private BoardRepository boardRepository;
	
	public BoardService(BoardRepository boardRepository) {
		this.boardRepository = boardRepository;
		
	}
	
	@Transactional
	public Long savePost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getID();
		
	}
	
	@Transactional
	public List<BoardDto>getBoardList(){
		List<Board> boards = boardRepository.findAll();
		List<BoardDto> boardDtoList = new ArrayList<>();
		
		for(Board board : boards) {
			BoardDto boardDto = BoardDto.builder()
					.id(board.getID())
					.title(board.getTitle())
					.content(board.getContent())
					.writer(board.getWriter())
					.createdDate(board.getCreatedDate())
					.build();
			
			boardDtoList.add(boardDto);
		}
		return boardDtoList;
	}

	@Transactional
	public BoardDto getPost(Long id) {
		Optional<Board> boardWrapper = boardRepository.findById(id);
		Board board = boardWrapper.get();
		
		BoardDto boardDto = boardDto.builder()
				.id(board.getID())
				.title(board.getTitle())
				.content(board.getContent())
				.writer(board.getWriter())
				.createdDate(board.getCreatedDate())
				.build();
		
		return boardDto;
	}
	
	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}
}
