package com.group.libraryapp.domain.user.loanhistory;


import com.group.libraryapp.domain.user.User;

import javax.persistence.*;

@Entity
public class UserLoanHistory {

    protected UserLoanHistory(){};

    public UserLoanHistory(User user, String bookName) {
        this.user = user;
        this.bookName = bookName;
        this.isReturn = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @JoinColumn(nullable = false)
    @ManyToOne
    private User user;

    //private Long userId;

    private String bookName;

    private Boolean isReturn;


    public void doReturn(){
        this.isReturn = true;
    }

    public String getBookName() {
        return bookName;
    }
}
