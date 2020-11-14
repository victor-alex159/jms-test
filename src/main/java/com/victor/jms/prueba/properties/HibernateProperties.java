package com.victor.jms.prueba.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("hibernate")
public class HibernateProperties {

	private String dialect;
	private boolean showSql;
	private boolean formatSql;
	private boolean newGeneratorMappings;

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

	public boolean isShowSql() {
		return showSql;
	}

	public void setShowSql(boolean showSql) {
		this.showSql = showSql;
	}

	public boolean isFormatSql() {
		return formatSql;
	}

	public void setFormatSql(boolean formatSql) {
		this.formatSql = formatSql;
	}

	public boolean isNewGeneratorMappings() {
		return newGeneratorMappings;
	}

	public void setNewGeneratorMappings(boolean newGeneratorMappings) {
		this.newGeneratorMappings = newGeneratorMappings;
	}
}
