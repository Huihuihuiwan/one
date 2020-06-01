package com.hfnu.library.service.impl;

import com.hfnu.library.domain.BookCategory;
import com.hfnu.library.mapper.BookCategoryMapper;
import com.hfnu.library.service.IBookCategoryService;
import com.hfnu.library.utils.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 21:09
 */
@Service
public class BookCategoryServiceImpl implements IBookCategoryService {
    @Resource
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public Page<BookCategory> selectBookCategoryByPageNum(int pageNum) {
        Page<BookCategory> page = new Page<>();
        List<BookCategory> list = bookCategoryMapper.selectByPageNum((pageNum - 1)*10,10);
        page.setPageSize(10);
        page.setPageNum(pageNum);
        page.setList(list);
        int recordCount = bookCategoryMapper.selectAllCount();
        int pageCount = recordCount / 10;
        if (recordCount%10 != 0){
            pageCount++;
        }
        page.setPageCount(pageCount);
        return page;
    }

    @Override
    public int deleteBookCategoryById(int bookCategoryId) {
        return bookCategoryMapper.deleteByPrimaryKey(bookCategoryId);
    }
}
