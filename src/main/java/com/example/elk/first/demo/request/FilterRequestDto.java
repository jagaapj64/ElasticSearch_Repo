package com.example.elk.first.demo.request;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilterRequestDto {

	   private Map<String, Object> match;
	    private Map<String, RangeFilterDto> range;
}
