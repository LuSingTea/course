package com.course.business.controller.admin;

import com.course.business.controller.ControllerExceptionHandler;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;
import com.course.server.dto.PageDto;
import com.course.server.dto.ResponseDto;
import com.course.server.service.ChapterService;
import com.course.server.service.TestService;
import com.course.server.util.ValidatorUtil;
import com.github.pagehelper.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {
    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    private static final String BUSINESS_NAME = "大章";
    @Autowired
    private ChapterService chapterService;

    @RequestMapping("/list")
    public ResponseDto list(@RequestBody ChapterPageDto chapterPageDto) {
        ValidatorUtil.require(chapterPageDto.getCourseId(), "课程ID");

        chapterService.list(chapterPageDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(chapterPageDto);
        return responseDto;
    }

    @RequestMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto) {
        // 保存校验
        ValidatorUtil.require(chapterDto.getName(), "名称");
        ValidatorUtil.require(chapterDto.getCourseId(), "课程ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "课程ID", 1, 8);

        chapterService.save(chapterDto);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable("id") String id) {
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }

}
