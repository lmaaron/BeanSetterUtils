package com.gomemyc;

/**
 * 构造类的setter方法
 * @author Aaron
 * @since 2017年3月16日
 */
public class BeanSetterUtils {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		try {
			Class loadClass = ClassLoader.getSystemClassLoader().loadClass("com.gomemyc.entity.TbPayTrade");

			String className = loadClass.getSimpleName(); // 类名 Class
			String objectName = captureName(className); // 对象名 object

			System.out.println(className + " " + objectName + " = new " + className + "();"); // Object object = new Object();

			for (int i = 0; i < loadClass.getMethods().length; i++) {
				if (loadClass.getMethods()[i].getName().startsWith("set")) {
					System.out.println(objectName + "." + loadClass.getMethods()[i].getName() + "(" + loadClass.getMethods()[i].getName().substring(3) + ");");
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 对象名称首字母小写
	 * @param name
	 * @return
	 */
	public static String captureName(String name) {
		String result = "";
		if (null == name || "".equals(name)) return result;

		result = name.substring(0, 1).toLowerCase() + name.substring(1);
		return result;

	}
}
