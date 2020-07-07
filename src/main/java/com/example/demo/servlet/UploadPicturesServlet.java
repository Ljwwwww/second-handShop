package com.example.demo.servlet;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Servlet implementation class UploadPicturesServlet
 */
@WebServlet("/uploadPicturesServlet")
public class UploadPicturesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadPicturesServlet() {
        super();
    }

    private static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    private static Random random = new Random();

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String uploadFileName = ""; //上传的文件名
        String fieldName = "";  //表单字段元素的name属性值
        //请求信息中的内容是否是multipart类型
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        //上传文件的存储路径（服务器文件系统上的绝对文件路径）
        String uploadFilePath = request.getSession().getServletContext().getRealPath("upload/");
        if (isMultipart) {
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            try {
                //解析form表单中所有文件
                List<FileItem> items = upload.parseRequest(request);
                System.out.println("items" + items);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {   //依次处理每个文件
                    FileItem item = (FileItem) iter.next();
                    if (item.isFormField()) {  //普通表单字段
                        fieldName = item.getFieldName();   //表单字段的name属性值
                        if (fieldName.equals("user")) {
                            //输出表单字段的值
                            System.out.print(item.getString("UTF-8") + "上传了文件。<br/>");
                        }
                    } else {  //文件表单字段
                        String fileName = item.getName();
                        PrintWriter out = response.getWriter();
                        JSONObject json = new JSONObject();
                        if (fileName != null && !fileName.equals("")) {
                            String FileName = createFileNameUseTime(item.getName());
                            File fullFile = new File(FileName);
                            File saveFile = new File(uploadFilePath, fullFile.getName());

                            item.write(saveFile);
                            uploadFileName = fullFile.getName();
                            System.out.println(uploadFilePath + fullFile);
                            json.put("msg", "seeson");
                            json.put("code", 0);
                            Map<String, Object> data = new HashMap<>();
                            data.put("src", "\\secondhand_shop\\upload\\" + uploadFileName);
                            data.put("title", uploadFileName);
                            json.put("data", data);
                            out.print(json);
                            System.out.print("上传成功后的文件名是：" + uploadFileName);
                        } else {
                            json.put("msg", "seeson");
                            json.put("code", -1);
                            json.put("data", null);
                            out.print(json);
                        }

                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String createFileNameUseTime(String fileName) {
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
        String time = sdf2.format(new Date());
        Integer num = random.nextInt(9000) + 1000;
        return time + num + fileSuffix;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
