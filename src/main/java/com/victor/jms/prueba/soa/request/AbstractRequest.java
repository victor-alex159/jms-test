package com.victor.jms.prueba.soa.request;

import java.io.Serializable;

public abstract class AbstractRequest<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
