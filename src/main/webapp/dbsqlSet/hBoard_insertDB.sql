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