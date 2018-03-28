package com.project.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.properties.ParamProperties;

@Controller
@RequestMapping("/log")
public class LoggerController {

	@Autowired
	private ParamProperties paramProperties;

	private static final Logger LOGGER = LoggerFactory.getLogger(LoggerController.class);

	@RequestMapping("/getLog")
	@ResponseBody
	public String getLog(HttpServletResponse response) {
		LOGGER.debug("===========debug信息>>>>" + paramProperties);
		LOGGER.info("===========info信息>>>>" + paramProperties);
		LOGGER.trace("I am trace log.");
		LOGGER.debug("I am debug log.");
		LOGGER.warn("I am warn log.");
		LOGGER.error("I am error log.");
		// 手动异常
		System.out.println(1 / 0);
		// 会有中文乱码问题 TODO
		return paramProperties.getWyaitName() + " 正在写" + paramProperties.getWyaitTitle() + "!总结："
				+ paramProperties.getWyaitMessage();
	}

}
