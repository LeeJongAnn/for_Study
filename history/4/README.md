# 4. 회원가입 기능 만들기 
    우선은 Controller에서 ApiController를 만들어준다.
    그리고 코드를 아래와 같이 작성한다. 이 코드는 
    save함수가 호출 됐을때 정상적으로 작동하는지 응답을 주기위한 코드이다.

![img_6.png](img_6.png)
    
    그리고 아래와 같이 js 파일에 가서 코드를 작성해준다
![img_1.png](img_1.png)

    해당 코드는 회원가입 버튼을 클릭했을때 Post요청을 보내는 코드이다.
    우선은 주석처리하고 값이 정상적으로 올라오는지 확인해보겠다.

![img_2.png](img_2.png)

    주석 처리를 하고 값을 입력한 뒤 회원가입 버튼을 눌러본다.

![img_3.png](img_3.png)

    값은 이렇게 입력했다. 그렇다면 콘솔에서 값이 올라오는지 보면

![img_4.png](img_4.png)

    이렇게 값이 올라오는 것을 볼 수 있다.
    그렇다면 이제 주석 처리를 해제하고 다시 값을 입력해보면 다음과 같이 뜬다.

![img_5.png](img_5.png)

    즉 정상적으로 작동하는 것을 알 수 있다.
    
> 그리고 패키지에서 UserService를 형성하고 여기서 save 메소드를 써준다.
> 그런 다음 ApiController에서 UserService Autowired로 DI해서 주입한다음 
> 회원가입 메소드를 써서 회원가입 로직을 작성해준다.

    회원가입이 성공하면 return 값이 1이 나오고 
    아니면 -1이 나오게 된다.
    아래는 UserService 코드의 모습
    
![img_9.png](img_9.png)

    그리고 아래는 ApiController의 코드이다.

![img_10.png](img_10.png)