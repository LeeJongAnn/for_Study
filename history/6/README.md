# ★★ 6.스프링 시큐리티 적용하기

> 스프링 시큐리티를 적용해보려고 한다. 
> 우선은 dependency에 스프링 시큐리티를 추가해준다.

    implementation 'org.springframework.boot:spring-boot-starter-security'

> 그런 다음 접속을 하게되면 닫혀있는 모양으로 나온다. 
> user와 비밀번호가 나오고 입력해야 들어갈 수 있다.

![](1.jpg)

    이렇게 Security Password 비밀번호가 뜨게 된다.
    그러면 이제 화면으로 가보겠다.

![](2.jpg)    

    이렇게 화면이 뜨게 되는데
    아이디에는 user를 넣고 
    비밀번호에는 아까 뜬 비밀번호를 넣어준다.

![](3.png)

    그리고 로그인을 눌러주면 들어가게 된다.

![](4.png)    

    정상적으로 로그인이 된 것을 확인할 수 있다.
    하지만 이렇게 해서는 사용자가 회원가입한 아이디와
    비밀번호를 사용해서 로그인을 하는것이 아니다.
    그렇기 때문에 다른 설정을 통해서 로그인을 할 수 있도록 
    설정해줘야 한다.

### 즉 로그인 커스터마이징을 해줘야한다.

    이제 로그인 커스터마이징을 하려고 한다.
    Config 패키지를 생성하고 
    SecurityConfig 클래스를 만들어준다.
    그리고 아래와 같이 코드를 작성해준다.

![](5.png)

    코드에 대한 설명은 나중에 다시 첨부하겠다.