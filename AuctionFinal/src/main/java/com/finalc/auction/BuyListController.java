package com.finalc.auction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalc.auction.common.MyUtil;
import com.finalc.auction.model.AuctionVO;
import com.finalc.auction.model.CategoryVO;
import com.finalc.auction.model.HugiBoardVO;
import com.finalc.auction.model.JoinaclistVO;
import com.finalc.auction.model.MemberVO;
import com.finalc.auction.service.InterBoardService;
import com.finalc.auction.service.InterBuyListService;



@Controller
public class BuyListController {
	
	@Autowired
	private InterBuyListService service;
	
	// LGH(이규호반장꺼 시작 서비스 의존객체)
	@Autowired
	private InterBoardService serviceLGH;
	
	// #Buy 2. 구매 리스트 controller 단
	@RequestMapping(value="/buyList.action", method={RequestMethod.GET})
	public String auctionLogin_buyList(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		HashMap<String, String> map = new HashMap<String, String>();
		
		if (loginuser != null) {
			session.setAttribute("loginuser", loginuser);
			map.put("usernum", loginuser.getUsernum());
		
		
			// ===== #110. 페이징 처리 하기 =====
			String str_currentShowPageNo = req.getParameter("currentShowPageNo"); 
			
			int totalCount = 0;         // 총게시물건수
			int sizePerPage = 5;       // 한 페이지당 보여줄 게시물 건수 
			int currentShowPageNo = 0;  // 현재 보여주는 페이지 번호로서, 초기치로는 1페이지로 설정함.
			int totalPage = 0;          // 총페이지수 (웹브라우저상에 보여줄 총 페이지 갯수)
			
			int startRno = 0;           // 시작행 번호
			int endRno = 0;             // 끝행 번호
			
			int blockSize = 5;         // "페이지바" 에 보여줄 페이지의 갯수 
			
			/*
			    ==== 총페이지수 구하기 ====    
			        검색조건이 없을 때의 총페이지 수와
			        검색조건이 있을 때의 총페이지 수를 구해야 한다.
			        
			        검색조건이 없을 때의 총페이지 수 ==> colname 과 search 값이 null 인 것이고,
			        검색조건이 있을 때의 총페이지 수 ==> colname 과 search 값이 null 이 아닌 것이다.        
			 */
			// 먼저 총게시물 건수를 구한다.
			
			totalCount = service.getTotalCount(); // 검색어가 없는 총게시물 건수
			
			
			totalPage = (int)Math.ceil((double)totalCount/sizePerPage);
			
			
			
			if(str_currentShowPageNo == null) {
				// 게시판 초기화면에 보여지는 것은 
				// req.getParameter("currentShowPageNo"); 값이 없으므로
				// str_currentShowPageNo 는 null 이 된다.
				
				currentShowPageNo = 1; 
			}
			else {
				try {
					currentShowPageNo = Integer.parseInt(str_currentShowPageNo);
					
					if(currentShowPageNo < 1 || currentShowPageNo > totalPage) {
						currentShowPageNo = 1;
					}
					
					/*if (currentShowPageNo > 1) {
						
					}*/
					
				} catch (NumberFormatException e) {
					currentShowPageNo = 1;
				}
			}
			
			// **** 가져올 게시글의 범위를 구한다.(공식임!!!) ****
			/*
			      currentShowPageNo    startRno    endRno
			      ---------------------------------------
			           1 page      ==>     1          5
			           2 page      ==>     6         10
			           3 page      ==>    11         15
			           4 page      ==>    16         20
			           5 page      ==>    21         25
			           6 page      ==>    26         30
			           7 page      ==>    31         35
			 */
			
			startRno = (currentShowPageNo - 1) * sizePerPage + 1;
			endRno = startRno + sizePerPage - 1;
			
			// ==== #111. 페이징 처리를 위해 startRno, endRno 를 map 에 추가하여 
			//            파라미터로 넘겨서 select 되도록 한다. 
			map.put("startRno", String.valueOf(startRno));
			map.put("endRno", String.valueOf(endRno));
			
			/*String pagebar = "<li>";
			
			pagebar += MyUtil.getAuctionPageBar("buyList.action", currentShowPageNo, sizePerPage, totalPage, blockSize);     
			pagebar += "</li>";*/
			
			
			
			String pagebar = MyUtil.getAuctionPageBar("buyList.action", currentShowPageNo, sizePerPage, totalPage, blockSize);     
			
			
			List<HashMap<String, String>> buyMapList = new ArrayList<HashMap<String, String>>();
			buyMapList = service.getBuyList(map);
			
			
			
			
			System.out.println("4. Controller 단 buyMapList");
			req.setAttribute("buyMapList", buyMapList);
			req.setAttribute("pagebar", pagebar);
			req.setAttribute("startRno", startRno);
			req.setAttribute("endRno", endRno);
			req.setAttribute("currentShowPageNo", currentShowPageNo);
			req.setAttribute("coin", loginuser.getCoin());
		}	
		return "buy/buyList.tiles";
		
	}
	
