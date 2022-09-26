package com.academy.shopping.aop;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.academy.shopping.exception.MemberException;
import com.academy.shopping.model.util.Message;

//RestController에서 발생되는 모든 예외를 잡는다.
@RestControllerAdvice //Controller 외부에서 나오는 Exception을 처리할 수 있음
public class RestGlobalExceptionAspect {
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<Message> handleException(MemberException e){
		Message message = new Message(0,e.getMessage());
		ResponseEntity<Message> entity = new ResponseEntity<Message>(message,HttpStatus.OK);
		return entity;
	}
}
