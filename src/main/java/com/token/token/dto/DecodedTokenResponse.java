package com.token.token.dto;

public class DecodedTokenResponse {
    private String accountId;
    private String accountRioId;

    public DecodedTokenResponse() {}

    public DecodedTokenResponse(String accountId, String accountRioId) {
        this.accountId = accountId;
        this.accountRioId = accountRioId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountRioId() {
        return accountRioId;
    }

    public void setAccountRioId(String accountRioId) {
        this.accountRioId = accountRioId;
    }
}
