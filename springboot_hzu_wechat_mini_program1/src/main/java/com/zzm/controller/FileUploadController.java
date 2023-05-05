package com.zzm.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

// 使用@RestController注解，使该类成为一个RESTful Web服务的控制器
@RestController
public class FileUploadController {

    // 处理"/upload"路径上的POST请求
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("userid") Integer userId, @RequestParam("file") MultipartFile file) {
        // 检查上传的文件是否为空
        if (!file.isEmpty()) {
            try {
                // 获取文件扩展名
                String fileExtension = getFileExtension(file.getOriginalFilename());
                // 生成文件名前缀，包含时间戳和随机字符串
                String filePrefix = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + randomString(4);
                // 创建新的文件名
                String newFileName = filePrefix + "_" + file.getOriginalFilename();
                // 根据文件扩展名判断是图片还是其他文件类型
                String folder = fileExtension.matches("jpg|jpeg|png|gif") ? "img" : "file";
                // 创建上传文件的文件夹路径
                String uploadFolderPath = "uploads" + File.separator + folder + File.separator + userId;
                // 将字符串路径转换为Path对象
                Path uploadPath = Paths.get(uploadFolderPath);
                // 如果目录不存在，则创建
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                // 将文件内容复制到目标路径
                Files.copy(file.getInputStream(), uploadPath.resolve(newFileName));

                // 拼接文件完整路径
                String filePath = uploadFolderPath + File.separator + newFileName;
                // 将路径中的反斜杠替换为斜杠，以便在URL中使用
                String urlFriendlyPath = filePath.replace("\\", "/");
                // 返回成功的响应，包含文件路径
                return new ResponseEntity<>(urlFriendlyPath, HttpStatus.OK);
            } catch (IOException e) {
                // 处理文件上传过程中的异常
                e.printStackTrace();
                // 返回错误响应，表示文件上传失败
                return new ResponseEntity<>("File upload failed", HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            // 返回错误响应，表示文件为空
            return new ResponseEntity<>("File is empty", HttpStatus.BAD_REQUEST);
        }
    }

    // 获取文件扩展名的辅助方法
    private String getFileExtension(String fileName) {
        // 获取文件名中最后一个点的索引
        int dotIndex = fileName.lastIndexOf('.');
        // 如果没有找到点，返回空字符串；否则返回点之后的子字符串
        return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1).toLowerCase();
    }

    // 生成指定长度的随机字符串的辅助方法
    private String randomString(int length) {
        // 定义可用字符集
        String characters = "0123456789abcdefghijklmnopqrstuvwxyz";
        // 初始化结果字符串
        StringBuilder result = new StringBuilder();
        // 创建随机数生成器
        Random random = new Random();
        // 循环生成随机字符串
        for (int i = 0; i < length; i++) {
            // 从字符集中随机选择一个字符并追加到结果字符串中
            result.append(characters.charAt(random.nextInt(characters.length())));
        }
        // 返回生成的随机字符串

        return result.toString();
    }
}
