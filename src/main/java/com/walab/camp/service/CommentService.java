package com.walab.camp.service;
import java.util.List;

import com.walab.camp.vo.CommentVO;

public interface CommentService {
		public int insert(CommentVO vo); 
		public int delete(int id);
		public int update(CommentVO vo); 
		public CommentVO getComment(int seq); 
		public List<CommentVO> getCommentList();
}
