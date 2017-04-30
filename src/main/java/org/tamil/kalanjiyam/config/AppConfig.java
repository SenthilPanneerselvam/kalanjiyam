package org.tamil.kalanjiyam.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Empty class that acts as the wrapper for the spring configuration.
 * 
 * @author Senthil Panneerselvam
 * 
 */
@Configuration
@ImportResource("classpath*:applicationContext.xml")
public class AppConfig
{
	// No configurations done here. Add the configurations to the
	// applicationContext.xml file
}
