
package com.example.admin.quickmaths.model.WalmartSearch;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GiftOptions implements Serializable{

    @SerializedName("allowGiftWrap")
    @Expose
    private Boolean allowGiftWrap;
    @SerializedName("allowGiftMessage")
    @Expose
    private Boolean allowGiftMessage;
    @SerializedName("allowGiftReceipt")
    @Expose
    private Boolean allowGiftReceipt;

    public Boolean getAllowGiftWrap() {
        return allowGiftWrap;
    }

    public void setAllowGiftWrap(Boolean allowGiftWrap) {
        this.allowGiftWrap = allowGiftWrap;
    }

    public Boolean getAllowGiftMessage() {
        return allowGiftMessage;
    }

    public void setAllowGiftMessage(Boolean allowGiftMessage) {
        this.allowGiftMessage = allowGiftMessage;
    }

    public Boolean getAllowGiftReceipt() {
        return allowGiftReceipt;
    }

    public void setAllowGiftReceipt(Boolean allowGiftReceipt) {
        this.allowGiftReceipt = allowGiftReceipt;
    }

}
