## 2. Board 엔티티 작성

> 아래와 같이 코드를 작성해준다. 
> 단, Board엔티티는 User엔티티와 연관관계가 설정이 된다. 그 내용은 아래에서 설명하겠다.

    @Entity
    public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 64)
    private String title;

    @Lob
    private String content;

    @ColumnDefault("0")
    private int count;

    @CreationTimestamp
    private Timestamp createDate;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    
    }


### Board와 User의 연관관계 

    여기서 Board에 User의 연관관계가 맺어진 것을 확인할 수 있다.
    ManyToOne으로 되어있는데, 이것은 한명의 유저가 여러개의 Board객체를
    만들 수 있기 때문에 ManyToOne이다. 
    그렇다면 실제 형성된 테이블의 모습은 다음과 같다.
---
    SQL문이 작성되며 DB가 생성됐고,

![img.png](img.png)

    아래와 같이 DB역시 작성된 것을 확인할 수 있다.

![img_1.png](img_1.png)

---




