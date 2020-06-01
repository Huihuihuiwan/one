package com.hfnu.library.service;

import com.hfnu.library.domain.Book;
import com.hfnu.library.domain.BookCategory;

import java.util.List;

/**
 * Author : wendy_wan
 * Created : 2020/2/3 23:02
 */
public interface IAdminService {

    //验证用户是否存在
    boolean adminIsExist(String name);

    //管理员登录
    boolean adminLogin(String name, String password);

    //录入新书
    boolean addBook(Book book);

    //获取所有图书类别
    List<BookCategory> getBookCategorys();

    //增加图书类别
    boolean addBookCategory(BookCategory bookCategory);
}
