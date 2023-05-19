package com.sopt.solsol.util;

import com.sopt.solsol.domain.Bank;

public class Util {
    public static Bank getBankEnum(String bank) {
        switch (bank) {
            case "kakao":
                return Bank.KAKAO;
            case "woori":
                return Bank.WOORI;
            case "shinhan":
                return Bank.SHINHAN;
            case "kookmin":
                return Bank.KOOKMIN;
            case "hana":
                return Bank.HANA;
            default:
                throw new IllegalArgumentException("Invalid bank: " + bank);
        }
    }
}