	// #Auction 1. 사용자가 경매에 등록한 상품의 정보를 조회한다.
	@RequestMapping(value="/viewAuction.action", method={RequestMethod.GET})
	public String viewAuction(HttpServletRequest req) {
		System.out.println("viewAuction.action(상품세부조회) 시작");
		String actdnum = req.getParameter("actdnum");		
		
		List<HugiBoardVO> hugiBoardList = serviceLGH.getReviewByActdnum(actdnum);
		
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		
		AuctionVO acvo = service.viewAuction(actdnum);
		CategoryVO cvo = service.getCategoryName(acvo.getActnum());
		
		@SuppressWarnings("unchecked")
		List<AuctionVO> actViewList2 = (List<AuctionVO>)session.getAttribute("actViewList");
		List<AuctionVO> actViewList = new ArrayList<AuctionVO>();
		
		if(actViewList2 != null) {
			for(int i=0; i<actViewList2.size(); i++) {
				if(actViewList2.get(i).getActnum().equals(acvo.getActnum())) {
					actViewList2.remove(i);
					break;
				}
			}
		}
		
		actViewList.add(acvo);
		if(actViewList2 != null) {
			actViewList.addAll(actViewList2);
		}
			
		session.removeAttribute("actViewList");
		session.setAttribute("actViewList", actViewList);
		
		String nowprice = "";
		
		// 입찰내역 중 최고 입찰금
		String tenderprice = service.getTender(acvo.getActnum());
		//System.out.println("시작가격 : " + acvo.getStartprice() + "원");
		// 입찰 수
		int count = service.getTenderCount(acvo.getActnum());
		
		
		if (tenderprice == null || count == 0) {
			// 입찰금이 없거나 입찰 수가 없는 경우라면 현재가는 시작가(고정가)로 시작한다.
			nowprice = acvo.getStartprice();
		}
		else {
			// 입찰금이 있거나 입찰내역이 있는 경우 최고 입찰금을 현재가로 지정한다.  
			nowprice = tenderprice;
		}
		
		
	    List<CategoryVO> categoryList = serviceLGH.getCategoryList();
	      
	    List<CategoryVO> categoryDetailList = serviceLGH.getCategoryDetailList();
	      
	    session.setAttribute("categoryList", categoryList);
	    session.setAttribute("categoryDetailList", categoryDetailList);
		
		int pr1 = Integer.parseInt(nowprice);
		int pr2 = Integer.parseInt(acvo.getActd_price());
		int hugisize = hugiBoardList.size();
		
		req.setAttribute("hugiBoardList", hugiBoardList);
		req.setAttribute("acvo", acvo);
		req.setAttribute("cvo", cvo);
		req.setAttribute("nowprice", nowprice);
		//System.out.println("nowprice : " + nowprice + "원");
		req.setAttribute("count", count);
		req.setAttribute("pr1", pr1);
		req.setAttribute("pr2", pr2);
		req.setAttribute("actdnum", actdnum);
		req.setAttribute("hugisize", hugisize);
		
		return "auction/auctionDetail.tiles";
	}
	
	@RequestMapping(value="/reviewRegistLGH.action", method={RequestMethod.GET})  
	public String auctionLogin_reviewRegist(HttpServletRequest req, HttpServletResponse res) {
				
		String actdnum = req.getParameter("actdnum");
		String fk_userid = req.getParameter("fk_userid");
		String ep_content = req.getParameter("ep_content");
		System.out.println("ep_content : " + ep_content);
		String ep_satisfaction = req.getParameter("ep_satisfaction");
		String msg = "", loc = "";		
		int n = 0;
		HashMap<String, String> map = new HashMap<String, String>();
		if (fk_userid.trim() != "" && !ep_content.trim().isEmpty()) { 
			map.put("actdnum", actdnum);
			map.put("fk_userid", fk_userid);
			map.put("ep_content", ep_content);
			map.put("ep_satisfaction", ep_satisfaction);
			n = serviceLGH.reviewRegist(map);
		}
		List<HugiBoardVO> hugiBoardList = serviceLGH.getReviewByActdnum(actdnum);
		if(n == 1) {
			msg = "댓글 등록 완료";
			loc = "viewAuction.action?actdnum="+actdnum+"&hugiBoardList="+hugiBoardList;
		}
		else {
			msg = "댓글 등록 실패";
			loc = "viewAuction.action?actdnum="+actdnum+"&hugiBoardList="+hugiBoardList;
		}
		req.setAttribute("msg", msg);
		req.setAttribute("loc", loc);
			
		return "msg.notiles";
	}
	
