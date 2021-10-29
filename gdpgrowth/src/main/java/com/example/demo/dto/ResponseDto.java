package com.example.demo.dto;

import java.io.Serializable;

	public class ResponseDto implements Serializable {

		private static final long serialVersionUID = 6953978110388779136L;

		private boolean status = true;
		private int errorCode;
		private String errorDescription;
		private Object responseDto;
		public boolean isStatus() {
			return status;
		}
		public void setStatus(boolean status) {
			this.status = status;
		}
		public int getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorDescription() {
			return errorDescription;
		}
		public void setErrorDescription(String errorDescription) {
			this.errorDescription = errorDescription;
		}
		public Object getResponseDto() {
			return responseDto;
		}
		public void setResponseDto(Object responseDto) {
			this.responseDto = responseDto;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
		
}
