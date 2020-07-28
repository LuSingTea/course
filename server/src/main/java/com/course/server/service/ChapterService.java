package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.domain.Test;
import com.course.server.domain.TestExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.mapper.TestMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName : TestService
 * @Description :
 * @Author : cybersa
 * @Date: 2020-07-20 20:45
 */
@Service
public class ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        ArrayList<ChapterDto> chapterDtoList = new ArrayList<>();
        PageInfo<Chapter> chapterPageInfo = new PageInfo<>(chapters);
        pageDto.setTotal(chapterPageInfo.getTotal());
        for (Chapter chapter : chapters) {
            ChapterDto chapterDto = new ChapterDto();
            BeanUtils.copyProperties(chapter, chapterDto);
            chapterDtoList.add(chapterDto);
        }

        pageDto.setList(chapterDtoList);
    }

}
