package org.psw_isa.psw_isa_backend.service;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;



@Service
public class HashService {

	public  String encrypt(String strClearText) throws Exception {
		String strData = "";
		

		try {
			byte[] bytesEncoded = Base64.encodeBase64(strClearText.getBytes());
			strData= new String(bytesEncoded);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}

	public  String decrypt(String strEncrypted) throws Exception {
		String strData = "";
		

		try {
			byte[] valueDecoded = Base64.decodeBase64(strEncrypted);
			strData= new String(valueDecoded);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}

}
