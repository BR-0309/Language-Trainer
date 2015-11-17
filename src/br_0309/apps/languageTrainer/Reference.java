package br_0309.apps.languageTrainer;

import br_0309.apps.languageTrainer.util.SystemUtil;

public class Reference {

	public static final String FXML_MENU = "/br_0309/apps/languageTrainer/scenes/Menu.fxml";
	public static final String FXML_PROFILE_SELECT = "/br_0309/apps/languageTrainer/scenes/ProfileSelect.fxml";
	public static final String FXML_PROFILE_NEW = "/br_0309/apps/languageTrainer/scenes/ProfileNew.fxml";
	public static final String FXML_TRANSLATION = "/br_0309/apps/languageTrainer/scenes/Translate.fxml";
	public static final String FXML_SETTINGS = "/br_0309/apps/languageTrainer/scenes/Settings.fxml";

	public static final String CSS_DEFAULT = "/stylesheets/default.css";
	public static final String CSS_DARK = "/stylesheets/dark.css";
	public static final String CSS_BLUE = "/stylesheets/blue.css";

	public static final String BUNDLE_LOC = "lang/Locale";

	public static final String PROPERTY_LANGUAGE = "lang";

	public static String DEFAULT_SAVE_DIR;
	public static String DEFAULT_EXERCISE_DIR;
	public static final String DEFAULT_PROFILE_DIR = SystemUtil.getUserHome();

	public static final String LOGO = "/icons/Logo.png";

	public static final String VERSION = "0.6.0";

}
