<%-- 
    Document   : uploadPage
    Created on : Jun 26, 2020, 11:15:51 AM
    Author     : tangminhtin
--%>

<%@page import="java.io.IOException"%>
<%@page import="java.io.FileOutputStream"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.setContentType("text/html"); // thiết lập kiểu tập tin cho đối tượng nhận dữ liệu
            response.setHeader("Cache-control", "no-cache"); //cache-control kiểu như bảo client là có cache dữ liệu này hay không, nếu không muốn cache thì chỉ định là no-cache

            String error = ""; // lưu lỗi
            // chuyển đổi đường dẫn nội dung web thành đường dẫn hệ thống tệp đĩa tuyệt đối, đổi kí tự '\\' thành '/'
            String fileOutPath = request.getRealPath("/").replace('\\', '/');
            String lastFileName = "";  // lưu tên hình ảnh

            String contentType = request.getContentType(); // Trả về loại MIME của phần thân của yêu cầu hoặc null nếu loại không được biết.
            String boundary = ""; // lưu boundary
            final int BOUNDARY_WORD_SIZE = "boundary=".length(); // lấy kích thước của "boundary="

            // nếu contentType là null và các ký tự bắt đầu khác với "multipart/form-data" thì sẽ lưu lỗi vào biến error
            if (contentType == null || !contentType.startsWith("multipart/form-data")) {
                error = "Ilegal ENCTYPE : must be multipart/form-data\n";
                error += "ENCTYPE set = " + contentType;
            } else {
                // contentType chứa multipart/form-data; boundary=----WebKitFormBoundaryrA1a25afwThR0T5R
                // lấy ----WebKitFormBoundaryrA1a25afwThR0T5R
                boundary = contentType.substring(contentType.indexOf("boundary=") + BOUNDARY_WORD_SIZE);
                boundary = "--" + boundary; // thêm ------WebKitFormBoundaryrA1a25afwThR0T5R

                try {
                    // lấy toàn bộ nội dung của đối tự request 
                    javax.servlet.ServletInputStream sis = request.getInputStream();
                    byte[] b = new byte[1024]; // tạo mảng với kích thước 1024
                    int x = 0;
                    int state = 0;
                    String name = null, fileName = null, contentType2 = null;
                    java.io.FileOutputStream buffer = null; // khởi tạo buffer

                    // đọc nội dung trong luồng dữ liệu và lưu nó vào mảng b với dạng byte
                    // nếu mảng có giá trị thì 
                    while ((x = sis.readLine(b, 0, 1024)) > -1) {
                        String s = new String(b, 0, x); // chuyển dạng byte sang dạng chuỗi vào lưu vào s
                        // s chứa ------WebKitFormBoundaryrA1a25afwThR0T5R
                        if (s.startsWith(boundary)) { // nếu chuỗi s kí tự bắt đầu giống với chuỗi boundary
                            state = 0;
                            name = null;
                            contentType2 = null;
                            fileName = null;
                            // s chứa Content-Disposition; name; filename
                            // nếu s bắt đầu bằng Content-Disposition và state bằng 0 thì
                        } else if (s.startsWith("Content-Disposition") && state == 0) {
                            state = 1; // thay đổi state
                            // nếu tồn tại filename thì 
                            if (s.indexOf("filename=") == -1) {
                                // lấy "file"; filename="background.png"
                                name = s.substring(s.indexOf("name=") + "name=".length(), s.length() - 2);
                            } else {
                                // lấy name trong chuỗi s (file)
                                name = s.substring(s.indexOf("name=") + "name=".length(), s.lastIndexOf(";"));
                                // lấy tên của tấm hình, -2 dùng để loại bỏ \r\n
                                fileName = s.substring(s.indexOf("filename=") + "filename=".length(), s.length() - 2);

                                if (fileName.equals("\"\"")) { // nếu fileName là rỗng thì sẽ đặt là null
                                    fileName = null;
                                } else {
                                    String userAgent = request.getHeader("User-Agent"); // lấy thông của máy của client
                                    String userSeparator = "/"; // mặc định cho dấu phân cách 

                                    // nếu là máy windows thì dấu phân cách là \\
                                    if (userAgent.indexOf("Windows") != -1) {
                                        userSeparator = "\\";
                                    }

                                    // nếu là máy windows thì dấu phân cách là /
                                    if (userAgent.indexOf("Linux") != -1) {
                                        userSeparator = "/";
                                    }
                                    // lấy tên của tấm hình
                                    fileName = fileName.substring(fileName.lastIndexOf(userSeparator) + 1, fileName.length() - 1);
                                    // nếu tên bắt đầu bằng " thì loại bỏ nó
                                    if (fileName.startsWith("\"")) {
                                        fileName = fileName.substring(1);
                                    }
                                }
                            }

                            name = name.substring(1, name.length() - 1);
                            if (name.equals("file")) { // nếu name là file
                                if (buffer != null) { // và buffer khác null thì đóng buffer
                                    buffer.close(); // đóng buffer
                                }
                                lastFileName = fileName; // lưu fileName vào lastFileName
                                buffer = new FileOutputStream(fileOutPath + fileName); // tạo mới outputstream với đường dẫn của file
                            }
                            // nếu s bắt đầu Content-Type
                        } else if (s.startsWith("Content-Type") && state == 1) {
                            state = 2; // thay đổi state
                            // lấy loại hình ảnh (Content-Type: ), -2 loại bỏ \r\n
                            contentType2 = s.substring(s.indexOf(":") + 2, s.length() - 2);
                        } else if (s.equals("\r\n") && state != 3) {
                            state = 3; // nếu s là \r\n và state khác 3 thành đặt state = 3
                        } else {
                            if (name.equals("file")) { // nếu name là file thì
                                buffer.write(b, 0, x); // viết nội dung của mảng b vào outputsteam
                            }
                        }
                    }

                    sis.close();// đóng servlet input stream
                    buffer.close(); // đóng buffer
                } catch (IOException e) {
                    error = e.toString(); // hiển thị lỗi
                }
            }

            boolean ok = error.equals("");
            if (!ok) { // nếu ok khác rỗng thì in ra lỗi
                out.println(error);
            } else {
                // nếu upload thành công thì hiển thị tên file
%>
        <script language="javascript">
            // history.back(1)
            alert('Uploaded <%=lastFileName%>');
            // window.location.reload(false);
        </script>
        <%
            }
        %>
        <!--    request.getScheme() là http
                request.getServerName() lấy tên server
                request.getServerPort() lấy cổng port
                request.getContextPath() lấy đường dẫn gốc của web
                lastFileName tên tập tin
                http://localhost:8084/UploadFileInJSP/background.png
        -->
             <img src="<% out.print(request.getScheme() + "://" + request.getServerName() + ":"
                         + request.getServerPort() + request.getContextPath() + "/" + lastFileName);%>"
             width="200px" alt="images"/>
    </body>
</html>

<!-- Hình ảnh sẽ lưu ở: /UploadFileInJSP/build/web/ -->

