package com.hfnu.library.service;

import com.hfnu.library.domain.Vo.BookVo;
import com.hfnu.library.utils.page.Page;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 18:35
 */
public interface IBookService {

    /**
     * 根据书名查找书籍
     * @param bookName
     * @return
     */
    List<BookVo> findBooksByBookName(String bookName);

    /**
     * 根据书籍种类id查找书籍，分页查找
     * @param categoryId
     * @param pageNum
     * @return
     */
    Page<BookVo> findBooksByCategoryId(int categoryId, int pageNum);

}
