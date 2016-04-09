package br_0309.apps.languageTrainer.scenes.controllers;

import br_0309.apps.languageTrainer.verbs.Verb;

import java.util.List;

abstract class ControllerNewVerb {

    abstract Verb getResult();

    abstract void initPreEnteredVerbs(List<Verb> list);

    abstract void loadVerb(Verb v);

}
