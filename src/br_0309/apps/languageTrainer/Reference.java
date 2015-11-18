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
	public static final String PROPERTY_SOUND_CORRECT = "correct";
	public static final String PROPERTY_SOUND_INCORRECT = "incorrect";
	public static final String PROPERTY_SOUND_FINISHED = "finsished";
	public static final String PROPERTY_PLAY_SOUNDS = "pSounds";

	public static String DEFAULT_SAVE_DIR;
	public static String DEFAULT_EXERCISE_DIR;
	public static final String DEFAULT_PROFILE_DIR = SystemUtil.getUserHome();

	public static final String LOGO = "/icons/Logo.png";
	public static final String VERSION = "0.6.0";

	public static final String[] SOUNDS_CORRECT = { "/sounds/correct/correct.wav", "/sounds/correct/correct2.wav", "/sounds/correct/game-sound-correct-v2.wav",
			"/sounds/correct/jingle-4.wav", "/sounds/correct/powerup-success.wav" };
	public static final String[] SOUNDS_INCORRECT = { "/sounds/incorrect/incorrect.wav", "/sounds/incorrect/misslyckad-bana-v5.wav",
			"/sounds/incorrect/negative-beeps.wav", "/sounds/incorrect/negative.wav", "/sounds/incorrect/negativebeep.wav",
			"/sounds/incorrect/sine-negative-beep.wav" };
	public static final String[] SOUNDS_FINISHED = { "/sounds/finshed/3-men-cheering.wav", "/sounds/finshed/applause-2.wav", "/sounds/finshed/loop1.wav",
			"/sounds/finshed/melo4.wav", "/sounds/finshed/sine-melody.wav", "/sounds/finshed/sine-melody-2.wav", "/sounds/finshed/smallcrowd.wav",
			"/sounds/finshed/summertime-stab" };

}
