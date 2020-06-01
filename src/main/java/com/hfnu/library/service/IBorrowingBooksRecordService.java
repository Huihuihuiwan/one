package com.hfnu.library.service;

import com.hfnu.library.domain.Vo.BorrowingBooksVo;
import com.hfnu.library.utils.page.Page;

import javax.servlet.http.HttpServletRequest;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 22:44
 */
public interface IBorrowingBooksRecordService {
    //查询用户的借书记录
    Page<BorrowingBooksVo> userSelectByPageNum(int pageNum, HttpServletRequest request);

    //分页查询所有的用户借书记录
    Page<BorrowingBooksVo> selectAllByPage(int pageNum);
}
