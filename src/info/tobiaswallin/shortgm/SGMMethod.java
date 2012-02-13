package info.tobiaswallin.shortgm;

public enum SGMMethod {

	SET, NOVALUE;

	public static SGMMethod toMethod(String str) {
		try {
			return valueOf(str);
		} catch (Exception ex) {
			return NOVALUE;
		}
	}

}
