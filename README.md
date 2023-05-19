## GO SOPT 합동세미나 Server Repository 입니다.
## SOLSOL server

### Our Team
- [최윤한](https://github.com/unanchoi)
- [장유진](https://github.com/jinchiim)

### 역할 분담

| 최윤한                              | 장유진                                    |
|----------------------------------|----------------------------------------|
| 프로젝트 세팅<br/>이체 관련 API 개발 <br/>배포 | 프로젝트 세팅 <br/>계좌, 광고 관련 API 개발 <br/> 배포 |

## API 명세서
<img src="./assets/api_spec.png">

## 프로젝트 구조
- src
    - main
        - java
            - com.sopt.solsol
                - common
                - config
                - controller
                - domain
                - dto
                - exception
                - repository
                - service
                - util
                - SolsolApplication.java
        - resources
            - application.yml
    - test
        - java
            - com.sopt.solsol
                - SolsolApplicationTests.java
        - resources
            - application.yml
## ERD
<img src="./assets/erd.png" />

## Convention
<img src="./assets/convention.png">

## 실행 방법
```bash

git clone https://github.com/GO-SOPT-SOLSOL/SOLSOL-server.git

cd SOLSOL-server

./gradlew clean build

cd build/libs

java -jar SOLSOL-0.0.1-SNAPSHOT.jar
```
