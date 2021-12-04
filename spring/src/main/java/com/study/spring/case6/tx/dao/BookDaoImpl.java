package com.study.spring.case6.tx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.spring.case6.tx.exception.InsufficientAmount;
import com.study.spring.case6.tx.exception.InsufficientQuantity;

@Repository
public class BookDaoImpl implements BookDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql;

	@Override // 取得 單一price
	public Integer getPrice(Integer bid) {
		sql = "Select price from book where bid=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { bid }, Integer.class);
	}

	@Override // 減去庫存
	public Integer updateStock(Integer bid) throws InsufficientQuantity{
		// 檢查庫存
		sql = "Select amount from stock where bid=?";
		Object[] args = new Object[] { bid };
		int amount = jdbcTemplate.queryForObject(sql, args, Integer.class);
		if (amount <= 0) {
			throw new InsufficientQuantity();
		}
		// 修改庫存
		sql = "Update stock set amount = amount - 1 where bid=?";
		return jdbcTemplate.update(sql, args);
	}

	@Override // 減去金額
	public Integer updateWallet(Integer wid, Integer money) throws InsufficientAmount{
		// 檢查錢包是否夠減
		sql = "Select money from wallet where wid =? ";
		Object[] args = new Object[] { wid };
		int wallet = jdbcTemplate.queryForObject(sql, args, Integer.class);
		// 錢包小於要購買的價錢
		if (wallet < money) {
			throw new InsufficientAmount();
		}
		// 修改金額
		sql = "update wallet set money = money - ? where wid = ?";
		args = new Object[] { money, wid };
		return jdbcTemplate.update(sql, args);
	}

}
