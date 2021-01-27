--시퀀스 삭제
DROP SEQUENCE SEQ_HBOARD;
--시퀀스 생성
CREATE SEQUENCE SEQ_HBOARD
    START WITH 1
    INCREMENT BY 1;
-- SEQ_HBOARD.NEXTVAL

-- 댓글 시퀀스 삭제
DROP SEQUENCE SEQ_HREPLY;
-- 댓글 시퀀스 생성
CREATE SEQUENCE SEQ_HREPLY
    START WITH 1
    INCREMENT BY 1;
-- SEQ_HREPLY.NEXTVAL
    
    


--테이블 삭제
DROP TABLE xusersx;
DROP TABLE HFILE;
DROP TABLE HREPLY;
DROP TABLE HBOARD;

--DB 생성/* 사용자 */
/* 사용자 */
CREATE TABLE xusersx (
	userid VARCHAR2(255), /* 사용자계정 */
	pass VARCHAR2(255) /* 비밀번호 */
);

COMMENT ON TABLE users IS '사용자';

COMMENT ON COLUMN users.userid IS '사용자계정';

COMMENT ON COLUMN users.pass IS '비밀번호';

/* 게시판및게시글 */
CREATE TABLE hboard (
	bcode INTEGER NOT NULL, /* 게시판번호 */
	originNo INTEGER, /* 원글번호 */
	groupOrd INTEGER, /* 원글순서 */
	groupLayer INTEGER, /* 답글계층 */
	active INTEGER NOT NULL, /* 활성 */
	title VARCHAR2(255), /* 제목 */
	content CLOB, /* 내용 */
	writer VARCHAR2(255), /* 작성자 */
	reg_datetime DATE /* 작성일 */
);

COMMENT ON TABLE hboard IS '게시판및게시글';

COMMENT ON COLUMN hboard.bcode IS '원글번호';

COMMENT ON COLUMN hboard.originNo IS '그룹';

COMMENT ON COLUMN hboard.groupOrd IS '그룹순서';

COMMENT ON COLUMN hboard.groupLayer IS '그룹계층';

COMMENT ON COLUMN hboard.active IS '0/1';

COMMENT ON COLUMN hboard.title IS '제목';

COMMENT ON COLUMN hboard.content IS '내용';

COMMENT ON COLUMN hboard.writer IS '작성자';

COMMENT ON COLUMN hboard.reg_datetime IS '작서일';

CREATE UNIQUE INDEX PK_hboard
	ON hboard (
		bcode ASC
	);

ALTER TABLE hboard
	ADD
		CONSTRAINT PK_hboard
		PRIMARY KEY (
			bcode
		);

/* 댓글 */
CREATE TABLE hreply (
	rcode INTEGER NOT NULL, /* 댓글번호 */
	bcode INTEGER NOT NULL, /* 게시글판번호 */
	active INTEGER NOT NULL, /* 활성 */
	content VARCHAR2(500 char), /* 내용 */
	writer VARCHAR2(255), /* 작성자 */
	reg_datetime DATE /* 작성일 */
);

COMMENT ON TABLE hreply IS '댓글';

COMMENT ON COLUMN hreply.rcode IS '댓글번호';

COMMENT ON COLUMN hreply.bcode IS '원글번호';

COMMENT ON COLUMN hreply.active IS '0/1';

COMMENT ON COLUMN hreply.content IS '내용';

COMMENT ON COLUMN hreply.writer IS '작성자';

COMMENT ON COLUMN hreply.reg_datetime IS '작성일';

CREATE UNIQUE INDEX PK_hreply
	ON hreply (
		rcode ASC
	);

ALTER TABLE hreply
	ADD
		CONSTRAINT PK_hreply
		PRIMARY KEY (
			rcode
		);

/* 파일 */
CREATE TABLE hfile (
	fcode INTEGER NOT NULL, /* 파일번호 */
	bcode INTEGER NOT NULL, /* 게시글번호 */
	active INTEGER NOT NULL, /* 활성 */
	fname VARCHAR2(255), /* 파일명 */
	fextension VARCHAR2(255), /* 파일확장자 */
	writer VARCHAR2(255), /* 작성자 */
	reg_datetime DATE, /* 작성일 */
	fclob CLOB /* 파일 */
);

COMMENT ON TABLE hfile IS '파일';

COMMENT ON COLUMN hfile.fcode IS '파일번호';

COMMENT ON COLUMN hfile.bcode IS '원글번호';

COMMENT ON COLUMN hfile.active IS '0/1';

COMMENT ON COLUMN hfile.fname IS '제목';

COMMENT ON COLUMN hfile.fextension IS '파일확장자';

COMMENT ON COLUMN hfile.writer IS '작성자';

COMMENT ON COLUMN hfile.reg_datetime IS '작성일';

COMMENT ON COLUMN hfile.fclob IS '파일';

CREATE UNIQUE INDEX PK_hfile
	ON hfile (
		fcode ASC
	);

ALTER TABLE hfile
	ADD
		CONSTRAINT PK_hfile
		PRIMARY KEY (
			fcode
		);

ALTER TABLE hreply
	ADD
		CONSTRAINT FK_hboard_TO_hreply
		FOREIGN KEY (
			bcode
		)
		REFERENCES hboard (
			bcode
		);

ALTER TABLE hfile
	ADD
		CONSTRAINT FK_hboard_TO_hfile
		FOREIGN KEY (
			bcode
		)
		REFERENCES hboard (
			bcode
		);

--초기 데이터 입력
INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    seq_hboard.NEXTVAL,
    0,
    0,
    0,
    '1번게시판',
    '',
    '게시판생성자',
    SYSDATE
);

INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    seq_hboard.NEXTVAL,
    0,
    0,
    0,
    '2번게시판',
    '',
    '게시판생성자',
    SYSDATE
);

INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    seq_hboard.NEXTVAL,
    0,
    0,
    0,
    '3번게시판',
    '',
    '게시판생성자',
    SYSDATE
);






INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    1,
    1,
    1,
    0,
    '1번글',
    '내용',
    'sally',
    SYSDATE
);
INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    1,
    2,
    1,
    0,
    '2번글',
    '내용',
    'sally',
    SYSDATE
);
INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    1,
    3,
    1,
    0,
    '3번글',
    '내용',
    'sally',
    SYSDATE
);

INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    1,
    2,
    2,
    0,
    '2번글답글',
    '내용',
    'sally',
    SYSDATE
);

INSERT INTO hboard (
    bcode,
    originno,
    groupord,
    grouplayer,
    active,
    title,
    content,
    writer,
    reg_datetime
) VALUES (
    seq_hboard.NEXTVAL,
    1,
    2,
    3,
    0,
    '2번글답글답글',
    '내용',
    'sally',
    SYSDATE
);

commit;

INSERT INTO hreply(
RCODE,
BCODE,
ACTIVE,
CONTENT,
WRITER,
REG_DATETIME
)VALUES(
SEQ_HREPLY.NEXTVAL, 5,0,'첫번째 댓글입니다','sally',sysdate
);

INSERT INTO hreply(
RCODE,
BCODE,
ACTIVE,
CONTENT,
WRITER,
REG_DATETIME
)VALUES(
SEQ_HREPLY.NEXTVAL, 5,0,'두번째 댓글입니다','sally',sysdate
);

commit;