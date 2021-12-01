package com.byko.vessel_tracking.database;

import javax.persistence.*;

@Entity
@Table(name = "api_table")
public class ApiCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String client_id;
    private String scope;
    private String client_secret;
    private String grant_type;

    private String positionstackAccessKey;
    private String weatherstackAccessKey;

    public ApiCredentials(String client_id, String scope, String client_secret, String grant_type,
                          String positionstackAccessKey, String weatherstackAccessKey) {
        this.client_id = client_id;
        this.scope = scope;
        this.client_secret = client_secret;
        this.grant_type = grant_type;
        this.positionstackAccessKey = positionstackAccessKey;
        this.weatherstackAccessKey = weatherstackAccessKey;
    }

    public ApiCredentials() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getGrant_type() {
        return grant_type;
    }

    public void setGrant_type(String grant_type) {
        this.grant_type = grant_type;
    }

    public String getPositionstackAccessKey() {
        return positionstackAccessKey;
    }

    public void setPositionstackAccessKey(String positionstackAccessKey) {
        this.positionstackAccessKey = positionstackAccessKey;
    }

    public String getWeatherstackAccessKey() {
        return weatherstackAccessKey;
    }

    public void setWeatherstackAccessKey(String weatherstackAccessKey) {
        this.weatherstackAccessKey = weatherstackAccessKey;
    }
}
