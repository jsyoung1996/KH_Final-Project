/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.50
 * Generated at: 2018-07-30 09:05:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class adminMain_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<div class=\"breadcrumbs\">\r\n");
      out.write("            <div class=\"col-sm-4\">\r\n");
      out.write("                <div class=\"page-header float-left\">\r\n");
      out.write("                    <div class=\"page-title\">\r\n");
      out.write("                        <h1>관리자</h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"col-sm-8\">\r\n");
      out.write("                <div class=\"page-header float-right\">\r\n");
      out.write("                    <div class=\"page-title\">\r\n");
      out.write("                        <ol class=\"breadcrumb text-right\">\r\n");
      out.write("                            <li class=\"active\">관리자</li>\r\n");
      out.write("                        </ol>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t\r\n");
      out.write("        <div class=\"content mt-3\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-12\">\r\n");
      out.write("                <div class=\"alert  alert-success alert-dismissible fade show\" role=\"alert\">\r\n");
      out.write("                  <span class=\"badge badge-pill badge-success\">Success</span> You successfully read this important alert message.\r\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\">\r\n");
      out.write("                        <span aria-hidden=\"true\">&times;</span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("           <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                <div class=\"card text-white bg-flat-color-1\">\r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("                        <div class=\"dropdown float-right\">\r\n");
      out.write("                            <button class=\"btn bg-transparent dropdown-toggle theme-toggle text-light\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-cog\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("                                <div class=\"dropdown-menu-content\">\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Another action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Something else here</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <h4 class=\"mb-0\">\r\n");
      out.write("                            <span class=\"count\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${boardCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                        <p class=\"text-light\">게시판 관리</p>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"chart-wrapper px-0\" style=\"height:70px;\" height=\"70\">\r\n");
      out.write("                            <canvas id=\"widgetChart1\"></canvas>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.col-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                <div class=\"card text-white bg-flat-color-2\">\r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("                        <div class=\"dropdown float-right\">\r\n");
      out.write("                            <button class=\"btn bg-transparent dropdown-toggle theme-toggle text-light\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-cog\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("                                <div class=\"dropdown-menu-content\">\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"");
      out.print(request.getContextPath());
      out.write("/adminMain.action\">Action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Another action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Something else here</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <h4 class=\"mb-0\">\r\n");
      out.write("                            <span class=\"count\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${categoryDetailCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                        <p class=\"text-light\">카테고리 관리</p>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"chart-wrapper px-0\" style=\"height:70px;\" height=\"70\">\r\n");
      out.write("                            <canvas id=\"widgetChart2\"></canvas>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.col-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                <div class=\"card text-white bg-flat-color-3\">\r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("                        <div class=\"dropdown float-right\">\r\n");
      out.write("                            <button class=\"btn bg-transparent dropdown-toggle theme-toggle text-light\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-cog\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("                                <div class=\"dropdown-menu-content\">\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Another action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Something else here</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <h4 class=\"mb-0\">\r\n");
      out.write("                            <span class=\"count\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${memberCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                        <p class=\"text-light\">회원 관리</p>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"chart-wrapper px-0\" style=\"height:70px;\" height=\"70\">\r\n");
      out.write("                            <canvas id=\"widgetChart3\"></canvas>\r\n");
      out.write("                        </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.col-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-sm-6 col-lg-3\">\r\n");
      out.write("                <div class=\"card text-white bg-flat-color-4\">\r\n");
      out.write("                    <div class=\"card-body pb-0\">\r\n");
      out.write("                        <div class=\"dropdown float-right\">\r\n");
      out.write("                            <button class=\"btn bg-transparent dropdown-toggle theme-toggle text-light\" type=\"button\" id=\"dropdownMenuButton\" data-toggle=\"dropdown\">\r\n");
      out.write("                                <i class=\"fa fa-cog\"></i>\r\n");
      out.write("                            </button>\r\n");
      out.write("                            <div class=\"dropdown-menu\" aria-labelledby=\"dropdownMenuButton\">\r\n");
      out.write("                                <div class=\"dropdown-menu-content\">\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Another action</a>\r\n");
      out.write("                                    <a class=\"dropdown-item\" href=\"#\">Something else here</a>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <h4 class=\"mb-0\">\r\n");
      out.write("                            <span class=\"count\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${deliverCount}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</span>\r\n");
      out.write("                        </h4>\r\n");
      out.write("                        <p class=\"text-light\">주문/배송 관리</p>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"chart-wrapper px-3\" style=\"height:70px;\" height=\"70\">\r\n");
      out.write("                            <canvas id=\"widgetChart4\"></canvas>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <!--/.col-->\r\n");
      out.write("\r\n");
      out.write("            <!-- <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                <div class=\"social-box facebook\">\r\n");
      out.write("                    <i class=\"fa fa-facebook\"></i>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">40</span> k</strong>\r\n");
      out.write("                            <span>friends</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">450</span></strong>\r\n");
      out.write("                            <span>feeds</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                /social-box\r\n");
      out.write("            </div>/.col\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                <div class=\"social-box twitter\">\r\n");
      out.write("                    <i class=\"fa fa-twitter\"></i>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">30</span> k</strong>\r\n");
      out.write("                            <span>friends</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">450</span></strong>\r\n");
      out.write("                            <span>tweets</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                /social-box\r\n");
      out.write("            </div>/.col\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                <div class=\"social-box linkedin\">\r\n");
      out.write("                    <i class=\"fa fa-linkedin\"></i>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">40</span> +</strong>\r\n");
      out.write("                            <span>contacts</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">250</span></strong>\r\n");
      out.write("                            <span>feeds</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                /social-box\r\n");
      out.write("            </div>/.col\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-lg-3 col-md-6\">\r\n");
      out.write("                <div class=\"social-box google-plus\">\r\n");
      out.write("                    <i class=\"fa fa-google-plus\"></i>\r\n");
      out.write("                    <ul>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">94</span> k</strong>\r\n");
      out.write("                            <span>followers</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li>\r\n");
      out.write("                            <strong><span class=\"count\">92</span></strong>\r\n");
      out.write("                            <span>circles</span>\r\n");
      out.write("                        </li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                /social-box\r\n");
      out.write("            </div> --><!--/.col-->\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xl-6\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"row\">\r\n");
      out.write("                            <div class=\"col-sm-4\">\r\n");
      out.write("                                <h4 class=\"card-title mb-0\">Traffic</h4>\r\n");
      out.write("                                <div class=\"small text-muted\">October 2017</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            <!--/.col-->\r\n");
      out.write("                            <div class=\"col-sm-8 hidden-sm-down\">\r\n");
      out.write("                                <button type=\"button\" class=\"btn btn-primary float-right bg-flat-color-1\"><i class=\"fa fa-cloud-download\"></i></button>\r\n");
      out.write("                                <div class=\"btn-toolbar float-right\" role=\"toolbar\" aria-label=\"Toolbar with button groups\">\r\n");
      out.write("                                    <div class=\"btn-group mr-3\" data-toggle=\"buttons\" aria-label=\"First group\">\r\n");
      out.write("                                        <label class=\"btn btn-outline-secondary\">\r\n");
      out.write("                                            <input type=\"radio\" name=\"options\" id=\"option1\"> Day\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                        <label class=\"btn btn-outline-secondary active\">\r\n");
      out.write("                                            <input type=\"radio\" name=\"options\" id=\"option2\" checked=\"\"> Month\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                        <label class=\"btn btn-outline-secondary\">\r\n");
      out.write("                                            <input type=\"radio\" name=\"options\" id=\"option3\"> Year\r\n");
      out.write("                                        </label>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div><!--/.col-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        </div><!--/.row-->\r\n");
      out.write("                        <div class=\"chart-wrapper mt-4\" >\r\n");
      out.write("                            <canvas id=\"trafficChart\" style=\"height:200px;\" height=\"200\"></canvas>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"card-footer\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <div class=\"text-muted\">Visits</div>\r\n");
      out.write("                                <strong>29.703 Users (40%)</strong>\r\n");
      out.write("                                <div class=\"progress progress-xs mt-2\" style=\"height: 5px;\">\r\n");
      out.write("                                    <div class=\"progress-bar bg-success\" role=\"progressbar\" style=\"width: 40%;\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"hidden-sm-down\">\r\n");
      out.write("                                <div class=\"text-muted\">Unique</div>\r\n");
      out.write("                                <strong>24.093 Users (20%)</strong>\r\n");
      out.write("                                <div class=\"progress progress-xs mt-2\" style=\"height: 5px;\">\r\n");
      out.write("                                    <div class=\"progress-bar bg-info\" role=\"progressbar\" style=\"width: 20%;\" aria-valuenow=\"20\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <div class=\"text-muted\">Pageviews</div>\r\n");
      out.write("                                <strong>78.706 Views (60%)</strong>\r\n");
      out.write("                                <div class=\"progress progress-xs mt-2\" style=\"height: 5px;\">\r\n");
      out.write("                                    <div class=\"progress-bar bg-warning\" role=\"progressbar\" style=\"width: 60%;\" aria-valuenow=\"60\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"hidden-sm-down\">\r\n");
      out.write("                                <div class=\"text-muted\">New Users</div>\r\n");
      out.write("                                <strong>22.123 Users (80%)</strong>\r\n");
      out.write("                                <div class=\"progress progress-xs mt-2\" style=\"height: 5px;\">\r\n");
      out.write("                                    <div class=\"progress-bar bg-danger\" role=\"progressbar\" style=\"width: 80%;\" aria-valuenow=\"80\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li class=\"hidden-sm-down\">\r\n");
      out.write("                                <div class=\"text-muted\">Bounce Rate</div>\r\n");
      out.write("                                <strong>40.15%</strong>\r\n");
      out.write("                                <div class=\"progress progress-xs mt-2\" style=\"height: 5px;\">\r\n");
      out.write("                                    <div class=\"progress-bar\" role=\"progressbar\" style=\"width: 40%;\" aria-valuenow=\"40\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("           <div class=\"col-xl-3 col-lg-6\">\r\n");
      out.write("                <section class=\"card\">\r\n");
      out.write("                    <div class=\"twt-feed blue-bg\">\r\n");
      out.write("                        <div class=\"corner-ribon black-ribon\">\r\n");
      out.write("                            <i class=\"fa fa-twitter\"></i>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"fa fa-twitter wtt-mark\"></div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"media\">\r\n");
      out.write("                            <a href=\"#\">\r\n");
      out.write("                                <img class=\"align-self-center rounded-circle mr-3\" style=\"width:85px; height:85px;\" alt=\"\" src=\"");
      out.print(request.getContextPath());
      out.write("/resources/images/admin.jpg\">\r\n");
      out.write("                            </a>\r\n");
      out.write("                            <div class=\"media-body\">\r\n");
      out.write("                                <h2 class=\"text-white display-6\">Jim Doe</h2>\r\n");
      out.write("                                <p class=\"text-light\">Project Manager</p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"weather-category twt-category\">\r\n");
      out.write("                        <ul>\r\n");
      out.write("                            <li class=\"active\">\r\n");
      out.write("                                <h5>750</h5>\r\n");
      out.write("                                Tweets\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <h5>865</h5>\r\n");
      out.write("                                Following\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <h5>3645</h5>\r\n");
      out.write("                                Followers\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"twt-write col-sm-12\">\r\n");
      out.write("                        <textarea placeholder=\"Write your Tweet and Enter\" rows=\"1\" class=\"form-control t-text-area\"></textarea>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <footer class=\"twt-footer\">\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-camera\"></i></a>\r\n");
      out.write("                        <a href=\"#\"><i class=\"fa fa-map-marker\"></i></a>\r\n");
      out.write("                        New Castle, UK\r\n");
      out.write("                        <span class=\"pull-right\">\r\n");
      out.write("                            32\r\n");
      out.write("                        </span>\r\n");
      out.write("                    </footer>\r\n");
      out.write("                </section>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xl-3 col-lg-6\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"stat-widget-one\">\r\n");
      out.write("                            <div class=\"stat-icon dib\"><i class=\"ti-money text-success border-success\"></i></div>\r\n");
      out.write("                            <div class=\"stat-content dib\">\r\n");
      out.write("                                <div class=\"stat-text\">Total Profit</div>\r\n");
      out.write("                                <div class=\"stat-digit\">1,012</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xl-3 col-lg-6\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"stat-widget-one\">\r\n");
      out.write("                            <div class=\"stat-icon dib\"><i class=\"ti-user text-primary border-primary\"></i></div>\r\n");
      out.write("                            <div class=\"stat-content dib\">\r\n");
      out.write("                                <div class=\"stat-text\">New Customer</div>\r\n");
      out.write("                                <div class=\"stat-digit\">961</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xl-3 col-lg-6\">\r\n");
      out.write("                <div class=\"card\">\r\n");
      out.write("                    <div class=\"card-body\">\r\n");
      out.write("                        <div class=\"stat-widget-one\">\r\n");
      out.write("                            <div class=\"stat-icon dib\"><i class=\"ti-layout-grid2 text-warning border-warning\"></i></div>\r\n");
      out.write("                            <div class=\"stat-content dib\">\r\n");
      out.write("                                <div class=\"stat-text\">Active Projects</div>\r\n");
      out.write("                                <div class=\"stat-digit\">770</div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div class=\"col-xl-6\">\r\n");
      out.write("                <div class=\"card\" >\r\n");
      out.write("                    <div class=\"card-header\">\r\n");
      out.write("                        <h4>World</h4>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"Vector-map-js\">\r\n");
      out.write("                        <div id=\"vmap\" class=\"vmap\" style=\"height: 265px;\"></div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!-- /# card -->\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("        </div> <!-- .content -->\r\n");
      out.write("        \r\n");
      out.write("        \t<script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/vendor/jquery-2.1.4.min.js\"></script>\r\n");
      out.write("    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/plugins.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/main.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/lib/chart-js/Chart.bundle.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/dashboard.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/widgets.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/lib/vector-map/jquery.vmap.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/lib/vector-map/jquery.vmap.min.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/lib/vector-map/jquery.vmap.sampledata.js\"></script>\r\n");
      out.write("    <script src=\"");
      out.print(request.getContextPath());
      out.write("/resources/assets-admin/js/lib/vector-map/country/jquery.vmap.world.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        ( function ( $ ) {\r\n");
      out.write("            \"use strict\";\r\n");
      out.write("\r\n");
      out.write("            jQuery( '#vmap' ).vectorMap( {\r\n");
      out.write("                map: 'world_en',\r\n");
      out.write("                backgroundColor: null,\r\n");
      out.write("                color: '#ffffff',\r\n");
      out.write("                hoverOpacity: 0.7,\r\n");
      out.write("                selectedColor: '#1de9b6',\r\n");
      out.write("                enableZoom: true,\r\n");
      out.write("                showTooltip: true,\r\n");
      out.write("                values: sample_data,\r\n");
      out.write("                scaleColors: [ '#1de9b6', '#03a9f5' ],\r\n");
      out.write("                normalizeFunction: 'polynomial'\r\n");
      out.write("            } );\r\n");
      out.write("        } )( jQuery );\r\n");
      out.write("    </script>");
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
