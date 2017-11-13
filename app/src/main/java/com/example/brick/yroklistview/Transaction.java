package com.example.brick.yroklistview;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by brick on 04.11.2017.
 */
@Table(name = "Transactions")
public class Transaction extends Model {
    @Column(name = "title")
    public String name;
    @Column(name = "sum")
    public int sum;
    @Column(name = "date")
    public String date;

    /**
     *
     */
    public Transaction() {
    }

    public Transaction(String name, int sum, String date) {
        this.name = name;
        this.sum = sum;
        this.date = date;

    }

//
}
