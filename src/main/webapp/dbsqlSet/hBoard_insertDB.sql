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
    '1번글',
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
    '2번글',
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
    '3번글',
    '',
    '게시판생성자',
    SYSDATE
);