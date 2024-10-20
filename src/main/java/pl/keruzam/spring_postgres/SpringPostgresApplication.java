package pl.keruzam.spring_postgres;

import lombok.extern.java.Log;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
@Log
public class SpringPostgresApplication implements CommandLineRunner {

	DataSource dataSource;

	public SpringPostgresApplication(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringPostgresApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		log.info("check console");
		log.info("DataSource: " + dataSource.toString());
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.execute("select 1");
	}
}
