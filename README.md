# 📚 프로젝트 소개 : SALAD-A-ZOOM
스프링부트 + REACT로 만드는 샐러드샵
## 1. 개요
- 프로젝트명 : SALAD-A-ZOOM
- 개발 기간 : 2023.12.06 ~ 2023.12.
- 개발 인원 : 2명

## 2. ⚙️기술 스택
### ✔️Frond-end
M<img src="https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=React&logoColor=black"><img src="https://img.shields.io/badge/Css-1572B6?style=for-the-badge&logo=Css&logoColor=white"><img src="https://img.shields.io/badge/node.js-339933?style=for-the-badge&logo=Node.js&logoColor=white"><img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black"><img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">

### ✔️Back-end
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"><img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=green"><img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot&logoColor=yellow"><img src="https://img.shields.io/badge/oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white"> 

## 🦹‍ Team
|                            목진혁                             |                            조소미                             |
|:----------------------------------------------------------:|:----------------------------------------------------------:|
|          [MJinHyuk](https://github.com/MJinHyuk)           |          [somi9954](https://github.com/somi9954)           |
| ![](https://avatars.githubusercontent.com/u/147026593?v=4) | ![](https://avatars.githubusercontent.com/u/137499604?v=4) |

## 📜 UI설계도 & ERDcloud 
- UI설계도 - 카카오 오븐을 사용하였습니다.(https://ovenapp.io/view/MW7gDnPiBf1b38079mv2n0lUEDumWlNF/LEprZ)
- ERDcloud(https://www.erdcloud.com/d/HmZ5EdZSjbWDJg7E9)

# 📋 기능 명세서
## 메인 페이지

## 1. 관리자 페이지
### 기본 설정

### 회원관리
- 회원 전체 조회
- 아이디 찾기
- 비밀번호 찾기

## 2. 회원
### 로그인
- 로그인
### 회원가입
- 회원가입 시 암호화(hashing)화 되어 DB에 저장.
- Id(email) : email 형식의 아이디. 필수 항목.
- Pw : 최대 길이 40. 필수 항목.
- 회원명 : 최대 길이 40. 필수 항목.
- 휴대전화번호 : 최대 길이 11. 필수 항목 정규표현식 사용.
- 주소 : 최대 길이 100. 필수 항목
- 나머지 주소

### 아이디(email) 찾기
- 아이디(email), 회원명으로 조회
- 성공시 정보 출력 후 로그인 페이지로 이동.
- 실패시 재입력 요구.

### 비밀번호 찾기
- 아이디(email), 회원명으로 조회
- 성공시 정보 출력 후 로그인 페이지로 이동.
- 실패시 재입력 요구.

### 마이페이지
- 개인정보 수정, 회원탈퇴

### 상품페이지 
- 상품 등록, 수정, 삭제 
- 상품 리뷰
- Q&A 

### 장바구니 
- 장바구니 기능 구현
- 주문서 기능 구현

### 커뮤니티
- 게시글 등록, 수정, 삭제
- 댓글 기능, 비회원은 id + User-Agent(브라우저별) 비밀번호 기능 추가
- 조회수 구현, 비회원은 id + User-Agent(브라우저별)

# 💡 담당 파트
- 관리자, 회원 : 목진혁
- 게시판 관리 :  조소미
- 나머지 파트는 공동구현을 하였습니다