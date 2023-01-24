CREATE TABLE sys.`MEMBER` (
	ID VARCHAR(20) NOT NULL COMMENT '아이디',
	PASSWORD VARCHAR(256) NOT NULL COMMENT '비밀번호',
	NAME VARCHAR(50) NOT NULL COMMENT '이름',
	BIRTH_DAY VARCHAR(8) NOT NULL COMMENT '생년월일(YYYYMMDD)',
	PHONE VARCHAR(11) NOT NULL COMMENT '전화번호(01039741139)',
	GENDER VARCHAR(1) NOT NULL COMMENT '성별(M,F)',
	REG_DT DATETIME NULL COMMENT '등록일시',
	REGISTRAR VARCHAR(20) NULL COMMENT '등록자',
	MODIFY_DT DATETIME NULL COMMENT '수정일시',
	MODIFIER VARCHAR(20) NULL COMMENT '수정자',
	CONSTRAINT MEMBER_PK PRIMARY KEY (ID)
	CONSTRAINT CK_GENDER CHECK(GENDER IN ('M', 'G'));
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4;