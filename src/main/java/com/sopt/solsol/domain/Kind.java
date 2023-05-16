package com.sopt.solsol.domain;

import lombok.Getter;

public enum Kind {

        TRANSFERS("입출금"),
        DEPOSIT("예적금");

        @Getter
        private String name;

        Kind(String name) {
            this.name = name;
        }
    }
