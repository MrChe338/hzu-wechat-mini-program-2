package com.zzm.controller;

import com.zzm.pojo.resume.WxUserResume;
import com.zzm.service.resume.UserResumeService;
import com.zzm.service.resume.WxUserResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resume")
public class WxUserResumeController {

    @Autowired
    private WxUserResumeService wxUserResumeService;

//    @GetMapping("/get_resume")
//    public ResponseEntity<Integer> getResume() {
////        List<WxUserResume> resumes = wxUserResumeService.getAllResumes();
//
//        return ResponseEntity.ok(3);
//    }
    @GetMapping("/get_resume")
    public ResponseEntity<List<WxUserResume>> getResume() {
        List<WxUserResume> resumes = wxUserResumeService.getAllResumes();
        return ResponseEntity.ok(resumes);
    }
    @Autowired
    private UserResumeService userResumeService;

    @PostMapping("/save")
    public ResponseEntity<WxUserResume> saveUserResume(@RequestBody WxUserResume userResume) {
        System.out.println("Received saveResumeRequest: " + userResume.toString());
        WxUserResume savedUserResume = userResumeService.saveUserResume(userResume);

        return new ResponseEntity<>(savedUserResume, HttpStatus.CREATED);
    }
}
