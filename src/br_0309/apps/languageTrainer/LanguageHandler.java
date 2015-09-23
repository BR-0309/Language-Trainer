package br_0309.apps.languageTrainer;

import java.util.Locale;

public class LanguageHandler {

	private final static Locale[] INTERFACE_LANGS = { Locale.GERMANY, Locale.UK };
	public static final Locale[] LANGUAGES = { new Locale("af"), new Locale("an"), new Locale("ay"), new Locale("bi"), new Locale("br"), new Locale("ca"),
			new Locale("ch"), new Locale("co"), new Locale("cs"), new Locale("da"), new Locale("en"), new Locale("eo"), new Locale("et"), new Locale("eu"),
			new Locale("ff"), new Locale("gl"), new Locale("de"), new Locale("gn"), new Locale("ht"), new Locale("ho"), new Locale("ia"), new Locale("ie"),
			new Locale("fi"), new Locale("fr"), new Locale("fj"), new Locale("fo"), new Locale("hr"), new Locale("io"), new Locale("is"), new Locale("it"),
			new Locale("kg"), new Locale("la"), new Locale("lb"), new Locale("mi"), new Locale("mg"), new Locale("kw"), new Locale("mt"), new Locale("gv"),
			new Locale("nb"), new Locale("nn"), new Locale("no"), new Locale("oc"), new Locale("pl"), new Locale("pt"), new Locale("nl"), new Locale("rm"),
			new Locale("ro"), new Locale("sm"), new Locale("gd"), new Locale("sk"), new Locale("sl"), new Locale("st"), new Locale("es"), new Locale("sq"),
			new Locale("sw"), new Locale("sv"), new Locale("ss"), new Locale("tn"), new Locale("to"), new Locale("tr"), new Locale("ve"), new Locale("vo"),
			new Locale("wa"), new Locale("cy"), new Locale("wo"), new Locale("xh"), new Locale("zu") };

	public static Locale getBestLocale() {
		Locale defaultLocale = Locale.getDefault();
		for (Locale l : INTERFACE_LANGS) {
			if (l.getLanguage().equals(defaultLocale.getLanguage())) {
				return l;
			}
		}
		Locale.setDefault(new Locale("en", "GB"));
		return new Locale("en", "GB");
	}

	public static void setDisplayLanguage(Locale language) {
		Locale set = null;
		for (Locale l : INTERFACE_LANGS) {
			if (l.getLanguage().equals(language.getLanguage())) {
				set = l;
				break;
			}
		}
		if (set == null) {
			set = new Locale("en", "GB");
		}
		Locale.setDefault(set);
	}

}
