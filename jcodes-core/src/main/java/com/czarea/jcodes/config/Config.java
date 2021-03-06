package com.czarea.jcodes.config;

import com.czarea.jcodes.model.Codes;
import org.yaml.snakeyaml.Yaml;

import java.io.*;

/**
 * 配置文件
 *
 * @author zhouzx
 */
public class Config {
	private static Codes codes;

	private static class SingletonInstance {
		private static final Config INSTANCE = new Config();
	}

	public static Config getInstance() {
		return SingletonInstance.INSTANCE;
	}

	/**
	 * 加载配置
	 *
	 * @return Codes
	 */
	public static Codes yamlInit() throws IOException {
		Yaml yaml = new Yaml();
		try (InputStream in = Config.class.getClassLoader()
				.getResourceAsStream("codes.yml")) {
			codes = yaml.loadAs(in, Codes.class);
			return codes;
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
	}

	/**
	 * 加载配置
	 *
	 * @return Codes
	 */
	public static Codes yamlInit(String config) {
		Yaml yaml = new Yaml();
		try (InputStream in = new FileInputStream(new File(config))) {
			codes = yaml.loadAs(in, Codes.class);
			return codes;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getTablePrefixes() {
		return codes.getTemplate().getPrefixes();
	}

	public static Codes getCodes() {
		return codes;
	}

}
