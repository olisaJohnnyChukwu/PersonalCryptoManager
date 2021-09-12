package com.ojc.Service;

import java.util.List;

import com.ojc.model.crypto;

public interface ICryptoservice {
	
	void scrapWeb();
	
	public List<crypto> getAll();
}
