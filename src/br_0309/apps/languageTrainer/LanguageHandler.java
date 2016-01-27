package br_0309.apps.languageTrainer;

import java.util.Locale;

public class LanguageHandler {

    public final static Locale[] INTERFACE_LANGS = {Locale.UK, Locale.GERMANY};
    /*
     * SCOT, WAL and INT are made up to represent Scotland, Wales and
     * international, respectively
     */
    public static final Locale[] LANGUAGES = {new Locale("af", "ZA"), new Locale("an", "ES"), new Locale("ay", "BO"), new Locale("bi", "VU"),
                                              new Locale("br", "FR"), new Locale("ca", "ES"), new Locale("ch", "US"), new Locale("co", "FR"),
                                              new Locale("cs", "CZ"), new Locale("cy", "WAL"), new Locale("da", "DK"), new Locale("de", "DE"),
                                              new Locale("en", "GB"), new Locale("eo", "INT"), new Locale("es", "ES"), new Locale("et", "EE"),
                                              new Locale("eu", "ES"), new Locale("ff", "INT"), new Locale("fi", "FI"), new Locale("fj", "FJ"),
                                              new Locale("fo", "FO"), new Locale("fr", "FR"), new Locale("ga", "IE"), new Locale("gd", "SCOT"),
                                              new Locale("gl", "ES"), new Locale("gn", "PY"), new Locale("gv", "GB"), new Locale("ho", "PG"),
                                              new Locale("hr", "HR"), new Locale("ht", "HT"), new Locale("ia", "INT"), new Locale("ie", "INT"),
                                              new Locale("io", "INT"), new Locale("is", "IS"), new Locale("it", "IT"), new Locale("kg", "CD"),
                                              new Locale("kw", "GB"), new Locale("la", "INT"), new Locale("lb", "LU"), new Locale("mg", "MG"),
                                              new Locale("mi", "NZ"), new Locale("mt", "MT"), new Locale("nb", "NO"), new Locale("nl", "NL"),
                                              new Locale("nn", "NO"), new Locale("no", "NO"), new Locale("oc", "FR"), new Locale("pl", "PL"),
                                              new Locale("pt", "PT"), new Locale("rm", "CH"), new Locale("ro", "RO"), new Locale("sk", "SK"),
                                              new Locale("sl", "SL"), new Locale("sm", "US"), new Locale("sq", "AL"), new Locale("ss", "SZ"),
                                              new Locale("st", "LS"), new Locale("sv", "SE"), new Locale("sw", "KE"), new Locale("tn", "BW"),
                                              new Locale("to", "TO"), new Locale("tr", "TR"), new Locale("ve", "ZA"), new Locale("vo", "INT"),
                                              new Locale("wa", "BE"), new Locale("wo", "SN"), new Locale("xh", "ZA"), new Locale("zu", "ZA"),
                                              new Locale("lt", "LT"), new Locale("lv", "LV"), new Locale("ast", "ES"), new Locale("mwl", "PT"),
                                              new Locale("srd", "IT"), new Locale("scn", "IT"), new Locale("nap", "IT")};

    /**
     * @return the best suited locale given the current system language and the
     * available i18n files
     */
    public static Locale getBestLocale() {
        Locale defaultLocale = Locale.getDefault();
        for (Locale l : INTERFACE_LANGS) {
            if (l.getLanguage().equals(defaultLocale.getLanguage())) {
                return l;
            }
        }
        Locale.setDefault(Locale.UK);
        return Locale.UK;
    }

    /**
     * Sets the default locale to language if it is an available locale, else
     * set to english
     */
    public static void setDisplayLanguage(Locale language) {
        Locale set = null;
        for (Locale l : INTERFACE_LANGS) {
            if (l.getDisplayLanguage().equals(language.getDisplayLanguage())) {
                set = l;
                break;
            }
        }
        if (set == null) {
            set = Locale.UK;
        }
        Locale.setDefault(set);
    }

    @SuppressWarnings("HardcodedFileSeparator")
    public static String getFlag(Locale locale) {
        String country = locale.getCountry().trim();
        if (! country.isEmpty()) {
            return "/icons/flags/" + country + ".png";
        } else {
            for (Locale l : LANGUAGES) {
                if (l.getLanguage().equals(locale.getLanguage())) {
                    return l.getCountry().isEmpty() ? "/icons/flags/INT" : "/icons/flags/" + l.getCountry() + ".png";
                }
            }
            return "/icons/flags/INT.png";
        }
    }
}
