package com.sopt.solsol.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Ad {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(max = 50)
        @Column(nullable = false)
        private String title;

        @Size(max = 200)
        @Column(nullable = false)
        private String content;

        @Builder
        public Ad(String title, String content){
            this.title = title;
            this.content = content;
        }

    }
