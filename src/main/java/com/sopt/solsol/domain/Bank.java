package com.sopt.solsol.domain;

import lombok.Getter;

public enum Bank {

    KAKAO("카카오"),
    SHINHAN("신한"),
    KOOKMIN("국민"),
    HANA("하나"),
    WOORI("우리");

    @Getter
    private final String name;

    Bank(String name) {
        this.name = name;
    }
}
