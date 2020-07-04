package com.technicaltest.restusercontrol.services;

import com.technicaltest.restusercontrol.model.ResponseDes;
import com.technicaltest.restusercontrol.model.Result;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class RestServiceConsumerImpl  implements IrestServiceConsumer {

	private static final Logger log = LoggerFactory.getLogger(RestServiceConsumerImpl.class);
	String encryptedRut;
	@Override
	public ResponseDes postConsult(String param) throws RestClientException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		long startTime = System.nanoTime();
		RestTemplate restTemplate = new RestTemplate();
		ResponseDes responseDes = new ResponseDes();
		String paramEncrypt = encryptInputParameter(param);
		responseDes = restTemplate.getForObject("https://sandbox.ionix.cl/test-tecnico/search?rut=" + paramEncrypt, ResponseDes.class);
		long endTime = System.nanoTime() - startTime;
		Result r1 = new Result();
		r1.setRegisterCount(responseDes.getResult().getItems().length);
		responseDes.setResult(r1);
		responseDes.setElapsedTime((int) endTime);
		return responseDes;
	}

	private String encryptInputParameter(String param){
	try {

		DESKeySpec keySpec = new DESKeySpec("ionix123456".getBytes("UTF8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		keyFactory.generateSecret(keySpec);
		byte[] cleartext = param.getBytes("UTF8");
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE,keyFactory.generateSecret(keySpec));
		Base64 b64 = new Base64();
		encryptedRut = b64.encodeToString(cipher.doFinal(cleartext));
		log.info("encrypted text url " + encryptedRut);
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	return encryptedRut;
	}

}
