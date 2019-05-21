<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- Page level plugin styles START -->
<link href="<%=request.getContextPath() %>/resources/assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/assets/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
<link href="<%=request.getContextPath() %>/resources/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
<link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"><!-- for slider-range -->
<link href="<%=request.getContextPath() %>/resources/assets/plugins/rateit/src/rateit.css" rel="stylesheet" type="text/css">
<!-- Page level plugin styles END -->

<%--
	#Buy 1. 구매 리스트 view 단

1. 구매리스트는 회원만 조회할 수 있다.
2. 페이징 처리
3.  
 --%>
<style type="text/css">
	table, tr, th  {
		text-align: center;
	}

</style>

<script type="text/javascript">
	$(document).ready(function(){
		
	});
	
</script>

<div class="main">
<div class="container">      
<!-- BEGIN SIDEBAR & CONTENT -->
<div class="row margin-bottom-40">
  <!-- BEGIN CONTENT -->
<div class="col-md-12 col-sm-12">
  <h1><span style="color: blue; font-weight: bold;">${sessionScope.loginuser.username}</span>님의 상품 등록 목록</h1>
  <div class="goods-page">
    <div class="goods-data clearfix">
      <div class="table-wrapper-responsive">
      <form name="JoinListFrm">
      <table summary="Shopping cart">
        <tr>
          <th class="goods-page-actimage">상품 이미지</th>
          <th class="goods-page-actnum">상품번호</th>
          <th class="goods-page-actname">상품이름</th>
          <th class="goods-page-startday">경매 시작일</th>
          <th class="goods-page-endday">경매 종료일</th>
        </tr>
        
        <c:if test="${AuctionList != null}">
	        <c:forEach var="map" items="${AuctionList}">
	         <tr class="ssi" style="margin-left:5%;">  
	           <td class="goods-page-actimage">
	             <img src="<%= request.getContextPath() %>/resources/actimages/${map.ACTIMAGE}" width="80px"/>
	           </td>
	           <td class="goods-page-actnum">
	             <span id="actnum" name="actnum">${map.ACTNUM}</span>
	           </td>
	           <td class="goods-page-actname">
	             <a href="viewAuction.action?actdnum=${map.ACTDNUM}">${map.ACTNAME}</a>
	           </td>
	           <td class="goods-page-startday">
	             ${map.ACTD_STARTDAY}
	           </td>
	           <td class="goods-page-endday">
	             ${map.ACTD_ENDDAY}
	           </td>
	         </tr>
	        </c:forEach>
        </c:if>
                  
        <c:if test="${AuctionList == null || empty AuctionList}">
		 <tr>
		  	<td colspan="5"><span style="color: red;">등록한 상품이 존재하지 않습니다.</span></td>
		 </tr>
		 </c:if> 
		 
      </table>
	      
      </form>
      	
      </div>
 
    </div>
 	
  </div>
  
</div>

<!-- BEGIN PAGINATOR -->
    <div align="center">${pagebar}</div>
<!-- END PAGINATOR -->
</div>
<!-- END CONTENT -->
<div align="center">
	<button type="button" class="btn btn-default" id="goBack" onClick="location.href='<%=request.getContextPath()%>/myPage.action';">돌아가기</button>
</div>
</div>
<!-- END SIDEBAR & CONTENT -->
</div>
<!-- BEGIN TOP SEARCH -->
			

<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
<script src="<%=request.getContextPath() %>/resources/assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
<script src="<%=request.getContextPath() %>/resources/assets/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
<script src='<%=request.getContextPath() %>/resources/assets/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
<script src="<%=request.getContextPath() %>/resources/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->
<script src="<%=request.getContextPath() %>/resources/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath() %>/resources/assets/plugins/rateit/src/jquery.rateit.js" type="text/javascript"></script>

<script src="<%=request.getContextPath() %>/resources/assets/corporate/scripts/layout.js" type="text/javascript"></script>

<script type="text/javascript">
    jQuery(document).ready(function() {
        Layout.init();    
        Layout.initOWL();
        Layout.initTwitter();
        Layout.initImageZoom();
        Layout.initTouchspin();
        Layout.initUniform();
    });
</script>
<!-- END PAGE LEVEL JAVASCRIPTS -->