package com.mywallet;

/**
 * Created by admin on 03-May-18.
 */

public class WalletModel {
    private String wallet_name;
    private int wallet_image;

   /* public WalletModel(String wallet_name, String wallet_image) {
        this.wallet_name = wallet_name;
        this.wallet_image = wallet_image;
    }
*/
    public String getWallet_name() {
        return wallet_name;
    }

    public void setWallet_name(String wallet_name) {
        this.wallet_name = wallet_name;
    }

    public int getWallet_image() {
        return wallet_image;
    }

    public void setWallet_image(int wallet_image) {
        this.wallet_image = wallet_image;
    }
}
