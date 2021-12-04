CREATE TABLE Book(
	bid INTEGER NOT NULL AUTO_INCREMENT,  -- 主鍵序號
	bname varchar(20) NOT NULL , --書名
	price INTEGER , -- 價格
	ct timestamp default current_timestamp, --建檔時間
	PRIMARY KEY (bid)
);

CREATE TABLE stock(
	sid INTEGER NOT NULL AUTO_INCREMENT,	-- 主鍵序號
	bid INTEGER NOT NULL ,	-- Book 主鍵
	amount INTEGER , -- 數量
	PRIMARY KEY (sid)
);

CREATE TABLE Wallet (
	wid INTEGER NOT NULL AUTO_INCREMENT ,	-- 主鍵序號
	money INTEGER , -- 數量
	PRIMARY KEY (wid)
);

Insert into wallet(Money) values(100);
Insert into book(bname,price) values('Java',80);
insert into stock(bid,amount) values(1,3);

-- 修改欄位型別
ALTER table stock
Modify column sid Integer NOT NULL Auto_increment 