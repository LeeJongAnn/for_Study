# 1. 스프링 게시판 개선하기 

### 이전에 만들었던 스프링 게시판을 Thymeleaf를 사용해서 다시 만들어봅니다.

 1. 사용기술 : 프론트엔드(부트스트랩),Thymeleaf,백엔드(SpringBoot,Spring-Sequrity,RestAPI) , DB(MySQL)
 2. 작성한 부분 :
>   - [1. 엔티티 생성하고 테스트 코드 작성하기](https://github.com/LeeJongAnn/for_Study/blob/master/history/1/README.md)
>   - [2. 프론트화면 만들기](https://github.com/LeeJongAnn/for_Study/blob/master/history/2/README.md)
>   - [3. Thymeleaf로 레이아웃 나누기](https://github.com/LeeJongAnn/for_Study/tree/master/history/3)
>   - [4. 회원가입 기능 만들기](https://github.com/LeeJongAnn/for_Study/tree/master/history/4)
>   - [5. 유저 정보 표시하기](https://github.com/LeeJongAnn/for_Study/tree/master/history/5)
>   - [6. 스프링 시큐리티 적용하기 ](https://github.com/LeeJongAnn/for_Study/tree/master/history/6)
>   - [7. 게시글 작성하기 ]()



| 날짜                                                                   | 비고                                              |
|----------------------------------------------------------------------|-------------------------------------------------|
| 1. User 엔티티 생성 및 DB연결 확인,부트스트랩으로 앞단에 화면 생성 - 22년 4월 12일              | User 엔티티 생성되고 DB에 들어가는것 확인하였음                   |
| 2. UserRepository 생성 및 테스트 코드로 User엔티티와 Repository 테스트  - 22년 4월 13일 | 실제로 값이 들어가는지 확인 완료                              |
| 3. Board,Reply 엔티티 추가 및 UserRepository 테스트 코드 추가 - 22년 4월 14일        | Board와 Reply 엔티티 생성 , 연관 관계 맵핑해줘야됨              |
| 4. UserRepository 객체를 얻어오는 테스트 코드 추가 - 22년 4월 14일                    | userRepository.get테스트 코드 추가                     |
| 5. Thymeleaf로 화면분할 하고 RoleType 추가  - 22년 4월 15일                      | 로그인 회원가입 화면 만들어야 한다.                            |
| 6. 회원가입 JS 작성 중 값이 콘솔로 올라오는지 확인  - 22년 4월 15일                        | 브랜치를 쪼개서 다른 방법으로도 만들어볼 생각,js init을 안해줘서 엄청 헤맸다. |
| 7. ResponseDto 작성 및 응답이 오는지 확인  - 22년 4월 16일                         | 정상적으로 작동하는지 확인                                  |
| 8. 브랜치 나누고 index 페이지에 가입한 아이디 나오도록 작성  - 22년 4월 17일                  | Enum 타입 오류 수정                                   |
| 9. 회원가입 성공  - 22년 4월 17일                                             | Enum타입은 안돼서 결국에는 삭제하고 회원가입 성공했다.                |
| 10. 스프링 시큐리티 회원가입 작성 - 22년 4월 18일                                    | 머리 뜨겁다.                                         |
| 11. 스프링 시큐리티 로그인 작성 완료 및 확인 - 22년 4월 18일                             | 스프링 시큐리티 로그인까지 진행                               |
| 12. 게시글 작성 기능 추가 및 게시판 화면 작성 - 22년 4월 18일                            | summernote p태그 없애는 법 찾아봐야할듯                     |
| 13. 첫 화면 꾸미기 및 게시글 목록 보기 추가 - 22년 4월 20일                             | 그림 사이즈 일정하게 하는 방법 찾다가 포기                        |
| 14. 게시글 Pagination 추가 - 22년 4월 21일                                   | 글쓰기 게시판에만 일단 추가 및 확인                            |
| 15. 파일 정리 및 시큐리티 파일 경로 오류 수정 - 22년 4월 21일                            | 복잡해서 정리함 그리고 시큐리티 오류 수정                         |
| 16. 시큐리티 오류 수정 완료 및 게시글 상세보기 추가 - 22년 4월 21일                         | 게시글 상세보기 추가 완료함 , 수정 및 삭제도 추가해야됨                |
| 17. 글 삭제하기 추가 - 22년 4월 21일                                           | 게시글 삭제 추가 완료함                                   |
| 18. 글 수정하기 추가 - 22년 4월 23일                                           | 게시글 수정 완료함 , 수정 오류 고치는데 오래 걸림                   |