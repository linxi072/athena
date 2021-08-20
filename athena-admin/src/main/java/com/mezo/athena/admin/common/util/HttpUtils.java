package com.mezo.athena.admin.common.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * @author qzrs
 */
public class HttpUtils {

    private static final String METHOD_POST = "POST";
    /**
     * 传输类型
     */
    private static final String DEFAULT_CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String JSON_CONTENT_TYPE = "application/json";
    private static final String XML_CONTENT_TYPE = "text/xml";
    private static final String FILE_CONTENT_TYPE = "multipart/form-data";
    /**
     * 边界符
     */
    private static final String BOUNDARY = "******";
    private static final String PRE_FIX = ("\r\n--" + BOUNDARY + "\r\n");
    private static final String END_FIX = ("\r\n--" + BOUNDARY + "--\r\n");

    public void postRequest(String urlStr, String jsonBodyStr) throws IOException {
        postRequest(urlStr, jsonBodyStr, DEFAULT_CONTENT_TYPE, null);
    }

    public void postRequest(String urlStr, String jsonBodyStr, String contentType) throws IOException {
        postRequest(urlStr, jsonBodyStr, contentType, null);
    }

    public void postRequest(String urlStr, String jsonBodyStr, String contentType, Map<String, String> header) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // post请求，参数要放在http正文内，因此需要设为true, 默认情况下是false;
        connection.setDoOutput(true);
        // 设置是否从HttpURLConnection读入，默认情况下是true;
        connection.setDoInput(true);
        // Post 请求不能使用缓存
        connection.setUseCaches(false);
        connection.setRequestMethod(METHOD_POST);
        // 设置超时时间
        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        connection.setRequestProperty("Accept", "*/*");
        connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.9");
        // 设置链接状态
        connection.setRequestProperty("connection", "keep-alive");
        // 设置通用请求类型
        connection.setRequestProperty("Content-Type", contentType);
        connection.setRequestProperty("Charset", "UTF-8");
        if (header != null) {
            Set<String> keys = header.keySet();
            for (String key : keys) {
                connection.setRequestProperty(key, header.get(key));
            }
        }
        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(jsonBodyStr.getBytes());
            outputStream.flush();
        }
        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            StringBuffer buffer = new StringBuffer();
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    buffer.append(line);
                }
            }
        } else {
            System.err.println(urlStr + " Response Code:" + connection.getResponseCode()
                    + "        " + connection.getResponseMessage());
        }
    }

    private String postImage(String urlStr, String formDataKey, String formData, String fileKey, String fileContentType, File file) {
        String dash = "--";
        String boundary = UUIDUtils.timestamp();
        String newLine = "\r\n";
        HttpURLConnection connection = null;
        DataOutputStream outputStream = null;
        FileInputStream inputStream = null;
        try {
            URL url = new URL(urlStr);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent", "Android Multipart HTTP Client 1.0");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);

            outputStream = new DataOutputStream(connection.getOutputStream());
            // form data
            String knowledgeRequest = dash + boundary + newLine +
                    "Content-Disposition: form-data; name=\"" + formDataKey + "\"" + newLine +
                    "Content-Type: text/plain; charset=utf-8" + newLine +
                    newLine +// important !
                    formData + newLine +
                    dash + boundary + newLine;
            outputStream.writeBytes(knowledgeRequest);
            // file data
            String fileHeader = "Content-Disposition: form-data; name=\"" + fileKey + "\"; filename=\"" + file.getName() + "\"" + newLine +
                    "Content-Type:" + fileContentType + newLine +
                    "Content-Transfer-Encoding: binary" + newLine +
                    newLine;// important !
            outputStream.writeBytes(fileHeader);
            byte[] buffer = new byte[1024];
            int count;
            inputStream = new FileInputStream(file);
            while (true) {
                count = inputStream.read(buffer);
                if (count == -1) {
                    break;
                }
                outputStream.write(buffer, 0, count);
            }
            // important !
            outputStream.writeBytes(newLine);
            outputStream.writeBytes(dash + boundary + dash + newLine);
            outputStream.flush();
            int statusCode = connection.getResponseCode();
            StringBuilder response = new StringBuilder();
            if (statusCode == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                return response.toString();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.disconnect();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
