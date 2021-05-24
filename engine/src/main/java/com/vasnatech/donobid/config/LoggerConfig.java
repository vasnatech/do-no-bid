package com.vasnatech.donobid.config;

import java.util.Map;

import com.vasnatech.donobid.log.ConsoleLoggerFactory;
import com.vasnatech.donobid.log.LoggerFactory;

public class LoggerConfig implements Config {

	@Override
	public void init(Map<String, ?> properties) {
		LoggerFactory.setDefault(new ConsoleLoggerFactory());
	}

}
