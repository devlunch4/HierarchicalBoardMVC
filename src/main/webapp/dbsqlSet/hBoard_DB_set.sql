--시퀀스 삭제
DROP SEQUENCE SEQ_HBOARD;
--시퀀스 생성
CREATE SEQUENCE SEQ_HBOARD
    START WITH 1
    INCREMENT BY 1;

--테이블 삭제
DROP TABLE xusersx;
DROP TABLE HFILE;
DROP TABLE HREPLY;
DROP TABLE HBOARD;

--DB 생성/* 사용자 */
/* 사용자 */
CREATE TABLE users (
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
	content VARCHAR2(255), /* 내용 */
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
	originNo INTEGER, /* 원글번호 */
	groupOrd INTEGER, /* 그룹순서 */
	groupLayer INTEGER, /* 답글계층 */
	active INTEGER NOT NULL, /* 활성 */
	content VARCHAR2(255), /* 내용 */
	writer VARCHAR2(255), /* 작성자 */
	reg_datetime DATE /* 작성일 */
);

COMMENT ON TABLE hreply IS '댓글';

COMMENT ON COLUMN hreply.rcode IS '댓글번호';

COMMENT ON COLUMN hreply.bcode IS '원글번호';

COMMENT ON COLUMN hreply.originNo IS '그룹';

COMMENT ON COLUMN hreply.groupOrd IS '그룹순서';

COMMENT ON COLUMN hreply.groupLayer IS '그룹계층';

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
	originNo INTEGER, /* 원글 */
	groupOrd INTEGER, /* 원글 순서 */
	groupLayer INTEGER, /* 답글계층 */
	active INTEGER NOT NULL, /* 활성 */
	fname VARCHAR2(255), /* 파일명 */
	fextension VARCHAR2(255), /* 파일확장자 */
	writer VARCHAR2(255), /* 작성자 */
	reg_datetime DATE /* 작성일 */
);

COMMENT ON TABLE hfile IS '파일';

COMMENT ON COLUMN hfile.fcode IS '파일번호';

COMMENT ON COLUMN hfile.bcode IS '원글번호';

COMMENT ON COLUMN hfile.originNo IS '그룹';

COMMENT ON COLUMN hfile.groupOrd IS '그룹순서';

COMMENT ON COLUMN hfile.groupLayer IS '그룹계층';

COMMENT ON COLUMN hfile.active IS '0/1';

COMMENT ON COLUMN hfile.fname IS '제목';

COMMENT ON COLUMN hfile.fextension IS '파일확장자';

COMMENT ON COLUMN hfile.writer IS '작성자';

COMMENT ON COLUMN hfile.reg_datetime IS '작성일';

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

--//
-- insert 값 시  해당 입력될 컬럼 위치에 SEQ_BOARD.NEXTVAL 값 입력
-- 현재 생성된 시퀀스 값 조회 SELECT SEQ_BOARD.CURRVAL FROM DUAL;
--//

--//시퀀스(Sequence) 생성
--문법
--CREATE SEQUENCE [시퀀스명]
--INCREMENT BY [증감숫자] --증감숫자가 양수면 증가 음수면 감소 디폴트는 1
--START WITH [시작숫자] -- 시작숫자의 디폴트값은 증가일때 MINVALUE 감소일때 MAXVALUE
--NOMINVALUE OR MINVALUE [최솟값] -- NOMINVALUE : 디폴트값 설정, 증가일때 1, 감소일때 -1028 
--                               -- MINVALUE : 최소값 설정, 시작숫자와 작거나 같아야하고 MAXVALUE보다 작아야함
--NOMAXVALUE OR MAXVALUE [최대값] -- NOMAXVALUE : 디폴트값 설정, 증가일때 1027, 감소일때 -1
--                               -- MAXVALUE : 최대값 설정, 시작숫자와 같거나 커야하고 MINVALUE보다 커야함
--CYCLE OR NOCYCLE --CYCLE 설정시 최대값에 도달하면 최소값부터 다시 시작 NOCYCLE 설정시 최대값 생성 시 시퀀스 생성중지
--CACHE OR NOCACHE --CACHE 설정시 메모리에 시퀀스 값을 미리 할당하고 NOCACHE 설정시 시퀀스값을 메로리에 할당하지 않음
----예제
--CREATE SEQUENCE EX_SEQ --시퀀스이름 EX_SEQ
--INCREMENT BY 1 --증감숫자 1
--START WITH 1 --시작숫자 1
--MINVALUE 1 --최소값 1
--MAXVALUE 1000 --최대값 1000
--NOCYCLE --순한하지않음
--CACHE; --메모리에 시퀀스값 미리할당

--//시퀀스(Sequence) 사용 예시
--CREATE TABLE EX_TABLE (BOARD_NUM NUMBER(19,6) NOT NULL);
--1. 테스트 할 간단한 TEST 테이블을 만듭니다.
--INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL);
--INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL);
--INSERT INTO EX_TABLE(BOARD_NUM) VALUES(EX_SEQ.NEXTVAL); 
--2. 위에서 만들었던 EX_SEQ 시퀀스로 TEST테이블에 데이터를 넣습니다.
--SELECT * FROM EX_TABLE
--3 넣었던 데이터를 SELECT문으로 확인해봅니다.
--//


--//시퀀스(Sequence) 조회
--SELECT EX_SEQ.CURRVAL FROM DUAL --해당 시퀀스 값 조회
--SELECT * FROM USER_SEQUENCES  --전체 시퀀스 조회
--//

--//시퀀스(Sequence) 수정
--문법
--ALTER SEQUENCE [시퀀스명]
--INCREMENT BY [증가값]
--NOMINVALUE OR MINVALUE [최솟값] 
--NOMAXVALUE OR MAXVALUE [최대값]
--CYCLE OR NOCYCLE [사이클 설정 여부]
--CACHE OR NOCACHE [캐시 설정 여부]
----예제
--ALTER SEQUENCE EX_SEQ
--INCREMENT BY 2
--MINVALUE 2
--MAXVALUE 10000
--CYCLE
--NOCACHE;
--//
