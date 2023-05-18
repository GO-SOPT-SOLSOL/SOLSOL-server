package com.sopt.solsol.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", nullable = false)
    private Accounts accounts;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy.MM.dd")
    private LocalDateTime createdAt;

    @Size(max = 20)
    @Column(nullable = false)
    private String transferMemo;

    @Size(max = 20)
    @Column(nullable = false)
    private String receiverMemo;

    @Size(max = 20)
    @Column(nullable = false)
    private String charge;

    @Builder
    public Transfer(Member member, Accounts accounts, LocalDateTime createdAt, String transferMemo, String receiverMemo, String charge) {
        this.member = member;
        this.accounts = accounts;
        this.createdAt = createdAt;
        this.transferMemo = transferMemo;
        this.receiverMemo = receiverMemo;
        this.charge = charge;
    }
}