	// 입찰 시작
	@RequestMapping(value="/tender.action", method={RequestMethod.POST})
	public String tender(HttpServletRequest req) {
		System.out.println("tender.action(입찰) 시작");
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		if (loginuser == null) {
			String msg = "먼저 로그인 하십시오.";
			String loc = "javascript:self.close();";
			req.setAttribute("msg", msg);
			req.setAttribute("loc", loc);
			return "msg.notiles";
		}
		else {
		String actnum = req.getParameter("actnum");
		String actname = req.getParameter("actname");
		String actd_endday = req.getParameter("actd_endday");
		String actd_qty = req.getParameter("actd_qty");
		String startprice = req.getParameter("startprice");
		String actd_price = req.getParameter("actd_price");
		String nowprice = req.getParameter("nowprice");
		String actd_lowertenderprice = req.getParameter("actd_lowertenderprice");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("actnum", actnum);
		map.put("actname", actname);
		map.put("actd_endday", actd_endday);
		map.put("actd_qty", actd_qty);
		map.put("startprice", startprice);
		map.put("actd_price", actd_price);
		map.put("usernum", loginuser.getUsernum());
		map.put("actd_lowertenderprice", actd_lowertenderprice);
		
		System.out.println("BuyListController.java 상품명 : " + actname);
		
		req.setAttribute("map", map);
		req.setAttribute("nowprice", nowprice);
		req.setAttribute("coin", loginuser.getCoin());
		
		return "tender.notiles";
		}
	}
	
