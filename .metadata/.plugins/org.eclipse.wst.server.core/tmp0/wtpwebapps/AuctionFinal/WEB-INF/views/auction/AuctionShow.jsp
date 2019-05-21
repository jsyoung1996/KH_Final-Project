<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.finalc.auction.model.CategoryVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<STYLE type="text/css">
	.auction {
		margin:10px;
	}
</STYLE>

<Script type="text/javascript">
	
	function goProductPage(actnum){
		
	}
	
</Script>

<div class="container">
<div class="slot">
<div id="AuctionNav">
	<h3>전체경매수 <span id="totalCnt" >${totalCnt}</span> 개</h3>
	<div >
		<select>
			<option value="">선택하세요</option>
			<option value="type1">입찰인기순</option>
			<option value="type2">신규등록순</option>
			<option value="type3">낮은가격순</option>
			<option value="type4">경매이름순</option>
		</select>
	</div>
</div>
<div class="row">

<c:forEach var="auctionvo" items="${auctionList}">
	<c:if test="${auctionvo.fk_cdnum == fk_cdnum || fk_cdnum == null}" >
		<form class="auction" onClick="goProductPage(${auctionvo.actnum})">
			<div class="product-item col-md-3 col-sm-6 col-xs-12">
				<div class="pi-img-wrapper" align="center">
					<img src="<%=request.getContextPath() %>/resources/actimages/${auctionvo.actimage}" 
						 class="img-responsive" 
						 alt="${auctionvo.orgFilename}" 
						 style="width:auto; height:200px;"
						/>
					<div>
						<a href="<%=request.getContextPath() %>/resources/actimages/${auctionvo.actimage}" class="btn btn-default fancybox-button">Zoom</a>
						<a href="#product-pop-up${auctionvo.actdnum}" class="btn btn-default fancybox-fast-view">View</a>
					</div>
				</div>
				<h3><a href="<%=request.getContextPath() %>/viewAuction.action?actdnum=${auctionvo.actdnum}">${auctionvo.actname}</a></h3>
				<div class="pi-price">현재경매가 : ${auctionvo.startprice} 원</div>
				<div class="row"></div>
				<div class="pi-price">즉시구매가 : ${auctionvo.actd_price} 원</div>
				<div class="row"></div>
				<div class="">${auctionvo.actd_endday} 까지</div>
				<div class="row"></div>
				<div align="right">
				<a href="<%=request.getContextPath() %>/viewAuction.action?actdnum=${auctionvo.actdnum}" class="btn btn-default" style="width:100px">상세보기</a>
				</div>
			</div>
		</form>
	</c:if>
</c:forEach>
<c:if test="${empty auctionList}" >
	<div >
		<h2 align="center">해당 카테고리에는 상품이 없습니다....</h2>
	</div>
</c:if>
</div>
</div>
</div>
<div class="row" style="margin-top:10pt; margin-bottom:10pt;"></div>
