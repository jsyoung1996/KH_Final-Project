<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.finalc.auction.model.MemberVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!-- ===== #176. (웹채팅관련8) ===== -->
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/jquery-2.0.0.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/json2.js"></script>

<script type="text/javascript" >

    $(document).ready(function(){
    
        var url = window.location.host;          // 웹브라우저의 주소창의 포트까지 가져옴
    	//  alert("url : " + url);
    	    // 결과값  url: 192.168.10.36:9090
    	    
    	var pathname = window.location.pathname; // '/'부터 오른쪽에 있는 모든 경로
    	// 	alert("pathname : " + pathname);
    	    // 결과값  pathname : /board/chatting/multichat.action
    	 	
    	var appCtx = pathname.substring(0, pathname.indexOf("/",7));  // "전체 문자열".indexOf("검사할 문자", 시작순서인덱스번호);   
    	// 	alert("appCtx : " + appCtx);
    	    // 결과값  appCtx : /board/chatting
    	 	
    	var root = url+appCtx;
    	// 	alert("root : " + root);
    		// 결과값   root : 192.168.50.8:9090/board/chatting
    	 	
    	
    	var wsUrl = "ws://"+root+"/multichatstart.action";
    	 // var websocket = new WebSocket("ws://192.168.50.36:9090/board/chatting/multichatstart.action");
    	var websocket = new WebSocket(wsUrl);        
        
    	// alert(wsUrl);
    	
    	// >>>> Javascript WebSocket 이벤트 정리 <<<< 
	    //      onopen    ==>  WebSocket 연결
	    //      onmessage ==>  메시지 수신
	    //      onerror   ==>  전송 에러 발생
	    //      onclose   ==>  WebSocket 연결 해제
    	
    	var messageObj = {};
    	
	    // === 웹소켓에 최초로 연결이 되었을 경우에 실행되어지는 콜백함수
    	websocket.onopen = function() {
    	//	alert("웹소켓 연결됨!!");
    		$("#chatStatus").text("고객센터 채팅방에 연결되었습니다.");
    	
    	/*	
            messageObj = {};  // 초기화
            messageObj.message = "반갑습니다.";
            messageObj.type = "all";
            messageObj.to = "all";
        */    
            // 또는
            messageObj = { message : "입장했습니다."
        		     	 , type : "all"
        		     	 , to : "all" };  // 초기화
            
            websocket.send(JSON.stringify(messageObj));
                        // JSON.stringify() 는 값을 그 값을 나타내는 JSON 표기법으로 변환한다
                        /*
                        JSON.stringify({});                  // '{}'
						JSON.stringify(true);                // 'true'
						JSON.stringify('foo');               // '"foo"'
						JSON.stringify([1, 'false', false]); // '[1,"false",false]'
						JSON.stringify({ x: 5 });            // '{"x":5}'
                        */
        };
    	
    	// === 메시지 수신 콜백함수
        websocket.onmessage = function(evt) {
            $("#chatMessage").append(evt.data);
            $("#chatMessage").append("<br />");
            $("#chatMessage").scrollTop(99999999);
        };
        
        // === 웹소캣 연결 해제 콜백함수
        websocket.onclose = function() {
            // websocket.send("채팅을 종료합니다.");
        }
         
        
        $("#message").keydown(function (key) {
             if (key.keyCode == 13) {
                $("#sendMessage").click();
             }
          });
         
        $("#sendMessage").click(function() {
            if( $("#message").val() != "") {
                 
                messageObj = {};
                messageObj.message = $("#message").val();
                messageObj.type = "all";
                messageObj.to = "all";
                 
                var to = $("#to").val();
                if ( to != "" ) {
                    messageObj.type = "one";
                    messageObj.to = to;
                }
                 
                websocket.send(JSON.stringify(messageObj));
                // JSON.stringify() 는 값을 그 값을 나타내는 JSON 표기법으로 변환한다
                
                $("#chatMessage").append("<span style='color:navy; font-weight:bold;'>[나] ▷ " + $("#message").val() + "</span><br/>");
                $("#chatMessage").scrollTop(99999999);
                 
                $("#message").val("");
            }
        });
    });
</script>
</head>
<body>
	<div id="chatStatus"></div>
	<input type="button" id="sendMessage" value="엔터" />
    <input type="text" id="message" placeholder="메시지 내용"/>
    <c:if test="${sessionScope.loginuser.userid eq 'admin'}">
    	<input type="text" id="to" placeholder="귓속말대상"/>
    </c:if>
    <div id="chatMessage" style="overFlow: auto; max-height: 500px;"></div>
</body>
</html>