package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.convertes.NumberConverter;
import br.com.erudio.exception.UnsuporteMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	
	private SimpleMath math= new SimpleMath();
		
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
		
		return math.sum(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
	
		return math.subtraction(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/multiplication/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
		
		return math.multiplication(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	@RequestMapping(value = "/division/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
		if(NumberConverter.convertToDouble(numberTwo)== 0) {
			throw new UnsuporteMathOperationException("Please not use value zero, because tends to infinity");
		}
		if(NumberConverter.convertToDouble(numberOne)== 0 && NumberConverter.convertToDouble(numberTwo)== 0) {
			throw new UnsuporteMathOperationException("Please not use value zero in both, because the result is indeterminate");
		}
		
		return math.division(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}",method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
		
		
		return math.mean(NumberConverter.convertToDouble(numberOne),NumberConverter.convertToDouble(numberTwo));
		
	}
	@RequestMapping(value = "/squareRoot/{numberOne}",method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!NumberConverter.isNumeric(numberOne)) {
			throw new UnsuporteMathOperationException("Please set a numeric value");
		}
		
		if(NumberConverter.convertToDouble(numberOne)< 0) {
			throw new UnsuporteMathOperationException("Please value not negative");
		}
		
		
		return math.squareRoot(NumberConverter.convertToDouble(numberOne));
		
	}

	
	
}
