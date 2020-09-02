# BestSeller(SpringBoot + JPA + MySQL)
* 기존 JSP, MVC 패턴을 이용해서 만든 프로젝트를 스프링 환경에서 재구성.

## 프로젝트 소개
> 정보 통신 기술의 발달로 전자 장치가 증가하면서 사람들의 독서량이 감소하고 있습니다. 독서는 창의적인 인재를 육성하는 데 도움이 되는 경제적인 역할도 하는 중요한 요소입니다.
따라서 독서의 필요성을 인식하고, 독서율을 높이기 위해 이러한 프로젝트를 만들게 되었습니다.

> 독서를 많이 해보지 않은 사람들은 무슨 책을 읽어야 할지 잘 모르고, 막상 읽으려고 해도 서점에서 책을 구매하기 귀찮거나 여건이 안 되는 상황도 많이 있습니다.
이러한 점을 이용해서 책을 선물 받고, 추천받는 기능을 추가하였습니다. 책을 선물하는 사람은 읽지 않는 혹은 다 읽은 책들을 선물함으로써 뿌듯함을 느낄 수 있고, 책을 선물 받는 사람은
선물 받은 책을 시작으로 책에 대한 흥미와 친숙함을 느끼게 할 수 있습니다.

> 또한 안 읽는 다량의 책들을 아동복지 재단 등 불우한 이웃을 위해 기부할 수 있는 기부 기능도 추가하여, 책을 그냥 버리는 것이 아니라 다른 사람들의 독서율을 높일 수 있게 하였습니다.

> 관리자들은 베스트셀러 책을 홈페이지에 등록하고, 사용자들은 베스트셀러를 보면서 어떤 책을 읽을지 방향을 잡을 수 있고, 다른 사람들의 리뷰를 통해 책 선택에 많은 도움을 받을 수 있습니다..

## 프로젝트 기능
### [로그인 & 회원가입]
1. 사용자는 로그인을 해야만 세부기능 사용 가능.
2. 회원이 아닌 사용자는 회원가입 수행.

### [Gift(선물)]  
1. 사용자는 자신의 책을 다른 유저에게 선물할 수 있다.
   * **이때, 선물 받는 사람은 회원중에 랜덤으로 선정한다.**
    
2. 사용자는 선물하고자 하는 책 이름과 저자를 작성한다.

3. 선물받는 사람의 이름과 주소가 화면에 뜨고 그 주소로 책을 보낸다.
   
### [Donate(기부)]  
1. 사용자는 자신의 책을 특정 재단에게 기부할 수 있다.

2. 사용자는 기부하고자 하는 책 이름, 저자를 작성하고 기부할 재단을 선택한다.

3. 기부를 가장 많이 한 회원 3명은 기부왕으로 등극된다.

### [Recommend(추천)] 
1. 관리자가 베스트셀러 20권을 선정해서 홈페이지에 등록한다.

2. 사용자는 베스트셀러 20권을 화면에서 볼 수 있다.

### [Review(리뷰)] 
1. 사용자들의 리뷰들을 화면에서 볼 수 있다.

2. 사용자는 책에 대한 리뷰를 등록할 수 있다.

3. 사용자는 리뷰할 책 이름, 리뷰 내용을 작성한다.

### [FAQ & Contact] 
1. 사용자는 궁금한 사항을 메시지로 전송할 수 있다.

2. 사용자는 정해진 질문 카테고리를 선택하고, 내용을 작성한다.

3. 관리자는 질문들에대한 답변을 등록한다.

4. 관리자는 자주 묻는 질문 5개를 선정하여 질문과 답변을 화면에서 볼 수 있게 한다.



  

  


