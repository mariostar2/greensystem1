package com.cos.crowapp.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.cos.crowapp.domain.NaverNews;
import com.cos.crowapp.domain.NaverNewsRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

//비동기서버 
@RequiredArgsConstructor
@RestController
public class NaverNewsController {

	private final NaverNewsRepository naverNewsRepository;
	
	@GetMapping(value ="/naverNews" ,produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<NaverNews> home(){
		//새로운 스레드가 만들어저서 응답을 잡고있음
		return naverNewsRepository.mFindAll()
				.subscribeOn(Schedulers.boundedElastic()); //Data -> TimeStamp 변경하는 리턴이 불가능 
	}

}
