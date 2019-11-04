package ken.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//springboot框架的核心注解
@SpringBootApplication
public class Starter {
	
	public static void main(String[] args) {
		//调用spring应用的run方法,将根据自动配置,默认配置,完成初始化的创建,根据依赖完成
		//所有功能的自动配置
		SpringApplication.run(Starter.class,  args);
	}  
	
	
}
