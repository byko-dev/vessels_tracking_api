package com.byko.vessel_tracking.database;

import javax.persistence.*;

@Entity
@Table(name = "api_token")
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @Column(name = "token_content", length = 2048)
    private String content;

    private long expiresIn;

    public Token(String content, long expiresIn) {
        this.content = content;
        this.expiresIn = expiresIn;
    }

    public Token() {}

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }
}
