package com.hfnu.library.domain.Vo;

import com.hfnu.library.domain.Book;
import com.hfnu.library.domain.User;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 12:49
 */
//添加视图层对象，新增属性user
public class BorrowingBooksVo {
    private User user;
    private Book book; //借阅书籍
    private String dateOfBorrowing;//借书日期
    private String dateOfReturn;//还书日期


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getDateOfBorrowing() {
        return dateOfBorrowing;
    }

    public void setDateOfBorrowing(String dateOfBorrowing) {
        this.dateOfBorrowing = dateOfBorrowing;
    }

    public String getDateOfReturn() {
        return dateOfReturn;
    }

    public void setDateOfReturn(String dateOfReturn) {
        this.dateOfReturn = dateOfReturn;
    }
}
