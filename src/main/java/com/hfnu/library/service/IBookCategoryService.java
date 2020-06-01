package com.hfnu.library.service;

import com.hfnu.library.domain.BookCategory;
import com.hfnu.library.utils.page.Page;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 21:07
 */
public interface IBookCategoryService {

    //图书类别分页查询
    Page<BookCategory> selectBookCategoryByPageNum(int pageNum);

    int deleteBookCategoryById(int bookCategoryId);
}
