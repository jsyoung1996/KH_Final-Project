package com.finalc.auction.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finalc.auction.model.AuctionVO;
import com.finalc.auction.model.BoardVO;
import com.finalc.auction.model.CategoryVO;
import com.finalc.auction.model.CommentVO;
import com.finalc.auction.model.HugiBoardVO;
import com.finalc.auction.model.InterBoardDAO;



@Service
public class BoardServive implements InterBoardService {
   
   // 게시판 Service
   
   @Autowired
   private InterBoardDAO dao;
   
   // 총 게시물 건수 페이징처리 시작 (07.03)
   // 검색어 없는 총 게시물 건수
   @Override
   public int getTotalCount() {
      
      int count = dao.getTotalCount();
      
      return count;
   }

   // 검색어 있는 총 게시물 건수
   @Override
   public int getTotalCount2(HashMap<String, String> map) {
      
      int count = dao.getTotalCount2(map);
      
      return count;
   }// 총 게시물 건수 페이징처리 끝 (07.03)

   // 게시글 목록 시작(07.03)
   // 검색어 없는 게시글목록 보여주기
   @Override
   public List<BoardVO> boardList(HashMap<String, String> map) {
      
      List<BoardVO> boardList = dao.boardList(map);
      
      return boardList;
   }
   // 검색어 있는 게시글목록 보여주기
   @Override
   public List<BoardVO> boardList2(HashMap<String, String> map) {
      
      List<BoardVO> boardList = dao.boardList2(map);
      
      return boardList;
   }// 게시글 목록 끝(07.03)

   // 게시글 쓰기 완료 (07.03 시작)
   // 게시글 쓰기 (파일 첨부 없는거 시작)
   @Override
   public int write_add(BoardVO boardvo) {
      
      if(boardvo.getFk_boardno() == null || boardvo.getFk_boardno().trim().isEmpty()) {
         
         int groupno = dao.getGroupMaxno()+1;
         boardvo.setGroupno(String.valueOf(groupno));
         
      }
      
      int n = dao.write_add(boardvo);
      
      return n;
   }// 게시글 쓰기 (파일 첨부 없는거 끝)
   

   // 게시글 쓰기 (파일 첨부 있는거 시작)
   @Override
   public int write_withFile(BoardVO boardvo) {
      
      if(boardvo.getFk_boardno() == null || boardvo.getFk_boardno().trim().isEmpty()) {
         
         int groupno = dao.getGroupMaxno()+1;
         boardvo.setGroupno(String.valueOf(groupno));
      }
      
      int n = dao. write_withFile(boardvo);
   
      return n;
    // 게시글 쓰기 (파일 첨부 있는거 끝)
   }// 게시글 쓰기 완료 (07.03 끝)

   @Override
   public List<CategoryVO> getCategoryList() {
      List<CategoryVO> categoryList = dao.getCategoryList();
      return categoryList;
   }

   @Override
   public List<CategoryVO> getCategoryDetailList() {
      List<CategoryVO> categoryDetailList = dao.getCategoryDetailList();
      return categoryDetailList;
   }
   // 게시글 1개보기 (조회수 증가 07.05 시작)
   @Override
   public BoardVO getWriteView(String boardno, String userid) {
      BoardVO boardvo = dao.getWriteView(boardno);
      
      if(userid != null && !boardvo.getFk_userid().equals(userid)) {
         dao.setAddViewCount(boardno);
         boardvo = dao.getWriteView(boardno);
         
      }
      
      return boardvo;
   }// 게시글 1개보기 (조회수 증가 07.05 끝)

   // 게시글 1개보기 (조회수 증가없이 07.05 시작)
   @Override
   public BoardVO getNoviewCountWriteView(String boardno) {
      BoardVO boardvo = dao.getWriteView(boardno);
      
      return boardvo;
   }// 게시글 1개보기 (조회수 증가없이 07.05 끝)

   // 댓글 보기 (07.05 시작)
   @Override
   public List<CommentVO> commentList(String boardno) {
      List<CommentVO> comment = dao.commentList(boardno);
      
      return comment;
   }// 댓글 보기 (07.05 끝)

   @Override
   public List<HugiBoardVO> getReviewByActdnum(String actdnum) {
      List<HugiBoardVO> hugiBoardList = dao.getReviewByActdnum(actdnum);
      return hugiBoardList;
   }

   @Override
   public int reviewRegist(HashMap<String, String> map) {
      int n = dao.reviewRegist(map);
      return n;
   }
   
   // 게시글 수정페이지 완료 (07.06 12:26 시작)
   @Override
   public int writeedit(BoardVO boardvo) {
      int n = dao.writeedit(boardvo);
      
      return n;
   }// 게시글 수정페이지 완료 (07.06 12:27 끝)
   
   // 게시글 삭제 완료 (07.06 17:28 시작)
   @Override
   @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor={Throwable.class} )
   public int writedel(HashMap<String, String> map)throws Throwable{
      
      int result1=0, result2=0, n=0;
      boolean bool = false;

         // 원게시글에 딸린 댓글이 있는지 없는지를 확인하기 
         bool = dao.isExistsComment(map);
       

         result1 = dao.deleteContent(map); // 글 1개 삭제하기

         if(bool) { // 원게시글에 딸린 댓글들 삭제하기
            result2 = dao.deleteComment(map);  
         }
      
      
      if( (bool==true && result1==1 && result2>0) ||
         (bool==false && result1==1 && result2==0) )   
         n = 1;
      
      
      return n;
   }// 게시글 삭제 완료 (07.06 17:28 끝)

   // 댓글 쓰기 (07.07 11:53 시작)
   @Override
   @Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, rollbackFor={Throwable.class} )
   public int writeComment(CommentVO commentvo) throws Throwable {
      
      int result = 0;
      
      int n = 0;
      
      n = dao.writeComment(commentvo);
      
      if(n == 1) {
         
         result = dao.updateCommentCount(commentvo.getFk_boardno());
      }
      
      return result;
   } // 댓글 쓰기 (07.07 11:56 끝)


@Override
public List<AuctionVO> getNewAuctionList() {
	
	List<AuctionVO> newAuctionList = dao.getNewAuctionList();
	
	return newAuctionList;
}

@Override
public List<AuctionVO> getAuctionList() {
	
	List<AuctionVO> auctionList = dao.getAuctionList();
	
	return auctionList;
}

@Override
public List<AuctionVO> getBestAuctionList() {
	
	List<AuctionVO> bestAuctionList = dao.getBestAuctionList();
	
	return bestAuctionList;
}

@Override
public List<AuctionVO> getWorstAuctionList() {
	
	List<AuctionVO> worstAuctionList = dao.getWorstAuctionList();
	
	return worstAuctionList;
}


   
   

}