	// 즉시구매 시작
	@RequestMapping(value="/quickgumae.action", method={RequestMethod.POST}) 
	public String quickgumae(HttpServletRequest req) {	
		System.out.println("quickgumae.action(즉시구매) 시작");
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		if (loginuser == null) {
			req.setAttribute("msg", "로그인을 먼저 하십시오!");
			req.setAttribute("loc", "login.action");
			return "msg.notiles";
		}
		else {
			// 즉시구매에 필요한 것은
			// 1. 세션 회원번호
			// 2. 세션 코인
			// 3. 즉시구매가
			// 4. 상품번호
			// 5. 상품 종료일
			// 6. 상품 status 0으로 업데이트 시켜주기
			// 7. 상품을 등록한 회원번호
			// 8. 등등
			String actnum = req.getParameter("actnum");
			String actdnum = req.getParameter("actdnum");
			String actd_price = req.getParameter("actd_price"); 
			String fk_usernum = req.getParameter("fk_usernum");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("usernum", loginuser.getUsernum());
			map.put("coin", loginuser.getCoin());
			map.put("actnum", actnum);
			map.put("actdnum", actdnum);
			map.put("actd_price", actd_price);
			map.put("fk_usernum", fk_usernum);
			map.put("tenderprice", actd_price);
			
			JoinaclistVO jvo = service.getMemberDeposit(actnum);
			int price = Integer.parseInt(actd_price);
			if (jvo != null) {	// 상품에 대한 입찰 내역이 있는 경우
				map.put("tenderpriceold", jvo.getTenderprice());
				//System.out.println("tenderpriceold : " + jvo.getTenderprice());
				map.put("usernumfail", jvo.getFk_usernum());
				
				// 제일 마지막에 입찰 성공시킨회원(제일 입찰금이 높은회원)의 보증금을 돌려주고자 한다.
				int result0 = service.rollbackDeposit(map);
				
				// 즉시구매
				int result = service.quickTender(map);
				if (result0+result == 7) {
					loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) - price));
					req.setAttribute("msg", "즉시 구매 성공!!");
					req.setAttribute("loc", "viewAuction.action?actdnum="+actdnum);
					return "msg.notiles";
				}
				else {
					req.setAttribute("msg", "즉시 구매 실패!!");
					req.setAttribute("loc", "javascript:history.back();");
					return "msg.notiles";
				}
			}
			else {	// 상품에 대한 입찰 내역이 없는 경우
				
				int result = service.quickTender(map);
				if (result == 6) {
					loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) - price));
					req.setAttribute("msg", "즉시 구매 성공!!");
					req.setAttribute("loc", "viewAuction.action?actdnum="+actdnum);
					return "msg.notiles";
				}
				else {
					req.setAttribute("msg", "즉시 구매 실패!!");
					req.setAttribute("loc", "javascript:history.back();");
					return "msg.notiles";
				}
			}
		}
	}
	
	// 입찰하기 끝
	@RequestMapping(value="/inputTender.action", method={RequestMethod.POST})
	public String inputTender(HttpServletRequest req) {
		System.out.println("inputTender.action(입찰) 완료");
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		if (loginuser == null) {
			req.setAttribute("msg", "로그인을 먼저 하십시오!");
			req.setAttribute("loc", "login.action");
			return "msg.notiles";
		}
		else {
			String actnum = req.getParameter("actnum");
			System.out.println("actnum : " + actnum);
			String tenderprice = req.getParameter("tenderprice");
			System.out.println("tenderprice : " + tenderprice);
			// if (tenderprice == null) {
			String deposit = req.getParameter("deposit");
			System.out.println("inputTender.action(deposit) : " + deposit);
			
			// 상품에 대한 전 입찰 내역 조회
			JoinaclistVO jvo = service.getMemberDeposit(actnum);
			
			/*if (tenderpriceold == null) {
				tenderpriceold = "0";
			}
			System.out.println("tenderpriceold : " + tenderpriceold);*/
			
			String actdnum = req.getParameter("actdnum");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("actnum", actnum);
			map.put("actdnum", actdnum);
			map.put("usernum", loginuser.getUsernum());
			map.put("tenderprice", tenderprice);
			map.put("deposit", deposit);
			// 상품에 대한 입찰 내역이 있다면
			
			if (jvo != null) {	// 상품에 대한 입찰 내역이 있는 경우
				map.put("tenderpriceold", jvo.getTenderprice());
				//System.out.println("tenderpriceold : " + jvo.getTenderprice());
				map.put("usernumfail", jvo.getFk_usernum());
				if (loginuser.getUsernum().equals(jvo.getFk_usernum())) {
					loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) + Integer.parseInt(jvo.getTenderprice())/10));
				}
				// 제일 마지막에 입찰 성공시킨회원(제일 입찰금이 높은회원)의 보증금을 돌려주고자 한다.
				int result0 = service.rollbackDeposit(map);
				
				
				
				// 경매 입찰
				int result = service.inputTender(map);
				if (result0+result == 3) {
					loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) - Integer.parseInt(deposit)));
					req.setAttribute("msg", "경매 입찰 성공!!");
					req.setAttribute("loc", "javascript:opener.location.reload(); self.close();");
					return "msg.notiles";
				}
				else {
					req.setAttribute("msg", "경매 입찰 실패!!");
					req.setAttribute("loc", "javascript:opener.location.reload(); self.close();");
					return "msg.notiles";
				}
			}
			else {	// 상품에 대한 입찰 내역이 없는 경우
				// 경매 입찰
				int result = service.inputTender(map);
				if (result == 2) {
					loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) - Integer.parseInt(deposit)));
					req.setAttribute("msg", "경매 입찰 성공!!");
					req.setAttribute("loc", "javascript:opener.location.reload(); self.close();");
					return "msg.notiles";
				}
				else {
					req.setAttribute("msg", "경매 입찰 실패!!");
					req.setAttribute("loc", "javascript:opener.location.reload(); self.close();");
					return "msg.notiles";
				}
			}
			
			
			
		}
		
	}
	
	// 낙찰 취소
	@RequestMapping(value="/awardCancel.action", method={RequestMethod.POST})
	public String awardCancel(HttpServletRequest req) throws Throwable {
		System.out.println("awardCancel.action(낙찰취소) 시작");
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		
		String panmaeusernum = req.getParameter("panmaeusernum");
		String awardprice = req.getParameter("awardprice");
		String actdnum = req.getParameter("actdnum");
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("panmaeusernum", panmaeusernum);
		map.put("awardprice", awardprice);
		map.put("usernum", loginuser.getUsernum());
		map.put("actdnum", actdnum);
		
		int cancel = service.awardCancel(map);
		
		int sample = Integer.parseInt(awardprice);
		
		if (cancel == 2) {
			req.setAttribute("msg", "낙찰이 취소되었습니다. 보증금이 판매자에게 "+(sample/10)+"원 입금됩니다.");
			req.setAttribute("loc", "buyList.action");
		}
		else if (cancel != 2){
			req.setAttribute("msg", "낙찰 취소 실패!!");
			req.setAttribute("loc", "javascript:opener.location.reload();");
		}
		
		return "msg.notiles";
	}
	
	@RequestMapping(value="/pay.action", method={RequestMethod.POST}) 
	public String pay(HttpServletRequest req) throws Throwable {
		System.out.println("pay.action(결제) 시작");
		HttpSession session = req.getSession();
		MemberVO loginuser = (MemberVO)session.getAttribute("loginuser");
		// 결제를 하기 위한 조건은
		// 1. 낙찰가
		// 2. 회원본인의 회원번호 세션으로 받아올 것이기 때문에 생략
		// 3. 판매자의 회원번호
		// 4. 상품번호
		// 5. 등등
		// 하고 나서
		// 6. 배송테이블 입력
		String awardprice = req.getParameter("awardprice");
		String panmaeusernum = req.getParameter("panmaeusernum");
		String actdnum = req.getParameter("actdnum");
		String actnum = req.getParameter("actnum");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("tenderpriceold", awardprice);
		map.put("actd_price", awardprice);
		map.put("usernumfail", loginuser.getUsernum());
		map.put("fk_usernum", panmaeusernum);
		map.put("usernum", loginuser.getUsernum());
		map.put("actdnum", actdnum);
		map.put("actnum", actnum);
		
		int result = service.productPay(map);
		
		if (result == 4) {
			loginuser.setCoin(String.valueOf(Integer.parseInt(loginuser.getCoin()) - Integer.parseInt(awardprice)));
			req.setAttribute("msg", ""+awardprice+"원 결제가 완료되었습니다.");
			req.setAttribute("loc", "buyList.action");
		}
		else if (result != 4){
			req.setAttribute("msg", ""+awardprice+"원 결제를 실패하였습니다.");
			req.setAttribute("loc", "javascript:history.back();");
		}
		
		return "msg.notiles";
	}
	
	
	/*// 낙찰
	@RequestMapping(value="/inputAward.action", method={RequestMethod.POST})
	public String inputAward(HttpServletRequest req) throws Throwable {		
		System.out.println("inputAward.action(낙찰) 시작");
		String actnum = req.getParameter("actnum");
		String actdnum = req.getParameter("actdnum");
		String nowprice = req.getParameter("nowprice");
		String actd_price = req.getParameter("actd_price");
		System.out.println("(낙찰)받아온 값들 : " +actnum+ ", " +actdnum+ ", " + nowprice);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("actnum", actnum);
		map.put("actdnum", actdnum);
		map.put("actd_price", actd_price);
		map.put("nowprice", nowprice);
		
		
		// 입찰 내역을 조회하여 가장 높은 입찰가격의 회원번호와 경매번호와 낙찰가격(최상 입찰가)을 가져온다.
		JoinaclistVO jvo = service.searchTender(map);
		if (jvo != null) {
			System.out.println("(낙찰)fk : " + jvo.getFk_usernum());
			map.put("fk_usernum", jvo.getFk_usernum());
			int award = 0;
			try {
				award = service.inputAward_transaction(map);
				if (award == 2) {
					// 수량 업데이트
					req.setAttribute("msg", "경매가 종료되었습니다.");
					req.setAttribute("loc", "viewAuction.action?actdnum="+actdnum);									
				}
				else if (award != 2){
					req.setAttribute("msg", "낙찰 실패!! 또는 경매가 이미 종료되었습니다.");
					req.setAttribute("loc", "viewAuction.action?actdnum="+actdnum);									
				}
			} catch (Exception e) {
				req.setAttribute("msg", "경매가 종료된 상품입니다.");
				req.setAttribute("loc", "viewAuction.action?actdnum="+actdnum);								
			}
			return "msg.notiles";
		}
		else {
			int n = service.updateAuctionStatus(map);
			if (n > 0) {
				req.setAttribute("msg", "입찰 없이 경매가 종료되었습니다.");
				req.setAttribute("loc", "index.action");
			}
			
			return "msg.notiles";
		}
	}*/
}