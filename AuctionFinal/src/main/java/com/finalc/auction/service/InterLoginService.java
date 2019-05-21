package com.finalc.auction.service;

import java.util.HashMap;
import java.util.List;

import com.finalc.auction.model.MemberVO;
import com.finalc.auction.model.ZipcodeVO;

public interface InterLoginService {

	MemberVO getLoginMember(HashMap<String, String> map);

	int idCheck(String userid);

	int memberRegist(HashMap<String, String> map);

	int memberRegistDetail(HashMap<String, String> map);

	List<HashMap<String, String>> serchZipcode(HashMap<String, String> map);

	int updatePwdUser(HashMap<String, String> map);
	
	int isUserExists(HashMap<String, String> map);

	int memberEdit(HashMap<String, String> map);

	int getTotalCount(int usernum);

	List<HashMap<String, String>> JoinList(HashMap<String, String> map);

	List<HashMap<String, String>> AuctionList(HashMap<String, String> map);


}
