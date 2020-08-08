package com.course.server.service;

import com.course.server.domain.Chapter;
import com.course.server.domain.ChapterExample;
import com.course.server.dto.ChapterDto;
import com.course.server.dto.ChapterPageDto;
import com.course.server.dto.PageDto;
import com.course.server.mapper.ChapterMapper;
import com.course.server.mapper.TestMapper;
import com.course.server.util.CopyUtil;
import com.course.server.util.UuidUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    public void list(ChapterPageDto chapterPageDto) {
        PageHelper.startPage(chapterPageDto.getPage(), chapterPageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        ChapterExample.Criteria criteria = chapterExample.createCriteria();
        if (!StringUtils.isEmpty(chapterPageDto.getCourseId())) {
            criteria.andCourseIdEqualTo(chapterPageDto.getCourseId());
        }

        List<Chapter> chapters = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> chapterPageInfo = new PageInfo<>(chapters);
        chapterPageDto.setTotal(chapterPageInfo.getTotal());
        List<ChapterDto> chapterDtoList = CopyUtil.copyList(chapters, ChapterDto.class);

        chapterPageDto.setList(chapterDtoList);
    }

    public void save(ChapterDto chapterDto) {
        Chapter copy = CopyUtil.copy(chapterDto, Chapter.class);
        if (StringUtils.isEmpty(chapterDto.getId())) {
            this.insert(copy);
        }
        else {
            this.update(copy);
        }
    }
    protected void insert(Chapter chapter) {
        chapter.setId(UuidUtil.getShortUuid());
        chapterMapper.insert(chapter);
    }

    protected void update(Chapter chapter) {
        chapterMapper.updateByPrimaryKey(chapter);
    }

    public void delete(String id) {
        chapterMapper.deleteByPrimaryKey(id);
    }
}
