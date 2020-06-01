package com.hfnu.library.domain.Vo;

/**
 * Author : wendy_wan
 * Created : 2020/2/4 12:49
 */
public class BookVo {

    private Integer bookId;  //书籍id

    private String bookName; //书名

    private String bookAuthor;//作者

    private String bookPublish;//出版社

    private String isExist;  //是否可借

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublish() {
        return bookPublish;
    }

    public void setBookPublish(String bookPublish) {
        this.bookPublish = bookPublish;
    }

    public String getIsExist() {
        return isExist;
    }

    public void setIsExist(String isExist) {
        this.isExist = isExist;
    }
}
