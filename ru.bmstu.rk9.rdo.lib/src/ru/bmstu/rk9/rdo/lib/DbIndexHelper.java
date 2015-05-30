package ru.bmstu.rk9.rdo.lib;

import ru.bmstu.rk9.rdo.lib.Database.SerializationCategory;

public class DbIndexHelper {
	public final CollectedDataNode getTree() {
		return root;
	}

	public final CollectedDataNode initializeModel(String name) {
		if (root.hasChildren()) {
			root.getChildren().clear();
		}

		modelName = name;
		CollectedDataNode modelIndex = root.addChild(name);
		for (SerializationCategory value : SerializationCategory.values()) {
			modelIndex.addChild(value.getName());
		}
		return modelIndex;
	}

	public final CollectedDataNode getModel() {
		return root.getChildren().get(modelName);
	}

	private final CollectedDataNode getCategory(SerializationCategory category) {
		return getModel().getChildren().get(category.getName());
	}

	public final CollectedDataNode addResourceType(String name) {
		return getCategory(SerializationCategory.RESOURCES).addChild(name);
	}

	public final CollectedDataNode getResourceType(String name) {
		return getCategory(SerializationCategory.RESOURCES).getChildren().get(
				name);
	}

	public final CollectedDataNode addResult(String name) {
		return getCategory(SerializationCategory.RESULTS).addChild(name);
	}

	public final CollectedDataNode getResult(String name) {
		return getCategory(SerializationCategory.RESULTS).getChildren().get(
				name);
	}

	public final CollectedDataNode addPattern(String name) {
		return getCategory(SerializationCategory.PATTERNS).addChild(name);
	}

	public final CollectedDataNode getPattern(String name) {
		return getCategory(SerializationCategory.PATTERNS).getChildren().get(
				name);
	}

	public final CollectedDataNode addEvent(String name) {
		return getCategory(SerializationCategory.EVENTS).addChild(name);
	}

	public final CollectedDataNode getEvent(String name) {
		return getCategory(SerializationCategory.EVENTS).getChildren().get(
				name);
	}

	public final CollectedDataNode addDecisionPoint(String name) {
		return getCategory(SerializationCategory.DECISION_POINTS)
				.addChild(name);
	}

	public final CollectedDataNode getDecisionPoint(String name) {
		return getCategory(SerializationCategory.DECISION_POINTS).getChildren()
				.get(name);
	}

	public final CollectedDataNode addSearch(String name) {
		return getCategory(SerializationCategory.SEARCH).addChild(name);
	}

	public final CollectedDataNode getSearch(String name) {
		return getCategory(SerializationCategory.SEARCH).getChildren()
				.get(name);
	}

	private String modelName;
	private final CollectedDataNode root = new CollectedDataNode("root", null);
}
