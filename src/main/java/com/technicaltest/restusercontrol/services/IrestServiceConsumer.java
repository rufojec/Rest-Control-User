package com.technicaltest.restusercontrol.services;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.web.client.RestClientException;

import com.technicaltest.restusercontrol.model.ResponseDes;

public interface IrestServiceConsumer {
	public ResponseDes postConsult(String param)throws RestClientException, InvalidKeyException, UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException;
}
