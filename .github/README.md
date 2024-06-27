<h1>Relation 설정 여부와 이유</h1>

![IMG_C45AA59A9B3A-1](https://github.com/Seungcode/intership/assets/104374372/685482c8-c5bc-43b5-9199-2a54487dc95b)

<h3>Relation 1</h3>
User - Board<br><br>
사용 목적 : <br>
Board에서 작성자를 받아오기 위함<br>
User 삭제 시 Board의 작성자를 바꾸기 위함<br><br>
사용 이유 : 하나의 보드는 한 명의 작성자만을 가질 수 있지만 한 유저는 여러 개의 게시물을 작성할 수 있기 때문에 OneToMany / ManyToOne을 사용하여 연결
<h3>Relation 2</h3>
User - Board<br><br>
사용 목적 : <br>
게시판에서 좋아요 기능을 구현하기 위함 (양방향)<br><br>
사용 이유 : 한 게시물에 여러 명의 사용자가 좋아요를 누를 수 있고, 한 사용자가 여러개의 게시물에 좋아요를 누를 수 있기 때문에 ManyToOne을 사용하여 연결
<h3>Relation 3</h3>
User - Comment<br><br>
사용 목적 : <br>
Comment에서 작성자를 받아오기 위함<br>
User 삭제 시 Comment의 작성자를 바꾸기 위함<br><br>

사용 이유 : 한 사용자는 여러 댓글을 작성할 수 있지만 한 댓글은 한 명의 사용자만을 작성자로 가질 수 있기 때문에 OneToMany / ManyToOne을 사용하여 연결
<h3>Relation 4</h3>
User-CommentLike<br><br>
사용 목적 : <br>
사용자가 댓글 좋아요를 누르면 현재 좋아요 여부를 확인하고 좋아요 / 취소를 할 때 참조하기 위함<br>
사용자가 삭제되었을 경우 좋아요가 사라지게 함<br><br>
사용 이유 : 한 사용자는 여러개의 댓글에 좋아요를 누를 수 있지만 한 게시물의 좋아요는 한 사용자만을 가질 수 있어 OneToMany / ManyToOne을 사용하여 연결
<h3>Relation 5</h3>
Comment-CommentLike<br><br>
사용 목적 : <br>
댓글을 불러 올 때 좋아요 수를 불러오기 위해 사용<br>
댓글이 삭제되었을 경우 좋아요가 사라지게 함<br><br>
사용 이유 : 한 댓글에는 여러 좋아요가 있을 수 있지만 한 좋아요는 한 댓글만을 가질 수 있어 OneToMany / ManyToOne을 사용하여 연결
<h3>Relation 6</h3>
Comment-Board<br><br>
사용 목적 : <br>
게시물을 불러올 때 댓글을 가져오기 위해 사용<br>
댓글에서 작성 된 위치(게시물)를 가져오기 위해 사용 <br><br>
사용 이유 : 한 게시물은 여러 댓글을 가질 수 있지만 한 댓글은 하나의 게시물만을 가져야 하기 때문에 OneToMany / ManyToOne을 사용하여 연결