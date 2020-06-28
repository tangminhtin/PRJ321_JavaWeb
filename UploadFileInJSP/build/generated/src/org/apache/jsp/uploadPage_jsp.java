package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.IOException;
import java.io.FileOutputStream;

public final class uploadPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            response.setContentType("text/html"); // thiết lập kiểu tập tin cho đối tượng nhận dữ liệu
            response.setHeader("Cache-control", "no-cache"); // cho phép bạn chỉ để đặt một tiêu đề số ít.
            
            String error = ""; // lưu lỗi
            // chuyển đổi đường dẫn nội dung web thành đường dẫn hệ thống tệp đĩa tuyệt đối, đổi kí tự '\\' thành '/'
            String fileOutPath = request.getRealPath("/").replace('\\', '/'); 
            String lastFileName = "";  // lưu tên hình ảnh
            
            String contentType = request.getContentType(); // Trả về loại MIME của phần thân của yêu cầu hoặc null nếu loại không được biết.
            String boundary = "";
            final int BOUNDARY_WORD_SIZE = "boundary=".length(); // lấy kích thước của "boundary="
            
             // nếu contentType là null và các ký tự bắt đầu khác với "multipart/form-data" thì sẽ lưu lỗi vào biến error
            if (contentType == null || !contentType.startsWith("multipart/form-data")) {
                error = "Ilegal ENCTYPE : must be multipart/form-data\n";
                error += "ENCTYPE set = " + contentType;
            } else {
                boundary = contentType.substring(contentType.indexOf("boundary=") + BOUNDARY_WORD_SIZE);
                boundary = "--" + boundary;
                
                try {
                    // lấy toàn bộ nội dung của đối tự request 
                    javax.servlet.ServletInputStream sis = request.getInputStream();
                    byte[] b = new byte[1024]; // tạo mảng với kích thước 1024
                    int x = 0;
                    int state = 0;
                    String name = null, fileName = null, contentType2 = null;
                    java.io.FileOutputStream buffer = null; // khởi tạo buffer
                    
                    while((x = sis.readLine(b, 0, 1024)) > -1) {
                        String s = new String(b, 0, x);
                        
                        if(s.startsWith(boundary)) {
                            state = 0;
                            name = null;
                            contentType2 = null;
                            fileName = null;
                        } else if(s.startsWith("Content-Disposition") && state ==0) {
                            state = 1;
                            if(s.indexOf("filename=") == -1) {
                                name = s.substring(s.indexOf("name=") + "name=".length(), s.length()-2);
                            } else {
                                name = s.substring(s.indexOf("name=") + "name=".length(), s.lastIndexOf(";"));
                                fileName = s.substring(s.indexOf("filename=") + "filename=".length(), s.length()-2);
                                
                                if(fileName.equals("\"\"")) { // nếu fileName là rỗng thì sẽ đặt là null
                                    fileName = null; 
                                } else {
                                    String userAgent = request.getHeader("User-Agent"); // lấy thông của máy của client
                                    String userSeparator = "/"; // mặc định cho dấu phân cách 
                                    
                                    // nếu là máy windows thì dấu phân cách là \\
                                    if(userAgent.indexOf("Windows")!= -1) {
                                        userSeparator = "\\";
                                    }
                                    
                                    // nếu là máy windows thì dấu phân cách là /
                                    if(userAgent.indexOf("Linux")!= -1) { 
                                        userSeparator = "/";
                                    }
                                    
                                    fileName = fileName.substring(fileName.lastIndexOf(userSeparator) + 1, fileName.length()-1);
                                    if(fileName.startsWith("\"")) {
                                        fileName = fileName.substring(1);
                                    }
                                }
                            }
                            
                            name = name.substring(1, name.length()-1);
                            if(name.equals("file")) { // nếu name là file
                                if(buffer!= null) { // và buffer khác null thì đóng buffer
                                    buffer.close();
                                }
                                lastFileName = fileName; // lưu fileName vào lastFileName
                                buffer = new FileOutputStream(fileOutPath + fileName);
                            }
                        } else if(s.startsWith("Content-Type") && state == 1) {
                            state = 2;
                            contentType2 = s.substring(s.indexOf(":") + 2, s.length() -2);
                        } else if(s.equals("\r\n") && state != 3) {
                            state = 3;
                        } else {
                            if(name.equals("file")) {
                                buffer.write(b, 0, x);
                            }
                        }
                    }
                    
                    sis.close();// đóng servlet input stream
                    buffer.close(); // đóng buffer
                } catch(IOException e) {
                    error = e.toString(); // hiển thị lỗi
                }
            }
            
            boolean ok = error.equals("");
            if(!ok) { // nếu ok khác rỗng thì in ra lỗi
                out.println(error);
            } else {
                // nếu upload thành công thì hiển thị tên file
        
      out.write("\n");
      out.write("        <script language=\"javascript\">\n");
      out.write("            // history.back(1)\n");
      out.write("            alert('Uploaded ");
      out.print(lastFileName);
      out.write("');\n");
      out.write("            // window.location.reload(false);\n");
      out.write("        </script>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("<!--    request.getScheme() là http\n");
      out.write("        request.getServerName() lấy tên server\n");
      out.write("        request.getServerPort() lấy cổng port\n");
      out.write("        request.getContextPath() lấy đường dẫn gốc của web\n");
      out.write("        lastFileName tên tập tin\n");
      out.write("        http://localhost:8084/UploadFileInJSP/background.png\n");
      out.write("-->\n");
      out.write("        <img src=\"");
 out.print(request.getScheme() + "://" + request.getServerName() + ":" +
                request.getServerPort() + request.getContextPath() + "/" + lastFileName); 
      out.write("\"\n");
      out.write("                width=\"200px\" alt=\"images\"/>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
