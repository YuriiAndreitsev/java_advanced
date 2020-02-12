package ua.itea;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import ua.annotations.Blochable;
import ua.annotations.LuckyCat;
import ua.annotations.Paw;

public class CatFactory {

	public void produceFarsh(Class[] array) {

		for (Class clazz : array) {

			if (clazz.isAnnotationPresent(Blochable.class)) {
				System.out.println(clazz.getName() + " goes to farsh because he has annotation @Blochable");
			} else {

				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					if (field.isAnnotationPresent(LuckyCat.class)) {
						if (field.getAnnotation(LuckyCat.class).lucky() == true) {
							System.out.println(clazz.getName() + " has field annotation on the field {"
									+ field.getName() + "} @Lucky - true. he will live...");

						} else {
							System.out.println(clazz.getName() + " has field annotation on the field {"
									+ field.getName() + "} @Lucky - false. he will die...");
						}

					}

					Method[] methods = clazz.getDeclaredMethods();
					for (Method m : methods) {
						if (m.isAnnotationPresent(Paw.class)) {
							if (m.getAnnotation(Paw.class).qnt() == 2) {
								System.out.println(clazz.getName() + " will live because the annotation @Paw = 2");
							} 
						}
					}
				}
			}
		}
	}
}
