package net.minecraft.src;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FontAllowedCharacters {
	public static final String field_20157_a = func_20156_a();

	private static String func_20156_a() {
		String var0 = "";

		try {
			BufferedReader var1 = new BufferedReader(new InputStreamReader(FontAllowedCharacters.class.getResourceAsStream("/font.txt"), "UTF-8"));
			String var2 = "";

			while(true) {
				var2 = var1.readLine();
				if(var2 == null) {
					var1.close();
					break;
				}

				if(!var2.startsWith("#")) {
					var0 = var0 + var2;
				}
			}
		} catch (Exception var3) {
		}

		return var0;
	}
}
