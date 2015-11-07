package br_0309.apps.languageTrainer;

import java.util.Locale;

public class LanguageHandler {

	private final static Locale[] INTERFACE_LANGS = { Locale.GERMANY, Locale.UK };
	// TODO: Add flags
	/*
	 * SCOT and WAL are made up to represent Scotland and Wales, respectively
	 */
	public static final Locale[] LANGUAGES = { new Locale("af", "ZA"), new Locale("an", "ES"), new Locale("ay", "BO"), new Locale("bi", "VU"),
			new Locale("br", "FR"), new Locale("ca", "ES"), new Locale("ch", "US"), new Locale("co", "FR"), new Locale("cs", "CZ"), new Locale("da", "DK"),
			new Locale("en", "GB"), new Locale("eo"), new Locale("et", "EE"), new Locale("eu", "ES"), new Locale("ff"), new Locale("gl", "ES"),
			new Locale("de", "DE"), new Locale("gn", "PY"), new Locale("ht", "HT"), new Locale("ho", "PG"), new Locale("ia"), new Locale("ie"),
			new Locale("fi", "FI"), new Locale("fr", "FR"), new Locale("fj", "FJ"), new Locale("fo", "FO"), new Locale("hr", "HR"), new Locale("io"),
			new Locale("is", "IS"), new Locale("it", "IT"), new Locale("kg", "KOG"), new Locale("la"), new Locale("lb", "LU"), new Locale("mi", "NZ"),
			new Locale("mg", "MG"), new Locale("kw", "GB"), new Locale("mt", "MT"), new Locale("gv", "GB"), new Locale("nb", "NO"), new Locale("nn", "NO"),
			new Locale("no", "NO"), new Locale("oc", "FR"), new Locale("pl", "PL"), new Locale("pt", "PT"), new Locale("nl", "NL"), new Locale("rm", "CH"),
			new Locale("ro", "RP"), new Locale("sm", "US"), new Locale("gd", "SCOT"), new Locale("sk", "SK"), new Locale("sl", "SL"), new Locale("st", "LS"),
			new Locale("es", "ES"), new Locale("sq", "AL"), new Locale("sw", "KE"), new Locale("sv", "SE"), new Locale("ss", "SZ"), new Locale("tn", "BW"),
			new Locale("to", "TO"), new Locale("tr", "TR"), new Locale("ve", "ZA"), new Locale("vo"), new Locale("wa", "BE"), new Locale("cy", "WAL"),
			new Locale("wo", "SN"), new Locale("xh", "ZA"), new Locale("zu", "ZA") };

	/**
	 * @return the best suited locale given the current system language and the
	 *         available i18n files
	 */
	public static Locale getBestLocale() {
		Locale defaultLocale = Locale.getDefault();
		for (Locale l : INTERFACE_LANGS) {
			if (l.getLanguage().equals(defaultLocale.getLanguage())) { return l; }
		}
		Locale.setDefault(new Locale("en", "GB"));
		return new Locale("en", "GB");
	}

	/**
	 * Sets the default locale to lanugage if it is an available locale, else
	 * set to english
	 */
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

	public static String getFlag(String locale) {
		for (Locale l : LANGUAGES) {
			if (locale.equals(l.getLanguage())) { return l.getCountry().isEmpty() ? "INT" : l.getCountry(); }
		}
		return "INT";
	}

}
