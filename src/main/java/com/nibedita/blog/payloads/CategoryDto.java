package com.nibedita.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer cid;
	@NotBlank
	@Size(min=4,message="min size is 4")
	private String categoryTitle;
	@NotBlank
	@Size(min=10,message="min size is 10")
	private String categoryDescription;

}
