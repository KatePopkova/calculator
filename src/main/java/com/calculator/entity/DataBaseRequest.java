package com.calculator.entity;

import javax.persistence.*;

@Entity
@Table(name = "requests")
public class DataBaseRequest {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String operation;

    public DataBaseRequest() {
    }

    public DataBaseRequest(String operation) {
        this.operation = operation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
