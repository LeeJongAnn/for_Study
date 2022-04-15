# 1. 스프링 게시판 개선하기 

### 이전에 만들었던 스프링 게시판을 Thymeleaf를 사용해서 다시 만들어봅니다.

 1. 사용기술 : 프론트엔드(부트스트랩),Thymeleaf,백엔드(SpringBoot,Spring-Sequrity,RestAPI) , DB(MySQL)
 2. 작성한 부분 :
>   - [1. 엔티티 생성하고 테스트 코드 작성하기](https://github.com/LeeJongAnn/for_Study/blob/master/history/1/README.md)
>   - [2. 프론트화면 만들기](https://github.com/LeeJongAnn/for_Study/blob/master/history/2/README.md)
>   - [3. Thymeleaf로 레이아웃 나누기]()



| 날짜                                                                   | 비고                                 |
|----------------------------------------------------------------------|------------------------------------|
| 1. User 엔티티 생성 및 DB연결 확인,부트스트랩으로 앞단에 화면 생성 - 22년 4월 12일              | User 엔티티 생성되고 DB에 들어가는것 확인하였음      |
| 2. UserRepository 생성 및 테스트 코드로 User엔티티와 Repository 테스트  - 22년 4월 13일 | 실제로 값이 들어가는지 확인 완료                 |
| 3. Board,Reply 엔티티 추가 및 UserRepository 테스트 코드 추가 - 22년 4월 14일        | Board와 Reply 엔티티 생성 , 연관 관계 맵핑해줘야됨 |
| 4. UserRepository 객체를 얻어오는 테스트 코드 추가 - 22년 4월 14일                    | userRepository.get테스트 코드 추가        |
| 5. Thymeleaf로 화면분할 하고 RoleType 추가  - 22년 4월 15일                      | 로그인 회원가입 화면 만들어야 한다.|