/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-07-30 09:03:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginform_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Page level plugin styles START -->\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/owl.carousel/assets/owl.carousel.css\" rel=\"stylesheet\">\r\n");
      out.write("<link href=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/uniform/css/uniform.default.css\" rel=\"stylesheet\" type=\"text/css\">\r\n");
      out.write("<!-- Page level plugin styles END -->\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write(" \r\n");
      out.write("\tjQuery(document).ready(function(){\r\n");
      out.write("    \t $(\"#btnLOGIN\").click(function() {\r\n");
      out.write("    \t\t func_Login(event);\r\n");
      out.write("    \t });\r\n");
      out.write("    \t \r\n");
      out.write("    \t $(\"#passwd\").keydown(function(event){\r\n");
      out.write("    \t\t if(event.keyCode == 13){\r\n");
      out.write("    \t\t\t func_Login(event);\r\n");
      out.write("    \t\t }\r\n");
      out.write("    \t });\r\n");
      out.write("    \t \r\n");
      out.write("    \t $(\"#btnRegist\").click(function(){\r\n");
      out.write("    \t\t func_Regist(event);\r\n");
      out.write("    \t });\r\n");
      out.write("    }); // end of $(document).ready()---------------------------\t \r\n");
      out.write("    \r\n");
      out.write("\tfunction func_Login(event) {\r\n");
      out.write("    \tif(");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.loginuser != null}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(") {\r\n");
      out.write("    \t\talert(\"이미 로그인 하신 상태입니다.\");\r\n");
      out.write("    \t\t$(\"#userid\").val(\"\");\r\n");
      out.write("    \t\t$(\"#passwd\").val(\"\");\r\n");
      out.write("    \t\t$(\"#userid\").focus();\r\n");
      out.write("    \t\tevent.preventDefault();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tvar userid = $(\"#userid\").val();\r\n");
      out.write("    \tvar pwd = $(\"#passwd\").val();\r\n");
      out.write("    \t\r\n");
      out.write("    \tif(userid.trim() == \"\") {\r\n");
      out.write("    \t\talert(\"아이디를 입력하세요\");\r\n");
      out.write("    \t\t$(\"#userid\").val(\"\");\r\n");
      out.write("    \t\t$(\"#userid\").focus();\r\n");
      out.write("    \t\tevent.preventDefault();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tif(pwd.trim() == \"\") {\r\n");
      out.write("    \t\talert(\"암호를 입력하세요\");\r\n");
      out.write("    \t\t$(\"#passwd\").val(\"\");\r\n");
      out.write("    \t\t$(\"#passwd\").focus();\r\n");
      out.write("    \t\tevent.preventDefault();\r\n");
      out.write("    \t\treturn;\r\n");
      out.write("    \t}\r\n");
      out.write("    \tvar frm = document.loginFrm;\r\n");
      out.write("    \tfrm.action = \"loginEnd.action\";\r\n");
      out.write("    \tfrm.method = \"post\";\r\n");
      out.write("    \tfrm.submit();\r\n");
      out.write("    \t\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("\tfunction func_Regist(event){\r\n");
      out.write("    \t/* var frm = document.RegistFrm;\r\n");
      out.write("    \tfrm.action = \"/auction/memberRegist.action\";\r\n");
      out.write("    \tfrm.method = \"GET\";\r\n");
      out.write("    \tfrm.submit(); */\r\n");
      out.write("    \tlocation.href = \"");
      out.print(request.getContextPath());
      out.write("/memberRegist.action\";\r\n");
      out.write("    }\r\n");
      out.write("\t\r\n");
      out.write("\tfunction gofindPwd(){\r\n");
      out.write("\t\t\r\n");
      out.write("\t\tvar url = \"pwdFind.action?userid=\"+userid;\r\n");
      out.write("\t    window.open(\"\", \"pwdFind\",\r\n");
      out.write("\t                \"left=500px, top=100px, width=300px, height=200px\");\r\n");
      out.write("\t       \r\n");
      out.write("\t    var frm = document.loginFrm;\r\n");
      out.write("\t    \r\n");
      out.write("\t    frm.target = \"pwdFind\";\r\n");
      out.write("\t    \r\n");
      out.write("\t    frm.action=\"pwdFind.action\";\r\n");
      out.write("\t    frm.method=\"post\";\r\n");
      out.write("\t    frm.submit();\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<!-- <div style=\"width:90%; margin: auto; border: solid 0px red;\">\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"width:80%; margin-top:10%; margin-left:10%; height:300px; border: solid 0px blue;\">\r\n");
      out.write("\t\t<h2 class=\"text-primary\">로그인</h2>\r\n");
      out.write("\t\t<p class=\"bg-primary\">&nbsp;</p>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<form name=\"loginFrm\">\r\n");
      out.write("\t\t\t<div class=\"mydiv\" style=\"margin-left: 15%;\">\r\n");
      out.write("\t\t\t\t<span class=\"mydisplay myfont\" >아이디 :</span>\r\n");
      out.write("\t\t\t\t<span class=\"mydisplay myfont\" style=\"margin-top: 30px;\">암&nbsp;&nbsp;&nbsp;호 :</span> \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<div class=\"mydiv\" style=\"margin-left: 5%;\">\r\n");
      out.write("\t\t\t\t<input class=\"mydisplay form-control\" type=\"text\" name=\"userid\" id=\"userid\" size=\"20\" style=\"font-size: 15px;\" />\r\n");
      out.write("\t\t\t\t<input class=\"mydisplay form-control\" style=\"margin-top: 15px; font-size: 15px;\" type=\"password\" name=\"passwd\" id=\"passwd\" size=\"20\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div style=\"margin-top: 5%; margin-left: 30%;\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" style=\"width: 100px; font-size: 14pt;\" type=\"button\" id=\"btnLOGIN\" >확인</button> \r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\" style=\"width: 100px; font-size: 14pt;\" type=\"button\" id=\"btnRegist\" >회원가입</button> \r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("</div> -->\r\n");
      out.write("\r\n");
      out.write("<!-- BEGIN CHECKOUT -->\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\t<div id=\"checkout-content\" class=\"panel-collapse collapse in\">\r\n");
      out.write("\t  <div class=\"panel-body row\">\r\n");
      out.write("\t    <div class=\"col-md-6 col-sm-6 offset-md-3 offset-sm-3\">\r\n");
      out.write("\t      <h3>로그인</h3>\r\n");
      out.write("\t      <p>Super Auction을 이용해주셔서 감사합니다.</p>\r\n");
      out.write("\t      <form role=\"form\" name=\"loginFrm\">\r\n");
      out.write("\t        <div class=\"form-group\">\r\n");
      out.write("\t          <label for=\"email-login\">아이디</label>\r\n");
      out.write("\t          <input type=\"text\" name=\"userid\" id=\"userid\" class=\"form-control\"/>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <div class=\"form-group\">\r\n");
      out.write("\t          <label for=\"password-login\">비밀번호</label>\r\n");
      out.write("\t          <input type=\"password\" name=\"passwd\" id=\"passwd\" class=\"form-control\"/>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <a href=\"javascript:javascript:gofindPwd();\">Forgotten Password?</a>\r\n");
      out.write("\t        <div class=\"padding-top-20\">                  \r\n");
      out.write("\t          <button class=\"btn btn-default\" type=\"button\" id=\"btnLOGIN\">로그인</button>\r\n");
      out.write("\t          <button class=\"btn btn-primary\" type=\"button\" id=\"btnRegist\">회원가입</button>\r\n");
      out.write("\t        </div>\r\n");
      out.write("\t        <hr>\r\n");
      out.write("\t      </form>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t  </div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- END CHECKOUT -->\r\n");
      out.write("<!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/owl.carousel/owl.carousel.min.js\" type=\"text/javascript\"></script><!-- slider for products -->\r\n");
      out.write("<script src='");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/zoom/jquery.zoom.min.js' type=\"text/javascript\"></script><!-- product zoom -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/bootstrap-touchspin/bootstrap.touchspin.js\" type=\"text/javascript\"></script><!-- Quantity -->\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/plugins/uniform/jquery.uniform.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/corporate/scripts/layout.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script src=\"");
      out.print(request.getContextPath() );
      out.write("/resources/assets/pages/scripts/checkout.js\" type=\"text/javascript\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    jQuery(document).ready(function() {\r\n");
      out.write("        Layout.init();    \r\n");
      out.write("        Layout.initOWL();\r\n");
      out.write("        Layout.initTwitter();\r\n");
      out.write("        Layout.initImageZoom();\r\n");
      out.write("        Layout.initTouchspin();\r\n");
      out.write("        Layout.initUniform();\r\n");
      out.write("        Checkout.init();\r\n");
      out.write("    });\r\n");
      out.write("</script>\r\n");
      out.write("<!-- END PAGE LEVEL JAVASCRIPTS -->");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}