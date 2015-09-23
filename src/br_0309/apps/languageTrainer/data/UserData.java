package br_0309.apps.languageTrainer.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserData implements Serializable {

	private static final long serialVersionUID = 2362898497407984692L;
	public List<String> map = new ArrayList<String>();
	public String lang;

}
