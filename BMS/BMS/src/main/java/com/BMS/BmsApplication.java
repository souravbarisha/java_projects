package com.BMS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.BMS.dao.Dao;
import com.BMS.entity.Customer;

@SpringBootApplication
public class BmsApplication implements CommandLineRunner {
	@Autowired
	private Dao d;

	public static void main(String[] args) {
		SpringApplication.run(BmsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Customer c1 = Customer.builder().acc_no(123456789).acc_holder("amitav").acc_bal(20000).acc_type("savings")
				.branch("delhi").ifsc("HDFC586H872").pin(999999).phone_no(8759533326L).build();
		Customer c2 = Customer.builder().acc_no(234567891).acc_holder("amit").acc_bal(10000).acc_type("savings")
				.branch("delhi").ifsc("HDFC586H872").pin(555555).phone_no(8759533325L).build();
		Customer c3 = Customer.builder().acc_no(345678921).acc_holder("sunit").acc_bal(10000).acc_type("savings")
				.branch("chennai").ifsc("AXIS876A427").pin(888888).phone_no(8759533324L).build();
		Customer c4 = Customer.builder().acc_no(456789321).acc_holder("pallabi").acc_bal(15000).acc_type("savings")
				.branch("chennai").ifsc("AXIS876A427").pin(777777).phone_no(8759533323L).build();
		d.save(c1);
		d.save(c2);
		d.save(c3);
		d.save(c4);
		System.out.println("----------------all saved-----------------");
		List<Customer> lc = d.findAll();
		for (Customer v : lc)
			System.out.println(v.getAcc_holder() + " " + v.getAcc_bal());

		System.out.println("----------------@QUERY-----------------");
		List<Customer> lc2 = d.findByBranch("chennai");
		for (Customer v : lc2)
			System.out.println(v.getAcc_holder() + " " + v.getAcc_bal() + "  " + v.getBranch());

	}

}
