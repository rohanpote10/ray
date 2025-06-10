package com.expo.blogapp.payloads;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Setter
@Getter
public class PostResponse {

	private List<PostDTO> postList;
	private int pageNumber;
	private long pageSize;
	private long totalElements;
	private int totalPages;
	private boolean lastPage;
}
