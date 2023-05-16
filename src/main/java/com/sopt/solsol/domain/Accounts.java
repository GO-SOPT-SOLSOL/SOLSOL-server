package com.sopt.solsol.domain;

import jdk.jshell.Snippet;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigInteger;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @Column(nullable = false, unique = true)
    private String number;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Bank bank;


    @Column(nullable = false)
    @ColumnDefault("0")
    private Long balance;

    @Size(max = 20)
    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Kind kind;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Builder
    public Accounts(Member member, String number, Bank bank, Long balance, String name, Kind kind){
        this.member = member;
        this.number = number;
        this.bank = bank;
        this.balance = balance;
        this.name = name;
        this.kind = kind;
    }


}
